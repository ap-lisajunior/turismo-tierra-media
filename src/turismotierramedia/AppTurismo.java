package turismotierramedia;

import java.io.IOException;
import java.util.LinkedList;



public class AppTurismo {
	public static void main(String[] args) throws IOException {

		LinkedList<Producto> productos = TierraMedia.getProductos("productos.in");
		System.out.println(productos);
		TierraMedia.escribirProductosOrdenadosPorNombre(productos);
		System.out.println(productos);
	}
}
