package dao;

import java.util.LinkedList;

import org.junit.Test;

import turismotierramedia.Producto;
import turismotierramedia.Usuario;

public class ItinerarioDAOTest {

	@Test
	public void seCreanItinerarios() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		LinkedList<Producto> atracciones = atraccionDAO.createAtracciones();
		
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		LinkedList<Producto> promociones = promocionDAO.createPromociones(atracciones);
		
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.findByUsername("Eowyn");
		
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.addAll(atracciones);
		productos.addAll(promociones);
		
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		System.out.println(itinerarioDAO.findByUsuario(usuario, productos));
	}

}
