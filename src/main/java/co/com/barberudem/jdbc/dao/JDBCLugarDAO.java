package co.com.barberudem.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import co.com.barberudem.jdbc.entities.Lugar;


/**
 * Clase que implementa los servicios definidos para la entidad Lugar
 * @author Milton {@link Lugar} {@link LugarDAO}
 */
public class JDBCLugarDAO implements LugarDAO {

  private DataSource dataSource;

  /**
   * Se asigna el datasource para administrar la conexion a la base de datos
   * 
   * @param dataSource
   */
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Lugar findLugarByID(int lugarId) {

    // Consulta que se realizara contra la base de datos
    String sql = "SELECT * FROM lugar WHERE id = ?";

    // Entidad que retornara el metodo
    Lugar lugar = new Lugar();

    // Objetos que administran la conexion a la base de datos
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      // Obtiene la conexion y prepara la consulta
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(sql);
      ps.setInt(1, lugarId);

      // Se obtienen los datos
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lugar.setId(rs.getInt("id"));
        lugar.setAddress(rs.getString("direccion"));
        lugar.setDescription(rs.getString("descripcion"));
        lugar.setEmail(rs.getString("correo"));
        lugar.setLat(rs.getLong("dir_lat"));
        lugar.setLng(rs.getLong("dir_lon"));
        lugar.setName(rs.getString("nombre"));
        lugar.setPhone(rs.getString("telefono"));
        lugar.setSchedule(rs.getString("horario"));
      }

      // Se cierra los recursos utilizados
      rs.close();
      ps.close();

      return lugar;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Se cierra la conexion aqui porque siempre se debe usar independiente de las excepciones
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

    return null;
  }

}
