package turismotierramedia;

public abstract class Promocion extends Producto {
	
	private Atraccion[] atracciones;

	public Promocion(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion) {
		super(nombre, costo, tiempo, tipoAtraccion);
	}
	
	abstract public void reduccionCostoTotal();

}
