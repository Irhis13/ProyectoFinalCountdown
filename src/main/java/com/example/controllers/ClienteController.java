package com.example.controllers;

import java.io.IOException;
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

    // Este método crea el modelo. El objetivo del modelo es crear un objeto para
    // poder pasarlo al html.
    public String getClientes(Model model) {
        model.addAttribute("clientes", servicioCliente.getClientes());
        return "clientes";
    }

    // Este método permite que aparezca el cliente que ha sido creado a partir del 
    // formulario HTML (formularioAltaCliente). 
    //¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡RECORDAR QUE EL NOMBRE DEL HTML DEBE COINCIDIR CON EL DE AQUÍ!!!!
    @GetMapping("/formulario")
    public String showFormulario(ModelMap map) {
        map.addAttribute("cliente", new Cliente());
        map.addAttribute("categorias", servicioCategoria.getCategorias());
        return "formularioAltaCliente";
    }

    // Creamos el cliente y configuramos la adhesión de la imagen del DNI
    @PostMapping("/crearCliente")
    public String crearCliente(@ModelAttribute(name = "cliente") Cliente cliente,
        @RequestParam(name = "imagen", required = false) MultipartFile imagenDNI) {

            if (imagenDNI != null) {

                // Ruta donde se guardará la imagen. 
                //¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡IMPORTANTE ESTABLECER LA CORRECTA PARA LA PRESENTACIÓN!!!!!
                String rutaAbsoluta = "C://Users//amoyamon//Documents//recursos";

                // Concatenamos la ruta con el nombre de la imagen
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagenDNI.getOriginalFilename());

                try {
                    byte[] bytesDNIimg = imagenDNI.getBytes();
                    Files.write(rutaCompleta, bytesDNIimg);
                    cliente.setImagenDni(imagenDNI.getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
            return "redirect:/listadoClientes";
        }

    // Forma 1:
    // @GetMapping("/forma1")
    // public ModelAndView porForma1(@RequestParam(name = "nombre") String nombre) {
    //     ModelAndView mav = new ModelAndView();
    //     mav.setViewName("forma1");
    //     mav.addObject("nombre", nombre);

    //     return mav;
    // }

    // Forma 2:
    @GetMapping("/forma2/{id}")
    public ModelAndView porForma2(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forma2");
        mav.addObject("valorRecibido", id);

        return mav;
    }

    // Para que se muestren los detalles del Cliente
    @GetMapping("/detalles/{id}")
    public ModelAndView detalles(@PathVariable(name = "id") int id) {

        Cliente cliente = servicioCliente.getCliente(id);
        ModelAndView mav = new ModelAndView();

        mav.setViewName("detalles");
        mav.addObject("cliente", cliente);

        return mav;
    }

    // Para modificar los detalles del cliente
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

    // Para eliminar clientes
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable(name = "id") int id) {

        servicioCliente.eliminar(id);

        return "redirect:/listadoClientes";
    }

}




