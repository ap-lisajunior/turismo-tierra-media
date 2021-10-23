package turismotierramedia;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Itinerario {

	private LinkedList<Producto> atracciones = new LinkedList<Producto>();
	private LinkedList<Producto> promociones = new LinkedList<Producto>();
	private Integer costo = 0;
	private Double tiempo = 0.0;
	private String nombreUsuario;
	private String nombreAtraccion;
	private String nombrePromocion;
	

	public Itinerario(String usuario, String atraccion, String promocion) {
		this.nombreUsuario = usuario;
		this.nombreAtraccion = atraccion;
		this.nombrePromocion = promocion;
	}

	public Itinerario() {

	}

	protected LinkedList<Producto> getAtracciones() {
		return atracciones;
	}

	protected void agregarPromocion(Producto producto) {
		promociones.add(producto);
		for (Producto atraccion : promociones.getLast().getAtracciones()) {
			atracciones.add(atraccion);
		}
	}

	protected void agregarAtraccion(Producto producto) {
		atracciones.add(producto);
	}

	protected Integer getCosto() {
		return costo;
	}

	protected void setCosto(Integer costo) {
		this.costo += costo;
	}

	protected Double getTiempo() {
		return tiempo;
	}

	protected void setTiempo(Double tiempo) {
		this.tiempo += tiempo;
	}

	@Override
	public String toString() {
		return "Resumen de su itinerario: \n" + "Atracciones a visitar: "
				+ this.atracciones.stream().map(Producto::getNombre).collect(Collectors.toList()) + "\nCosto total: "
				+ this.costo + " monedas." + "\nTiempo de permanencia total: " + this.tiempo + " horas.";
	}

}