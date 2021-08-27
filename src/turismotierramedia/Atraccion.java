package turismotierramedia;

public class Atraccion extends Producto {
	
	private int cupo;

	public Atraccion(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion) {
		super(nombre, costo, tiempo, tipoAtraccion);
		this.cupo = cupo;
	}
}
