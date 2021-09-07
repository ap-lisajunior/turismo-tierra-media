package turismotierramedia;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Consola {

	public static void ejecutarPrograma() throws IOException {
		
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
				if (TurismoTierraMedia.usuarioPuedeComprar(usuario, producto) && producto.tieneCupo()
						&& !producto.fueOfrecido()) {

					System.out.println("¿Desea usted comprar: " + producto + "?");
					System.out.println("Escriba 'si' o 'no' y luego presione Enter para continuar.");
					String eleccion = input.nextLine();

					while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
						System.out.println("DATO NO VALIDO. INGRESE NUEVAMENTE SU RESPUESTA");
						eleccion = input.nextLine();
					}
					if (eleccion.equalsIgnoreCase("si")) {
						if (producto.esUnaPromocion()) {
							for (Atraccion atraccion : ((Promocion) producto).getAtracciones()) {
								atraccion.reducirCupo();
								atraccion.setOfrecido(true);
								itinerario.agregarAtraccion(atraccion);
							}
							((Promocion) producto).setOfrecido(true);
							itinerario.agregarPromocion((Promocion) producto);
							itinerario.setCosto(producto.getCosto());
							itinerario.setTiempo(producto.getTiempo());
						} else {
							((Atraccion) producto).reducirCupo();
							((Atraccion) producto).setOfrecido(true);
							itinerario.agregarAtraccion((Atraccion) producto);
							itinerario.setCosto(producto.getCosto());
							itinerario.setTiempo(producto.getTiempo());
						}
						usuario.aceptarOferta(producto);

						System.out.println("Usted ha comprado: " + producto.getNombre() + " a un precio de "
								+ producto.getCosto() + " monedas.\n");
					}

					if (itinerario.getAtracciones().isEmpty() && itinerario.getAtracciones().isEmpty()) {
						System.out.println("Usted no ha comprado ninguna promocion o acceso a atraccion");
					}
				}
			}
			if (!itinerario.getAtracciones().isEmpty() && !itinerario.getAtracciones().isEmpty()) {
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
