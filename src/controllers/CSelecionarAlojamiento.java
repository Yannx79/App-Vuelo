package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import dao.*;
import dto.*;
import formato.*;
import process.*;
import interfaces.*;
import java.util.LinkedList;
import java.util.List;
import process.PSelecionarAlojamiento;

public class CSelecionarAlojamiento extends ObligacionControlador implements ActionListener {

    private VSelecionarAlojamiento vista;
    private List<AlojamientoDTO> list;

    private AlojamientoDAO alojamientoDAO;
    private PortadaDAO portadaDAO;
    private HotelDAO hotelDAO;

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
        this.vista.lblUsuario.setText("Usuario: " + CMenu.usuario.getEmail());
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
        this.vista.lblPortadaPrincipal.setSize(510, 250);
        this.vista.lblPortadaSecundaria.setSize(510, 250);
        alojamientoDAO = new AlojamientoDAO();
        portadaDAO = new PortadaDAO();
        hotelDAO = new HotelDAO();
        this.list = new LinkedList<>();
        this.list = alojamientoDAO.readAll();
        this.index = 0;
        this.vista.lblPortadaPrincipal.setSize(510, 250);
        this.vista.lblPortadaSecundaria.setSize(510, 250);
        this.completarInformacionAlojamiento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnRight) {
            this.moveRight();
        } else if (e.getSource() == this.vista.btnLeft) {
            this.moveLeft();
        } else if (e.getSource() == this.vista.btnAgregar) {
            this.agregarAlojamiento();
            PMisPaquetes.completarTablaConDependencias(CMisPaquetes.vista.tblDatos);
        }
    }

    private void agregarAlojamiento() {
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        int idPaquete = Parse.getPK(this.vista.cbxMisPaquetes.getSelectedItem().toString());
        miPaqueteDTO.setIdPaquete(idPaquete);
        miPaqueteDTO.setIdAlojamiento(list.get(index).getIdAlojamiento());
        miPaqueteDAO.updateAlojamiento(miPaqueteDTO);
        Mensaje.mostrar("Accion ejecutada correctamente");
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
        this.vista.lblNombreAlojamiento.setText("Id del alojamiento: " + list.get(index).getIdAlojamiento());
        AlojamientoDTO alojamientoDTO = list.get(index);
        this.vista.txtIdAlojamiento.setText(String.valueOf(alojamientoDTO.getIdAlojamiento()));
        this.vista.txtCostoAlojamiento.setText(String.valueOf(alojamientoDTO.getCostoAlojamiento()));
        this.vista.txtIdHotel.setText(String.valueOf(alojamientoDTO.getIdHotel()));
        this.vista.txtNumeroHabitaciones.setText(String.valueOf(alojamientoDTO.getNumeroHabitaciones()));
        this.vista.txtNumeroPersonas.setText(String.valueOf(alojamientoDTO.getNumeroPersonas()));
        PortadaDTO portadaDTO = portadaDAO.read(alojamientoDTO.getPortadoPrincipal());
        Imagen.ajustar(this.vista.lblPortadaPrincipal, "imagenes/alojamientos/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(alojamientoDTO.getPortadaSecundaria());
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/alojamientos/" + portadaDTO.getPath());
        HotelDTO hotelDTO = hotelDAO.read(alojamientoDTO.getIdHotel());
        System.out.println(hotelDTO);
        if (hotelDTO.getIdHotel()== 0 || hotelDTO.getNombreHotel().isBlank()) {
            this.vista.txaDatosExtra.setText("Datos del hotel no registrados aun");
        } else {
            this.vista.txaDatosExtra.setText(hotelDTO.toString());
        }
    }

}
