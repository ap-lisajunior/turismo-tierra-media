package turismotierramedia;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {
	
	private int costoFinal;

	public PromocionAbsoluta(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion, int costoFinal) {
		super(nombre, atracciones, tipoAtraccion);
		this.costoFinal = costoFinal;
		calcularCostoFinal();
	}

	@Override
	public void calcularCostoFinal() {
		super.setCosto(costoFinal);
	}

}
