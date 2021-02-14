import org.junit.Assert;
import org.junit.Test;


public class PorcentualTest {

	@Test
	public void calcularPromoTest() {
		Atraccion atraccionTest = new Atraccion("atraccionTest1", 10, 2, 10, TipoDeAtraccion.PAISAJE);
		Atraccion atraccionTest1 = new Atraccion("atraccionTest2", 10, 2, 10, TipoDeAtraccion.PAISAJE);
		
		Porcentual promoPorcentualTest = new Porcentual(atraccionTest, atraccionTest1, 0.80);
		
		double costo = promoPorcentualTest.getCostoTotal();
		double tiempo = promoPorcentualTest.getTiempoTotal();
		
		Assert.assertEquals(16.0, costo, 0);
		Assert.assertEquals(4.0, tiempo, 0);
	}

	@Test (expected = Error.class)
	public void crearPromoTest() {
		Atraccion atraccionTest = new Atraccion("atraccionTest1", 10, 2, 10, TipoDeAtraccion.DEGUSTACION);
		Atraccion atraccionTest1 = new Atraccion("atraccionTest2", 10, 2, 10, TipoDeAtraccion.PAISAJE);
		
		new Porcentual(atraccionTest, atraccionTest1, 0.80);
		
	}
}
