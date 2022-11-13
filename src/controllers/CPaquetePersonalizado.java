package controllers;

import views.*;
import interfaces.*;
import process.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CPaquetePersonalizado extends ObligacionControlador implements ActionListener{

    private VPaquetePersonalizado vista;
    
    public CPaquetePersonalizado(VPaquetePersonalizado f){
        this.vista = f;
        super.constructor();
    }
    
    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("Crear un Paquete Personalizado");
        PPaquetePersonalizado.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
    }

    @Override
    public void inicializarObjetos() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
