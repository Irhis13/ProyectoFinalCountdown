package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

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
			categoriaSrv.guardar(Categoria.builder().nombre("Aventura").descripcion("Viajes divertidos repletos de aventuras").enlaceImagen("https://previews.123rf.com/images/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fond.jpg")
			.build());
			categoriaSrv.guardar(Categoria.builder().nombre("Cultural").descripcion("Viajes divertidos repletos de cultura").enlaceImagen("https://previews.123rf.com/images/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fond.jpg")
			.build());
			categoriaSrv.guardar(Categoria.builder().nombre("Familiar").descripcion("Viajes para toda la familia").enlaceImagen("https://previews.123rf.com/images/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fond.jpg")
			.build());
			categoriaSrv.guardar(Categoria.builder().nombre("Pareja").descripcion("Viajes romáticos").enlaceImagen("https://previews.123rf.com/images/amitspro/amitspro1706/amitspro170600016/80099376-mandala-de-flor-abstracta-patr%C3%B3n-decorativo-fondo-azul-imagen-cuadrada-imagen-de-ilusi%C3%B3n-patr%C3%B3n-fond.jpg")
			.build());

			//Viajes
			////////Categoria id:1 - AVENTURA
			viajeSrv.guardar(Viaje.builder().nombre("Hazaña Inca").descripcion("Viaja al año 1460 y visita el mayor imperio de la Amércia precolombina. Contempla Machu Pichu en todo su esplendor y realiza el viaje de iniciación de los guerreros Incas, acompañado por uno de nuestros guías especializados .")
			.precio(2500.0).categoria(categoriaSrv.getCategoria(1)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Aventura%20-%20IncasOkPeq.png?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Travesía Vikinga").descripcion("Embárcate en el drakkar más famoso del rey vikingo Olaf Tryggvason en el año 998. Brinda en honor a Odin, el Vallhala te esperá.")
			.precio(3250.0).categoria(categoriaSrv.getCategoria(1)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Aventura%20-%20VikingosOKPeq.png?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Upside-Down").descripcion("Sólo para amantes de las emociones fuertes….. ¿Quieres conocer el mundo del Demogorgon y Vecna? Adiestra a tu propio demoperro y maravillate con el poder del Azotamentes.")
			.precio(3250.0).categoria(categoriaSrv.getCategoria(1)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Aventura%20-%20UpsideDownOK.png?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Naboo").descripcion("Conoce las verdes llanuras de Naboo , sus colinas, frondosos bosques y bellas cascadas de agua cristalina y lagos o pantanos de densa profundidad donde los gungans habitan.")
			.precio(2386.0).categoria(categoriaSrv.getCategoria(1)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Aventura%20-%20NabooOk.png?raw=true").build());

			///////////////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////Categoria id:2 - CULTURAL
			viajeSrv.guardar(Viaje.builder().nombre("Tierra Media").descripcion("Visita la Comarca año 2670 de la Tercera Edad, alójate en un acogedor agujero Hobbit, disfruta de los fuegos artificiales, goza de la gastronomía local y prueba la famosa hierba de la comarca.")
			.precio(3250.0).categoria(categoriaSrv.getCategoria(2)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/TierraMediaAzulOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Crucero Maravillas Mundo Antiguo").descripcion("Puedes visitar los grandes hitos de la cultura clásica que en un crucero, verás: el Faro de Alejandría, el Coloso de Rodas, el Templo de Artemisa, la Estatua de Zeus, el Mausoleo de Halicarnaso, y los Jardines Colgantes de Babilonia.")
			.precio(3250.0).categoria(categoriaSrv.getCategoria(2)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Cultural%20-%20MaravillasOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Orígenes del Jazz").descripcion("Si lo tuyo es la música... Años 20, Nueva Orleans, Lousiana…. El jazz comienza a despuntar como género propio, los músicos se reúnen en clubs clandestinos para improvisar. Únete a ellos y conoce de primera mano el orígen de estas melodías.")
			.precio(3250.0).categoria(categoriaSrv.getCategoria(2)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Cultural%20-%20JazzOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Atlantis").descripcion("Descubre esta mítica cultura perdida descrita por Platón  como una isla situada más allá de las columnas de Hércules, más grande que Libia y Asia Menor juntas. Sumérgete en su cultura y maravillate de su avanzada tecnología.")
			.precio(3250.0).categoria(categoriaSrv.getCategoria(2)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Cultural%20-%20AtlantisOKPeq.jpg?raw=true").build());

			// ///////////////////////////////////////////////////////////////////////////////////////////////////////////
			// ////////Categoria id:3 - FAMILIAR
			viajeSrv.guardar(Viaje.builder().nombre("Jurassic Park").descripcion("Viaja a  Isla Nublar y contempla el parque de ocio más famoso del mundo. Visita los laboratorios y aprende con Mr. ADN acerca del proceso de creación de nuestros dinosaurios. ")
			.precio(2386.0).categoria(categoriaSrv.getCategoria(3)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Familiar%20-%20JurassicOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Hogsmeade").descripcion("Especial Navidad en Hogsmeade. Disfruta de la cerveza de mantequilla, los helados de Florean Fortescue y de la tienda de artículos para bromas Zonko.")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(3)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Familiar%20-%20HogsmeadeOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Narnia").descripcion("Embárcate en el Lucero del Alba del Principe Caspian, prueba unas exquisitas delicias turcas en el palacio de la Reina de Hielo y disfruta de la compañía del Señor Tumnus o Aslan.")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(3)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Familiar%20-%20NarniaOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Ruta de la Seda").descripcion("Contempla Samarkanda, la ciudad de los mil colores. Disfruta de las idas y venidas de mercaderes que les despachaban a romanos y persas las sedas de Oriente. Visita en familia los oasis repletos de animales exóticos que dieron fama a la leyenda.")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(3)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/RutaSedaVerde.jpg?raw=true").build());
			
			// ////////Categoria id:4 - PAREJA
			viajeSrv.guardar(Viaje.builder().nombre("París Bohemio").descripcion("Oh là là! París, año 1890. El barrio de Montmartre es el punto de reunión de los artistas más importantes del momento. La música, el teatro, los picnics en los canales….. ¿Acaso hay algo más romántico sobre la faz de la tierra? ")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(4)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Parejas%20-%20MontmartePeqOk.png?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Roma Años 60").descripcion("Disfruta la dolce vita como un auténtico italiano. Recorre la ciudad de Roma con tu Vespa junto a tu pareja, lanza una moneda en la Fontana di Trevi o simplemente dejate llevar por la magia en el ambiente.")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(4)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Parejas%20-%20DolceVitaOKPeq.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Mamma Mia").descripcion("Alójate en el Hotel Villa Donna y vive en primera persona el reenuentro de un amor de juventud en las islas griegas. Toda una experiencia rodeada por una música vibrante y llena de vida.")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(4)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Parejas%20-%20MammaMiaPeqOk.jpg?raw=true").build());
			viajeSrv.guardar(Viaje.builder().nombre("Moulin Rouge").descripcion("En el París de Toulose-Lautrec, sé testigo de la hermosa y trágica historia de amor entre el bohemio Christian y la bella artsita Satine.  Porque como dice la canción: The greatest thing you'll ever learn is just to love and be loved in return…")
			.precio(2125.0).categoria(categoriaSrv.getCategoria(4)).enlaceImagen("https://github.com/AsunPaterna/img_chrono/blob/main/Parejas%20-%20MoulinPeq1.jpg?raw=true").build());
			

			//VIAJES PARA AÑADIR EN LA LISTA
			Viaje viajeCliente1 = viajeSrv.getViaje(1);
			Viaje viajeCliente2 = viajeSrv.getViaje(2);
			Viaje viajeCliente3 = viajeSrv.getViaje(3);
			Viaje viajeCliente4 = viajeSrv.getViaje(4);
			////////////LISTA VIAJES CLIENTE
			List<Viaje> viajes1 = new ArrayList<>();
			viajes1.add(viajeCliente1);
			viajes1.add(viajeCliente2);
		

			List<Viaje> viajes2 = new ArrayList<>();
			viajes2.add(viajeCliente3);
			viajes2.add(viajeCliente4);

			
			//Cliente
			clienteSrv.guardar(Cliente.builder().nombre("Herminia").apellidos("Garcia Velez")
			.imagenDni("1.jpg").fechaSalida(LocalDate.parse("2020-10-10"))
			.fechaRegreso(LocalDate.parse("2022-10-10")).telefono("999887766")
			.email("aa@aa.com").viaje(viajes1).build());			
			
			clienteSrv.guardar(Cliente.builder().nombre("Eufrasia").apellidos("Cochamba Luengo")
			.imagenDni("2.jpg").fechaSalida(LocalDate.parse("2020-01-10"))
			.fechaRegreso(LocalDate.parse("2022-01-10")).telefono("999887766").email("ee@ee.com")
			.viaje(viajes2).build());

 
		};
	}
}