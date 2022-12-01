package controllers;

import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.*;
import dto.*;
import formato.Desktop;
import formato.Imagen;
import formato.Mensaje;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import process.PMisPaquetes;
import views.*;

public class CMisPaquetes extends ObligacionControlador implements ActionListener {

    public static VMisPaquetes vista;
    private MiPaqueteDAO miPaqueteDAO;
    private PaqueteDAO paqueteDAO;
    private AlojamientoDAO alojamientoDAO;
    private ActividadDAO actividadDAO;
    private VueloDAO vueloDAO;
    private HotelDAO hotelDAO;
    private AvionDAO avionDAO;
    private CategoriaDAO categoriaDAO;

    public CMisPaquetes(VMisPaquetes f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("MIS PAQUETES");
        this.vista.lblActualizarActividad.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.lblActualizarAlojamiento.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.lblActualizarVuelo.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.lblEliminar.setIcon(new ImageIcon("imagenes/iconos/delete2.png"));
        this.vista.lblPagar.setIcon(new ImageIcon("imagenes/iconos/pay.png"));
        this.vista.lblVerDetalle.setIcon(new ImageIcon("imagenes/iconos/detail2.png"));
        this.vista.lblRepresentacion.setSize(60, 60);
        Imagen.ajustar(this.vista.lblRepresentacion, "imagenes/iconos/package.png");
        PMisPaquetes.construirTabla(this.vista);
        PMisPaquetes.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnPagar.addActionListener(this);
        this.vista.btnVerDetalle.addActionListener(this);
        this.vista.btnActualizarActividad.addActionListener(this);
        this.vista.btnActualizarVuelo.addActionListener(this);
        this.vista.btnActualizarAlojamiento.addActionListener(this);
        this.vista.rbMostrarMuyResumido.addActionListener(this);
        this.vista.rbMostrarResumen.addActionListener(this);
        this.vista.rbMostrarTodo.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        miPaqueteDAO = new MiPaqueteDAO();
        alojamientoDAO = new AlojamientoDAO();
        actividadDAO = new ActividadDAO();
        vueloDAO = new VueloDAO();
        hotelDAO = new HotelDAO();
        avionDAO = new AvionDAO();
        categoriaDAO = new CategoriaDAO();
        paqueteDAO = new PaqueteDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnEliminar) {
            this.eliminarPaquete();
        } else if (e.getSource() == this.vista.btnActualizarActividad) {
            this.actualizarActividad();
        } else if (e.getSource() == this.vista.btnActualizarVuelo) {
            this.actualizarVuelo();
        } else if (e.getSource() == this.vista.btnActualizarAlojamiento) {
            this.actualizarAlojamiento();
        } else if (e.getSource() == this.vista.btnVerDetalle) {
            this.verDetalle();
        } else if (e.getSource() == this.vista.btnPagar) {
            Mensaje.mostrar(CMenu.usuario.getNombres() + " pagaste exitosamente");
        } else if (e.getSource() == this.vista.rbMostrarTodo) {
            PMisPaquetes.completarTablaTotal(vista.tblDatos);
        } else if (e.getSource() == this.vista.rbMostrarResumen) {
            PMisPaquetes.completarTablaConDependencias(vista.tblDatos);
        } else if (e.getSource() == this.vista.rbMostrarMuyResumido) {
            PMisPaquetes.completarResumenTabla(vista.tblDatos);
        }
    }

    private void verDetalle() {
        int indexTable = this.vista.tblDatos.getSelectedRow();
        if (indexTable != -1) {
            int key = Integer.parseInt(this.vista.tblDatos.getValueAt(indexTable, 0).toString());

            MiPaqueteDTO miPaqueteDTO = miPaqueteDAO.read(key);
            AlojamientoDTO alojamientoDTO = alojamientoDAO.read(miPaqueteDTO.getIdAlojamiento());
            ActividadDTO actividadDTO = actividadDAO.read(miPaqueteDTO.getIdActividad());
            VueloDTO vueloDTO = vueloDAO.read(miPaqueteDTO.getIdVuelo());

            String mensaje = miPaqueteDTO + "\n" + alojamientoDTO + "\n"  + actividadDTO + "\n" + vueloDTO;
            
            Mensaje.mostrar(mensaje);
        }
    }

    private void actualizarAlojamiento() {
        int indexTable = this.vista.tblDatos.getSelectedRow();
        if (indexTable != -1) {
            int key = Integer.parseInt(this.vista.tblDatos.getValueAt(indexTable, 0).toString());

            VSelecionarAlojamiento vsa = new VSelecionarAlojamiento();
            CSelecionarAlojamiento csa = new CSelecionarAlojamiento(vsa);
            Desktop.agregarAlDesktop(CMenu.vista.desktopMenu, vsa);
            vista.toBack();

            MiPaqueteDTO miPaqueteDTO = miPaqueteDAO.read(key);

            vsa.cbxMisPaquetes.removeAllItems();
            vsa.cbxMisPaquetes.addItem(miPaqueteDTO.getIdPaquete() + " - " + miPaqueteDTO.getNombrePaquete());
            vsa.cbxMisPaquetes.setEnabled(false);
        }
    }

    private void actualizarActividad() {
        int indexTable = this.vista.tblDatos.getSelectedRow();
        if (indexTable != -1) {
            int key = Integer.parseInt(this.vista.tblDatos.getValueAt(indexTable, 0).toString());

            VSelecionarActividad vsa = new VSelecionarActividad();
            CSelecionarActividad csa = new CSelecionarActividad(vsa);
            Desktop.agregarAlDesktop(CMenu.vista.desktopMenu, vsa);
            vista.toBack();

            MiPaqueteDTO miPaqueteDTO = miPaqueteDAO.read(key);
            System.out.println(miPaqueteDTO.toString());
            vsa.cbxMisPaquetes.removeAllItems();
            vsa.cbxMisPaquetes.addItem(miPaqueteDTO.getIdPaquete() + " - " + miPaqueteDTO.getNombrePaquete());
            vsa.cbxMisPaquetes.setEnabled(false);
        }
    }

    private void actualizarVuelo() {
        int indexTable = this.vista.tblDatos.getSelectedRow();
        if (indexTable != -1) {
            int key = Integer.parseInt(this.vista.tblDatos.getValueAt(indexTable, 0).toString());

            VSelecionarVuelo vsv = new VSelecionarVuelo();
            CSelecionarVuelo csv = new CSelecionarVuelo(vsv);
            Desktop.agregarAlDesktop(CMenu.vista.desktopMenu, vsv);
            vista.toBack();

            MiPaqueteDTO miPaqueteDTO = miPaqueteDAO.read(key);

            vsv.cbxMisPaquetes.removeAllItems();
            vsv.cbxMisPaquetes.addItem(miPaqueteDTO.getIdPaquete() + " - " + miPaqueteDTO.getNombrePaquete());
            vsv.cbxMisPaquetes.setEnabled(false);
        }
    }

    private void eliminarPaquete() {
        int indexTable = this.vista.tblDatos.getSelectedRow();
        if (indexTable != -1) {
            int confirmacion = Mensaje.confirmacion("¿Desea eliminar el paquete?", "Eliminar");
            if (confirmacion == 0) {
                int key = Integer.parseInt(this.vista.tblDatos.getValueAt(indexTable, 0).toString());
                miPaqueteDAO.delete(key);
                PMisPaquetes.construirTabla(this.vista);
            }
        } else {
            System.out.println("Aca va una entrada de texto para buscarlo");
        }

    }

}
