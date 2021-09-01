package turismotierramedia;

public class Producto {
	
	private String nombre;
	protected int costo;
	private double tiempo;
	private TipoAtraccion tipoAtraccion;
	
	public Producto(String nombre, double tiempo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
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

}
