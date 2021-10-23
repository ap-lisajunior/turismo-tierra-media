package turismotierramedia;

public class Usuario {

	private String nombre;
	private int presupuesto;
	private double tiempo;
	private TipoAtraccion tipoAtraccion;
	private Itinerario itinerario;

	public Usuario(String nombre, int presupuesto, double tiempo, TipoAtraccion tipoAtraccion) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public String getTipoAtraccionToString() {
		return tipoAtraccion.toString().toUpperCase();
	}


	protected boolean puedeComprar(Producto producto) {
		return this.getPresupuesto() >= producto.getCosto() && this.getTiempo() >= producto.getTiempo();
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

	public Itinerario getItinerario() {
		return itinerario;
	}

}
