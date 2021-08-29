package turismotierramedia;


public class PromocionPorcentual extends Promocion {

	private double porcentajeDescuento;

	public PromocionPorcentual(String nombre, int costo, double tiempo, TipoAtraccion tipoatraccion) {
		super(nombre, costo, tiempo, tipoatraccion);
	}
	
	public PromocionPorcentual(String nombre, int costo, int duracion, double porcentajeDescuento) {
		super(nombre, costo, duracion);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	@Override
	public void reduccionCostoTotal() {
		double descuento = (int) (getCosto() * porcentajeDescuento);
		double nuevoCosto = getCosto() - descuento;
		super.setCosto((int) nuevoCosto);
	}

	

}
