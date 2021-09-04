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

public class TurismoTierraMedia {
	
	// DECLARACION LISTAS DE OBJETOS
	
	static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	static LinkedList<Producto> atracciones = new LinkedList<Producto>();
	static LinkedList<Producto> promociones = new LinkedList<Producto>();
	
	
	// OBTENGO LISTA DE USUARIOS DESDE ARCHIVO
	
	public static LinkedList<Usuario> getUsuarios(String archivo){
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(archivo));
			
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				
				String nombre = datos[0];
				int presupuesto = Integer.parseInt(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				TipoAtraccion tipoatraccion = TipoAtraccion.valueOf(datos[3]);
				
				Usuario usuario = new Usuario(nombre, presupuesto, tiempo, tipoatraccion);
				
				if(!usuarios.contains(usuario)) {
					usuarios.add(usuario);
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
		return usuarios;
	}
	
	// OBTENGO LISTA DE ATRACCIONES DESDE ARCHIVO
	
	public static LinkedList<Producto> getAtracciones(String archivo){
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(archivo));
			
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				
				String nombre = datos[0];
				int costo = Integer.parseInt(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				TipoAtraccion tipoatraccion = TipoAtraccion.valueOf(datos[4]);
				
				Producto atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipoatraccion);
				
				if(!atracciones.contains(atraccion)) {
					atracciones.add(atraccion);
				}	
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		
		return atracciones;
	}
	
	// OBTENGO LISTA DE PROMOCIONES DESDE ARCHIVO
	
	public static LinkedList<Producto> getPromociones(String archivo){
		
		//LinkedList<Atraccion> atraccionesTotales = getAtracciones(archivoAtracciones);
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(archivo));
			
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(",");
				
				String nombre = datos[0];
				String[] nombresAtraccionesPromocion = datos[1].split(";");
				TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(datos[2]);
				TipoPromocion tipoPromocion = TipoPromocion.valueOf(datos[3]);
				
				Promocion promocion = null;
				LinkedList<Atraccion> atraccionesPromocion = new LinkedList<Atraccion>();
				
				
				for(String nombreAtraccion : nombresAtraccionesPromocion) {
					for(Producto atraccion : atracciones) {
						if(atraccion.getNombre().equals(nombreAtraccion)) {
							atraccionesPromocion.add((Atraccion) atraccion);
							break;
						}
					}
				}
				
				if(tipoPromocion.equals(TipoPromocion.PORCENTUAL)) {
					double porcentajeDescuento = Double.parseDouble(datos[4]);
					promocion = new PromocionPorcentual(nombre, atraccionesPromocion, tipoAtraccion, tipoPromocion, porcentajeDescuento);
				}
				
				else if(tipoPromocion.equals(TipoPromocion.ABSOLUTA)) {
					int costoFinal = Integer.parseInt(datos[4]);
					promocion = new PromocionAbsoluta(nombre, atraccionesPromocion, tipoAtraccion, tipoPromocion, costoFinal);
				}

				else if(tipoPromocion.equals(TipoPromocion.AXB)) {
					promocion = new PromocionAxB(nombre, atraccionesPromocion, tipoAtraccion, tipoPromocion);
				}
				
				if(!promociones.contains(promocion)) {
					promociones.add(promocion);
				}	
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
		
		return promociones;
	}
	
	
	public static void ordenarProductos(LinkedList<Producto> lista) {
		Collections.sort(lista, new Ordenar());
	}
	
	public static void escribirProductos(LinkedList<Producto> productos, String archivo) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(archivo));

		for (Producto producto : productos) {
			salida.println(producto);
		}
		salida.close();

	}
	
	// ESCRITURA DE ARCHIVOS DE SALIDA
	
	public static void escribirUsuarios(LinkedList<Usuario> usuarios, String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		for (Usuario usuario : usuarios) {
			salida.println(usuario);
		}
		salida.close();
		
	}
	
	public static void escribirAtracciones(LinkedList<Atraccion> atracciones, String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		for (Atraccion atraccion : atracciones) {
			salida.println(atraccion);
		}
		salida.close();
		
	}
	
	public static void escribirPromociones(LinkedList<Promocion> promociones, String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		for (Promocion promocion : promociones) {
			salida.println(promocion);
		}
		salida.close();
		
	}
	
	// METODO MAIN
	
	public static void main(String[] args) throws IOException {
		LinkedList<Usuario> usuarios = getUsuarios("usuarios.in");
		LinkedList<Producto> atracciones = getAtracciones("atracciones.in");
		LinkedList<Producto> promociones = getPromociones("promociones.in");
		// "MERGE" DE LISTAS DE ATRACCIONES Y PROMOCIONES EN UNA SOLA LISTA DE PRODUCTOS (SE AGREGA PROMOCIONES A LA LISTA DE ATRACCIONES)
		atracciones.addAll(promociones);
		LinkedList<Producto> productos = atracciones;
		
		ordenarProductos(productos);
		escribirProductos(productos, "productos.out");
		
//		escribirUsuarios(usuarios, "usuarios.out");
//		escribirAtracciones(atracciones, "atracciones.out");
//		escribirPromociones(promociones, "promociones.out");
		
		
	}
	
}
