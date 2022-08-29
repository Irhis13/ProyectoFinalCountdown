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

    @GetMapping("/home")
    public String getViajes(Model model) {
        model.addAttribute("viajes", servicioViaje.getViajes());
        return "home";
    }

    // @GetMapping("/listado")
    // public String getViajes(Model model){
    // model.addAttribute("viajes", servicioViaje.getViajes());
    // return "viajes";
    // }

    @GetMapping("/formulario")
    public String mostrarFormulario(ModelMap map) {
        map.addAttribute("viaje", new Viaje());
        map.addAttribute("categoria", servicioCategoria.getCategorias());

        return "formularioAltaViaje";
    }

    @PostMapping("/CrearViaje")
    public String crearViaje(@ModelAttribute(name = "viaje") Viaje viaje) {

        servicioViaje.guardar(viaje);

        return "redirect:/listado";
    }

    @PostMapping("/detalles/{id}")
    public ModelAndView detalles(@PathVariable(name = "id") String id) {
        Viaje viaje = servicioViaje.getViaje(Integer.parseInt(id));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("detalles");
        mav.addObject("viaje", viaje);
        return mav;
    }

    @GetMapping("/modificar/{id}")
    public ModelAndView modificar(@PathVariable(name = "id") String id) {
        Viaje viaje = servicioViaje.getViaje(Integer.parseInt(id));
        List<Categoria> categorias = servicioCategoria.getCategorias();

        ModelAndView mav = new ModelAndView();

        mav.setViewName("formularioAltaViaje");
        mav.addObject("viaje", viaje);
        mav.addObject("categorias", categorias);

        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(name = "id") int id) {
        servicioViaje.eliminar(id);

        return "redirect:/listado";
    }

}
