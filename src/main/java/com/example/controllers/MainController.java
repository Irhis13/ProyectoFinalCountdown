package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.*;
import com.example.service.*;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private IViajeService servicioViaje;
    @Autowired
    private ICategoriaService servicioCategoria;

    @Autowired
    private IClienteService servicioCliente;

    @GetMapping("/home")
    //PARA QUE SE VEAN LOS HTML
    public String getViajes(Model model){
        List<Viaje> viajes = servicioViaje.getViajes();
        // for (Viaje viaje : viajes) { /*Comprobación que funciona */
        //     System.out.println(viaje.getCategoria().getNombre());
        // }
        model.addAttribute("viajes", viajes);
        return "home";
    }

    @GetMapping("/aboutUs")
    public String getAboutUs(){
        return "aboutUs";
    }

    @GetMapping("/FAQS")
    public String getFAQS(){
        return "FAQS";
    }

    @GetMapping("/login")
    public String getLogin(/*Model model*/){
        // model.addAttribute("cliente", servicioCliente.getCliente(1));
        return "login";
    }

    @GetMapping("/carritoCompra")
    public String getCarrito(Model model){
        model.addAttribute("viajes", servicioViaje.getViaje(1));
        return "carritoCompra";
    }

    @GetMapping("/aventura")
    public String getAventura(Model model){
        List<Viaje> viajeAventura = servicioCategoria.getViajesCategoria(1);
        model.addAttribute("categoria", viajeAventura);
        // model.addAttribute("categoria", servicioCategoria.getCategoria(1));
        return "aventura";
    }

    @GetMapping("/cultural")
    public String getCultural(Model model){
        model.addAttribute("categoria", servicioCategoria.getCategoria(2));
        return "cultural";
    }

    @GetMapping("/familiar")
    public String getFamiliar(Model model){
        model.addAttribute("categoria", servicioCategoria.getCategoria(3));
        return "familiar";
    }

    @GetMapping("/pareja")
    public String getPareja(Model model){
        model.addAttribute("categoria", servicioCategoria.getCategoria(4));
        return "pareja";
    }

    @GetMapping("/pasarelaPago")
    public String getPasarelaPago(){
        return "pasarelaPago";
    }




/////////////////////////////////////////////////////////////////////////////////////
    //METODOS
    @GetMapping("/formulario")
    public String mostrarFormulario(ModelMap map){
        map.addAttribute("viaje", new Viaje()); 
        map.addAttribute("categoria", servicioCategoria.getCategorias());
        
        return "formularioAltaViaje";
    }

    @PostMapping("/CrearViaje")
    public String crearViaje(@ModelAttribute(name="viaje")Viaje viaje){

        servicioViaje.guardar(viaje);

        return "redirect:/listado";
    }


    @PostMapping("/detalles/{id}")
    public ModelAndView detalles(@PathVariable(name = "id") String id){
        Viaje viaje =servicioViaje.getViaje(Integer.parseInt(id));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detalles");
        mav.addObject("viaje", viaje);
        return mav;
    }

    @GetMapping("/modificar/{id}")
    public ModelAndView modificar(@PathVariable(name="id") String id){
        Viaje viaje= servicioViaje.getViaje(Integer.parseInt(id));
        List<Categoria> categorias = servicioCategoria.getCategorias();

        ModelAndView mav = new ModelAndView();

        mav.setViewName("formularioAltaViaje");
        mav.addObject("viaje", viaje);
        mav.addObject("categorias", categorias);

        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(name="id") int id){
        servicioViaje.eliminar(id);

        return "redirect:/listado";
    }


}
