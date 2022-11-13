package controllers;

import dao.MiPaqueteDAO;
import views.*;
import interfaces.*;
import process.*;
import dto.*;
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
        this.vista.btnCrear.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnCrear) {
            crearPaquetePerzonalizado();
        }
    }

    private void crearPaquetePerzonalizado(){
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        miPaqueteDTO = PPaquetePersonalizado.instanciar(this.vista);
        miPaqueteDAO.createPaquete(miPaqueteDTO);
    }
    
}
