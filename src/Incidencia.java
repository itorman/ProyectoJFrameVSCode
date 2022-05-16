public class Incidencia {

    /* La clase incidencia tiene como atributos:
    - Un identificador alfanumérico: Ej IC0001
    - Una descripción breve de la incidencia.
    - Una fecha de creación: En formato día/mes/año
    - Una fecha de cierre. En formato día/mes/año
    - Un estado, que podrá ser: abierta, en progreso, cerrada
    - Un Técnico asociado: Si la incidencia no tiene técnico asociado no se puede cambiar de estado. La incidencia solo puede tener un único Técnico asociado
    - Tiempo de resolución (horas): Ejemplo 2 horas*/

    private String id;
    private String descripcion;
    private String fechaCreacion;
    private String fechaCierre;
    private String estado;
    private Tecnico tecnico;
    private int tiempoResolucion;

    //No inicializo cierre porque no se sabe la fecha de cierre
    //Inicializo estado a abierto por defecto
    //No inicializo tiempo de resolución porque no se sabe el tiempo de resolución
    public Incidencia(String id, String descripcion, String fechaCreacion, String estado, Tecnico tecnico) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.tecnico = tecnico;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    /**
     * @return the fechaCierre
     */
    public String getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param fechaCierre the fechaCierre to set
     */
    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tecnico
     */
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    /**
     * @return the tiempoResolucion
     */
    public int getTiempoResolucion() {
        return tiempoResolucion;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Incidencia [descripcion=" + descripcion + ", estado=" + estado + ", fechaCierre=" + fechaCierre
                + ", fechaCreacion=" + fechaCreacion + ", id=" + id + ", tecnico=" + tecnico + ", tiempoResolucion="
                + tiempoResolucion + "]";
    }
   
}
