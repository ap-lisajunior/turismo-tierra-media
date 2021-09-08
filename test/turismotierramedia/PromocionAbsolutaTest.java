package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionAbsolutaTest {

	@Test
	public void queSeCreaYNoEsNula() {
		Atraccion lothlórien = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlórien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustación", packD, TipoAtraccion.DEGUSTACION, TipoPromocion.ABSOLUTA,36);
		
		assertNotNull(packDegustacion);
		
		}
	
	@Test
	public void queSeCreaConValoresDeParametrosCorrectos() {
		Atraccion lothlórien = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlórien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustación", packD, TipoAtraccion.DEGUSTACION, TipoPromocion.ABSOLUTA,36);
		
		assertEquals("Pack Degustación", packDegustacion.getNombre());
		assertEquals(packD, packDegustacion.getAtracciones());
		assertEquals(TipoAtraccion.DEGUSTACION, packDegustacion.getTipoAtraccion());
		assertEquals(TipoPromocion.ABSOLUTA, packDegustacion.getTipoPromocion());
		assertEquals(Integer.valueOf(36), packDegustacion.getCosto());
	}
	
	@Test
	public void queEsPromocion() {
		Atraccion lothlórien = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlórien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustación", packD, TipoAtraccion.DEGUSTACION, TipoPromocion.ABSOLUTA,36);
		
		assertTrue(packDegustacion.esUnaPromocion());
	}
	
	@Test
	public void queReduceCupoEnAtraccionesComponentes() {
		Atraccion lothlórien = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
		Atraccion laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add(lothlórien);
		packD.add(laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustación", packD, TipoAtraccion.DEGUSTACION, TipoPromocion.ABSOLUTA,36);
		
		packDegustacion.reducirCupo();
		
		assertEquals(29, lothlórien.getCupo());
		assertEquals(149, laComarca.getCupo());
		
	}
	
	
	
	}
