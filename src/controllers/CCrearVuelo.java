package controllers;

import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import dao.*;
import dto.*;
import formato.Imagen;
import process.PCrearVuelo;
import process.Parse;

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
        vueloDAO = new VueloDAO();
        avionDAO = new AvionDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCrear) {
            VueloDTO vueloDTO = PCrearVuelo.instanciar(vista);
            vueloDAO.create(vueloDTO);
        } else if (e.getSource() == this.vista.cbxIdAvion) {
            AvionDTO avionDTO = avionDAO.read(Parse.getPK(vista.cbxIdAvion.getSelectedItem().toString()));
            this.vista.txaDatosExtra.setText(avionDTO.toString());
        } else if (e.getSource() == this.vista.cbxPortadaPrincipal) {
            this.cambiarImagen();
        } else if (e.getSource() == this.vista.cbxPortadaSecundaria) {
            this.cambiarImagen();
        }

    }

    private void cambiarImagen() {
        PortadaDTO portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaPrincipal.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaPrincipal, "imagenes/vuelos/" + portadaDTO.getPath());
    }

}
