package controllers;

import static controllers.CMisPaquetes.vista;
import dao.PaqueteDAO;
import dto.*;
import formato.ManejadorTablas;
import interfaces.ObligacionControlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import views.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import process.PMisPaquetes;
import process.PRegistro;

public class CRegistro extends ObligacionControlador implements ActionListener {

    public static VRegistro vista;

    public CRegistro(VRegistro f) {
        vista = f;
        vista.setVisible(true);
        vista.setTitle("Registros");
        super.constructor();
    }

    public static void completarTablaPaquetes(JTable jTable) {
        String[] header = {
            "ID PAQUETE", "ID ALOJAMIENTO", "ID VUELO", "ID ORIGEN", "ID DESTINO",
            "FECHA SALIDA", "FECHA REGRESO", "ID ACTIVIDAD", "PORTADA PRINCIPAL",
            "PORTADA SECUNDARIA", "NOMBRE PAQUETE"
        };
        PaqueteDAO paqueteDAO = new PaqueteDAO();
        List<PaqueteDTO> list = paqueteDAO.readAll();
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        jTable.setModel(dtm);
        for (PaqueteDTO x : list) {
            dtm.addRow(x.vectorizar());
        }
        ManejadorTablas.setFormatoTablaPaquetes(jTable);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.rbMostrarTodo) {
            PRegistro.completarTablaTotal(vista.tblDatos);
        } else if (e.getSource() == this.vista.rbMostrarResumen) {
            PRegistro.completarTablaConDependencias(vista.tblDatos);
        } else if (e.getSource() == this.vista.rbMostrarMuyResumido) {
            PRegistro.completarResumenTabla(vista.tblDatos);
        }
    }

    @Override
    public void construirVista() {
        PRegistro.construirForma(vista);
    }

    @Override
    public void agregarTodosListeners() {
        this.vista.rbMostrarMuyResumido.addActionListener(this);
        this.vista.rbMostrarResumen.addActionListener(this);
        this.vista.rbMostrarTodo.addActionListener(this);
    }

    @Override
    public void inicializarObjetos() {
    }

}
