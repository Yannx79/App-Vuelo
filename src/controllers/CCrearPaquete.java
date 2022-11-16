package controllers;

import java.awt.event.ActionListener;
import interfaces.*;
import java.awt.event.ActionEvent;
import views.*;
import dao.*;
import dto.*;
import formato.Imagen;
import java.util.List;
import javax.swing.ImageIcon;
import process.PCrearPaquete;

public class CCrearPaquete extends ObligacionControlador implements ActionListener {

    private VCrearPaquete vista;

    private AlojamientoDAO alojamientoDAO;
    private VueloDAO vueloDAO;
    private ActividadDAO actividadDAO;
    private PortadaDAO portadaDAO;
    private PaqueteDAO paqueteDAO;
    
    private List<AlojamientoDTO> listAlojamientos;
    private List<ActividadDTO> listActividades;
    private List<VueloDTO> listVuelos;

    private Integer indexAlojamiento = 0;
    private Integer indexActividad = 0;
    private Integer indexVuelo = 0;

    public CCrearPaquete(VCrearPaquete f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("CREAR PAQUETE");
        this.vista.lblTitulo.setText("Crear Paquete");
        this.vista.btnCambiarAlojamiento.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.btnCambiarActividad.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.btnCambiarVuelo.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.btnCrearPaquete.setIcon(new ImageIcon("imagenes/iconos/create3.png"));
        this.mostrarInformacion();
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnCambiarActividad.addActionListener(this);
        this.vista.btnCambiarAlojamiento.addActionListener(this);
        this.vista.btnCambiarVuelo.addActionListener(this);
        this.vista.btnCrearPaquete.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        PCrearPaquete.construirForma(vista);

        alojamientoDAO = new AlojamientoDAO();
        actividadDAO = new ActividadDAO();
        vueloDAO = new VueloDAO();
        portadaDAO = new PortadaDAO();
        paqueteDAO = new PaqueteDAO();

        listActividades = actividadDAO.readAll();
        listAlojamientos = alojamientoDAO.readAll();
        listVuelos = vueloDAO.readAll();

        this.vista.lblActividad.setSize(288, 300);
        this.vista.lblVuelo.setSize(288, 300);
        this.vista.lblAlojamiento.setSize(288, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCambiarActividad) {
            this.cambiar(listActividades);
        } else if (e.getSource() == this.vista.btnCambiarAlojamiento) {
            this.cambiar(listAlojamientos);
        } else if (e.getSource() == this.vista.btnCambiarVuelo) {
            this.cambiar(listVuelos);
        } else if (e.getSource() == this.vista.btnCrearPaquete) {
            this.crearPaquete();
        }
    }

    private void crearPaquete() {
        PaqueteDTO paqueteDTO = PCrearPaquete.instanciar(vista);
        paqueteDTO.setIdActividad(listActividades.get(indexActividad).getIdActividad());
        paqueteDTO.setIdAlojamiento(listAlojamientos.get(indexAlojamiento).getIdAlojamiento());
        paqueteDTO.setIdVuelo(listVuelos.get(indexVuelo).getIdAvion());
        paqueteDAO.create(paqueteDTO);
    }

    private void cambiar(List list) {
        if (list.get(0) instanceof VueloDTO) {
            if (indexVuelo < list.size() - 1) {
                indexVuelo++;
            } else {
                indexVuelo = 0;
            }
        } else if (list.get(0) instanceof ActividadDTO) {
            if (indexActividad < list.size() - 1) {
                indexActividad++;
            } else {
                indexActividad = 0;
            }
        } else if (list.get(0) instanceof AlojamientoDTO) {
            if (indexAlojamiento < list.size() - 1) {
                indexAlojamiento++;
            } else {
                indexAlojamiento = 0;
            }
        }
        mostrarInformacion();
    }

    private void mostrarInformacion() {
        this.vista.txaDatosActividad.setText(listActividades.get(indexActividad).toString());
        this.vista.txaDatosAlojamiento.setText(listAlojamientos.get(indexAlojamiento).toString());
        this.vista.txaDatosVuelo.setText(listVuelos.get(indexVuelo).toString());
        this.mostrarImagen();
    }

    private void mostrarImagen() {
        //establecer img alojamiento
        PortadaDTO portadaDTO = portadaDAO.read(listAlojamientos.get(indexAlojamiento).getPortadoPrincipal());
        Imagen.ajustar(this.vista.lblAlojamiento, "imagenes/alojamientos/" + portadaDTO.getPath());
        //establecer img vuelo
        portadaDTO = portadaDAO.read(listVuelos.get(indexVuelo).getPortadaPrincipal());
        Imagen.ajustar(this.vista.lblVuelo, "imagenes/vuelos/" + portadaDTO.getPath());
        //establecer img actividad
        portadaDTO = portadaDAO.read(listActividades.get(indexActividad).getPortadoPrincipal());
        Imagen.ajustar(this.vista.lblActividad, "imagenes/actividades/" + portadaDTO.getPath());
    }

}
