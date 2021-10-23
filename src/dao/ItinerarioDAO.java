package dao;

import turismotierramedia.Itinerario;
import turismotierramedia.Producto;
import turismotierramedia.PromocionAbsoluta;
import turismotierramedia.Usuario;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {

	public abstract int insertAtraccion(Usuario usuario, Producto producto);

	public abstract int insertPromocion(Usuario usuario, Producto producto);

	public abstract Itinerario findByNombrePromocion(Producto producto, Usuario usuario);
	
	public abstract Itinerario findByNombreAtraccion(Producto producto, Usuario usuario);
}
