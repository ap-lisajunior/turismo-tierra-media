package turismotierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void queSeCreaNuevoUsuarioYNoEsNulo() {
		Usuario gandalf = new Usuario("Gandalf", 100, 5, TipoAtraccion.PAISAJE);
		
		assertNotNull(gandalf);
	}
	
	@Test
	public void queSeConstruyaConValoresDeParametroCorrectos() {
		Usuario gandalf = new Usuario("Gandalf",100, 5, TipoAtraccion.PAISAJE);
		
		
		assertEquals(TipoAtraccion.PAISAJE, gandalf.getTipoAtraccion());
		assertEquals(100, gandalf.getPresupuesto());
		assertEquals(5, gandalf.getTiempo(), 0);
		assertEquals("Gandalf", gandalf.getNombre());
	}
	
	
}
