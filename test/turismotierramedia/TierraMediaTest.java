package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TierraMediaTest {

	@Test
	public void queOrdenaSegunCostoMayor() {
		Producto p1 = new Atraccion("Moria",10,2,6,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Producto p3 = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		Producto p4 = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		
		TurismoTierraMedia.ordenarProductosPorCosto(productos);
		
		assertEquals(p4, productos.get(0));
		assertEquals(p1, productos.get(1));
		assertEquals(p2, productos.get(2));
		assertEquals(p3, productos.get(3));
		
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
	public void queOrdenaSegunTiempoMayor() {
		Producto p1 = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		Producto p3 = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
		Producto p4 = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		
		TierraMedia.ordenarProductosPorTiempo(productos);
		
		assertEquals(p1, productos.get(0));
		assertEquals(p2, productos.get(1));
		assertEquals(p4, productos.get(2));
		assertEquals(p3, productos.get(3));
		
	}
	
	@Test
	public void queSeCreeUnNuevoProductoYNoSeaNulo() {
		Producto p1 = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		
		assertNotNull(p1);
		
	}
	
	@Test
	public void queSeOrdenanSegunTipoDeAtraccion() {
		Producto p1 = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		Producto p3 = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
		Producto p4 = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		
		TierraMedia.ordenarProductosPorTipoAtraccion(productos);
		
		assertEquals(p1, productos.get(0));
		assertEquals(p2, productos.get(1));
		assertEquals(p4, productos.get(2));
		assertEquals(p3, productos.get(3));
		
	}
	
	@Test
	public void queSeCreaUnaPromocion() {
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
	
	
	
	
	
	
	

}
