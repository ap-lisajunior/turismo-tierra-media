package turismotierramedia;


public class PromocionPorcentual extends Promocion {

	private double porcentajeDescuento;

	public PromocionPorcentual(String nombre, int costo, double tiempo, TipoAtraccion tipoatraccion, double porcentajeDescuento) {
		super(nombre, costo, tiempo, tipoatraccion);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	@Override
	public void reduccionCostoTotal() {
		double descuento = (int) (getCosto() * porcentajeDescuento);
		double nuevoCosto = getCosto() - descuento;
		super.setCosto((int) nuevoCosto);
	}

	

}
