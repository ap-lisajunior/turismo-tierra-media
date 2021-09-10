package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class OfertadorTest {

	@Test
	public void queOfertaPriorizandoPromociones() {
		Producto moria = new Atraccion("Moria",10,2,6,TipoAtraccion.AVENTURA);
		Producto minasTirith = new Atraccion("Minas Tirith",5,2.5,25,TipoAtraccion.PAISAJE);
		Producto laComarca = new Atraccion("La Comarca",3,6.5,150,TipoAtraccion.DEGUSTACION);
		Producto mordor = new Atraccion("Mordor",25,3,4,TipoAtraccion.AVENTURA);
		Producto abismoDeHelm = new Atraccion("Abismo de Helm",5,2,15,TipoAtraccion.PAISAJE);
		Producto lothlórien = new Atraccion("Lothlórien",35,1,30,TipoAtraccion.DEGUSTACION);
	    Producto erebor = new Atraccion("Erebor",12,3,32,TipoAtraccion.PAISAJE);
		Producto bosqueNegro = new Atraccion("Bosque Negro",3,4,12,TipoAtraccion.AVENTURA);
		
		LinkedList<Atraccion> packD = new LinkedList<Atraccion>();
		packD.add((Atraccion) lothlórien);
		packD.add((Atraccion) laComarca);
		
		Producto packDegustacion = new PromocionAbsoluta("Pack Degustación", packD, TipoAtraccion.DEGUSTACION,36);
		
		LinkedList<Producto> ofertador = new LinkedList<Producto>();
		
		ofertador.add(moria);
		ofertador.add(minasTirith);
		ofertador.add(laComarca);
		ofertador.add(mordor);
		ofertador.add(abismoDeHelm);
		ofertador.add(lothlórien);
		ofertador.add(erebor);
		ofertador.add(bosqueNegro);
		ofertador.add(packDegustacion);
		
		Usuario sam = new Usuario("Sam",36, 8, TipoAtraccion.DEGUSTACION);
		
		TurismoTierraMedia.ordenarProductos(ofertador, sam.getTipoAtraccion());
		
		assertEquals(packDegustacion, ofertador.get(0));
		assertEquals(lothlórien, ofertador.get(1));
		assertEquals(laComarca, ofertador.get(2));
		assertEquals(mordor, ofertador.get(3));
		assertEquals(erebor, ofertador.get(4));
		assertEquals(moria, ofertador.get(5));
		assertEquals(minasTirith, ofertador.get(6));
		assertEquals(abismoDeHelm, ofertador.get(7));
		assertEquals(bosqueNegro, ofertador.get(8));
		
		
		
	}
	
}
