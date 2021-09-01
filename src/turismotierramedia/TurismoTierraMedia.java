package turismotierramedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class TurismoTierraMedia {
	
	public static LinkedList<Usuario> getUsuarios(String archivo){
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
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
	
	public static void escribirUsuarios(LinkedList<Usuario> usuarios, String archivo) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		
		for (Usuario usuario : usuarios) {
			salida.println(usuario);
		}
		salida.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		escribirUsuarios(getUsuarios("usuarios.in"), "TestSalida.csv");
	}
	
}
