package controllers;

import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.*;
import dto.*;
import views.*;

public class CMisPaquetes extends ObligacionControlador implements ActionListener{

    private VMisPaquetes vista;
    private MiPaqueteDAO miPaqueteDAO;
    
    public CMisPaquetes(VMisPaquetes f){
        this.vista = f;
        constructor();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void completarTabla(){
        
    }
    
}
