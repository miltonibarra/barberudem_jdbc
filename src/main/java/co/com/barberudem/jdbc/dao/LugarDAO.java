package co.com.barberudem.jdbc.dao;

import co.com.barberudem.jdbc.entities.Lugar;


/**
 * Interface que contiene los servicios asociados a la tabla lugares
 * @author Milton
 */
public interface LugarDAO {

  /**
   * Obtiene un lugar dado el id
   * @param lugarId
   * @return Lugar {@link Lugar}
   */
  public Lugar findLugarByID(int lugarId);
}
