package turismotierramedia;

public class PromocionPorcentual extends Promocion {

	private int porcentajeDescuento;
	
	public PromocionPorcentual(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion,
			int cantAtracciones, int porcentajeDescuento) {
		super(nombre, costo, tiempo, tipoAtraccion, cantAtracciones);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public void reduccionCostoTotal() {

	}

}
