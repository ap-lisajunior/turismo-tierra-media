package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import turismotierramedia.Itinerario;
import turismotierramedia.Producto;
import turismotierramedia.Usuario;

public class ItinerarioDAOImpl implements ItinerarioDAO{

	@Override
	public List<Itinerario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ITINERARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insertAtraccion(Usuario usuario, Producto producto) {
		try {
			String sql = "INSERT INTO ITINERARIOS (NOMBRE_USUARIO, NOMBRE_ATRACCION, COSTO, TIEMPO) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getCosto());
			statement.setDouble(4, producto.getTiempo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int insertPromocion(Usuario usuario, Producto producto) {
		try {
			String sql = "INSERT INTO ITINERARIOS (NOMBRE_USUARIO, NOMBRE_PROMOCION, COSTO, TIEMPO) VALUES (?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getCosto());
			statement.setDouble(4, producto.getTiempo());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Itinerario findByUsuario(Usuario usuario, LinkedList<Producto> atracciones, LinkedList<Producto> promociones) {
		try {
			String sql = "SELECT itinerarios.nombre_usuario, group_concat(itinerarios.nombre_atraccion, ';') AS 'atracciones', group_concat(itinerarios.nombre_promocion, ';') AS 'promociones'\r\n"
					+ "FROM itinerarios\r\n"
					+ "WHERE nombre_usuario = ?"
					+ "GROUP BY itinerarios.nombre_usuario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			ResultSet resultados = statement.executeQuery();

			Itinerario itinerario = new Itinerario();
			
			if (resultados.next()) {
				itinerario = toItinerario(resultados, atracciones, promociones, itinerario);
			}
			return itinerario;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Itinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int insert(Itinerario t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Itinerario toItinerario(ResultSet resultados, LinkedList<Producto> atracciones, LinkedList<Producto> promociones, Itinerario itinerario) throws SQLException {
				
		String listaAtracciones = resultados.getString("atracciones");
		if(listaAtracciones != null) {
			String[] nombresListaAtracciones = listaAtracciones.split(";");
			for(String nombre : nombresListaAtracciones) {
				for(Producto atraccion : atracciones) {
					if(atraccion.getNombre().equals(nombre)) {
						itinerario.agregarAtraccion(atraccion);
						itinerario.setCosto(atraccion.getCosto());
						itinerario.setTiempo(atraccion.getTiempo());
						break;
					}
				}
			}
		}
		
		String listaPromociones = resultados.getString("promociones");
		if(listaPromociones != null) {
			String[] nombresListaPromociones = listaPromociones.split(";");
			for(String nombre : nombresListaPromociones) {
				for(Producto promocion : promociones) {
					if(promocion.getNombre().equals(nombre)) {
						itinerario.agregarPromocion(promocion);
						itinerario.setCosto(promocion.getCosto());
						itinerario.setTiempo(promocion.getTiempo());
						break;
					}
				}
			}
		}
	
		return itinerario;			
	}
}
