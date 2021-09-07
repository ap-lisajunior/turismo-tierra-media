package turismotierramedia;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Itinerario {

	private LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
	private LinkedList<Promocion> promociones = new LinkedList<Promocion>();
	private Integer costo = 0;
	private Double tiempo = 0.0;

	protected LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}

	protected void agregarAtraccion(Atraccion atraccion) {
		atracciones.add(atraccion);
	}
	
	public void agregarPromocion(Promocion promocion) {
		promociones.add(promocion);
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
		return "Resumen de su itinerario: \n" + "Atracciones a visitar: " + this.atracciones.stream().map(Atraccion::getNombre).collect(Collectors.toList()) + "; Costo total: " + this.costo + "; Tiempo duracion total: " + tiempo;
	}


	
	
	
	
}