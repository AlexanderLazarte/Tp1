import org.junit.Assert;
import org.junit.Test;


public class DosPorUnoTest {

	@Test
	public void calcularPromoTest() {
		Atraccion atraccionTest = new Atraccion("atraccionTest1", 15, 2, 10, TipoDeAtraccion.PAISAJE);
		Atraccion atraccionTest1 = new Atraccion("atraccionTest2", 50, 3, 10, TipoDeAtraccion.PAISAJE);
		Atraccion atraccionTest2 = new Atraccion("atraccionGratis", 5, 3, 10, TipoDeAtraccion.PAISAJE);
		
		DosPorUno promoDosPorUnoTest = new DosPorUno(atraccionTest, atraccionTest1, atraccionTest2);
		
		double costo = promoDosPorUnoTest.getCostoTotal();
		double tiempo = promoDosPorUnoTest.getTiempoTotal();
		
		Assert.assertEquals(65.0, costo, 0);
		Assert.assertEquals(8.0, tiempo, 0);
	}

	@Test (expected = Error.class)
	public void crearPromoTest() {
		Atraccion atraccionTest = new Atraccion("atraccionTest1", 10, 2, 10, TipoDeAtraccion.DEGUSTACION);
		Atraccion atraccionTest1 = new Atraccion("atraccionTest2", 50, 2, 10, TipoDeAtraccion.PAISAJE);
		Atraccion atraccionTest2 = new Atraccion("atraccionGratis", 5, 3, 10, TipoDeAtraccion.PAISAJE);
		
		new DosPorUno(atraccionTest, atraccionTest1, atraccionTest2);
		
	}

}
