package controllers;

import views.*;
import dao.*;
import dto.*;
import formato.Imagen;
import formato.ManejadorTablas;
import process.*;
import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CCrearActividad extends ObligacionControlador implements ActionListener {

    private VCrearActividad vista;

    private ActividadDAO actividadDAO;
    private CategoriaDAO categoriaDAO;
    private PortadaDAO portadaDAO;

    public CCrearActividad(VCrearActividad f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("CREAR ACTIVIDAD");
        this.vista.lblPortadaPrincipal.setSize(310, 110);
        this.vista.lblPortadaSecundaria.setSize(310, 110);
        this.cambiarImagen();
        this.generarTabla();
        this.completarInformacionCategoria();
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnCrear.addActionListener(this);
        this.vista.cbxIdCategoria.addActionListener(this);
        this.vista.cbxPortadaPrincipal.addActionListener(this);
        this.vista.cbxPortadaSecundaria.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        PCrearActividad.construirForma(vista);
        actividadDAO = new ActividadDAO();
        categoriaDAO = new CategoriaDAO();
        portadaDAO = new PortadaDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCrear) {
            ActividadDTO actividadDTO = PCrearActividad.instanciar(vista);
            actividadDAO.create(actividadDTO);
            this.generarTabla();
        } else if (e.getSource() == this.vista.cbxIdCategoria) {
            this.completarInformacionCategoria();
        } else if (e.getSource() == this.vista.cbxPortadaPrincipal) {
            this.cambiarImagen();
        } else if (e.getSource() == this.vista.cbxPortadaSecundaria) {
            this.cambiarImagen();
        }
    }

    private void completarInformacionCategoria() {
        CategoriaDTO categoriaDTO = categoriaDAO.read(Parse.getPK(vista.cbxIdCategoria.getSelectedItem().toString()));
        this.vista.txaDatosExtra.setText(categoriaDTO.toString());
    }

    private void cambiarImagen() {
        PortadaDTO portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaPrincipal.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaPrincipal, "imagenes/actividades/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(Parse.getPK(vista.cbxPortadaSecundaria.getSelectedItem().toString()));
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/actividades/" + portadaDTO.getPath());
    }

    private void generarTabla() {
        String header[] = {"ID ACTIVIDAD", "NOMBRE ACTIVIDAD", "DESCRIPCION",
            "ID CATEGORIA", "COSTO ACTIVIDAD", "ID PORTADA PRINCIPAL",
            "ID PORTADA PRINCIPAL"};
        PCrearActividad.completarTabla(this.vista.tblDatos, header, actividadDAO.readAll());
        ManejadorTablas.centrarTodo(vista.tblDatos);
    }

}
