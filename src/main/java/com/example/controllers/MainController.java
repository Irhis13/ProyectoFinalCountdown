package com.example.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    @Autowired
    private IEmpleadoService servicioEmpleado;

////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////CONEXIÓN BACKEND CON HTML////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

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

    @GetMapping("/Paco")
    public String getCarritoC(){
        return "carrito2";
    }

    @GetMapping("/login/{id}") 
    public ModelAndView getLogin(@PathVariable(name = "id") String id){
        Cliente cliente = servicioCliente.getCliente(Integer.parseInt(id));

        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("cliente", cliente);
        return mav;

    }
    String getLogin(Model model){
        model.addAttribute("cliente", servicioCliente.getCliente(1));
        return "login";
    }

    @GetMapping("/carritoCompra") //Aquí implementar paramrequest!!!
    public String getCarrito(/*Model model*/){
        // model.addAttribute("viajes", servicioViaje.getViaje(1));
        return "carritoCompra";
    }

    @GetMapping("/pasarelaPago")
    public String getPasarelaPago(){
        return "pasarelaPago";
    }
    
    @GetMapping("/portalEmpleado")
    public String getPortalEmpleado(){
        return "portalEmpleado";
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    ///////GET MAPPING DE LAS PÁGINAS DE CATEGORIAS QUE TRAEN LOS VIAJES DE ESA CATEGORIA//////
    ///////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/aventura")
    public String getAventura(Model model){

        List<Viaje> viajeAventura = servicioViaje.getViajesCategoria(1);
        model.addAttribute("viajeAventura", viajeAventura);
        return "aventura";
    }

    @GetMapping("/cultural")
    public String getCultural(Model model){
        List<Viaje> viajeCultural = servicioViaje.getViajesCategoria(2);
        model.addAttribute("viajeCultural", viajeCultural);
        return "cultural";
    }
    
    @GetMapping("/familiar")
    public String getFamiliar(Model model){
        List<Viaje> viajeFamiliar = servicioViaje.getViajesCategoria(3);
        model.addAttribute("viajeFamiliar", viajeFamiliar);
        return "familiar";
    }

    @GetMapping("/pareja")
    public String getPareja(Model model){
        List<Viaje> viajePareja = servicioViaje.getViajesCategoria(4);
        model.addAttribute("viajePareja",viajePareja);
        return "pareja";
    }


////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////FORMULARIOS/////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/formularioEmpleado")
public String mostrarFormularioEmpleado(ModelMap map){
    map.addAttribute("empleado", new Empleado()); 
    
    return "formularioAltaEmpleado";
}

@GetMapping("/formularioCliente")
public String mostrarFormularioCliente(ModelMap map){
    map.addAttribute("cliente", new Cliente()); 
    map.addAttribute("viajes", servicioViaje.getViajes());
    map.addAttribute("clientes", servicioCliente.getClientes());
    
    return "formularioAltaCliente";
}

    @GetMapping("/formularioViaje")
    public String mostrarFormularioViaje(ModelMap map){
        map.addAttribute("viaje", new Viaje()); 
        map.addAttribute("categorias", servicioCategoria.getCategorias());
        
        return "formularioAltaViaje";
    }

///////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////METODOS//////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////


///////////NO CONSIGO QUE ME GUARDE EL VIAJE/EMPLEADO/CLIENTE EN BBDD
    @PostMapping("/crearViaje") 
    public String crearViaje(@ModelAttribute(name="viaje")
    Viaje viaje){
        servicioViaje.guardar(viaje);
        return "redirect:/home";
    }

    @PostMapping("/crearEmpleado")
    public String crearEmpleado(@ModelAttribute(name="empleado")
    Empleado empleado){
        servicioEmpleado.guardar(empleado);

        return "redirect:/home";
    }

    @PostMapping("/crearCliente")
    public String crearCliente(@ModelAttribute(name="cliente")
    Cliente cliente, @RequestParam(name ="imagen", required = false)MultipartFile imagenDni){

        if(imagenDni != null){
            String rutaAbsoluta ="C://Users//mpaterna//Documents//recursosEmpleado/";
            Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+imagenDni.getOriginalFilename());
            
            try {
                byte[] bytesImagenDni = imagenDni.getBytes();
                Files.write(rutaCompleta, bytesImagenDni);
                cliente.setImagenDni(imagenDni.getOriginalFilename());
                servicioCliente.guardar(cliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/home";
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


