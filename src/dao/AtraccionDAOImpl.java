package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import turismotierramedia.Atraccion;
import turismotierramedia.TipoAtraccion;

public class AtraccionDAOImpl implements AtraccionDAO {

	@Override
	public List<Atraccion> crearAtracciones() {
		try {
			String sql = "SELECT nombre, costo, tiempo, cupo, tipo FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			List<Atraccion> atracciones = new LinkedList<Atraccion>();
			while(resultados.next()) {
				atracciones.add(toAtraccion(resultados));
			}
			
			return atracciones;
			
		} catch(Exception e){
			throw new MissingDataException(e);
		}
	}
	
	private Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		return new Atraccion(resultados.getString("nombre"), resultados.getInt("costo"), resultados.getDouble("tiempo"), resultados.getInt("cupo"), TipoAtraccion.valueOf(resultados.getString("tipo")));
	}
}
