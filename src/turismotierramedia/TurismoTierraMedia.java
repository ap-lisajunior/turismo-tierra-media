package turismotierramedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TurismoTierraMedia {
	public static void main(String[] args) {
		FileReader fru = null;
		BufferedReader bru = null;
		FileReader fra = null;
		BufferedReader bra = null;

		try {
			fru = new FileReader("usuarios.txt");
			bru = new BufferedReader(fru);
			int cantLineasUsuarios = 0;
			String linea;
			
			while((linea=bru.readLine()) != null) {
				try {
					String [] dataUsuario = linea.split(",");
					String nombre = dataUsuario[0];
					int presupuesto = Integer.parseInt(dataUsuario[1]);
					double tiempo = Double.parseDouble(dataUsuario[2]);
					TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(dataUsuario[3]);
					cantLineasUsuarios++;
					// USUARIO
					Usuario usuario = new Usuario(nombre, presupuesto, tiempo, tipoAtraccion);
					System.out.println(usuario);
					
				}catch(NumberFormatException nfe){
					System.err.println("Algun numero es negativo");
				}		
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		try {
			fra = new FileReader("atracciones.txt");
			bra = new BufferedReader(fra);
			int i = 0;
			Atraccion [] arrayAtracciones = new Atraccion[10];
			String linea;
			
			while((linea=bru.readLine()) != null) {
				try {
					String [] dataAtraccion = linea.split(",");
					String nombreAtraccion = dataAtraccion[0];
					int costo = Integer.parseInt(dataAtraccion[1]);
					double tiempoAtraccion = Double.parseDouble(dataAtraccion[2]);
					TipoAtraccion tipoAtraccionAtraccion = TipoAtraccion.valueOf(dataAtraccion[3]);
					// ATRACCION
					Atraccion atraccion = new Atraccion(nombreAtraccion, costo, tiempoAtraccion, tipoAtraccionAtraccion);
					arrayAtracciones[i] = atraccion;
					i++;
					
				}catch(NumberFormatException nfe){
					System.err.println("Algun numero es negativo");
				}		
			}
			Arrays.sort(arrayAtracciones);
			System.out.println(arrayAtracciones);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}





		
	

