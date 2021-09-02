package turismotierramedia;

public class Producto implements Comparable<Producto>{

	private String nombre;
	private int costo;
	private double tiempo;
	private TipoAtraccion tipoAtraccion;
	

	public Producto(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
	@Override
	public int compareTo(Producto otroProducto) {
		return this.tipoAtraccion.compareTo(otroProducto.tipoAtraccion);
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}
		
}
