import org.junit.Assert;
import org.junit.Test;


public class UsuarioTest {

	@Test
	public void comprobacionDeModificacionDeDatosTest() {
		Usuario usuarioTest = new Usuario("javier", 200, 18, TipoDeAtraccion.PAISAJE);
		
		usuarioTest.disminuirPresupuesto(500.0);
		usuarioTest.disminuirPresupuesto(100.0);
		usuarioTest.disminuirTiempoDisponible(20);
		usuarioTest.disminuirTiempoDisponible(10);
		
		Assert.assertEquals("Presupuesto", 100, usuarioTest.getPresupuesto(), 0);
		Assert.assertEquals("tiempo", 8, usuarioTest.getTiempo(), 0);
		
	}

}
