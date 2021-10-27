package dao;

import java.util.LinkedList;
import turismotierramedia.Producto;

public interface PromocionDAO extends GenericDAO<Producto>{
	
	public abstract LinkedList<Producto> createPromociones(LinkedList<Producto> atracciones);
	
}
