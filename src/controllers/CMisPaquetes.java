package controllers;

import interfaces.*;
import views.*;

public class CMisPaquetes implements ObligacionControlador{

    private VMisPaquetes vista;
    
    public CMisPaquetes(VMisPaquetes f){
        this.vista = f;
        agregarTodosListeners();
        inicializarObjetos();
        construirVista();
    }
    
    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("MIS PAQUETES");
    }

    @Override
    public void agregarTodosListeners() {
    }

    @Override
    public void inicializarObjetos() {
    }

}
