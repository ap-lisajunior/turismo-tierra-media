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

	protected void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	protected void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	protected double getTiempo() {
		return tiempo;
	}

	protected TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}
	
	protected boolean puedeComprar(Producto producto) {
		return this.getPresupuesto() >= producto.getCosto() 
				&& this.getTiempo() >= producto.getTiempo();
	}
	
	protected void aceptarOferta(Producto producto) {
		this.setPresupuesto(this.getPresupuesto() - producto.getCosto());
		this.setTiempo(this.getTiempo() - producto.getTiempo());
	}
	
	@Override
	public String toString() {
		return "Nombre de usuario: " + this.getNombre() + ", Tipo de atraccion preferida: "
				+ this.getTipoAtraccion().getDescripcion();
	}
	
	
}
