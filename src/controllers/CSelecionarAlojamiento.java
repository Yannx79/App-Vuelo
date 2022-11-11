package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import dao.*;
import dto.*;
import interfaces.*;
import java.util.LinkedList;
import java.util.List;

public class CSelecionarAlojamiento implements ActionListener, ObligacionControlador {

    private VSelecionarAlojamiento vista;
    private List<AlojamientoDTO> list;
    private AlojamientoDAO alojamientoDAO;
    private int index;

    public CSelecionarAlojamiento(VSelecionarAlojamiento f) {
        this.vista = f;
        this.construirVista();
        this.agregarTodosListeners();
        this.inicializarObjetos();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
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
        this.list = new LinkedList<>();
        this.list = alojamientoDAO.readAll();
        this.index = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnRight) {
            this.moveRight();
        } else if (e.getSource() == this.vista.btnLeft) {

        } else if (e.getSource() == this.vista.btnAgregar) {

        }
    }

    private void moveLeft() {
//        if (index > 0) {
//            index--;
//        } else {
//            index = list.size() - 1;
//        }
        this.index = (index > 0) ? index-- : list.size() - 1;
        this.llenarCasillas();
    }

    private void moveRight() {
//        if (index < list.size() - 1) {
//            index++;
//        } else {
//            index = 0;
//        }
        this.index = (index < list.size() - 1) ? index++ : 0;
        this.llenarCasillas();
    }

    private void llenarCasillas() {
        AlojamientoDTO adto = list.get(index);
        this.vista.txtIdAlojamiento.setText(String.valueOf(adto.getIdAlojamiento()));
        this.vista.txtCostoAlojamiento.setText(String.valueOf(adto.getCostoAlojamiento()));
        this.vista.txtIdHotel.setText(String.valueOf(adto.getIdHotel()));
        this.vista.txtNumeroHabitaciones.setText(String.valueOf(adto.getNumeroHabitaciones()));
        this.vista.txtNumeroPersonas.setText(String.valueOf(adto.getNumeroPersonas()));
    }

}
