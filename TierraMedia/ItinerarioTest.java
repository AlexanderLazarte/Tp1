import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ItinerarioTest {

	private LeerDatos lector;
	private ArrayList<Usuario> listaDeUsuarios;
	private ArrayList<Atraccion> listaDeAtracciones;
	private ArrayList<Promocion> listaDePromociones;
	private Itinerario itinerario;
	
	@Before
	public void situacionInicial(){
		lector = new LeerDatos();
		listaDeUsuarios = lector.obtenerDatosUsuarios();
		listaDeAtracciones = lector.obtenerDatosAtracciones();
		listaDePromociones = lector.obtenerDatosPromociones(listaDeAtracciones);
		itinerario = new Itinerario ( listaDeUsuarios.get(0));
	}
	
	
	@Test
	public void pruebaDeDevolverItinerarioVacio(){
		String resultado = itinerario.devolverItinerarioParcial();
		
		Assert.assertEquals("itinerario vacio", "El itinerario del usuario :Nombrecito se encuentra vacío", resultado);
	}
	
	@Test
	public void pruebaDeDevolverItinerario(){
		itinerario.agregarAtraccion(listaDeAtracciones.get(1));
		String resultado = itinerario.devolverItinerarioParcial();
		
		Assert.assertEquals("itinerario parcial", "El itinerario del usuario : Nombrecito, tiene un gasto total de :5.0,"
				+ " le va a llevar 2.5hs , y visitara las siguientes atracciones :Minas Tirith, ", resultado);
	}
	@Test
	public void pruebaDeDevolverItinerarioConMasDeUnaAtraccion(){
		itinerario.agregarAtraccion(listaDeAtracciones.get(1));
		itinerario.agregarAtraccion(listaDeAtracciones.get(8));
		String resultado = itinerario.devolverItinerarioParcial();
		Assert.assertEquals("itinerario parcial", "El itinerario del usuario : Nombrecito, tiene un gasto total de :15.0,"
				+ " le va a llevar 4.5hs , y visitara las siguientes atracciones :Minas Tirith, Campos de Pelennor, ", resultado);
	}
	@Test
	public void pruebaDeAgregarPromocion(){
		itinerario.agregarPromocion(listaDePromociones.get(1));
		String resultado = itinerario.devolverItinerarioParcial();
		
		Assert.assertEquals("itinerario parcial", "El itinerario del usuario : Nombrecito, tiene un gasto total de :10.0,"
				+ " le va a llevar 7.5hs , y visitara las siguientes atracciones :Minas Tirith, Abismo de Helm, Erebor, ", resultado);
	}
}

