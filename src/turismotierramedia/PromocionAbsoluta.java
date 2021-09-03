package turismotierramedia;

import java.util.LinkedList;

public class PromocionAbsoluta extends Promocion {
	
	private int costoFinal;

	public PromocionAbsoluta(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion,
			TipoPromocion tipoPromocion, int costoFinal) {
		super(nombre, atracciones, tipoAtraccion);
		this.costoFinal = costoFinal;
	}

	@Override
	public void calcularCostoFinal() {
		super.setCosto(costoFinal);
	}

}
