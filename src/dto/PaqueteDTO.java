package dto;

import dao.ActividadDAO;
import dao.AlojamientoDAO;
import dao.PaisDAO;
import dao.VueloDAO;
import interfaces.ObligacionModelo;

public class PaqueteDTO implements ObligacionModelo {

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
    private String nombrePaquete;

    /*Para la lectura*/
    public PaqueteDTO(int idPaquete, int idAlojamiento, int idVuelo, int idOrigen,
            int idDestino, String fechaSalida, String fechaRegreso, int idActividad,
            int portadaPrincipal, int portadaSecundaria, String nombrePaquete) {
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
        this.nombrePaquete = nombrePaquete;
    }

    /*Insert no necesitan un key porque es AI*/
    public PaqueteDTO(int idAlojamiento, int idVuelo, int idOrigen, int idDestino,
            String fechaSalida, String fechaRegreso, int idActividad, int portadaPrincipal,
            int portadaSecundaria, String nombrePaquete) {
        this.idAlojamiento = idAlojamiento;
        this.idVuelo = idVuelo;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.idActividad = idActividad;
        this.portadaPrincipal = portadaPrincipal;
        this.portadaSecundaria = portadaSecundaria;
        this.nombrePaquete = nombrePaquete;
    }

    public PaqueteDTO(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public PaqueteDTO() {
        this.idAlojamiento = 0;
    }

    @Override
    public String toString() {
        return "***************** DATOS DEL PAQUETE *******************"
                + "\n Nombre Paquete         : " + nombrePaquete
                + "\n Id Paquete             : " + idPaquete
                + "\n Id Alojamiento         : " + idAlojamiento
                + "\n Id Vuelo               : " + idVuelo
                + "\n Id Origen              : " + idOrigen
                + "\n Id Destino             : " + idDestino
                + "\n Fecha Salida           : " + fechaSalida
                + "\n Fecha Regreso          : " + fechaRegreso
                + "\n Id Actividad           : " + idActividad
                + "\n Id Portada Principal   : " + portadaPrincipal
                + "\n Id Portada Secundaria  : " + portadaSecundaria;
    }

    @Override
    public Object[] vectorizar() {
        Object[] values = {
            getIdPaquete(),
            getIdAlojamiento(),
            getIdVuelo(),
            getIdOrigen(),
            getIdDestino(),
            getFechaSalida(),
            getFechaRegreso(),
            getIdActividad(),
            getPortadaPrincipal(),
            getPortadaSecundaria(),
            getNombrePaquete()
        };
        return values;
    }

    public Object[] vectorizarConDependencias() {
        //daos
        AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
        ActividadDAO actividadDAO = new ActividadDAO();
        VueloDAO vueloDAO = new VueloDAO();
        //dtos
        AlojamientoDTO alojamientoDTO = alojamientoDAO.read(getIdAlojamiento());
        ActividadDTO actividadDTO = actividadDAO.read(getIdActividad());
        VueloDTO vueloDTO = vueloDAO.read(getIdVuelo());
        //vector
        Object[] values = {
            getIdPaquete(),
            getIdAlojamiento(),
            "Alojamiento " + alojamientoDTO.getIdAlojamiento() + "" + alojamientoDTO.getIdHotel(),
            getIdVuelo(),
            "Vuelo " + vueloDTO.getIdVuelo() + "" + vueloDTO.getIdAvion(),
            getIdOrigen(),
            getIdDestino(),
            getFechaSalida(),
            getFechaRegreso(),
            getIdActividad(),
            "Actividad " + actividadDTO.getNombreActividad(),
            getPortadaPrincipal(),
            getPortadaSecundaria(),
            getNombrePaquete()
        };
        return values;
    }

    public Object[] vectorizarParaCliente() {
        //daos
        AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
        ActividadDAO actividadDAO = new ActividadDAO();
        VueloDAO vueloDAO = new VueloDAO();
        PaisDAO paisDAO = new PaisDAO();
        //dtos
        AlojamientoDTO alojamientoDTO = alojamientoDAO.read(getIdAlojamiento());
        ActividadDTO actividadDTO = actividadDAO.read(getIdActividad());
        VueloDTO vueloDTO = vueloDAO.read(getIdVuelo());
        if (actividadDTO.getNombreActividad() == null) {
            actividadDTO.setNombreActividad("Sin asignar");
        }
        //vector
        Object[] values = {
            getIdPaquete(),
            "Alojamiento " + alojamientoDTO.getIdAlojamiento() + "" + alojamientoDTO.getIdHotel(),
            "Vuelo " + vueloDTO.getIdVuelo() + "" + vueloDTO.getIdAvion(),
            paisDAO.read(getIdOrigen()).getNombrePais(),
            paisDAO.read(getIdDestino()).getNombrePais(),
            getFechaSalida(),
            getFechaRegreso(),
            "Actividad " + actividadDTO.getNombreActividad(),
            getNombrePaquete()
        };
        return values;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
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

    @Override
    public Object[] vectorizarResumen() {
        //daos
        AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
        ActividadDAO actividadDAO = new ActividadDAO();
        VueloDAO vueloDAO = new VueloDAO();
        PaisDAO paisDAO = new PaisDAO();
        //dtos
        AlojamientoDTO alojamientoDTO = alojamientoDAO.read(getIdAlojamiento());
        ActividadDTO actividadDTO = actividadDAO.read(getIdActividad());
        VueloDTO vueloDTO = vueloDAO.read(getIdVuelo());
        if (actividadDTO.getNombreActividad() == null) {
            actividadDTO.setNombreActividad("Sin asignar");
        }
        //vector
        Object[] values = {
            getIdPaquete(),
            "Alojamiento " + alojamientoDTO.getIdAlojamiento() + "" + alojamientoDTO.getIdHotel(),
            "Vuelo " + vueloDTO.getIdVuelo() + "" + vueloDTO.getIdAvion(),
            paisDAO.read(getIdOrigen()).getNombrePais(),
            paisDAO.read(getIdDestino()).getNombrePais(),
            getFechaSalida(),
            getFechaRegreso(),
            "Actividad " + actividadDTO.getNombreActividad(),
            getNombrePaquete()
        };
        return values;
    }

}
