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

	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Presupuesto: " + presupuesto + "| Tiempo disponible = " + tiempo + "| Tipo de atracción preferida: "
				+ tipoAtraccion;
	}

	
	
}
