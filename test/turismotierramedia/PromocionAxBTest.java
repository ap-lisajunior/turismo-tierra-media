package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionAxBTest {

	@Test
	public void crearPromocionAxB() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Atraccion minastirith = new Atraccion("Minas Tirith",5,2.5,TipoAtraccion.PAISAJE,25);
		Atraccion abismodehelm = new Atraccion("Abismo de Helm",5,2,TipoAtraccion.PAISAJE,15); 
		Atraccion erebor = new Atraccion("Erebor",12,3,TipoAtraccion.PAISAJE,32); 
		atracciones.add(minastirith);
		atracciones.add(abismodehelm);
		atracciones.add(erebor);
		
		
		PromocionAxB promocionaxb = new PromocionAxB("Pack Paisajes", 7.5, TipoAtraccion.PAISAJE,atracciones, erebor);
		assertNotNull(promocionaxb);
	}

}
