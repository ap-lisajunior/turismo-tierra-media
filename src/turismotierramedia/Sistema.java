package turismotierramedia;

import java.util.LinkedList;

public class Sistema {
	
	LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
	LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
	LinkedList<Promocion> promociones = new LinkedList<Promocion>();
	
	
	
	public Sistema(LinkedList<Usuario> usuarios, LinkedList<Atraccion> atracciones, LinkedList<Promocion> promociones) {
		this.usuarios = usuarios;
		this.atracciones = atracciones;
		this.promociones = promociones;
	}



	public void nuevoUsuario(){
		
	}
	
	public LinkedList<Usuario> getUsuarios(){
		return null;
		
	}

	
}
