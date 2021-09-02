package turismotierramedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class AppTurismo {
	public static void main(String[] args) throws IOException {

		LinkedList<Producto> productos = TierraMedia.getProductos("productos.in");
		TierraMedia.escribirProductosOrdenadosPorCosto(productos);
		TierraMedia.escribirProductosOrdenadosPorTiempo(productos);
		Map<TipoAtraccion, ArrayList<Producto>> productosPorTipo = TierraMedia.agruparPorTipo(productos);
		TierraMedia.escribirProductosAgrupadosPorTipo(productosPorTipo,"agrupadosPorTipo.out");		
	}
}
