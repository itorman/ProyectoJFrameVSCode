public class Tecnico {

  /*  la clase Tecnico tiene como atributos el nombre completo y el nivel
  Nombre completo
  Nivel ( N1,N2,N3)
  */
  private String nombre;
  private String nivel;

  /**
   * @param nombre
   * @param nivel
   */
  public Tecnico(String nombre, String nivel) {
    this.nombre = nombre;
    this.nivel = nivel;
  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the nivel
   */
  public String getNivel() {
    return nivel;
  }

  /**
   * @param nivel the nivel to set
   */
  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  
  @Override
  public String toString() {
    return "Tecnico [nivel=" + nivel + ", nombre=" + nombre + "]";
  }

  
  

}