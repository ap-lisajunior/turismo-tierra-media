package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionAbsolutaTest {

	@Test
	public void crearPromocionAbsoluta() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Atraccion lothlorien = new Atraccion("Lothlórien",35,1,TipoAtraccion.DEGUSTACION,30);
		Atraccion lacomarca = new Atraccion("La Comarca",3,6.5,TipoAtraccion.DEGUSTACION,150); 
		atracciones.add(lothlorien);
		atracciones.add(lacomarca);
		
		PromocionAbsoluta promocionabsoluta = new PromocionAbsoluta("Pack Degustacion", 7.5, TipoAtraccion.DEGUSTACION, atracciones, 36);
		assertNotNull(promocionabsoluta);
	}

}
