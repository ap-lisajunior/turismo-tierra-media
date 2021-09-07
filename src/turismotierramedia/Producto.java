package turismotierramedia;

import java.util.LinkedList;

public abstract class Producto {
	
	private String nombre;
	private int costo;
	private double tiempo;
	TipoAtraccion tipoAtraccion;
	protected Boolean ofrecido = false;
	
	public Producto(String nombre, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.tipoAtraccion = tipoAtraccion;
	}

	protected String getNombre() {
		return this.nombre;
	}

	protected Integer getCosto() {
		return this.costo;
	}

	protected Double getTiempo() {
		return this.tiempo;
	}
	
	protected TipoAtraccion getTipoAtraccion() {
		return this.tipoAtraccion;
	}

	protected Boolean fueOfrecido() {
		return this.ofrecido;
	}
	
	abstract public void setOfrecido(Boolean estado);
	
	abstract public void reducirCupo();
	
	abstract public Boolean tieneCupo();
	
	abstract public Boolean esUnaPromocion();

	abstract public LinkedList<Atraccion> getAtracciones();
	
	public void setCosto(int costoFinal){
		this.costo = costoFinal;
	}

	public void setTiempo(double tiempoFinal) {
		this.tiempo = tiempoFinal;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
