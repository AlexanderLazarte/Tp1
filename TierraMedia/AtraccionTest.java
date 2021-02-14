import org.junit.Assert;
import org.junit.Test;


public class AtraccionTest {

	@Test
	public void aceptarTest() {
		Atraccion atraccionTest = new Atraccion("atraccionDePrueba", 500, 10, 5, TipoDeAtraccion.DEGUSTACION);
		
		
		 Assert.assertEquals("Cupo disminuido", 4, atraccionTest.getCupo());
		 
	}

}
