package dao;

import org.junit.Test;

public class UsuarioDAOTest {

	@Test
	public void seCreanUsuarios() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		System.out.println(usuarioDAO.createUsuarios());
	}

}
