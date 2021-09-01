package turismotierramedia;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	
	Atraccion promocionada;

	public PromocionAxB(String nombre, double tiempo, TipoAtraccion tipoAtraccion, LinkedList<Atraccion> atracciones, Atraccion promocionada) {
		super(nombre, tiempo, tipoAtraccion, atracciones);
		this.promocionada = promocionada;
	}

	@Override
	public void reduccionCostoTotal() {
		super.setCosto(getCosto() - promocionada.getCosto());
	}

}
