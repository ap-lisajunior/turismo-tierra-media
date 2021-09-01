package turismotierramedia;

import java.util.LinkedList;

public abstract class Promocion extends Producto {
	
	private LinkedList<Atraccion> atracciones;

	public Promocion(String nombre, double tiempo, TipoAtraccion tipoAtraccion, LinkedList<Atraccion> atracciones) {
		super(nombre, tiempo, tipoAtraccion);
		this.atracciones = atracciones;
	}
	
	abstract public void reduccionCostoTotal();

}
