package turismotierramedia;

import java.util.LinkedList;

public class PromocionAXB extends Promocion {
	
	private Atraccion bonificada;

	public PromocionAXB(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion,
			TipoPromocion tipoPromocion) {
		super(nombre, atracciones, tipoAtraccion);
		this.bonificada = atracciones.getLast();
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
