package controllers;

import views.*;
import dao.*;
import dto.*;
import formato.Imagen;
import formato.Mensaje;
import interfaces.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import process.PMisPaquetes;
import process.PSelecionarVuelo;
import process.Parse;

public class CSelecionarVuelo extends ObligacionControlador implements ActionListener {

    private VSelecionarVuelo vista;
    private List<VueloDTO> list;

    private VueloDAO vueloDAO;
    private PortadaDAO portadaDAO;

    private int index;

    public CSelecionarVuelo(VSelecionarVuelo f) {
        this.vista = f;
        constructor();
    }

    @Override
    public void construirVista() {
        this.vista.setVisible(true);
        this.vista.setTitle("SELECCIONAR VUELOS");
        this.vista.lblTitulo.setText("Seleccionar Vuelos");
        this.vista.lblCantidadRegistros.setText(
                "Cantidad de vuelos: " + list.size());
        this.vista.lblUsuario.setText("Usuario: " + CMenu.usuario.getEmail());
        PSelecionarVuelo.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnLeft.addActionListener(this);
        this.vista.btnRight.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
        vueloDAO = new VueloDAO();
        portadaDAO = new PortadaDAO();
        this.list = new LinkedList<>();
        this.list = vueloDAO.readAll();
        this.index = 0;
        this.vista.lblPortadaSecundaria.setSize(510, 250);
        this.vista.lblPortadoPrincipal.setSize(510, 250);
        this.completarInformacionVuelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnRight) {
            this.moveRight();
        } else if (e.getSource() == this.vista.btnLeft) {
            this.moveLeft();
        } else if (e.getSource() == this.vista.btnAgregar) {
            this.agregarVuelo();
            PMisPaquetes.completarTablaConDependencias(CMisPaquetes.vista.tblDatos);
        }
    }

    private void moveLeft() {
        if (index > 0) {
            index--;
        } else {
            index = list.size() - 1;
        }
        this.completarInformacionVuelo();
    }

    private void moveRight() {
        if (index < list.size() - 1) {
            index++;
        } else {
            index = 0;
        }
        this.completarInformacionVuelo();
    }

    private void agregarVuelo() {
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        int idPaquete = Parse.getPK(this.vista.cbxMisPaquetes.getSelectedItem().toString());
        miPaqueteDTO.setIdPaquete(idPaquete);
        miPaqueteDTO.setIdVuelo(list.get(index).getIdVuelo());
        miPaqueteDAO.updateVuelo(miPaqueteDTO);
        Mensaje.mostrar("Accion ejecutada correctamente");
    }

    private void completarInformacionVuelo() {
        this.vista.lblNombreVuelo.setText("Id del vuelo: " + list.get(index).getIdVuelo());
        VueloDTO vueloDTO = list.get(index);
        this.vista.txtCostoVuelo.setText(String.valueOf(vueloDTO.getCostoVuelo()));
        this.vista.txtIdAvion.setText(String.valueOf(vueloDTO.getIdAvion()));
        this.vista.txtIdVuelo.setText(String.valueOf(vueloDTO.getIdVuelo()));
        this.vista.txtNombreVuelo.setText("Vuelo N° " + list.get(index).getIdVuelo() + "" + list.get(index).getIdAvion());
        this.vista.txtNumeroPasajeros.setText(String.valueOf(vueloDTO.getNumeroPasajeros()));
        PortadaDTO portadaDTO = portadaDAO.read(vueloDTO.getPortadaPrincipal());
        Imagen.ajustar(this.vista.lblPortadoPrincipal, "imagenes/vuelos/" + portadaDTO.getPath());
        portadaDTO = portadaDAO.read(vueloDTO.getPortadaSecundaria());
        Imagen.ajustar(this.vista.lblPortadaSecundaria, "imagenes/vuelos/" + portadaDTO.getPath());
    }

}
