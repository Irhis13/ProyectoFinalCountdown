package com.example;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entities.Categoria;
// import com.example.entities.Cliente;
import com.example.entities.Viaje;
import com.example.service.ICategoriaService;
// import com.example.service.IClienteService;
import com.example.service.IViajeService;

@SpringBootApplication
public class ProyectoFinalCountdownApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalCountdownApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(ICategoriaService categoriaSrv, IViajeService viajeSrv){
		return args ->{

			categoriaSrv.guardar(Categoria.builder().nombre("nombre").descripcion("descripcion").build());
			viajeSrv.guardar(Viaje.builder().nombre("nombre").descripcion("descripcion").precio(0.0)
			.categoria(categoriaSrv.getCategoria(1)).build());
		};
	}
}