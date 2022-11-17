package controllers;

import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.*;
import formato.Imagen;
import formato.Mensaje;
import javax.swing.ImageIcon;
import process.PMisPaquetes;
import views.*;

public class CMisPaquetes extends ObligacionControlador implements ActionListener {

    private VMisPaquetes vista;
    private MiPaqueteDAO miPaqueteDAO;

    public CMisPaquetes(VMisPaquetes f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("MIS PAQUETES");
        this.vista.btnSinAccion1.setVisible(false);
        this.vista.btnSinAccion2.setVisible(false);
        this.vista.lblActualizar.setIcon(new ImageIcon("imagenes/iconos/update.png"));
        this.vista.lblEliminar.setIcon(new ImageIcon("imagenes/iconos/delete2.png"));
        this.vista.lblPagar.setIcon(new ImageIcon("imagenes/iconos/pay.png"));
        this.vista.lblVerDetalle.setIcon(new ImageIcon("imagenes/iconos/detail2.png"));
        this.vista.lblRepresentacion.setSize(60,60);
        Imagen.ajustar(this.vista.lblRepresentacion, "imagenes/iconos/package.png");
        PMisPaquetes.construirForma(this.vista);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnPagar.addActionListener(this);
        this.vista.btnVerDetalle.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        miPaqueteDAO = new MiPaqueteDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnEliminar) {
            this.eliminarPaquete();
        } else if (e.getSource() == this.vista.btnActualizar) {
            /*
            muestra el alojamiento
            muestra el vuelo
            muestra la actividad
            */
        } else if (e.getSource() == this.vista.btnVerDetalle) {
            /*
            recuperar la data paquete
            recuperar la data alojamiento
                recuperar su subpaquete
            recuperar la data actividad
                recuperar subpaquete
            recuperar vuelo
                recuperar aviones
            */
            
        } else if (e.getSource() == this.vista.btnPagar) {
            Mensaje.mostrar(CMenu.usuario.getNombres() + " pagaste exitosamente");
        }

    }

    private void eliminarPaquete() {
        int indexTable = this.vista.tblDatos.getSelectedRow();
        if (indexTable != -1) {
            int key = Integer.parseInt(this.vista.tblDatos.getValueAt(indexTable, 0).toString());
            miPaqueteDAO.delete(key);
            PMisPaquetes.completarTabla(this.vista.tblDatos);
        } else {
            System.out.println("Aca va una entrada de texto");
        }
        
    }

}
