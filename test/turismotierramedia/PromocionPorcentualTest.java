package turismotierramedia;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class PromocionPorcentualTest {

//	@Test
//	public void queReduceElCostoSegunElPorcentajeDeDescuento() {
//		
//		Promocion p1 = new PromocionPorcentual("tierraDelSol", 100, 10, TipoAtraccion.AVENTURA, 0.2);
//		
//		p1.reduccionCostoTotal();
//		
//		assertEquals(80, p1.getCosto(), 0);
//		
//	}
	
	@Test
	public void crearPromocionPorcentual() {
		LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
		Atraccion bosquenegro = new Atraccion("Bosque Negro",3,4,TipoAtraccion.AVENTURA,12);
		Atraccion mordor = new Atraccion("Mordor",25,3,TipoAtraccion.AVENTURA,4); 
		atracciones.add(bosquenegro);
		atracciones.add(mordor);
		
		PromocionPorcentual promocion = new PromocionPorcentual("Pack Aventura", 7, TipoAtraccion.AVENTURA, atracciones, 0.2);
		assertNotNull(promocion);
	}

}
