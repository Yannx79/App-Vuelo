package controllers;

import dao.*;
import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import process.*;
import dto.*;
import formato.Imagen;
import java.util.LinkedList;
import java.util.List;

public class CSelecionarActividad extends ObligacionControlador implements ActionListener {

    private VSelecionarActividad vista;
    private List<ActividadDTO> list;

    private ActividadDAO actividadDAO;
    private PortadaDAO portadaDAO;

    private int index = 0;

    public CSelecionarActividad(VSelecionarActividad f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("SELECIONAR ACTIVIDAD");
        this.vista.lblTitulo.setText("Seleccionar Actividad");
        this.vista.lblCantidadRegistros.setText("Cantidad de alojamientos: " + list.size());
        this.vista.lblUsuario.setText("Usuario: " + CMenu.usuario.getEmail());
        PSelecionarActividad.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnLeft.addActionListener(this);
        this.vista.btnRight.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        actividadDAO = new ActividadDAO();
        portadaDAO = new PortadaDAO();
        this.list = new LinkedList<>();
        this.list = actividadDAO.readAll();
        this.index = 0;
        this.completarInformacionActividad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnAgregar) {
            this.agregarActividad();
        } else if (e.getSource() == this.vista.btnLeft) {
            this.moveLeft();
        } else if (e.getSource() == this.vista.btnRight) {
            this.moveRight();
        }
    }

    private void moveLeft() {
        if (index > 0) {
            index--;
        } else {
            index = list.size() - 1;
        }
        this.completarInformacionActividad();
    }

    private void moveRight() {
        if (index < list.size() - 1) {
            index++;
        } else {
            index = 0;
        }
        this.completarInformacionActividad();
    }
    
    private void agregarActividad(){
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        int idPaquete = Parse.getPK(this.vista.cbxMisPaquetes.getSelectedItem().toString());
        miPaqueteDTO.setIdPaquete(idPaquete);
        miPaqueteDTO.setIdActividad(list.get(index).getIdActividad());
        miPaqueteDAO.updateActividad(miPaqueteDTO);
        
    }
    
    private void completarInformacionActividad(){
        ActividadDTO actividadDTO = list.get(index);
        this.vista.lblNombreActividad.setText(actividadDTO.getNombreActividad());
        this.vista.txtIdActividad.setText(String.valueOf(actividadDTO.getIdActividad()));
        this.vista.txtCostoActividad.setText(String.valueOf(actividadDTO.getCostoActividad()));
        this.vista.txtDescripcion.setText(String.valueOf(actividadDTO.getDescripcion()));
        this.vista.txtIdCategoria.setText(String.valueOf(actividadDTO.getIdCategoria()));
        this.vista.txtNombreActividad.setText(String.valueOf(actividadDTO.getNombreActividad()));
        PortadaDTO portadaDTO = portadaDAO.read(actividadDTO.getPortadoPrincipal());
        Imagen.ajustar(this.vista.lblPortadoPrincipal, "imagenes/actividades/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(actividadDTO.getPortadaSecundaria());
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/actividades/" + portadaDTO.getPath());
    }
    
}
