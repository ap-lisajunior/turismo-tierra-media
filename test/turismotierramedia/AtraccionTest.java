package turismotierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtraccionTest {

	@Test(expected = CupoException.class)
	
	public void ingresarMasUsuariosQueLosPermitidosPorElCupo() throws CupoException {
		
		Atraccion a1 = new Atraccion("moria", 100, 2, 5);
		
		a1.reduccionCupo(5);
		a1.reduccionCupo(1);
		
	}

}
