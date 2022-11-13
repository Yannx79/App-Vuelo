package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import dao.*;
import dto.*;
import interfaces.*;
import java.util.LinkedList;
import java.util.List;
import process.PSelecionarAlojamiento;
import rsscalelabel.RSScaleLabel;

public class CSelecionarAlojamiento extends ObligacionControlador implements ActionListener {

    private VSelecionarAlojamiento vista;
    private List<AlojamientoDTO> list;

    private AlojamientoDAO alojamientoDAO;
    private PortadaDAO portadaDAO;
    private VueloDAO vueloDAO;

    private int index;

    public CSelecionarAlojamiento(VSelecionarAlojamiento f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("SELECCIONAR ALOJAMIENTO");
        this.vista.lblTitulo.setText("Seleccionar Alojamientos");
        this.vista.lblCantidadRegistros.setText("Cantidad de alojamientos "
                + "disponibles " + list.size());
        PSelecionarAlojamiento.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnLeft.addActionListener(this);
        this.vista.btnRight.addActionListener(this);
        this.vista.btnAgregar.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        alojamientoDAO = new AlojamientoDAO();
        portadaDAO = new PortadaDAO();
        this.list = new LinkedList<>();
        this.list = alojamientoDAO.readAll();
        this.index = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnRight) {
            this.moveRight();
        } else if (e.getSource() == this.vista.btnLeft) {
            this.moveLeft();
        } else if (e.getSource() == this.vista.btnAgregar) {

        }
    }

    private void moveLeft() {
        if (index > 0) {
            index--;
        } else {
            index = list.size() - 1;
        }
        this.completarInformacionAlojamiento();
    }

    private void moveRight() {
        if (index < list.size() - 1) {
            index++;
        } else {
            index = 0;
        }
        this.completarInformacionAlojamiento();
    }

    private void completarInformacionAlojamiento() {
        AlojamientoDTO alojamientoDTO = list.get(index);
        this.vista.txtIdAlojamiento.setText(String.valueOf(alojamientoDTO.getIdAlojamiento()));
        this.vista.txtCostoAlojamiento.setText(String.valueOf(alojamientoDTO.getCostoAlojamiento()));
        this.vista.txtIdHotel.setText(String.valueOf(alojamientoDTO.getIdHotel()));
        this.vista.txtNumeroHabitaciones.setText(String.valueOf(alojamientoDTO.getNumeroHabitaciones()));
        this.vista.txtNumeroPersonas.setText(String.valueOf(alojamientoDTO.getNumeroPersonas()));
        PortadaDTO portadaDTO = portadaDAO.read(alojamientoDTO.getPortadoPrincipal());
        RSScaleLabel.setScaleLabel(this.vista.lblPortadoPrincipal, "imagenes/alojamientos/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(alojamientoDTO.getPortadaSecundaria());
        RSScaleLabel.setScaleLabel(this.vista.lblPortadaSecundaria, "imagenes/alojamientos/" + portadaDTO.getPath());
    }

}
