package turismotierramedia;

public class Producto {
	
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

}
