package turismotierramedia;

import java.util.LinkedList;

public class PromocionAxB extends Promocion {
	
	private Atraccion bonificada;

	public PromocionAxB(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion,
			TipoPromocion tipoPromocion) {
		super(nombre, atracciones, tipoAtraccion);
		this.bonificada = atracciones.getLast();
		calcularCostoFinal();
	}

	@Override
	public void calcularCostoFinal() {
		int aux = 0;
		for(Atraccion atraccion : atracciones) {
			aux += atraccion.getCosto();
		}
		super.setCosto(aux - this.bonificada.getCosto());	
	}

}
