package turismotierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void crearUsuario() {
		Usuario usuario = new Usuario("Eowyn", 10, 8, TipoAtraccion.AVENTURA);
		assertNotNull(usuario);
	}

}
