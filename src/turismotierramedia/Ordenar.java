package turismotierramedia;

import java.util.Comparator;

public class Ordenar implements Comparator<Producto> {

	@Override
	public int compare(Producto producto, Producto otroProducto) {
		int aux;
		aux = -producto.esUnaPromocion().compareTo(otroProducto.esUnaPromocion());
		if(aux == 0) {
			aux = -producto.getCosto().compareTo(otroProducto.getCosto());
		} if (aux == 0) {
			aux = -producto.getTiempo().compareTo(otroProducto.getTiempo());
		}
		return aux;
	}
}

	

