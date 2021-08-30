package turismotierramedia;

public class PromocionAxB extends Promocion {
	
	Atraccion promocionada;

	public PromocionAxB(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion, int cantAtracciones, Atraccion promocionada) {
		super(nombre, costo, tiempo, tipoAtraccion);
		this.promocionada = promocionada;
	}

	@Override
	public void reduccionCostoTotal() {

	}

}
