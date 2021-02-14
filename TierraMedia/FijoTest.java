import org.junit.Assert;
import org.junit.Test;


public class FijoTest {

	@Test
	public void calcularPromoTest() {
		Atraccion atraccionTest = new Atraccion("atraccionTest1", 15, 2, 10, TipoDeAtraccion.PAISAJE);
		Atraccion atraccionTest1 = new Atraccion("atraccionTest2", 10, 3, 10, TipoDeAtraccion.PAISAJE);
		
		Fijo promoFijoTest = new Fijo(atraccionTest, atraccionTest1, 5);
		
		double costo = promoFijoTest.getCostoTotal();
		double tiempo = promoFijoTest.getTiempoTotal();
		
		Assert.assertEquals(20.0, costo, 0);
		Assert.assertEquals(5.0, tiempo, 0);
	}

	@Test (expected = Error.class)
	public void crearPromoTest() {
		Atraccion atraccionTest = new Atraccion("atraccionTest1", 10, 2, 10, TipoDeAtraccion.DEGUSTACION);
		Atraccion atraccionTest1 = new Atraccion("atraccionTest2", 10, 2, 10, TipoDeAtraccion.PAISAJE);
		
		new Fijo(atraccionTest, atraccionTest1, 5);
		
	}

}
