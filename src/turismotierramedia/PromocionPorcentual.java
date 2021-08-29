package turismotierramedia;


public class PromocionPorcentual extends Promocion {

	private final static double porcentajeDescuento = 0.2;

	public PromocionPorcentual(String nombre, int costo, double tiempo, TipoAtraccion tipoatraccion) {
		super(nombre, costo, tiempo, tipoatraccion);
	}
	
	public PromocionPorcentual(String nombre, int costo, int duracion) {
		super(nombre, costo, duracion);
	}
	
	@Override
	public void reduccionCostoTotal() {
		double descuento = (int) (getCosto() * porcentajeDescuento);
		double nuevoCosto = getCosto() - descuento;
		super.setCosto((int) nuevoCosto);
	}

	

}
