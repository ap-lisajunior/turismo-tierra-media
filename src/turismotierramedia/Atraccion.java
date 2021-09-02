package turismotierramedia;

public class Atraccion extends Producto {
	
	private int cupo;

	public Atraccion(String nombre, int costo, double tiempo, int cupo, TipoAtraccion tipoAtraccion) {
		super(nombre, costo, tiempo, tipoAtraccion);
		this.cupo = cupo;
	}
	
	public void reduccionCupo() {
		this.cupo --;
	}
	
	@Override
	public String toString() {
		return "Productos disponibles: nombre: " + getNombre() + ", costo: " + getCosto() + ", tiempo: " + getTiempo()
				+ ", tipoAtraccion: " + getTipoAtraccion() + ", cupo: " + cupo + "]";
	}
}
