package turismotierramedia;

public class Atraccion extends Producto {
	
	private int cupo;

	public Atraccion(String nombre, int costo, double tiempo, TipoAtraccion tipoAtraccion) {
		super(nombre, costo, tiempo, tipoAtraccion);
		this.cupo = cupo;
	}
	
	public Atraccion(String nombre, int costo, double tiempo, int cupo) {
		super(nombre, costo, tiempo);
		this.cupo = cupo;
	}
	
	public void reduccionCupo(int cantUsuarios) throws CupoException {
		if (this.cupo == 0) {
			throw new CupoException("Ya no queda lugar para esta atracción");
		}
		this.cupo -= cantUsuarios;
	}
}
