package dto;

public class MiPaqueteDTO extends PaqueteDTO {

    private int idUsuario;

    public MiPaqueteDTO(int idUsuario, int idPaquete, int idAlojamiento, int idVuelo, int idOrigen, int idDestino, String fechaSalida, String fechaRegreso, int idActividad, int portadaPrincipal, int portadaSecundaria) {
        super(idPaquete, idAlojamiento, idVuelo, idOrigen, idDestino, fechaSalida, fechaRegreso, idActividad, portadaPrincipal, portadaSecundaria);
        this.idUsuario = idUsuario;
    }

    public MiPaqueteDTO(int idUsuario, int idAlojamiento, int idVuelo, int idOrigen, int idDestino, String fechaSalida, String fechaRegreso, int idActividad, int portadaPrincipal, int portadaSecundaria) {
        super(idAlojamiento, idVuelo, idOrigen, idDestino, fechaSalida, fechaRegreso, idActividad, portadaPrincipal, portadaSecundaria);
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
                + "\n Id Usuario        : " + idUsuario;
    }
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
