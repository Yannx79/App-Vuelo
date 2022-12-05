package process;

import dao.PaqueteDAO;
import dto.PaqueteDTO;
import formato.ManejadorTablas;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.VRegistro;

public class PRegistro {
    
    private static final String[] HEADER = {
        "ID PAQUETE", "ID ALOJAMIENTO", "ID VUELO", "ID ORIGEN", "ID DESTINO",
        "FECHA SALIDA", "FECHA REGRESO", "ID ACTIVIDAD", "PORTADA PRINCIPAL",
        "PORTADA SECUNDARIA", "NOMBRE PAQUETE"
    };
    private static final String[] HEADER_DEPENDENCIAS = {
        "ID PAQUETE", "ID ALOJAMIENTO", "NOMBRE ALOJAMIENTO", "ID VUELO",
        "NOMBRE VUELO", "ID ORIGEN", "ID DESTINO",
        "FECHA SALIDA", "FECHA REGRESO", "ID ACTIVIDAD", "NOMBRE ACTIVIDAD",
        "PORTADA PRINCIPAL", "PORTADA SECUNDARIA", "NOMBRE PAQUETE"
    };
    private static final String[] HEADER_RESUMEN = {
        "ID PAQUETE", "NOMBRE ALOJAMIENTO", "NOMBRE VUELO",
        "ORIGEN", "DESTINO", "FECHA SALIDA", "FECHA REGRESO",
        "NOMBRE ACTIVIDAD", "NOMBRE PAQUETE"
    };
    
    public static void construirForma(VRegistro f) {
        f.rbMostrarMuyResumido.setSelected(true);
        completar(f);
    }
    
    public static void completar(VRegistro f) {
        if (f.rbMostrarMuyResumido.isSelected()) {
            completarResumenTabla(f.tblDatos);
        } else if (f.rbMostrarResumen.isSelected()) {
            completarTablaConDependencias(f.tblDatos);
        } else if (f.rbMostrarTodo.isSelected()) {
            completarTablaTotal(f.tblDatos);
        }
    }
    
    public static void completarResumenTabla(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER_RESUMEN);
        jTable.setModel(dtm);
        PaqueteDAO paqueteDAO = new PaqueteDAO();
        List<PaqueteDTO> list = paqueteDAO.readAll();
        for (PaqueteDTO x : list) {
            dtm.addRow(x.vectorizarParaCliente());
        }
        ManejadorTablas.setFormatoTablaMisPaquetesCliente(jTable);
        ManejadorTablas.centrarTodo(jTable);
    }
    
    public static void completarTablaConDependencias(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER_DEPENDENCIAS);
        jTable.setModel(dtm);
        PaqueteDAO paqueteDAO = new PaqueteDAO();
        List<PaqueteDTO> list = paqueteDAO.readAll();
        for (PaqueteDTO x : list) {
            dtm.addRow(x.vectorizarConDependencias());
        }
        ManejadorTablas.centrarTodo(jTable);
    }
    
    public static void completarTablaTotal(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER);
        jTable.setModel(dtm);
        PaqueteDAO paqueteDAO = new PaqueteDAO();
        List<PaqueteDTO> list = paqueteDAO.readAll();
        for (PaqueteDTO x : list) {
            dtm.addRow(x.vectorizar());
        }
        ManejadorTablas.centrarTodo(jTable);
    }
}
