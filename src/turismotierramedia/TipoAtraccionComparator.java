package turismotierramedia;

import java.util.Comparator;

public class TipoAtraccionComparator implements Comparator<Producto>{
	@Override
	public int compare(Producto producto, Producto otroProducto) {
		return producto.getTipoAtraccion().compareTo(otroProducto.getTipoAtraccion());
	}
}
