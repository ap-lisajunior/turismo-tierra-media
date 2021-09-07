package turismotierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TurismoTierraMedia {
	
	// DECLARACION LISTAS DE OBJETOS
	
	static LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	static LinkedList<Producto> atracciones = new LinkedList<Producto>();
	static LinkedList<Producto> promociones = new LinkedList<Producto>();
	
	
	// OBTENGO LISTA DE USUARIOS DESDE ARCHIVO
	
	public static LinkedList<Usuario> getUsuarios(){
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("entrada/usuarios.in"));
			
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
	
	public static LinkedList<Producto> getAtracciones(){
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("entrada/atracciones.in"));
			
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
	
	public static LinkedList<Producto> getPromociones(){
		
		//LinkedList<Atraccion> atraccionesTotales = getAtracciones(archivoAtracciones);
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("entrada/promociones.in"));
			
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
	
	
	// CREO LISTA DE PRODUCTOS TOTALES
	
	public static LinkedList<Producto> getProductos() {
		LinkedList<Producto> productos = new LinkedList<Producto>();
		productos.addAll(getAtracciones());
		productos.addAll(getPromociones());
		return productos;
	}
	
	// METODO PARA ORDENAR LOS PRODUCTOS EN BASE A LA CONSIGNA DADA
	
	public static void ordenarProductos(LinkedList<Producto> productos, TipoAtraccion tipoAtraccionPreferida) {
		Collections.sort(productos, new Ordenar(tipoAtraccionPreferida));
	}
	

	// ESCRITURA DE ARCHIVOS DE SALIDA
	
	public static void escribirItinerarioPorUsuario(Usuario usuario, Itinerario itinerario, String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		salida.println("Datos de usuario: ");
		salida.println(usuario);
		salida.println(itinerario);
		
		salida.close();
	}
	
	// METODO MAIN
	
	public static void main(String[] args) throws IOException {

		Ofertador.sugerirItineriario();
		
	}

}
