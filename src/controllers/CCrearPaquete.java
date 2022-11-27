package controllers;

import java.awt.event.ActionListener;
import interfaces.*;
import java.awt.event.ActionEvent;
import views.*;
import dao.*;
import dto.*;
import formato.Imagen;
import formato.Mensaje;
import java.util.List;
import javax.swing.ImageIcon;
import process.PCrearPaquete;
import process.Parse;

public class CCrearPaquete extends ObligacionControlador implements ActionListener {

    private VCrearPaquete vista;

    private AlojamientoDAO alojamientoDAO;
    private VueloDAO vueloDAO;
    private ActividadDAO actividadDAO;
    private HotelDAO hotelDAO;
    private AvionDAO avionDAO;
    private CategoriaDAO categoriaDAO;
    private PortadaDAO portadaDAO;
    private PaqueteDAO paqueteDAO;

    private List<AlojamientoDTO> listAlojamientos;
    private List<ActividadDTO> listActividades;
    private List<VueloDTO> listVuelos;
    private List<PaqueteDTO> listPaquetes;

    private Integer indexAlojamiento = 0;
    private Integer indexActividad = 0;
    private Integer indexVuelo = 0;
    
    private String codigoActualizar = "";

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
        this.vista.btnActualizar.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.btnConsultar.setIcon(new ImageIcon("imagenes/iconos/select.png"));
        this.vista.btnActualizar.setEnabled(false);
        vista.lblCantidadRegistros.setText("Cantidad de paquetes existentes: " + listPaquetes.size());
        this.vista.lblEmail.setText("Usuario: " + CMenu.usuario.getEmail());
        this.vista.lblNombreUsuario.setText("Nombre Usuario: " + CMenu.usuario.getNombres());
        this.mostrarInformacion();
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnCambiarActividad.addActionListener(this);
        this.vista.btnCambiarAlojamiento.addActionListener(this);
        this.vista.btnCambiarVuelo.addActionListener(this);
        this.vista.btnCrearPaquete.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnConsultar.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        PCrearPaquete.construirForma(vista);

        alojamientoDAO = new AlojamientoDAO();
        actividadDAO = new ActividadDAO();
        vueloDAO = new VueloDAO();
        portadaDAO = new PortadaDAO();
        paqueteDAO = new PaqueteDAO();
        avionDAO = new AvionDAO();
        hotelDAO = new HotelDAO();
        categoriaDAO = new CategoriaDAO();

        listActividades = actividadDAO.readAll();
        listAlojamientos = alojamientoDAO.readAll();
        listVuelos = vueloDAO.readAll();
        listPaquetes = paqueteDAO.readAll();

        this.vista.lblActividad.setSize(350, 300);
        this.vista.lblVuelo.setSize(350, 300);
        this.vista.lblAlojamiento.setSize(350, 300);
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
        } else if (e.getSource() == this.vista.btnConsultar) {
            this.consultar();
        } else if (e.getSource() == this.vista.btnActualizar) {
            this.actualizar();
        }
    }

    private void actualizar() {
        PaqueteDTO paqueteDTO = PCrearPaquete.instanciar(vista);
        paqueteDTO.setIdPaquete(Integer.parseInt(codigoActualizar));
        System.out.println(paqueteDTO);
        paqueteDTO.setIdActividad(listActividades.get(indexActividad).getIdActividad());
        paqueteDTO.setIdAlojamiento(listAlojamientos.get(indexAlojamiento).getIdAlojamiento());
        paqueteDTO.setIdVuelo(listVuelos.get(indexVuelo).getIdVuelo());
        paqueteDAO.update(paqueteDTO);
        System.out.println(paqueteDTO);
        this.vista.btnActualizar.setEnabled(false);
        PCrearPaquete.limpiar(vista);
        Mensaje.mostrar("Actualizado satisfactoriamente");
    }

    private void consultar() {
        codigoActualizar = Mensaje.capturar("¿Que paquete desea consultar?");
        PaqueteDTO paqueteDTO = paqueteDAO.read(codigoActualizar);
        AlojamientoDTO alojamientoDTO;
        ActividadDTO actividadDTO;
        VueloDTO vueloDTO;
        if (paqueteDTO.getNombrePaquete() == null) {
            Mensaje.mostrar("Codigo " + codigoActualizar + " no registrado en la db. Vuelva a intentar");
        } else {
            vista.txtNombrePaquete.setText(paqueteDTO.getNombrePaquete());
            vista.dcFechaPartida.setDate(Parse.formatearStringToFecha(paqueteDTO.getFechaSalida()));
            vista.dcFechaRegreso.setDate(Parse.formatearStringToFecha(paqueteDTO.getFechaRegreso()));
            alojamientoDTO = alojamientoDAO.read(paqueteDTO.getIdAlojamiento());
            actividadDTO = actividadDAO.read(paqueteDTO.getIdActividad());
            vueloDTO = vueloDAO.read(paqueteDTO.getIdVuelo());

            String mensajeActividad = "" + actividadDTO;
            this.vista.txaDatosActividad.setText(mensajeActividad);
            String mensajeAlojamiento = "" + alojamientoDTO + "\n" + hotelDAO.read(alojamientoDTO.getIdHotel());
            this.vista.txaDatosAlojamiento.setText(mensajeAlojamiento);
            String mensajeVuelo = "" + vueloDTO + "\n" + avionDAO.read(vueloDTO.getIdAvion());
            this.vista.txaDatosVuelo.setText(mensajeVuelo);
            this.mostrarImagen();
            this.vista.btnActualizar.setEnabled(true);
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
        ActividadDTO actividadDTO = listActividades.get(indexActividad);
        String mensajeActividad = "" + actividadDTO;
        this.vista.txaDatosActividad.setText(mensajeActividad);

        AlojamientoDTO alojamientoDTO = listAlojamientos.get(indexAlojamiento);
        String mensajeAlojamiento = "" + alojamientoDTO + "\n" + hotelDAO.read(alojamientoDTO.getIdHotel());
        this.vista.txaDatosAlojamiento.setText(mensajeAlojamiento);

        VueloDTO vueloDTO = listVuelos.get(indexVuelo);
        String mensajeVuelo = "" + vueloDTO + "\n" + avionDAO.read(vueloDTO.getIdAvion());
        this.vista.txaDatosVuelo.setText(mensajeVuelo);
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
