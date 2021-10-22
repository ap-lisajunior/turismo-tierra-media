package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import turismotierramedia.Atraccion;
import turismotierramedia.TipoAtraccion;

public class AtraccionDAOImpl implements AtraccionDAO {

	@Override
	public List<Atraccion> findAll() {
		try {
			String sql = "SELECT NOMBRE, COSTO, TIEMPO, CUPO, TIPO FROM ATRACCIONES";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Atraccion> atracciones = new LinkedList<Atraccion>();
			while (resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ATRACCIONES";
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
	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO ATRACCIONES (NOMBRE, COSTO, TIEMPO, CUPO, TIPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, atraccion.getNombre());
			statement.setInt(3, atraccion.getCosto());
			statement.setDouble(4, atraccion.getTiempo());
			statement.setInt(5, atraccion.getCupo());
			statement.setString(6, atraccion.getTipoAtraccion());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Atraccion atraccion) {
		try {
			String sql = "UPDATE ATRACCION SET CUPO = ? WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, atraccion.getCupo());
			statement.setString(2, atraccion.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Atraccion atracciones) {
		try {
			String sql = "DELETE FROM ATRACCIONES WHERE ID_ATRACCION = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, atracciones.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Atraccion toAtraccion(ResultSet resultados) throws SQLException{
		return new Atraccion (resultados.getString("nombre"),
							resultados.getInt("costo"),
							resultados.getDouble("tiempo"),
							resultados.getInt("cupo"),
							TipoAtraccion.valueOf(resultados.getString("tipo").toUpperCase()));

}
}
