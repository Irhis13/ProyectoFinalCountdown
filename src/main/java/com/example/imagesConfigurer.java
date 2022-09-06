package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class imagesConfigurer implements WebMvcConfigurer {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // LAS RUTAS DEBERÁN SER ADAPTADAS DEPENDIENDO DEL PC DONDE SE REALICE LA PRESENTACIÓN DEL PROYECTO////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/recursosEmpleado/**")
        .addResourceLocations("file:///C:/Users/mpaterna/Documents/recursosEmpleado/");
    }
}