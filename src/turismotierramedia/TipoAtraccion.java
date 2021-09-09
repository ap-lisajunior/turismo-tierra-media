package turismotierramedia;

public enum TipoAtraccion {
	AVENTURA("Aventura"),
	PAISAJE("Paisaje"),
	DEGUSTACION("Degustacion");
	
	private String descripcion;
	
	private TipoAtraccion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	protected String getDescripcion() {
		return this.descripcion;
	}
}
