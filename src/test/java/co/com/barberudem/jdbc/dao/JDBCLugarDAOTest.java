package co.com.barberudem.jdbc.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.barberudem.jdbc.entities.Lugar;


/**
 * Clase para probar los servicios asociados a Lugares
 * @author Milton
 */
public class JDBCLugarDAOTest {

  @Test
  public void test() {
    // Se obtiene el contexto de la aplicacion
    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

    // Se obtiene el servicio que implementa los servicios de la base de datos
    LugarDAO sesionDAO = (LugarDAO) context.getBean("lugarDAO");

    // Se realiza el insert
    Lugar lugar = sesionDAO.findLugarByID(1);
    System.out.println("Nombre: " + lugar.getName());
    System.out.println("Direccion: " + lugar.getAddress());
  }

}
