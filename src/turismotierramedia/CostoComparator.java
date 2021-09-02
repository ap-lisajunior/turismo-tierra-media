package turismotierramedia;

import java.util.Comparator;

public class CostoComparator implements Comparator<Producto>{
	
	@Override
	public int compare(Producto producto, Producto otroProducto) {
		return (-1) * Integer.compare(producto.getCosto(), otroProducto.getCosto());
	}
}
