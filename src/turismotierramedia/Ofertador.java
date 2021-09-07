package turismotierramedia;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Ofertador {

	public static void sugerirItineriario() throws IOException {
		
		LinkedList<Usuario> usuarios = TurismoTierraMedia.getUsuarios();
		LinkedList<Producto> productos = TurismoTierraMedia.getProductos();
		Itinerario itinerario;

		Scanner input = new Scanner(System.in);

		for (Usuario usuario : usuarios) {
			TurismoTierraMedia.ordenarProductos(productos, usuario.getTipoAtraccion());
			itinerario = new Itinerario();
			System.out.println("\nBienvenido/a " + usuario.getNombre() + " al sistema de Turismo en la Tierra Media");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			for (Producto producto : productos) {
				
				if (usuario.puedeComprar(producto) && producto.tieneCupo()
						&& !producto.fueOfrecido()) {
					System.out.println("¿Desea usted comprar: " + producto + "?");
					System.out.println("Escriba 'si' o 'no' y luego presione Enter para continuar.");
					String eleccion = input.nextLine();

					while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
						System.out.println("DATO NO VALIDO. INGRESE NUEVAMENTE SU RESPUESTA");
						eleccion = input.nextLine();
					}
					if (eleccion.equalsIgnoreCase("si")) {
						producto.setOfrecido(true);
						producto.reducirCupo();
						itinerario.agregarProducto(producto);
						itinerario.setCosto(producto.getCosto());
						itinerario.setTiempo(producto.getTiempo());
						usuario.aceptarOferta(producto);
						System.out.println("Usted ha comprado: " + producto.getNombre() + " a un precio de "
								+ producto.getCosto() + " monedas.\n");
						}
					else {
						System.out.println("Usted no ha comprado este producto. Siguiente oferta: \n");
					}
					}

			}
			if (itinerario.getAtracciones().isEmpty()) {
				System.out.println("Usted no ha comprado ninguna promocion o acceso a atraccion\n");
			}
			else if (!itinerario.getAtracciones().isEmpty()) {
				System.out.println(itinerario);
			}
			
			// SE SETEAN NUEVAMENTE LOS PRODUCTOS AL ESTADO SIN OFRECER ORIGINAL
			for(Producto producto : productos) {
				if(producto.fueOfrecido()) {
					producto.setOfrecido(false);
				}
			}
			TurismoTierraMedia.escribirItinerarioPorUsuario(usuario, itinerario,
					"salida/"+ usuario.getNombre().toLowerCase() + ".out");
		}
		input.close();
	}

}
