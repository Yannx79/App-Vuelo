package controllers;

import dao.PaqueteDAO;
import dto.*;
import formato.ManejadorTablas;
import static java.util.Collections.list;
import java.util.List;
import views.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRegistro {

    public static VRegistro vista;

    public CRegistro(VRegistro f) {
        vista = f;
        vista.setVisible(true);
        vista.setTitle("Registros");
        completarTablaPaquetes(vista.tblDatos);
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

}
