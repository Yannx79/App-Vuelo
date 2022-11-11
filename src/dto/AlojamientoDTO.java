package dto;

public class AlojamientoDTO {

    private int idAlojamiento;
    private double costoAlojamiento;
    private int numeroPersonas;
    private int numeroHabitaciones;
    private int idHotel;
    private int portadoPrincipal;
    private int portadaSecundaria;

    public AlojamientoDTO(int idAlojamiento, double costoAlojamiento,
            int numeroPersonas, int numeroHabitaciones, int idHotel,
            int portadoPrincipal, int portadaSecundaria) {
        this.idAlojamiento = idAlojamiento;
        this.costoAlojamiento = costoAlojamiento;
        this.numeroPersonas = numeroPersonas;
        this.numeroHabitaciones = numeroHabitaciones;
        this.idHotel = idHotel;
        this.portadoPrincipal = portadoPrincipal;
        this.portadaSecundaria = portadaSecundaria;
    }

    public AlojamientoDTO(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public AlojamientoDTO() {
    }

    @Override
    public String toString() {
        return "********************* DATOS HOTEL ***********************" 
                + "\n Id Alojamiento         : " + idAlojamiento 
                + "\n Costo Alojamiento      : " + costoAlojamiento 
                + "\n Numero Personas        : " + numeroPersonas 
                + "\n Numero Habitaciones    : " + numeroHabitaciones 
                + "\n Id Hotel               : " + idHotel;
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

    
    
    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public double getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(double costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
}
