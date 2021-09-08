package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionAxBTest {

	@Test
	public void queSeCreaYNoEsNula() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE, TipoPromocion.AXB);
		
		assertNotNull(packPaisajes);
	}
	
	@Test
	public void queSeCreaConValoresDeParametrosCorrectos() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE, TipoPromocion.AXB);
		
		assertEquals("Pack Paisajes", packPaisajes.getNombre());
		assertEquals(packPaisa, packPaisajes.getAtracciones());
		assertEquals(TipoAtraccion.PAISAJE, packPaisajes.getTipoAtraccion());
		assertEquals(TipoPromocion.AXB, packPaisajes.getTipoPromocion());
		
	}
	
	@Test
	public void queEsPromocion() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE, TipoPromocion.AXB);
		
		assertTrue(packPaisajes.esUnaPromocion());
	}
	
	@Test
	public void queReduceCupoEnAtraccionesComponentes() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE, TipoPromocion.AXB);
		
		packPaisajes.reducirCupo();
		
		assertEquals(24, minasTirith.getCupo());
		assertEquals(14, abismoDeHelm.getCupo());
		assertEquals(31, erebor.getCupo());
	}
	
	@Test
	public void queCalculaCostoFinalCorrectamente() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE, TipoPromocion.AXB);
		
		assertEquals(Integer.valueOf(10), packPaisajes.getCosto());
		
	
	}
	


}
