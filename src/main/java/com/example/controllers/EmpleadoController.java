package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Empleado;
import com.example.service.IEmpleadoService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/")
public class EmpleadoController {
    
    @Autowired
    private IEmpleadoService servicioEmpleado;

    @GetMapping("/listadoEmpleados")
    public String getEmpleados(Model model) {

        model.addAttribute("empleados", servicioEmpleado.getEmpleados());
        return "empleados";
    }

    @GetMapping("/formularioEmp")
    public String showFormulario(ModelMap map) {

        map.addAttribute("empleado", new Empleado());
        return "formularioAltaEmpleado";
    }

}
