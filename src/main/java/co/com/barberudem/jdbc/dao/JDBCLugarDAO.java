package co.com.barberudem.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import co.com.barberudem.DAO.LugarDAO;
import co.com.barberudem.jdbc.entities.Lugar;
import co.com.barberudem.model.LugarDTO;


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

  public LugarDTO findLugarByID(int lugarId) {

    // Consulta que se realizara contra la base de datos
    String sql = "SELECT * FROM lugar WHERE id = ?";

    // Entidad que retornara el metodo
    LugarDTO lugar = new LugarDTO();

    // Objetos que administran la conexion a la base de datos
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
      // Obtiene la conexion y prepara la consulta
      conn = dataSource.getConnection();
      ps = conn.prepareStatement(sql);
      ps.setInt(1, lugarId);

      // Se obtienen los datos
      rs = ps.executeQuery();
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

      return lugar;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Se cierra los recursos utilizados
      try {
        if (rs != null) {
          rs.close();
        }
        if (ps != null) {
          ps.close();
        }
        // Se cierra la conexion aqui porque siempre se debe usar independiente de las excepciones
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  public LugarDTO findLugares() {
    // TODO Auto-generated method stub
    return null;
  }

}
