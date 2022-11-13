package controllers;

import dao.ClienteDAO;
import dto.ClienteDTO;
import views.*;
import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import formato.Encriptar;

public class CLogin extends ObligacionControlador implements ActionListener {

    private VLogin vista;
    private ClienteDAO clienteDAO;
    private List<ClienteDTO> list;

    public CLogin(VLogin f) {
        this.vista = f;
        super.constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("Login");
        this.vista.rbCliente.setSelected(true);
        habilitarOperacionesCliente(false);
        habilitarOperacionesEmpleado(false);
        habilitarOperacionesSesion(false);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnLogin.addActionListener(this);
        this.vista.txtPassword.addActionListener(this);
        this.vista.txtEmail.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        clienteDAO = new ClienteDAO();
        list = clienteDAO.readAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnLogin) {
            this.loguear();
            this.habilitarOperaciones();
        }
        if (e.getSource() == this.vista.btnRegistrar) {
            this.registrar();
        }
    }

    private void registrar() {
        this.vista.lblTitulo.setText("Registrar");
        this.vista.setTitle("Registrar");
    }

    private void loguear() {
        String email = this.vista.txtEmail.getText();
        String password = Encriptar.toMD5(String.valueOf(this.vista.txtPassword.getPassword()));
        boolean estaLogueado = false;
        for (ClienteDTO c : list) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                CMenu.usuario = c;
                estaLogueado = true;
                break;
            }
        }
        if (estaLogueado) {
            this.vista.dispose();
        } else {
            this.vista.txtEmail.setText("");
            this.vista.txtPassword.setText("");
        }

    }

    private void habilitarOperaciones(){
        if (this.vista.rbCliente.isSelected()) {
            habilitarOperacionesCliente(true);
        } else if (this.vista.rbEmpleado.isSelected()) {
            habilitarOperacionesEmpleado(true);
        } else if (this.vista.rbAdministrador.isSelected()) {
            habilitarOperacionesCliente(true);
            habilitarOperacionesEmpleado(true);
        }
        habilitarOperacionesSesion(true);
    }
    
    private void habilitarOperacionesSesion(boolean estado) {
        CMenu.vista.miLogin.setEnabled(!estado);
        CMenu.vista.miLogout.setEnabled(estado);
    }

    private void habilitarOperacionesEmpleado(boolean estado) {
        CMenu.vista.miCrearActividad.setEnabled(estado);
        CMenu.vista.miCrearAlojamiento.setEnabled(estado);
        CMenu.vista.miCrearPaquete.setEnabled(estado);
        CMenu.vista.miCrearVuelo.setEnabled(estado);
    }

    private void habilitarOperacionesCliente(boolean estado) {
        CMenu.vista.miPaquetesPersonalizados.setEnabled(estado);
        CMenu.vista.miSeleccionarActividad.setEnabled(estado);
        CMenu.vista.miSeleccionarAlojamiento.setEnabled(estado);
        CMenu.vista.miSeleccionarVuelo.setEnabled(estado);
        CMenu.vista.miVerMisPaquetes.setEnabled(estado);
        CMenu.vista.miVerPaquetes.setEnabled(estado);
    }

}
