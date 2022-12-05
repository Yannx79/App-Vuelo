package controllers;

import interfaces.ObligacionControlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import process.PListar;
import views.*;

public class CListar extends ObligacionControlador implements ActionListener {

    private VListar vista;

    public CListar(VListar vista) {
        this.vista = vista;
        super.constructor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.rbResumen
                || e.getSource() == vista.rbTodaInformacion
                || e.getSource() == vista.rbActividades
                || e.getSource() == vista.rbAlojamiento
                || e.getSource() == vista.rbAviones
                || e.getSource() == vista.rbHoteles
                || e.getSource() == vista.rbPaquetes
                || e.getSource() == vista.rbUsuarios
                || e.getSource() == vista.rbVuelos) {
            PListar.mostrarInformacion(vista);
        }
    }

    @Override
    public void construirVista() {
        PListar.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
        vista.rbActividades.addActionListener(this);
        vista.rbAlojamiento.addActionListener(this);
        vista.rbAviones.addActionListener(this);
        vista.rbHoteles.addActionListener(this);
        vista.rbPaquetes.addActionListener(this);
        vista.rbResumen.addActionListener(this);
        vista.rbTodaInformacion.addActionListener(this);
        vista.rbUsuarios.addActionListener(this);
        vista.rbVuelos.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
    }

}
