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
						&& !producto.fueComprado()) {
					System.out.println("�Desea usted comprar: " + producto.getNombre() + "?");
					System.out.println("Descripcion del producto: ");
					System.out.println(producto);
					System.out.println("\nEscriba 'si' o 'no' y luego presione Enter para continuar.\n");
					String eleccion = input.nextLine();

					while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
						System.out.println("DATO NO VALIDO. INGRESE NUEVAMENTE SU RESPUESTA");
						eleccion = input.nextLine();
					}
					if (eleccion.equalsIgnoreCase("si")) {
						producto.setComprado(true);
						producto.reducirCupo();
						itinerario.agregarProducto(producto);
						itinerario.setCosto(producto.getCosto());
						itinerario.setTiempo(producto.getTiempo());
						usuario.aceptarOferta(producto);
						System.out.println("Usted ha comprado: " + producto.getNombre() + " a un precio de "
								+ producto.getCosto() + " monedas.\n");
						}
					else {
						System.out.println("Usted no ha comprado este producto.\n ");
					}
					}

			}
			if (itinerario.getAtracciones().isEmpty()) {
				System.out.println("Usted no ha comprado ninguna promocion o acceso a atraccion\n");
			}
			else if (!itinerario.getAtracciones().isEmpty()) {
				System.out.println(itinerario);
			}
			
			// SE SETEAN NUEVAMENTE LOS PRODUCTOS AL ESTADO SIN COMPRAR ORIGINAL
			for(Producto producto : productos) {
				if(producto.fueComprado()) {
					producto.setComprado(false);
				}
			}
			TurismoTierraMedia.escribirItinerarioPorUsuario(usuario, itinerario,
					"salida/"+ usuario.getNombre().toLowerCase() + ".out");
			System.out.println("\n**********************************************");
			System.out.println("PRESIONE ENTER PARA MOSTRAR SIGUIENTE USUARIO");
			System.out.println("**********************************************");
			input.nextLine();
		}
		input.close();
	}

}
