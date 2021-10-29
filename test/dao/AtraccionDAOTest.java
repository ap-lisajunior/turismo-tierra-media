package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtraccionDAOTest {
	

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();

	@Test
	public void seCreanAtracciones() {
		System.out.println(atraccionDAO.createAtracciones());
	}
	
	@Test
	public void contarAtracciones() {
		assertEquals(8,atraccionDAO.countAll());
	}

	
	
}
