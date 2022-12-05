package dto;

import interfaces.ObligacionModelo;

public class HotelDTO implements ObligacionModelo {

    private int idHotel;
    private String nombreHotel;
    private int cantidadEstrellas;

    public HotelDTO(int idHotel, String nombreHotel, int cantidadEstrellas) {
        this.idHotel = idHotel;
        this.nombreHotel = nombreHotel;
        this.cantidadEstrellas = cantidadEstrellas;
    }

    public HotelDTO(String nombreHotel, int cantidadEstrellas) {
        this.nombreHotel = nombreHotel;
        this.cantidadEstrellas = cantidadEstrellas;
    }

    public HotelDTO() {
    }

    @Override
    public String toString() {
        return "**************** DATOS DEL HOTEL ****************************"
                + "\n IdHotel                : " + idHotel
                + "\n NombreHotel            : " + nombreHotel
                + "\n CantidadEstrellas      : " + cantidadEstrellas;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getCantidadEstrellas() {
        return cantidadEstrellas;
    }

    public void setCantidadEstrellas(int cantidadEstrellas) {
        this.cantidadEstrellas = cantidadEstrellas;
    }

    @Override
    public Object[] vectorizarResumen() {
        Object[] value = {
            idHotel, nombreHotel
        };
        return value;
    }

    @Override
    public Object[] vectorizar() {
        Object[] value = {
            idHotel, nombreHotel, cantidadEstrellas
        };
        return value;
    }

}
