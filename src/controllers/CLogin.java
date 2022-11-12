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

public class CLogin implements ObligacionControlador, ActionListener {

    private VLogin vista;
    private ClienteDAO clienteDAO;
    private List<ClienteDTO> list;

    public CLogin(VLogin f) {
        this.vista = f;
        agregarTodosListeners();
        inicializarObjetos();
        construirVista();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("Login");
        this.vista.rbCliente.setSelected(true);
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
        } if (e.getSource() == this.vista.btnRegistrar) {
            this.registrar();
        }
    }

    private void registrar(){
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

}
