package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class ItinerarioTest {

	@Test
	public void queSeCreaItinerarioYNoEsNulo() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE);
		
		
		Producto mordor = new Atraccion("Mordor",25 ,3 ,4 ,TipoAtraccion.AVENTURA);
		
		LinkedList<Producto> itinerario = new LinkedList<Producto>();
		
		itinerario.add(packPaisajes);
		itinerario.add(mordor);
		
		assertNotNull(itinerario);
		
	}
	
	@Test
	public void queContieneUnaPromocionYUnaAtraccion() {
		Atraccion minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> packPaisa = new LinkedList<Atraccion>();
		packPaisa.add(minasTirith);
		packPaisa.add(abismoDeHelm);
		packPaisa.add(erebor);
		
		Producto packPaisajes = new PromocionAxB("Pack Paisajes", packPaisa, TipoAtraccion.PAISAJE);
		
		
		Producto mordor = new Atraccion("Mordor",25 ,3 ,4 ,TipoAtraccion.AVENTURA);
		
		LinkedList<Producto> itinerario = new LinkedList<Producto>();
		
		itinerario.add(packPaisajes);
		itinerario.add(mordor);
		
		assertTrue(itinerario.contains(packPaisajes));
		assertTrue(itinerario.contains(mordor));
	}
	
	
}
