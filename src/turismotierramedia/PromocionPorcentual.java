package turismotierramedia;

import java.util.LinkedList;

public class PromocionPorcentual extends Promocion {
	
	private double porcentajeDescuento;

	public PromocionPorcentual(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion,
			TipoPromocion tipoPromocion, double porcentajeDescuento) {
		super(nombre, atracciones, tipoAtraccion);
		this.porcentajeDescuento = porcentajeDescuento;
		calcularCostoFinal();
	}

	@Override
	public void calcularCostoFinal() {
		int aux = 0;
		for(Atraccion atraccion : atracciones) {
			aux += atraccion.getCosto();
		}
		super.setCosto((int) (aux * this.porcentajeDescuento));
	}


}
