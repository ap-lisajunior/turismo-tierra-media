package turismotierramedia;

import java.util.LinkedList;

public abstract class Promocion extends Producto{
	
	LinkedList<Atraccion> atracciones;

	public Promocion(String nombre, LinkedList<Atraccion> atracciones, TipoAtraccion tipoAtraccion) {
		super(nombre, tipoAtraccion);
		this.atracciones = atracciones;
	}
	
	abstract public void calcularCostoFinal();
	
	public void calcularTiempoTotal() {
		int aux = 0;
		for(Atraccion atraccion : atracciones) {
			aux += atraccion.getTiempo();
		}
		super.setTiempo(aux);
	}
	
	protected LinkedList<Atraccion> getAtracciones() {
		return atracciones;
	}

	@Override
	public boolean esUnaPromocion() {
		return true;
	}
	

	@Override
	public String toString() {
		return "Nombre promocion: " + this.getNombre() + "; Costo de promocion: " + this.getCosto() + "; Tiempo de atraccion: "
				+ this.getTiempo() + "; Tipo de atracciones: " + this.getTipoAtraccion();
	}		
	
	
}
