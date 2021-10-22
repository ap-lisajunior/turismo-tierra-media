package dao;

import java.util.List;

import turismotierramedia.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion>{
	
	public abstract List<Promocion> crearPromociones();
	
}
