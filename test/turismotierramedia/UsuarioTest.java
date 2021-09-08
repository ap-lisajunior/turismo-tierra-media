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
	
	@Test
	public void quePuedeComprarProducto() {
		Usuario gandalf = new Usuario("Gandalf",100, 5, TipoAtraccion.PAISAJE);
		Atraccion a1 = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		
		assertTrue(gandalf.puedeComprar(a1));
	}
	
	@Test
	public void queRduceTiempoYMonedasAlAceptarProducto() {
		Usuario gandalf = new Usuario("Gandalf",100, 5, TipoAtraccion.PAISAJE);
		Atraccion a1 = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		
		gandalf.aceptarOferta(a1);
		
		assertEquals(95, gandalf.getPresupuesto());
		assertEquals(2.5, gandalf.getTiempo(), 0);
	}
	
	
	
	
	
	
}
