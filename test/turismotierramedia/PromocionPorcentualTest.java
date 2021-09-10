package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionPorcentualTest {
	
	@Test
	public void queSeCreaYNoEsNula() {
		Atraccion bosqueNegro = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Atraccion mordor = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Atraccion> packAven = new LinkedList<Atraccion>();
		packAven.add(bosqueNegro);
		packAven.add(mordor);
		
		Producto packAventura = new PromocionPorcentual("Pack Aventura", packAven, TipoAtraccion.AVENTURA, 20);
		
		assertNotNull(packAventura);
		
	}
	
	@Test
	public void queEsPromocion() {
		Atraccion bosqueNegro = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Atraccion mordor = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Atraccion> packAven = new LinkedList<Atraccion>();
		packAven.add(bosqueNegro);
		packAven.add(mordor);
		
		Producto packAventura = new PromocionPorcentual("Pack Aventura", packAven, TipoAtraccion.AVENTURA, 20);
		
		assertTrue(packAventura.esUnaPromocion());
		
	}
	
	@Test
	public void queReduceCupoDeAtraccionesComponentes() {
		Atraccion bosqueNegro = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Atraccion mordor = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Atraccion> packAven = new LinkedList<Atraccion>();
		packAven.add(bosqueNegro);
		packAven.add(mordor);
		
		Producto packAventura = new PromocionPorcentual("Pack Aventura", packAven, TipoAtraccion.AVENTURA, 20);
		
		packAventura.reducirCupo();
		
		assertEquals(11, bosqueNegro.getCupo());
		assertEquals(3, mordor.getCupo());
		
	}
	
	@Test
	public void queCalculaCostoFinalCorrectamente() {
		Atraccion bosqueNegro = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Atraccion mordor = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Atraccion> packAven = new LinkedList<Atraccion>();
		packAven.add(bosqueNegro);
		packAven.add(mordor);
		
		Producto packAventura = new PromocionPorcentual("Pack Aventura", packAven, TipoAtraccion.AVENTURA, 0.2);
		
		assertEquals(Integer.valueOf((int) 22.4), packAventura.getCosto());
	}
	
	@Test
	public void queSeCreaConValoresDeParametrosCorrectos() {
		Atraccion bosqueNegro = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Atraccion mordor = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Atraccion> packAven = new LinkedList<Atraccion>();
		packAven.add(bosqueNegro);
		packAven.add(mordor);
		
		Producto packAventura = new PromocionPorcentual("Pack Aventura", packAven, TipoAtraccion.AVENTURA, 0.2);
		
		assertEquals("Pack Aventura", packAventura.getNombre());
		assertEquals(packAven, packAventura.getAtracciones());
		assertEquals(TipoAtraccion.AVENTURA, packAventura.tipoAtraccion);
	}

	
}
