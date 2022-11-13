package controllers;

import dto.ClienteDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
//import models.*;
import interfaces.*;
import formato.Desktop;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import views.*;

public class CMenu extends ObligacionControlador implements ActionListener, WindowListener {
    
    private VMenu vista;
    public static ClienteDTO usuario;
    
    public CMenu(VMenu vmenu) {
        this.vista = vmenu;
        super.constructor();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.miLogout) {
            
        } else if (e.getSource() == this.vista.miLogin) {
            
        } else if (e.getSource() == this.vista.miVerMisPaquetes) {
            VMisPaquetes vmp = new VMisPaquetes();
            CMisPaquetes cmp = new CMisPaquetes(vmp);
            Desktop.agregarAlDesktop(this.vista.desktopMenu, vmp);
        } else if (e.getSource() == this.vista.miVerPaquetes) {
            VVerPaquetes vvp = new VVerPaquetes();
            CVerPaquetes cvp = new CVerPaquetes(vvp);
            Desktop.agregarAlDesktop(this.vista.desktopMenu, vvp);
        } else if (e.getSource() == this.vista.miPaquetesPersonalizados) {
            VPaquetePersonalizado vpp = new VPaquetePersonalizado();
            CPaquetePersonalizado cpp = new CPaquetePersonalizado(vpp);
            Desktop.agregarAlDesktop(this.vista.desktopMenu, vpp);
        } else if (e.getSource() == this.vista.miSeleccionarAlojamiento) {
            VSelecionarAlojamiento vsa = new VSelecionarAlojamiento();
            CSelecionarAlojamiento csa = new CSelecionarAlojamiento(vsa);
            Desktop.agregarAlDesktop(this.vista.desktopMenu, vsa);
        } else if (e.getSource() == this.vista.miSeleccionarVuelo) {
            
        } else if (e.getSource() == this.vista.miSeleccionarActividad) {
            
        } else if (e.getSource() == this.vista.miCrearPaquete) {
            
        } else if (e.getSource() == this.vista.miCrearAlojamiento) {
            
        } else if (e.getSource() == this.vista.miCrearVuelo) {
            
        } else if (e.getSource() == this.vista.miCrearActividad) {
            
        }
    }
    
    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("App de venta de paquetes de viajes");
        this.vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    @Override
    public void inicializarObjetos() {
        usuario = new ClienteDTO();
    }
    
    @Override
    public void agregarTodosListeners() {
        this.vista.addWindowListener(this);
        //acciones del empleado, cliente, administrador
        this.vista.miLogout.addActionListener(this);
        this.vista.miLogin.addActionListener(this);
        //acciones del cliente
        this.vista.miVerMisPaquetes.addActionListener(this);
        this.vista.miVerPaquetes.addActionListener(this);
        this.vista.miPaquetesPersonalizados.addActionListener(this);
        this.vista.miSeleccionarAlojamiento.addActionListener(this);
        this.vista.miSeleccionarVuelo.addActionListener(this);
        this.vista.miSeleccionarActividad.addActionListener(this);
        //acciones del empleado
        this.vista.miCrearPaquete.addActionListener(this);
        this.vista.miCrearAlojamiento.addActionListener(this);
        this.vista.miCrearVuelo.addActionListener(this);
        this.vista.miCrearActividad.addActionListener(this);
    }

//    private void setAllEnable() {
//        //encontra el tipo de instancia
//    }
    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource() == this.vista) {
            VLogin vLogin = new VLogin();
            CLogin cLogin = new CLogin(vLogin);
            Desktop.agregarAlDesktop(this.vista.desktopMenu, vLogin);
        }
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        
    }
    
    @Override
    public void windowClosed(WindowEvent e) {
    }
    
    @Override
    public void windowIconified(WindowEvent e) {
    }
    
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    
    @Override
    public void windowActivated(WindowEvent e) {
    }
    
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
