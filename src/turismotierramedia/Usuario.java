package turismotierramedia;

public class Usuario {
	
	private String nombre;
	private int presupuesto;
	private double tiempo;
	private TipoAtraccion tipoAtraccion;
	
	public Usuario(String nombre, int presupuesto, double tiempo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipoAtraccion;
	}

	protected String getNombre() {
		return nombre;
	}

	protected int getPresupuesto() {
		return presupuesto;
	}

	protected double getTiempo() {
		return tiempo;
	}

	protected TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	@Override
	public String toString() {
		return "Nombre de usuario: " + this.getNombre() + "; Presupuesto: " + this.getPresupuesto() + "; Tiempo disponible: " + this.getTiempo() + "; Tipo de atraccion preferida: "
				+ this.getTipoAtraccion();
	}
	
	
}
