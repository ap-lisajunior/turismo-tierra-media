package turismotierramedia;

public abstract class Promocion extends Producto {
	
	private Atraccion[] atracciones;

	public Promocion(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion, int cantAtracciones) {
		super(nombre, costo, tiempo, tipoAtraccion);
		this.atracciones = new Atraccion[cantAtracciones];
	}
	
	public Promocion(String nombre, int costo, int duracion) {
		super(nombre, costo, duracion);
	}

	public Promocion(String nombre, int costo, double tiempo, TipoAtraccion tipoatraccion) {
		super(nombre, costo, tiempo, tipoatraccion);
	}
	

	abstract public void reduccionCostoTotal();

}
