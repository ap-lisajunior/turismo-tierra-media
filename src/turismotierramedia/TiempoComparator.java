package turismotierramedia;

import java.util.Comparator;

public class TiempoComparator implements Comparator<Producto>{
	
	@Override
	public int compare(Producto producto, Producto otroProducto) {
		return (-1) * Double.compare(producto.getTiempo(), otroProducto.getTiempo());
	}
}
