package turismotierramedia;

import java.util.LinkedList;

public class PromocionPorcentual extends Promocion {

	private double porcentajeDescuento;

	public PromocionPorcentual(String nombre, double tiempo, TipoAtraccion tipoatraccion, LinkedList<Atraccion> atracciones, double porcentajeDescuento) {
		super(nombre, tiempo, tipoatraccion, atracciones);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	@Override
	public void reduccionCostoTotal() {
		double descuento = (int) (getCosto() * porcentajeDescuento);
		double nuevoCosto = getCosto() - descuento;
		super.setCosto((int) nuevoCosto);
	}

	

}
