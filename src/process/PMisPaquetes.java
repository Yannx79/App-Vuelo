package process;

import controllers.CMenu;
import dto.MiPaqueteDTO;
import dao.MiPaqueteDAO;
import formato.ManejadorTablas;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.*;

public class PMisPaquetes {

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

    public static void construirForma(VMisPaquetes f) {
        f.rbMostrarMuyResumido.setSelected(true);
    }

    public static void construirTabla(VMisPaquetes f) {
        if (f.rbMostrarTodo.isSelected()) {
            completarTablaTotal(f.tblDatos);
        } else if (f.rbMostrarResumen.isSelected()) {
            completarTablaConDependencias(f.tblDatos);
        } else if (f.rbMostrarMuyResumido.isSelected()) {
            completarResumenTabla(f.tblDatos);
        } else {
            completarResumenTabla(f.tblDatos);
        }
    }

    public static void completarResumenTabla(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER_RESUMEN);
        jTable.setModel(dtm);
        List<MiPaqueteDTO> list = obtenerListMisPaquetes();
        for (MiPaqueteDTO x : list) {
            dtm.addRow(x.vectorizarParaCliente());
        }
        ManejadorTablas.setFormatoTablaMisPaquetesCliente(jTable);
    }

    public static void completarTablaConDependencias(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER_DEPENDENCIAS);
        jTable.setModel(dtm);
        List<MiPaqueteDTO> list = obtenerListMisPaquetes();
        for (MiPaqueteDTO x : list) {
            dtm.addRow(x.vectorizarConDependencias());
        }
        ManejadorTablas.centrarTodo(jTable);
    }

    public static void completarTablaTotal(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER);
        jTable.setModel(dtm);
        List<MiPaqueteDTO> list = obtenerListMisPaquetes();
        for (MiPaqueteDTO x : list) {
            dtm.addRow(x.vectorizar());
        }
        ManejadorTablas.centrarTodo(jTable);
    }

    private static List<MiPaqueteDTO> obtenerListMisPaquetes() {
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        List<MiPaqueteDTO> list = miPaqueteDAO.readAll();
        list = list.stream().
                filter(x -> x.getIdUsuario() == CMenu.usuario.getIdUsuario()).
                collect(Collectors.toList());
        return list;
    }

}
