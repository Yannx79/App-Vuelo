package dto;

public class PaqueteDTO {

    private int idPaquete;
    private int idAlojamiento;
    private int idVuelo;
    private int idOrigen;
    private int idDestino;
    private String fechaSalida;
    private String fechaRegreso;
    private int idActividad;
    private int portadaPrincipal;
    private int portadaSecundaria;

    /*Para la lectura*/
    public PaqueteDTO(int idPaquete, int idAlojamiento, int idVuelo, int idOrigen,
            int idDestino, String fechaSalida, String fechaRegreso, int idActividad,
            int portadaPrincipal, int portadaSecundaria) {
        this.idPaquete = idPaquete;
        this.idAlojamiento = idAlojamiento;
        this.idVuelo = idVuelo;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.idActividad = idActividad;
        this.portadaPrincipal = portadaPrincipal;
        this.portadaSecundaria = portadaSecundaria;
    }

    /*Insert no necesitan un key porque es AI*/
    public PaqueteDTO(int idAlojamiento, int idVuelo, int idOrigen, int idDestino,
            String fechaSalida, String fechaRegreso, int idActividad, int portadaPrincipal,
            int portadaSecundaria) {
        this.idAlojamiento = idAlojamiento;
        this.idVuelo = idVuelo;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.idActividad = idActividad;
        this.portadaPrincipal = portadaPrincipal;
        this.portadaSecundaria = portadaSecundaria;
    }

    public PaqueteDTO(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public PaqueteDTO() {

    }

    @Override
    public String toString() {
        return "**********************************************"
                + "\nId Paquete         : " + idPaquete
                + "\nId Alojamiento     : " + idAlojamiento
                + "\nId Vuelo           : " + idVuelo
                + "\nId Origen          : " + idOrigen
                + "\nId Destino         : " + idDestino
                + "\nFecha Salida       : " + fechaSalida
                + "\nFecha Regreso      : " + fechaRegreso;
    }

    public int getPortadaPrincipal() {
        return portadaPrincipal;
    }

    public void setPortadaPrincipal(int portadaPrincipal) {
        this.portadaPrincipal = portadaPrincipal;
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

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

}
