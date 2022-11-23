package controllers;

import dao.MiPaqueteDAO;
import dao.*;
import views.*;
import interfaces.*;
import process.*;
import dto.*;
import formato.Imagen;
import formato.Mensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPaquetePersonalizado extends ObligacionControlador implements ActionListener {

    private VPaquetePersonalizado vista;

    private PortadaDAO portadaDAO;

    public CPaquetePersonalizado(VPaquetePersonalizado f) {
        this.vista = f;
        super.constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("Crear un Paquete Personalizado");
        this.vista.lblPortadaPrincipal.setSize(310, 110);
        this.vista.lblPortadaSecundaria.setSize(310, 110);
        this.cambiarImagen();
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnCrear.addActionListener(this);
        this.vista.cbxPortadaPrincipal.addActionListener(this);
        this.vista.cbxPortadaSecundaria.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
                PPaquetePersonalizado.construirForma(vista);
        portadaDAO = new PortadaDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCrear) {
            this.crearPaquetePerzonalizado();
        } else if (e.getSource() == this.vista.cbxPortadaPrincipal) {
            this.cambiarImagen();
        } else if (e.getSource() == this.vista.cbxPortadaSecundaria) {
            this.cambiarImagen();
        }
    }

    private void crearPaquetePerzonalizado() {
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        miPaqueteDTO = PPaquetePersonalizado.instanciar(this.vista);
        miPaqueteDAO.createPaquete(miPaqueteDTO);
        Mensaje.mostrar("Paquete Creado Sastifactoriamente");
    }

    private void cambiarImagen() {
        PortadaDTO portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaPrincipal.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaPrincipal, "imagenes/paquetes/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaSecundaria.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/paquetes/" + portadaDTO.getPath());
    }

}
