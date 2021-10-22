package dao;

import java.util.List;
import turismotierramedia.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion> {
	
	public abstract List<Atraccion> crearAtracciones();
	
}
