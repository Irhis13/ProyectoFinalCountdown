package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Categoria;
import com.example.entities.Cliente;
import com.example.service.ICategoriaService;
import com.example.service.IClienteService;

@Controller
@RequestMapping("/")
public class ClienteController {

    @Autowired
    private IClienteService servicioCliente;

    @Autowired
    private ICategoriaService servicioCategoria;

    @GetMapping("/listadoClientes")

    public String getClientes(Model model) {
        model.addAttribute("clientes", servicioCliente.getClientes());
        return "clientes";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    // Esto es para el formulario de alta de cliente que no sé si lo queremos hacer
    // en caso de no quere hacerlo lo borramos posteriormente
    @GetMapping("/formulario")
    public String showFormulario(ModelMap map) {
        map.addAttribute("cliente", new Cliente());
        map.addAttribute("categorias", servicioCategoria.getCategorias());
        return "formularioAltaCliente";
    }

    // Forma 1:
    @GetMapping("/forma1")
    public ModelAndView porForma1(@RequestParam(name = "nombre") String nombre) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forma1");
        mav.addObject("nombre", nombre);

        return mav;
    }

    // Forma 2:
    @GetMapping("/forma2/{id}")
    public ModelAndView porForma2(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forma2");
        mav.addObject("valorRecibido", id);

        return mav;
    }

    // Detalles del Cliente
    @GetMapping("/detalles/{id}")
    public ModelAndView detalles(@PathVariable(name = "id") int id) {

        Cliente cliente = servicioCliente.getCliente(id);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("detalles");
        mav.addObject("cliente", cliente);

        return mav;
    }

    // Modificar cliente
    @GetMapping("/modificar/{id}")
    public ModelAndView modificar(@PathVariable("id") String id) {

        ModelAndView mav = new ModelAndView();

        Cliente cliente = servicioCliente.getCliente(Long.parseLong(id));
        List<Categoria> categorias = servicioCategoria.getCategorias();

        mav.setViewName("formularioAltaCliente");
        mav.addObject("cliente", cliente);
        mav.addObject("categorias", categorias);

        return mav;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable(name = "id") int id) {

        servicioCliente.eliminar(id);

        return "redirect:/listadoClientes";
    }

}




