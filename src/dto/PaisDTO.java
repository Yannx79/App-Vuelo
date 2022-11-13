package dto;

public class PaisDTO {

    private int idPais;
    private String nombrePais;

    public PaisDTO(int idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }

    public PaisDTO(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public PaisDTO() {

    }

    @Override
    public String toString() {
        return "************ DATOS DEL PAIS ************" 
                + "\n Id Pais       : " + idPais 
                + "\n Nombre Pais   : " + nombrePais;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

}
