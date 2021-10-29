package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionAbsolutaTest {

	@Test
	public void queSeCreaYNoEsNula() {
		Atraccion lothlorien = new Atraccion("Lothl�rien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlorien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustaci�n", packD, TipoAtraccion.DEGUSTACION,36);
		
		assertNotNull(packDegustacion);
		
		}
	
	@Test
	public void queSeCreaConValoresDeParametrosCorrectos() {
		Atraccion lothlorien = new Atraccion("Lothl�rien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlorien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustaci�n", packD, TipoAtraccion.DEGUSTACION,36);
		
		assertEquals("Pack Degustaci�n", packDegustacion.getNombre());
		assertEquals(packD, packDegustacion.getAtracciones());
		assertEquals(TipoAtraccion.DEGUSTACION, packDegustacion.getTipoAtraccion());
		assertEquals(Integer.valueOf(36), packDegustacion.getCosto());
	}
	
	@Test
	public void queEsPromocion() {
		Atraccion lothlorien = new Atraccion("Lothl�rien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlorien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustaci�n", packD, TipoAtraccion.DEGUSTACION,36);
		
		assertTrue(packDegustacion.esUnaPromocion());
	}
	
	@Test
	public void queReduceCupoEnAtraccionesComponentes() {
		Atraccion lothlorien = new Atraccion("Lothl�rien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlorien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustaci�n", packD, TipoAtraccion.DEGUSTACION,36);
		
		packDegustacion.reducirCupo();
		
		assertEquals(29, lothlorien.getCupo());
		assertEquals(149, laComarca.getCupo());
		
	}
	
	
	
	}
