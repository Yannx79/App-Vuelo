package controllers;

import formato.*;
import interfaces.ObligacionControlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import dto.*;
import java.util.List;
import dao.*;
import java.awt.Image;
import process.*;
import java.util.LinkedList;
import rsscalelabel.RSScaleLabel;

public class CVerPaquetes extends ObligacionControlador implements ActionListener {

    private VVerPaquetes vista;
    //dao
    private PaqueteDAO paqueteDAO;
    private MiPaqueteDAO miPaqueteDAO;
    private PortadaDAO portadaDAO;
    private AlojamientoDAO alojamientoDAO;
    private ActividadDAO actividadDAO;
    private VueloDAO vueloDAO;
    //dto
    private PaqueteDTO paqueteDTO;
    private MiPaqueteDTO miPaqueteDTO;
    //otros
    private List<PaqueteDTO> listPaquetes;
    private int index;

    public CVerPaquetes(VVerPaquetes f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("VER PAQUETES");
        this.vista.lblTitulo.setText("Ver Paquetes");
        this.vista.lblCantidadRegistros.setText("Cantidad de Paquetes: " + listPaquetes.size());
        this.vista.lblEmail.setText("Usuario: " + CMenu.usuario.getEmail());
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnLeft.addActionListener(this);
        this.vista.btnRight.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        paqueteDAO = new PaqueteDAO();
        miPaqueteDAO = new MiPaqueteDAO();
        portadaDAO = new PortadaDAO();
        alojamientoDAO = new AlojamientoDAO();
        actividadDAO = new ActividadDAO();
        vueloDAO = new VueloDAO();

        paqueteDTO = new PaqueteDTO();
        miPaqueteDTO = new MiPaqueteDTO();

        listPaquetes = new LinkedList<>();
        listPaquetes = paqueteDAO.readAll();
        index = 0;
        
        this.vista.lblActividad.setSize(288, 300);
        this.vista.lblVuelo.setSize(288, 300);
        this.vista.lblPaquete.setSize(288, 300);
        this.vista.lblAlojamiento.setSize(288, 300);
        completarInformacionPaquete();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnRight) {
            this.moveRight();
        } else if (e.getSource() == this.vista.btnLeft) {
            this.moveLeft();
        } else if (e.getSource() == this.vista.btnAgregar) {
            this.agregarPaquete();
        }
    }

    private void agregarPaquete() {
        miPaqueteDTO = Parse.parsePaqueteToMiPaquete(paqueteDTO);
        miPaqueteDTO.setIdUsuario(CMenu.usuario.getIdUsuario());
        miPaqueteDAO.create(miPaqueteDTO);
    }

    private void moveLeft() {
        if (index > 0) {
            index--;
        } else {
            index = listPaquetes.size() - 1;
        }
        System.out.println(vista.lblActividad.getSize());
        completarInformacionPaquete();
    }

    private void moveRight() {
        if (index < listPaquetes.size() - 1) {
            index++;
        } else {
            index = 0;
        }
        completarInformacionPaquete();
    }

    private void completarInformacionPaquete() {
        //informacion basica
        this.vista.lblNombrePaquete.setText("Nombre Paquete: " + listPaquetes.get(index).getNombrePaquete());
        //establecer img portada
        paqueteDTO = listPaquetes.get(index);
        PortadaDTO portadaDTO = portadaDAO.read(paqueteDTO.getPortadaPrincipal());
        Imagen.ajustar(this.vista.lblPaquete, "imagenes/paquetes/" + portadaDTO.getPath());
        this.vista.txaDatosPaquete.setText(paqueteDTO.toString());
        //establecer img alojamiento
        AlojamientoDTO alojamientoDTO = alojamientoDAO.read(paqueteDTO.getIdAlojamiento());
        portadaDTO = portadaDAO.read(alojamientoDTO.getPortadoPrincipal());
        Imagen.ajustar(this.vista.lblAlojamiento, "imagenes/alojamientos/" + portadaDTO.getPath());
        this.vista.txaDatosAlojamiento.setText(alojamientoDTO.toString());
        //establecer img vuelo
        VueloDTO vueloDTO = vueloDAO.read(paqueteDTO.getIdVuelo());
        portadaDTO = portadaDAO.read(vueloDTO.getPortadaPrincipal());
        Imagen.ajustar(this.vista.lblVuelo, "imagenes/vuelos/" + portadaDTO.getPath());
        this.vista.txaDatosVuelo.setText(vueloDTO.toString());
        //establecer img actividad
        ActividadDTO actividadDTO = actividadDAO.read(paqueteDTO.getIdActividad());
        portadaDTO = portadaDAO.read(actividadDTO.getPortadoPrincipal());
        Imagen.ajustar(this.vista.lblActividad, "imagenes/actividades/" + portadaDTO.getPath());
        this.vista.txaDatosActividad.setText(actividadDTO.toString());
    }

}
