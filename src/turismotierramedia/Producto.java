package turismotierramedia;

import java.util.Arrays;
import java.util.Objects;


public class Producto implements Comparable<Producto>{

	private String nombre;
	private int costo;
	private double tiempo;
	private TipoAtraccion tipoAtraccion;
	private int cupo;

	public Producto(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipoAtraccion;
	}
	
	public Producto(String nombre, int costo, double tiempo, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}
	
	public Producto(String nombre, int costo, double tiempo, int cupo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}

	protected int getCosto() {
		return costo;
	}

	protected void setCosto(int costo) {
		this.costo = costo;
	}

	protected double getTiempo() {
		return tiempo;
	}

	protected void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}
	

	@Override
	public int compareTo(Producto otroProducto) {
		return this.nombre.compareTo(otroProducto.nombre);
	}

	public int getCupo() {
		return cupo;
	}

	@Override
	public String toString() {
		return "Productos disponibles: nombre: " + nombre + ", costo: " + costo + ", tiempo: " + tiempo + ", tipoAtraccion: "
				+ tipoAtraccion + ", cupo: " + cupo + "]";
	}

	
}
