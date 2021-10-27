package dao;

import java.util.LinkedList;
import turismotierramedia.Producto;

public interface AtraccionDAO extends GenericDAO<Producto> {
	
	public abstract LinkedList<Producto> createAtracciones();
	
}
