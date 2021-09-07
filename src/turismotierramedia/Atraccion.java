package turismotierramedia;

import java.util.LinkedList;

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
	
	@Override
	public void reducirCupo() {
		this.cupo--;
	}

	@Override
	public Boolean esUnaPromocion() {
		return false;
	}


	@Override
	public Boolean tieneCupo() {
		return this.cupo > 0;
	}		
	
	@Override
	public void setOfrecido(Boolean estado) {
		super.ofrecido = estado;
	}

	

	@Override
	public String toString() {
		return "Nombre atraccion: " + this.getNombre() + "; Cupo de atracción: " 
				+ this.getCupo() + "; Costo de atraccion: " + this.getCosto() + "; Tiempo de atraccion: "
				+ this.getTiempo() + "; Tipo de atraccion: " + this.getTipoAtraccion().getDescripcion();
	}


	@Override
	public LinkedList<Atraccion> getAtracciones() {
		return null;
	}




	
}
