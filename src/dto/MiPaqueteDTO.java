package dto;

public class MiPaqueteDTO extends PaqueteDTO {

    private int idUsuario;

    public MiPaqueteDTO(int idUsuario, int idPaquete, int idAlojamiento,
            int idVuelo, int idOrigen, int idDestino, String fechaSalida,
            String fechaRegreso, int idActividad, int portadaPrincipal,
            int portadaSecundaria, String nombrePaquete) {
        super(idPaquete, idAlojamiento, idVuelo, idOrigen, idDestino,
                fechaSalida, fechaRegreso, idActividad, portadaPrincipal,
                portadaSecundaria, nombrePaquete);
        this.idUsuario = idUsuario;
    }

    public MiPaqueteDTO(int idUsuario, int idAlojamiento, int idVuelo,
            int idOrigen, int idDestino, String fechaSalida, String fechaRegreso,
            int idActividad, int portadaPrincipal, int portadaSecundaria,
            String nombrePaquete) {
        super(idAlojamiento, idVuelo, idOrigen, idDestino, fechaSalida,
                fechaRegreso, idActividad, portadaPrincipal, portadaSecundaria,
                nombrePaquete);
        this.idUsuario = idUsuario;
    }

    public MiPaqueteDTO(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MiPaqueteDTO() {

    }

    @Override
    public String toString() {
        return ""
                + super.toString()
                + "\n Id Usuario             : " + idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
