package controllers;

import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import dao.*;
import dto.*;
import formato.Imagen;
import formato.ManejadorTablas;
import java.util.List;
import process.*;

public class CCrearVuelo extends ObligacionControlador implements ActionListener {

    private VCrearVuelo vista;

    private VueloDAO vueloDAO;
    private PortadaDAO portadaDAO;
    private AvionDAO avionDAO;

    public CCrearVuelo(VCrearVuelo f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("CREAR UN VUELO");
        this.vista.lblPortadaPrincipal.setSize(310, 110);
        this.vista.lblPortadaSecundaria.setSize(310, 110);
        this.cambiarImagen();
        this.completarInformacionAvion();
        this.generarTabla();
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnCrear.addActionListener(this);
        this.vista.cbxIdAvion.addActionListener(this);
        this.vista.cbxPortadaPrincipal.addActionListener(this);
        this.vista.cbxPortadaSecundaria.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        PCrearVuelo.construirForma(vista);
        vueloDAO = new VueloDAO();
        avionDAO = new AvionDAO();
        portadaDAO = new PortadaDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCrear) {
            VueloDTO vueloDTO = PCrearVuelo.instanciar(vista);
            vueloDAO.create(vueloDTO);
            this.generarTabla();
        } else if (e.getSource() == this.vista.cbxIdAvion) {
            this.completarInformacionAvion();
        } else if (e.getSource() == this.vista.cbxPortadaPrincipal) {
            this.cambiarImagen();
        } else if (e.getSource() == this.vista.cbxPortadaSecundaria) {
            this.cambiarImagen();
        }

    }

    private void completarInformacionAvion() {
        AvionDTO avionDTO = avionDAO.read(Parse.getPK(vista.cbxIdAvion.getSelectedItem().toString()));
        this.vista.txaDatosExtra.setText(avionDTO.toString());
    }

    private void cambiarImagen() {
        PortadaDTO portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaPrincipal.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaPrincipal, "imagenes/vuelos/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaSecundaria.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/vuelos/" + portadaDTO.getPath());
    }

    private void generarTabla() {
        String header[] = {"ID VUELO", "NRO PASAJERO", "COSTO VUELO", "ID AVION",
            "ID PORTADA PRINCIPAL", "ID PORTADA SECUNDARIA"};
        ProcesoTable.completarTabla(this.vista.tblDatos, header, vueloDAO.readAll());
        ManejadorTablas.centrarTodo(vista.tblDatos);
    }

}
