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
			// SE ORDENAN LOS PRODUCTOS EN BASE A LA PREFERENCIA DE USUARIO
			TurismoTierraMedia.ordenarProductos(productos, usuario.getTipoAtraccion());
			itinerario = new Itinerario();
			System.out.println("\nBienvenido/a " + usuario.getNombre() + " al sistema de Turismo en la Tierra Media");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println("\nSu perfil indica que su tipo de atraccion favorita es de " + usuario.getTipoAtraccion().getDescripcion());
			System.out.println("Su dinero disponible es de: " + usuario.getPresupuesto() + " monedas.");
			System.out.println("Su tiempo disponible es de: " + usuario.getTiempo() + " horas.");
			System.out.println("________________________________________");
			
			for (Producto producto : productos) {
				// SE FILTRA LA INFORMACION A MOSTRAR
				if (usuario.puedeComprar(producto) && producto.tieneCupo()
						&& !producto.fueComprado()) {
					if(producto.esUnaPromocion()) {
						System.out.println("\n¿Desea usted comprar " + producto.getNombre() + "?");
					} else {
						System.out.println("\n¿Desea usted comprar acceso a " + producto.getNombre() + "?");
					}
					System.out.println("\nDescripcion: ");
					System.out.println(producto);
					System.out.println("\nEscriba 'si' o 'no' y luego presione Enter para continuar.\n");
					String eleccion = input.nextLine();

					while (!eleccion.equalsIgnoreCase("si") && !eleccion.equalsIgnoreCase("no")) {
						System.out.println("DATO NO VALIDO. INGRESE NUEVAMENTE SU RESPUESTA");
						eleccion = input.nextLine();
					}
					if (eleccion.equalsIgnoreCase("si")) {
						// PROCESO DE COMPRA
						producto.setComprado(true);
						producto.reducirCupo();
						itinerario.agregarProducto(producto);
						itinerario.setCosto(producto.getCosto());
						itinerario.setTiempo(producto.getTiempo());
						usuario.aceptarOferta(producto);
						System.out.println("____________________________________________");
						System.out.println("\nUsted ha comprado: " + producto.getNombre() + " a un precio de "
								+ producto.getCosto() + " monedas.");
						System.out.println("Su dinero restante es de: " + usuario.getPresupuesto() + " monedas.");
						System.out.println("Su tiempo disponible restante es de: " + usuario.getTiempo() + " horas.");
						System.out.println("____________________________________________");
						}
					else {
						System.out.println("\nUsted no ha comprado este producto.");
						System.out.println("____________________________________________");
					}
					}
			}
			if (itinerario.getAtracciones().isEmpty()) {
				System.out.println("\nUsted no ha comprado ninguna promocion o acceso a atraccion.\n");
				System.out.println("Su dinero restante es de: " + usuario.getPresupuesto() + " monedas.");
				System.out.println("Su tiempo disponible restante es de: " + usuario.getTiempo() + " horas.");
				System.out.println("____________________________________________");
			}
			else if (!itinerario.getAtracciones().isEmpty()) {
				System.out.println("\n"+ itinerario);
				System.out.println("____________________________________________");
			}
			
			// SE SETEAN NUEVAMENTE LOS PRODUCTOS AL ESTADO SIN COMPRAR ORIGINAL
			for(Producto producto : productos) {
				if(producto.fueComprado()) {
					producto.setComprado(false);
				}
			}
			// SE GENERA ARCHIVO DE SALIDA
			TurismoTierraMedia.escribirItinerarioPorUsuario(usuario, itinerario,
					"salida/"+ usuario.getNombre().toLowerCase() + ".out");
			
			if(usuario.getNombre() != usuarios.getLast().getNombre()) {
				System.out.println("\n**********************************************");
				System.out.println("PRESIONE ENTER PARA MOSTRAR SIGUIENTE USUARIO");
				System.out.println("**********************************************");
			} else {
				System.out.println("\n*************************************************************");
				System.out.println("YA NO HAY MAS USUARIOS QUE MOSTRAR EN EL SISTEMA");
				System.out.println("GRACIAS POR UTILIZAR EL SISTEMA DE TURISMO EN LA TIERRA MEDIA");
				System.out.println("*************************************************************");
			}

			input.nextLine();
		}
		input.close();
	}

}
