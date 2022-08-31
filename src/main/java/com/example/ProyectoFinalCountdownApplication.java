package com.example;

import java.time.LocalDate;

// import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entities.Categoria;
import com.example.entities.Cliente;
import com.example.entities.Viaje;
import com.example.service.ICategoriaService;
import com.example.service.IClienteService;
// import com.example.service.IClienteService;
import com.example.service.IViajeService;

@SpringBootApplication
public class ProyectoFinalCountdownApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalCountdownApplication.class, args);
	}


	///////////////////FALTA POR AÑADIR EL IEMPLEADOSERVICE
	@Bean
	public CommandLineRunner demoData(ICategoriaService categoriaSrv, IViajeService viajeSrv, IClienteService clienteSrv){
		return args ->{
			//Categoria id:1 -> Aventura
			//Categoria id:2 -> Cultural
			//Categoria id:3 -> Familiar
			//Categoria id:4 -> Pareja

			//Categorias
			categoriaSrv.guardar(Categoria.builder().nombre("Aventura").descripcion("Viajes divertidos repletos de aventuras")
			.build());
			categoriaSrv.guardar(Categoria.builder().nombre("Cultural").descripcion("Viajes divertidos repletos de cultura")
			.build());
			categoriaSrv.guardar(Categoria.builder().nombre("Familiar").descripcion("Viajes para toda la familia")
			.build());
			categoriaSrv.guardar(Categoria.builder().nombre("Pareja").descripcion("Viajes romáticos")
			.build());

			//Viajes
			////////Categoria id:1
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 1").descripcion("BLA").precio(100.0)
			.categoria(categoriaSrv.getCategoria(1)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 1- Copia").descripcion("BLA").precio(100.0)
			.categoria(categoriaSrv.getCategoria(1)).build());

			////////Categoria id:2
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 2").descripcion("BLABLA").precio(200.0)
			.categoria(categoriaSrv.getCategoria(2)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 2 - Copia").descripcion("BLABLA").precio(200.0)
			.categoria(categoriaSrv.getCategoria(2)).build());
			
			////////Categoria id:3
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 3").descripcion("BLABLABLA").precio(300.0)
			.categoria(categoriaSrv.getCategoria(3)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 3 - Copia").descripcion("BLABLABLA").precio(300.0)
			.categoria(categoriaSrv.getCategoria(3)).build());

			////////Categoria id:4
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 4").descripcion("BLABLABLABLA").precio(400.0)
			.categoria(categoriaSrv.getCategoria(4)).build());
			viajeSrv.guardar(Viaje.builder().nombre("Viaje 4 - Copia").descripcion("BLABLABLABLA").precio(400.0)
			.categoria(categoriaSrv.getCategoria(4)).build());
			
			
			//Cliente
			clienteSrv.guardar(Cliente.builder().nombre("Herminia").apellidos("Garcia Velez").imagenDni("1.jpg").fechaSalida(LocalDate.parse("2020-10-10")).fechaRegreso(LocalDate.parse("2022-10-10")).telefono("999887766").email("aa@aa.com").viaje(viajeSrv.getViaje(1)).build());
			clienteSrv.guardar(Cliente.builder().nombre("Eufrasia").apellidos("Cochamba Luengo").imagenDni("2.jpg").fechaSalida(LocalDate.parse("2020-01-10")).fechaRegreso(LocalDate.parse("2022-01-10")).telefono("999887766").email("ee@ee.com").viaje(viajeSrv.getViaje(2)).build());


		};
	}
}