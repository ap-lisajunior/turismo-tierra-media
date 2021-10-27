package dao;

import java.util.LinkedList;

import turismotierramedia.Itinerario;
import turismotierramedia.Producto;
import turismotierramedia.Usuario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	public abstract int insertAtraccion(Usuario usuario, Producto producto);

	public abstract int insertPromocion(Usuario usuario, Producto producto);
	
	public abstract Itinerario findByUsuario(Usuario usuario, LinkedList<Producto> atracciones, LinkedList<Producto> promociones);

}
