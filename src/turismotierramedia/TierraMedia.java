package turismotierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


public class TierraMedia {
	
	public static LinkedList<Producto> getProductos(String archivo) {
		LinkedList<Producto> productos = new LinkedList<Producto>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				
				String linea = sc.nextLine();
				String datos[] = linea.split(" ");
				
				String nombre = datos[0];
				int costo = Integer.parseInt(datos[1]);
				double tiempo = Integer.parseInt(datos[2]);
				TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(datos[3]);
				int cupo = Integer.parseInt(datos[4]);
				
				Producto p = new Producto(nombre, costo, tiempo, tipoAtraccion, cupo);

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
	
	public static void escribirProductosOrdenadosPorNombre(List<Producto> productos) throws IOException {

		
		ordenarProductosPorNombre(productos);
		escribirProductos(productos, "productos");
	}
	public static void ordenarProductosPorNombre(List<Producto> lista) {
		Collections.sort(lista, new NombreComparator());
	}
}
