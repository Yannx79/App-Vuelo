
package controllers;

import dao.AlojamientoDAO;
import dao.HotelDAO;
import dao.PortadaDAO;
import dto.AlojamientoDTO;
import dto.HotelDTO;
import dto.PortadaDTO;
import formato.Imagen;
import formato.ManejadorTablas;
import views.VCrearAlojamiento;
import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.ref.Cleaner.create;
import process.PCrearAlojamiento;
import process.Parse;

public class CCrearAlojamiento extends ObligacionControlador implements  ActionListener{

    private VCrearAlojamiento vista;
    
    private AlojamientoDAO alojamientoDAO;
    private HotelDAO hotelDAO;
    private PortadaDAO portadaDAO;
    
    public CCrearAlojamiento(VCrearAlojamiento f){
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("CREAR ALOJAMIENTO");
        this.vista.lblPortadaPrincipal.setSize(310, 110);
        this.vista.lblPortadaSecundaria.setSize(310, 110);
        this.cambiarImagen();
        this.completarInformacionHotel();
        this.generarTabla();
        
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnCrear.addActionListener(this);
        this.vista.cbxIdHotel.addActionListener(this);
        this.vista.cbxPortadaPrincipal.addActionListener(this);
        this.vista.cbxPortadaSecundaria.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        PCrearAlojamiento.construirForma(vista);
        alojamientoDAO = new AlojamientoDAO();
        hotelDAO = new HotelDAO();
        portadaDAO = new PortadaDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCrear) {
            AlojamientoDTO alojamientoDTO = PCrearAlojamiento.instanciar(vista);
            alojamientoDAO.create(alojamientoDTO);
            this.generarTabla();
        } else if (e.getSource() == this.vista.cbxIdHotel) {
            completarInformacionHotel();
        } else if (e.getSource() == this.vista.cbxPortadaPrincipal) {
            cambiarImagen();
        } else if (e.getSource() == this.vista.cbxPortadaSecundaria) {
            cambiarImagen();
        }
    }
    
    private void completarInformacionHotel() {
        HotelDTO hotelDTO = hotelDAO.read(Parse.getPK(vista.cbxIdHotel.getSelectedItem().toString()));
        this.vista.txaDatosExtra.setText(hotelDTO.toString());
    }

    private void cambiarImagen() {
        PortadaDTO portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaPrincipal.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaPrincipal, "imagenes/alojamientos/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaSecundaria.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/alojamientos/" + portadaDTO.getPath());
    }
    
    private void generarTabla() {
        String header[] = {"ID ALOJAMIENTO","COSTO ALOJAMIENTO","NRO DE PERSONAS",
            "NRO DE HABITACIONES","ID HOTEL","ID PORTADA PRINCIPAL","ID PORTADA SECUNDARIA"};
        PCrearAlojamiento.completarTabla(this.vista.tblDatos, header, alojamientoDAO.readAll());
        ManejadorTablas.centrarTodo(vista.tblDatos);
    }
    
}
