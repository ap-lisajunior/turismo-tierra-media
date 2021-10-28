package dao;

import java.util.LinkedList;

import turismotierramedia.Itinerario;
import turismotierramedia.Producto;
import turismotierramedia.Usuario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	public abstract int insertProducto(Usuario usuario, Producto producto);
	
	public Itinerario findByUsuario(Usuario usuario, LinkedList<Producto> productos);

}
