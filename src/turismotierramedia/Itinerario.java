package turismotierramedia;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Itinerario {

	private LinkedList<Producto> atracciones = new LinkedList<Producto>();
	private LinkedList<Producto> promociones = new LinkedList<Producto>();
	private Integer costo = 0;
	private Double tiempo = 0.0;

	protected LinkedList<Producto> getAtracciones() {
		return atracciones;
	}
	
	protected void agregarProducto(Producto producto) {
		if(producto.esUnaPromocion()) {
			promociones.add(producto);
			for(Producto atraccion : promociones.getLast().getAtracciones()) {
				atracciones.add(atraccion);
			}
		} else {
			atracciones.add(producto);
		}
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
		return "Resumen de su itinerario: \n" + "Atracciones a visitar: " + this.atracciones.stream().map(Producto::getNombre).collect(Collectors.toList()) + "\nCosto total: " + this.costo + " monedas." + "\nTiempo de permanencia total: " + this.tiempo + " horas.";
	}
	
}