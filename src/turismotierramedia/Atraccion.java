package turismotierramedia;

public class Atraccion extends Producto {

	private int cupo;
	
	public Atraccion(String nombre, int costo, double tiempo, int cupo, TipoAtraccion tipoAtraccion) {
		super(nombre, tipoAtraccion);
		super.setCosto(costo);
		super.setTiempo(tiempo);
		this.cupo = cupo;
	}


	protected int getCupo() {
		return this.cupo;
	}
	
	public void reducirCupo() {
		this.cupo--;
	}

	@Override
	public boolean esUnaPromocion() {
		return false;
	}


	@Override
	public String toString() {
		return "Nombre atraccion: " + this.getNombre() + "; Cupo de atracción: " 
				+ this.getCupo() + "; Costo de atraccion: " + this.getCosto() + "; Tiempo de atraccion: "
				+ this.getTiempo() + "; Tipo de atraccion: " + this.getTipoAtraccion();
	}		
	
	
}
