package turismotierramedia;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {
	
	private int precioFinal;

	public PromocionAbsoluta(String nombre, double tiempo, TipoAtraccion tipoAtraccion, LinkedList<Atraccion> atracciones, int precioFinal) {
		super(nombre, tiempo, tipoAtraccion, atracciones);
		this.precioFinal = precioFinal;
	}

	@Override
	public void reduccionCostoTotal() {
		super.setCosto(precioFinal);
	}

}
