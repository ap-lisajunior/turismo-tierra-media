package dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromocionDAOTest {

	@Test
	public void test() {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		System.out.println(promocionDAO.crearPromociones());
	}

}
