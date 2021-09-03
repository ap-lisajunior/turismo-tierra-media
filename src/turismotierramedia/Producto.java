package turismotierramedia;

public abstract class Producto {
	
	private String nombre;
	private int costo;
	private double tiempo;
	TipoAtraccion tipoAtraccion;
	
	public Producto(String nombre, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.tipoAtraccion = tipoAtraccion;
	}

	protected String getNombre() {
		return this.nombre;
	}

	protected int getCosto() {
		return this.costo;
	}

	protected double getTiempo() {
		return this.tiempo;
	}
	
	protected TipoAtraccion getTipoAtraccion() {
		return this.tipoAtraccion;
	}
	
	abstract public boolean esUnaPromocion();

	public void setCosto(int costoFinal){
		this.costo = costoFinal;
	}

	public void setTiempo(double tiempoFinal) {
		this.tiempo = tiempoFinal;
	}
	
}
