package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class AtraccionTest {
	
	@Test
	public void queSeCreaUnaAtraccionYNoSeaNula() {
		Producto p1 = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		
		assertNotNull(p1);
	}

	@Test
	public void queSeCreaUnaAtraccion() {
		Atraccion a1 = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Atraccion a3 = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		
		assertEquals(a1, atracciones.get(0));
		assertEquals(a2, atracciones.get(1));
		assertEquals(a3, atracciones.get(2));		
	}
	
	@Test
	public void queSonIgualesSiTienenElMismoNombre() {
		Producto p1 = new Atraccion("Moria",10,2,6,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Moria",2,5,8,TipoAtraccion.PAISAJE);
		
		assertEquals(p1, p2);
	}
	
	@Test
	public void queNoSonIgualesSiTienenDistintoNombre() {
		Producto p1 = new Atraccion("Moria",10,2,6,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Minas",10,2,6,TipoAtraccion.AVENTURA);
		
		assertNotEquals(p1, p2);
	}
	
	@Test
	public void queSeCreaConValoresDeParametroCorrectos() {
		Atraccion p1 = new Atraccion("Moria",10,2,6,TipoAtraccion.AVENTURA);
		
		assertEquals("Moria", p1.getNombre());
		assertEquals(Integer.valueOf(10), p1.getCosto());
		assertEquals(Double.valueOf(2), p1.getTiempo());
		assertEquals(6, p1.getCupo());
		assertEquals(TipoAtraccion.AVENTURA, p1.tipoAtraccion);
		
		
	}

}
