package dao;

import java.util.LinkedList;

import org.junit.Test;

import turismotierramedia.Producto;

public class PromocionDAOTest {

	@Test
	public void seCreanPromociones() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		LinkedList<Producto> atracciones = atraccionDAO.createAtracciones();
		
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		System.out.println(promocionDAO.createPromociones(atracciones));
	}

}
