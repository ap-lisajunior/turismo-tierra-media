package turismotierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtraccionTest {

//	@Test(expected = CupoException.class)
//	
//	public void ingresarMasUsuariosQueLosPermitidosPorElCupo() throws CupoException {
//
//		
//	}
	
	@Test
	public void crearUnaAtraccion() {
		Atraccion atraccion = new Atraccion("Mordor", 25, 3, TipoAtraccion.AVENTURA, 3);
		assertNotNull(atraccion);
	}
	
	

}
