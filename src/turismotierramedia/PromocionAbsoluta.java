package turismotierramedia;

public class PromocionAbsoluta extends Promocion {
	
	private int precioFinal;

	public PromocionAbsoluta(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion,
			int cantAtracciones, int precioFinal) {
		super(nombre, costo, tiempo, tipoAtraccion, cantAtracciones);
		this.precioFinal = precioFinal;
	}

	@Override
	public void reduccionCostoTotal() {

	}

}
