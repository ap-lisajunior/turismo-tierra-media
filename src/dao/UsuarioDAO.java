package dao;

import java.util.LinkedList;
import turismotierramedia.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public abstract Usuario findByUsername(String username);
	
	public abstract LinkedList<Usuario> createUsuarios();
}
