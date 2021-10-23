package dao;

import java.util.LinkedList;
import java.util.List;

import turismotierramedia.Producto;
import turismotierramedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public abstract Usuario findByUsername(String username);
	
	public abstract LinkedList<Usuario> createUsuario();
}
