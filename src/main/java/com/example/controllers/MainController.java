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

    @GetMapping("/chronologic")
    public String getViajes(Model model){
        List<Viaje> viajes = servicioViaje.getViajes();
        // for (Viaje viaje : viajes) { /*Comprobación que funciona */
        //     System.out.println(viaje.getCategoria().getNombre());
        // }
        model.addAttribute("viajes", viajes);
        return "home";
    }

    @GetMapping("/destinos")
    public String getDestinosCategoria(Model model){
        List<Categoria> categorias = servicioCategoria.getCategorias();
        model.addAttribute("categorias", categorias);
        return "Destinos";
    }

    @GetMapping("/aboutUs")
    public String getAboutUs(){
        return "aboutUs";
    }

    @GetMapping("/signIn")
    public String getsignIn(){
        return "loginPrueba";
    }


    @GetMapping("/FAQS")
    public String getFAQS(){
        return "FAQS";
    }

    @GetMapping("/login/{id}") 
    public ModelAndView getLogin(@PathVariable(name = "id") String id){
        Cliente cliente = servicioCliente.getCliente(Integer.parseInt(id));

        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("cliente", cliente);
        return mav;
    }

    @GetMapping("/pasarelaPago")
    public String getPasarelaPago(){
        return "pasarelaPago";
    }


    @GetMapping("/portalEmpleado")
    public String getPortalEmpleado1(Model model, Model model1, Model model2){

        List<Viaje> viajes = servicioViaje.getViajes();
        model.addAttribute("viajesDisponibles", viajes);

        List<Cliente> clientes = servicioCliente.getClientes();
        model1.addAttribute("clientesRegistrados", clientes);

        return "portalEmpleado";
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    ///////GETMAPPING DE LAS PÁGINAS DE CATEGORIAS QUE TRAEN LOS VIAJES DE ESA CATEGORIA///////
    ///////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/aventura")
    public String getAventura(Model model){

        List<Viaje> viajeAventura = servicioViaje.getViajesCategoria(1);
        model.addAttribute("viajeAventura", viajeAventura);
        return "aventuraD";
    }

    @GetMapping("/cultural")
    public String getCultural(Model model){
        List<Viaje> viajeCultural = servicioViaje.getViajesCategoria(2);
        model.addAttribute("viajeCultural", viajeCultural);
        return "culturalD";
    }
    
    @GetMapping("/familiar")
    public String getFamiliar(Model model){
        List<Viaje> viajeFamiliar = servicioViaje.getViajesCategoria(3);
        model.addAttribute("viajeFamiliar", viajeFamiliar);
        return "familiarD";
    }

    @GetMapping("/pareja")
    public String getPareja(Model model){
        List<Viaje> viajePareja = servicioViaje.getViajesCategoria(4);
        model.addAttribute("viajePareja",viajePareja);
        return "parejaD";
    }


////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////FORMULARIOS/////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/formularioEmpleado")
public String mostrarFormularioEmpleado(ModelMap map, ModelMap map1){
    map.addAttribute("empleado", new Empleado()); 
    map1.addAttribute("empleadosLista", servicioEmpleado.getEmpleados());
    
    return "formularioAltaEmpleado";
}

@GetMapping("/formularioCliente")
public String mostrarFormularioCliente(ModelMap map){
    map.addAttribute("cliente", new Cliente()); 
    
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


    @PostMapping("/crearViaje") 
    public String crearViaje(@ModelAttribute(name="viaje")
    Viaje viaje){
        // System.out.println("PROBANDO: "+ viaje.getNombre());
        servicioViaje.guardar(viaje);

        return "redirect:/portalEmpleado";
    }

    @PostMapping("/crearEmpleado")
    public String crearEmpleado(@ModelAttribute(name="empleado")
    Empleado empleado){
        servicioEmpleado.guardar(empleado);
        // System.out.println("PROBANDO "+ empleado.getNombre());
        return "redirect:/portalEmpleado";
    }
    
    @PostMapping("/crearCliente")
    public String crearCliente(@ModelAttribute(name="cliente")
    Cliente cliente, @RequestParam(name ="imagenDni", required = false)
    MultipartFile imagenDni){
        servicioCliente.guardar(cliente);
        
        if(imagenDni != null){
            String rutaAbsoluta ="C://Users//mpaterna//Documents//recursosEmpleado";
            Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+imagenDni.getOriginalFilename());
            
            try {
                byte[] bytesimagenDni = imagenDni.getBytes();
                Files.write(rutaCompleta, bytesimagenDni);
                cliente.setImagenDni(imagenDni.getOriginalFilename());
                servicioCliente.guardar(cliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/portalEmpleado";
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

        return "redirect:/portalEmpleado";
    }
}


