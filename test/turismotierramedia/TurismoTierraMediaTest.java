package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class TurismoTierraMediaTest {

	@Test
	public void queOrdenaSegunCostoMayor() {
		Producto p1 = new Atraccion("Moria",10,2,6,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.AVENTURA);
		Producto p3 = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.AVENTURA);
		Producto p4 = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		
		TurismoTierraMedia.ordenarProductos(productos, TipoAtraccion.AVENTURA);
		
		assertEquals(p4, productos.get(0));
		assertEquals(p1, productos.get(1));
		assertEquals(p2, productos.get(2));
		assertEquals(p3, productos.get(3));
	}
	
	@Test
	public void queOrdenaSegunTiempoMayor() {
		Producto p1 = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.PAISAJE);
		Producto p2 = new Atraccion("Erebor",3,3,32,TipoAtraccion.PAISAJE);
		Producto p3 = new Atraccion("Lothlórien",3,1,30,TipoAtraccion.PAISAJE);
		Producto p4 = new Atraccion("Abismo de Helm",3,2,15,TipoAtraccion.PAISAJE);
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		
		TurismoTierraMedia.ordenarProductos(productos, TipoAtraccion.PAISAJE);
		
		assertEquals(p1, productos.get(0));
		assertEquals(p2, productos.get(1));
		assertEquals(p4, productos.get(2));
		assertEquals(p3, productos.get(3));
	}
	
	@Test
	public void queSeOrdenanSegunTipoDeAtraccion() {
		Producto p1 = new Atraccion("Bosque Negro",3,2,12,TipoAtraccion.AVENTURA);
		Producto p2 = new Atraccion("Erebor",6,5,32,TipoAtraccion.PAISAJE);
		Producto p3 = new Atraccion("Lothlórien",3,2,30,TipoAtraccion.AVENTURA);
		Producto p4 = new Atraccion("Abismo de Helm",3,2,15,TipoAtraccion.PAISAJE);
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		productos.add(p4);
		
		TurismoTierraMedia.ordenarProductos(productos, TipoAtraccion.PAISAJE);
		
		assertEquals(p2, productos.get(0));
		assertEquals(p4, productos.get(1));
		assertEquals(p1, productos.get(2));
		assertEquals(p3, productos.get(3));
	}

}
