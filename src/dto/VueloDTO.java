package dto;

public class VueloDTO {

    private int idVuelo;
    private int numeroPasajeros;
    private double costoVuelo;
    private int idAvion;
    private int portadaPrincipal;
    private int portadaSecundaria;

    public VueloDTO(int idVuelo, int numeroPasajeros, double costoVuelo, int idAvion,
            int portadaPrincipal, int portadaSecundaria) {
        this.idVuelo = idVuelo;
        this.numeroPasajeros = numeroPasajeros;
        this.costoVuelo = costoVuelo;
        this.idAvion = idAvion;
        this.portadaPrincipal = portadaPrincipal;
        this.portadaSecundaria = portadaSecundaria;
    }

    public VueloDTO(int numeroPasajeros, double costoVuelo, int idAvion) {
        this.numeroPasajeros = numeroPasajeros;
        this.costoVuelo = costoVuelo;
        this.idAvion = idAvion;
    }

    public VueloDTO(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public VueloDTO() {
    }

    @Override
    public String toString() {
        return "**************************************************" 
                + "\n Id Vuelo           : " + idVuelo 
                + "\n Numero Pasajeros   : " + numeroPasajeros 
                + "\n Costo Vuelo        : " + costoVuelo 
                + "\n Id Avion           : " + idAvion;
    }

    public int getPortadaPrincipal() {
        return portadaPrincipal;
    }

    public void setPortadaPrincipal(int portadoPrincipal) {
        this.portadaPrincipal = portadoPrincipal;
    }

    public int getPortadaSecundaria() {
        return portadaSecundaria;
    }

    public void setPortadaSecundaria(int portadaSecundaria) {
        this.portadaSecundaria = portadaSecundaria;
    }

    
    
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public double getCostoVuelo() {
        return costoVuelo;
    }

    public void setCostoVuelo(double costoVuelo) {
        this.costoVuelo = costoVuelo;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

}
