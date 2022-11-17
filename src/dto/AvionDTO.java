package dto;

public class AvionDTO {

    private int idAvion;
    private String nombreAvion;

    public AvionDTO(int idAvion, String nombreAvion) {
        this.idAvion = idAvion;
        this.nombreAvion = nombreAvion;
    }

    public AvionDTO(String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public AvionDTO() {

    }

    @Override
    public String toString() {
        return "******** DATOS AVION *******************" 
                + "\n Id Avion           : " + idAvion 
                + "\n Nombre Avion       : " + nombreAvion;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

}
