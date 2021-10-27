package dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtraccionDAOTest {

	@Test
	public void test() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		System.out.println(atraccionDAO.createAtracciones());
	}

}
