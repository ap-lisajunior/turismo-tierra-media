package turismotierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TierraMedia {

	public static LinkedList<Producto> getProductos(String archivo) {
		LinkedList<Producto> productos = new LinkedList<Producto>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String datos[] = linea.split(",");

				String nombre = datos[0];
				int costo = Integer.parseInt(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(datos[4]);

				Producto p = new Producto(nombre, costo, tiempo, cupo, tipoAtraccion);
				
				if (!productos.contains(p))
				productos.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		sc.close();

		return productos;
	}

	public static void escribirProductos(List<Producto> productos, String file) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(file));

		for (Producto producto : productos) {
			salida.println(producto);
		}
		salida.close();

	}
	
	public static void ordenarProductosPorCosto(List<Producto> lista) {
		Collections.sort(lista, new CostoComparator());
	}

	public static void ordenarProductosPorTiempo(List<Producto> lista) {
		Collections.sort(lista, new TiempoComparator());
	}

	public static void ordenarProductosPorTipoAtraccion(List<Producto> lista) {
		Collections.sort(lista, new TipoAtraccionComparator());
	}

	public static void escribirProductosOrdenadosPorCosto(List<Producto> productos) throws IOException {

		ordenarProductosPorCosto(productos);
		escribirProductos(productos, "productosxCosto");
	}

	public static void escribirProductosOrdenadosPorTiempo(List<Producto> productos) throws IOException {

		ordenarProductosPorTiempo(productos);
		escribirProductos(productos, "productosxTiempo");
	}

	public static Map<TipoAtraccion, ArrayList<Producto>> agruparPorTipo(List<Producto> productos) {

		Map<TipoAtraccion, ArrayList<Producto>> productosPorTipo = new TreeMap<TipoAtraccion, ArrayList<Producto>>();

		ArrayList<Producto> aux;
		TipoAtraccion key;

		for (Producto cadaProducto : productos) {
			key = cadaProducto.getTipoAtraccion();

			if (productosPorTipo.containsKey(key)) {
				aux = productosPorTipo.get(key);

			} else {
				aux = new ArrayList<Producto>();
			}

			aux.add(cadaProducto);
			productosPorTipo.put(key, aux);

		}

		return productosPorTipo;

	}

	public static void escribirProductosAgrupadosPorTipo(Map<TipoAtraccion, ArrayList<Producto>> map, String file)
			throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(file));
		List<Producto> aux;

		for (Entry<TipoAtraccion, ArrayList<Producto>> cadaProducto : map.entrySet()) {

			salida.println(cadaProducto.getKey());
			aux = cadaProducto.getValue();

			for (Producto p : aux)
				salida.println(p.getTipoAtraccion() + " " + p.getNombre());

		}

		salida.close();

	}
}
