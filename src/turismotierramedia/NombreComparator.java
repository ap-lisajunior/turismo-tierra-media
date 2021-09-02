package turismotierramedia;

import java.util.Comparator;

public class NombreComparator implements Comparator<Producto>{
	@Override
	public int compare(Producto producto, Producto otroProducto) {
		return producto.getNombre().compareTo(otroProducto.getNombre());
	}

}
