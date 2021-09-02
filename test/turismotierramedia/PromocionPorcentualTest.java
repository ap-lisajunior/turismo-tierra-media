package turismotierramedia;

import static org.junit.Assert.*;

import org.junit.Test;


public class PromocionPorcentualTest {

	@Test
	public void queReduceElCostoSegunElPorcentajeDeDescuento() {
		
		Promocion p1 = new PromocionPorcentual("tierraDelSol", 100, 10, TipoAtraccion.AVENTURA, 0.2, 1);
		
		p1.reduccionCostoTotal();
		
		assertEquals(80, p1.getCosto(), 0);
		
	}

}
