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
	protected void reducirCupo() {
		this.cupo--;
	}

	@Override
	protected Boolean esUnaPromocion() {
		return false;
	}


	@Override
	protected Boolean tieneCupo() {
		return this.cupo > 0;
	}		
	
	@Override
	protected void setComprado(Boolean estado) {
		super.comprado = estado;
	}

	@Override
	protected LinkedList<Atraccion> getAtracciones() {
		return null;
	}	

	@Override
	public String toString() {
		return "Esta es una atraccion del tipo: " + this.getTipoAtraccion().getDescripcion() 
				+ "\nCosto: " + this.getCosto() + " monedas."
				+ "\nTiempo de permanencia: " + this.getTiempo() + " horas.";
	}
	
}
