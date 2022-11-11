package dto;

public class ActividadDTO {

    private int idActividad;
    private String nombreActividad;
    private String descripcion;
    private int idCategoria;
    private double costoActividad;
    private int portadoPrincipal;
    private int portadaSecundaria;

    public ActividadDTO(int idActividad, String nombreActividad, String descripcion,
            int idCategoria, double costoActividad, int portadoPrincipal, int portadaSecundaria) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.costoActividad = costoActividad;
        this.portadoPrincipal = portadoPrincipal;
        this.portadaSecundaria = portadaSecundaria;
    }

    public ActividadDTO(int idActividad) {
        this.idActividad = idActividad;
    }

    public ActividadDTO() {
    }

    @Override
    public String toString() {
        return "*****************************************************" 
                + "\nId Actividad           : " + idActividad 
                + "\nNombre Actividad       : " + nombreActividad 
                + "\nDescripcion            : " + descripcion 
                + "\nId Categoria           : " + idCategoria 
                + "\nCosto Actividad        : " + costoActividad 
                + "\nPortado Principal      : " + portadoPrincipal 
                + "\nPortada Secundaria     : " + portadaSecundaria;
    }

    public int getPortadoPrincipal() {
        return portadoPrincipal;
    }

    public void setPortadoPrincipal(int portadoPrincipal) {
        this.portadoPrincipal = portadoPrincipal;
    }

    public int getPortadaSecundaria() {
        return portadaSecundaria;
    }

    public void setPortadaSecundaria(int portadaSecundaria) {
        this.portadaSecundaria = portadaSecundaria;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public double getCostoActividad() {
        return costoActividad;
    }

    public void setCostoActividad(double costoActividad) {
        this.costoActividad = costoActividad;
    }

}
