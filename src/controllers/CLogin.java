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
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnLogin.addActionListener(this);
        this.vista.txtPassword.addActionListener(this);
        this.vista.txtEmail.addActionListener(this);
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
        }
    }

    private void loguear() {
        String email = this.vista.txtEmail.getText();
        String password = Encriptar.toMD5(this.vista.txtPassword.getText());
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
