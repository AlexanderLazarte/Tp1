import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeerDatosTest {
	
	private LeerDatos lector;
	private ArrayList<Usuario> listaDeUsuarios;
	private ArrayList<Atraccion> listaDeAtracciones;
	private ArrayList<Promocion> listaDePromociones;
	
	@Before
	public void situacionInicial(){
		lector = new LeerDatos();
		listaDeUsuarios = lector.obtenerDatosUsuarios();
		listaDeAtracciones = lector.obtenerDatosAtracciones();
		listaDePromociones = lector.obtenerDatosPromociones(listaDeAtracciones);
		
	}

	@Test
	public void pruebaDeTamañoDeListaDeUsuarios() {

		int resultado = listaDeUsuarios.size();
		
		Assert.assertEquals(resultado, 3);
		
	}
	
	@Test
	public void pruebaDeUsuariosGuardadosEnLaLista() {
		
		String resultado =listaDeUsuarios.get(0).getNombre();
		
		Assert.assertEquals("Usuario nombrecito", "Nombrecito", resultado);
		
	}
	@Test
	public void pruebaDeDatosGuardadosEnPosicion2DeLaLista() {
		
		TipoDeAtraccion resultado = listaDeUsuarios.get(2).getPreferencia();
		
		Assert.assertEquals("Preferencia AVENTURA", TipoDeAtraccion.AVENTURA, resultado);
		
	}
	@Test
	public void pruebaDeListaVaciaDeUsuarios() {
		
		boolean resultado = listaDeUsuarios.isEmpty();
				
		Assert.assertFalse("La lista esta Vacia", resultado);
		
	}
	
	@Test
	public void pruebaDeListaDeAtracciones() {

		int resultado = listaDeAtracciones.size();
		
		Assert.assertEquals(resultado, 9);
		
	}
	@Test
	public void pruebaDeNombreGuardadoDeAtraccion() {
		
		String resultado = listaDeAtracciones.get(3).getNombreDeLaAtraccion();
		
		Assert.assertEquals("Atracion Mordor", "Mordor", resultado);
		
	}
	@Test
	public void pruebaDeDatosGuardadosEnLaListaDeAtraccion() {
		
		TipoDeAtraccion resultado = listaDeAtracciones.get(4).getTipoDeAtraccion();
		
		Assert.assertEquals("Preferencia PAISAJE", TipoDeAtraccion.PAISAJE, resultado);
		
	}
	@Test
	public void pruebaDeListaDeAtraccionesVacia() {
		
		boolean resultado = listaDeAtracciones.isEmpty();
		
		Assert.assertFalse("La lista esta Vacia", resultado);
		
	}
	
	
	@Test
	public void pruebaDeListaDePromocionesTamaño() {

	
		Assert.assertEquals(9, listaDePromociones.size());;
		
	}
	@Test
	public void pruebaDeCostoTotalGuardadoDePromocionDosPorUno() {
		
	
		double resultado = listaDePromociones.get(2).getCostoTotal();
		
		Assert.assertEquals(45, resultado, 0);
		
	}
	@Test
	public void pruebaDeDatosTipoDeAtraccionDeLaPromo() {
	
		
		TipoDeAtraccion tipoDeAtraccion = listaDePromociones.get(0).getTipoDeLasAtracciones();
		
		Assert.assertEquals(TipoDeAtraccion.AVENTURA, tipoDeAtraccion);
		
	}
	
	@Test
	public void pruebaDeCostoTotalGuardadoDePromocionFijo() {
		
		double resultado = listaDePromociones.get(4).getCostoTotal();
		
		Assert.assertEquals(14, resultado, 0);
		
	}
	
	@Test
	public void pruebaDeCostoTotalGuardadoDePromocionPorcentual() {
		
		double resultado = listaDePromociones.get(7).getCostoTotal();
		
		Assert.assertEquals(9.1, resultado, 0);
		
	}
	
}
