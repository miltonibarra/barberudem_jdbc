package co.com.barberudem.jdbc.entities;

/**
 * Entidad que contiene toda la información de los lugares
 * @author Milton
 */
public class Lugar {

  private int id;

  private String name;

  private String address;

  private Long lat;

  private Long lng;

  private String phone;

  private String description;

  private String schedule;

  private String email;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the lat
   */
  public Long getLat() {
    return lat;
  }

  /**
   * @param lat the lat to set
   */
  public void setLat(Long lat) {
    this.lat = lat;
  }

  /**
   * @return the lng
   */
  public Long getLng() {
    return lng;
  }

  /**
   * @param lng the lng to set
   */
  public void setLng(Long lng) {
    this.lng = lng;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the schedule
   */
  public String getSchedule() {
    return schedule;
  }

  /**
   * @param schedule the schedule to set
   */
  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
