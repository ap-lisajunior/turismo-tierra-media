package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.ConnectionProvider;
import turismotierramedia.Itinerario;
import turismotierramedia.Producto;
import turismotierramedia.PromocionAbsoluta;
import turismotierramedia.TipoAtraccion;
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
			String sql = "SELECT COUNT(1) AS TOTAL FROM ITINERARIO";
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
			String sql = "INSERT INTO ITINERARIO (ID_USUARIO, ID_ATRACCION) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, producto.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int insertPromocion(Usuario usuario, Producto producto) {
		try {
			String sql = "INSERT INTO ITINERARIO (ID_USUARIO, ID_PROMOCION) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, producto.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Itinerario findByNombrePromocion(Producto producto, Usuario usuario) {
		try {
			String sql = "SELECT * FROM ITINERARIO WHERE ID_PROMOCION = ? AND ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, producto.getNombre());
			statement.setString(2, usuario.getNombre());
			ResultSet resultados = statement.executeQuery();

			Itinerario itinerario = null;

			if (resultados.next()) {
				itinerario = toItinerario(resultados);
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public Itinerario findByNombreAtraccion(Producto producto, Usuario usuario) {
		try {
			String sql = "SELECT * FROM ITINERARIO WHERE ID_ATRACCION = ? AND ID_USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, producto.getNombre());
			statement.setString(2, usuario.getNombre());
			ResultSet resultados = statement.executeQuery();

			Itinerario itinerario = null;

			if (resultados.next()) {
				itinerario = toItinerario(resultados);
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
	
	private Itinerario toItinerario(ResultSet resultados) throws SQLException {
		return new Itinerario(resultados.getString(2), resultados.getString(3), resultados.getString(4));
	}
}
