package turismotierramedia;

import java.util.LinkedList;

public abstract class Promocion extends Producto{
	
	LinkedList<Atraccion> atracciones;
	private String nombreAtracciones = "";

	public Promocion(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion) {
		super(nombre, tipoAtraccion);
		this.atracciones = atracciones;
		for(Atraccion atraccion : atracciones) {
			nombreAtracciones += atraccion.getNombre() + ", ";
		}
		calcularTiempoTotal();
	}
	
	abstract protected void calcularCostoFinal();
	
	protected void calcularTiempoTotal() {
		double aux = 0;
		for(Atraccion atraccion : atracciones) {
			aux += atraccion.getTiempo();
		}
		super.setTiempo(aux);
	}
	
	@Override
	protected LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	@Override
	protected Boolean tieneCupo() {
		for(Atraccion atraccion : atracciones) {
			if(atraccion.getCupo() == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	protected void reducirCupo() {
		for(Atraccion atraccion : atracciones) {
			atraccion.reducirCupo();
		}
	}
	
	@Override
	protected void setComprado(Boolean estado) {
		for (Atraccion atraccion : atracciones) {
			atraccion.comprado = estado;
		}
		this.comprado = estado;
	}

	@Override
	protected Boolean esUnaPromocion() {
		return true;
	}
	

	@Override
	public String toString() {
		return "Nombre promocion: " + this.getNombre() + "; Costo de promocion: " + this.getCosto() +"; Atracciones de la promocion: " + this.nombreAtracciones +"; Tiempo total de atracciones: "
				+ this.getTiempo() + "; Tipo de atracciones: " + this.getTipoAtraccion().getDescripcion();
	}		
	
	
}
