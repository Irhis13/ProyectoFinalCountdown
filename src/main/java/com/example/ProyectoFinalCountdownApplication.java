package com.example;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entities.Categoria;
import com.example.entities.Cliente;
import com.example.entities.Viaje;
import com.example.service.ICategoriaService;
import com.example.service.IClienteService;
import com.example.service.IViajeService;

@SpringBootApplication
public class ProyectoFinalCountdownApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalCountdownApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(ICategoriaService categoriaSrv, IViajeService viajeSrv, IClienteService clienteSrv){
		return args ->{

			//Creacion de categorías
			categoriaSrv.guardar(Categoria.builder().nombre("Aventura").descripcion("blabla").build());
			categoriaSrv.guardar(Categoria.builder().nombre("Familia").descripcion("blabla").build());
			categoriaSrv.guardar(Categoria.builder().nombre("Pareja").descripcion("blabla").build());
			categoriaSrv.guardar(Categoria.builder().nombre("Cultural").descripcion("blabla").build());

			//Creacion viajes
			///¡¡¡CUIDADO CON LOS NOMBRES DE LOS ATRIBUTOS, REPASAR!!!!!!
				//Viajes categoria 1 - Aventura
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 1").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(1)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 2").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(1)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 3").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(1)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 4").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(1)).build());

			//Viajes categoria 2 - Familia
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 1").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(2)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 2").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(2)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 3").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(2)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 4").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(2)).build());
			
			//Viajes categoria 3 - Pareja
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 1").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(3)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 2").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(3)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 3").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(3)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 4").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(3)).build());

			//Viajes categoria 4 - Cultural
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 1").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(4)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 2").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(4)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 3").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(4)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 4").descripcion("descripcion").precio(0.0).vestuarioExtra(true).reportajeExtra(true).categoria(categoriaSrv.getCategoria(4)).build());


			//Cliente - viaje 1
			clienteSrv.guardar(Cliente.builder().nombre("nombre").apellidos("apellidos").imagenDni("imagenDni").fechaSalida(LocalDate.parse("2022-10-10")).fechaRegreso(LocalDate.parse("2022-10-11")).telefono("telefono").email("email").viaje(viajeSrv.getViaje(1)).build());
		
			
			//REVISAR Y CREAR EMPLEADO SI SE NECESITASE
		};
	}
}
