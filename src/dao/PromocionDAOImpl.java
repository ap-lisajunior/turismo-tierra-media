package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import turismotierramedia.Atraccion;
import turismotierramedia.Producto;
import turismotierramedia.Promocion;
import turismotierramedia.PromocionAbsoluta;
import turismotierramedia.PromocionAxB;
import turismotierramedia.PromocionPorcentual;
import turismotierramedia.TipoAtraccion;
import turismotierramedia.TipoPromocion;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public List<Promocion> crearPromociones() {
		try {
			String sql = "SELECT promociones.nombre, group_concat(atracciones.nombre, ';') AS 'lista_atracciones', promociones.tipo_atraccion, promociones.tipo_promocion, promociones.descuento \r\n"
					+ "FROM promociones\r\n"
					+ "JOIN atraccion_promocion ON atraccion_promocion.id_promocion = promociones.id_promocion\r\n"
					+ "JOIN atracciones ON atracciones.id_atraccion = atraccion_promocion.id_atraccion\r\n"
					+ "GROUP BY promociones.nombre";
			
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			List<Promocion> promociones = new LinkedList<Promocion>();
			while(resultados.next()) {
				promociones.add(toPromocion(resultados));
			}
			
			return promociones;
			
		} catch(Exception e){
			throw new MissingDataException(e);
		}
	}
	
	private Promocion toPromocion(ResultSet resultados) throws SQLException {
		String nombre = resultados.getString("nombre");
		String[] nombreAtracciones = resultados.getString("lista_atracciones").split(";");
		TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(resultados.getString("tipo_atraccion"));
		TipoPromocion tipoPromocion = TipoPromocion.valueOf(resultados.getString("tipo_promocion"));
		
		LinkedList<Atraccion> atraccionesPromocion = new LinkedList<Atraccion>();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		List<Atraccion> atraccionesTotales = atraccionDAO.crearAtracciones();
		
		for(String nombreAtraccion : nombreAtracciones) {
			for(Producto atraccion : atraccionesTotales) {
				if(atraccion.getNombre().equals(nombreAtraccion)) {
					atraccionesPromocion.add((Atraccion) atraccion);
					break;
				}
			}
		}
		
		if(tipoPromocion.equals(TipoPromocion.PORCENTUAL)) {
			double porcentajeDescuento = resultados.getDouble("descuento");
			return new PromocionPorcentual(nombre, atraccionesPromocion, tipoAtraccion, porcentajeDescuento);
		}
		else if (tipoPromocion.equals(TipoPromocion.ABSOLUTA)) {
			int costoFinal = resultados.getInt("descuento");
			return new PromocionAbsoluta(nombre, atraccionesPromocion, tipoAtraccion, costoFinal);
		}
		else if (tipoPromocion.equals(TipoPromocion.AXB)) {
			return new PromocionAxB(nombre, atraccionesPromocion, tipoAtraccion);
		}
		return null;		
		
	}

}
