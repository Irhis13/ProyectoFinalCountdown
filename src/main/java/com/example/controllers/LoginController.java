package com.example.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    
    // Añadimos los comandos necesarios para que muestre un mensaje de error en caso de escribir mal el login
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
    @RequestParam(value = "logout", required = false) String logout,
    Model model, Principal principal, RedirectAttributes attribute) {

        if(error!=null) {
            model.addAttribute("error", "ERROR DE ACCESO: Usuario y/o Contraseña son incorrectos");
        }

        // Para en el caso de ya haber iniciado sesión que muestre mensaje y redirija al home
        if(principal!=null) {
            attribute.addFlashAttribute("warning", "ATENCIÓN: La sesión fue iniciada anteriormente");
            return "redirect:/home";
        }

        if(logout!=null) {
            model.addAttribute("succes", "ATENCIÓN: Ha finalizado sesión con éxito");
        }

        return "login";
    }
}
