package process;

import controllers.CMenu;
import dto.MiPaqueteDTO;
import dao.MiPaqueteDAO;
import dao.PaqueteDAO;
import dto.PaqueteDTO;
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
    private static final String[] HEADER_CLIENTE = {
        "ID PAQUETE", "ID ALOJAMIENTO", "NOMBRE ALOJAMIENTO", "ID VUELO",
        "NOMBRE VUELO", "ID ORIGEN", "ID DESTINO",
        "FECHA SALIDA", "FECHA REGRESO", "ID ACTIVIDAD", "NOMBRE ACTIVIDAD",
        "PORTADA PRINCIPAL", "PORTADA SECUNDARIA", "NOMBRE PAQUETE"
    };

    public static void construirForma(VMisPaquetes f) {
        completarTablaConDependencias(f.tblDatos);
    }

    public static void completarTablaConDependencias(JTable jTable){
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER_CLIENTE);
        jTable.setModel(dtm);
        List<MiPaqueteDTO> list = obtenerListMisPaquetes();
        for (MiPaqueteDTO x : list) {
            dtm.addRow(x.vectorizarConDependencias());
        }
    }
    
    public static void completarTabla(JTable jTable) {
        DefaultTableModel dtm = new DefaultTableModel(null, HEADER);
        jTable.setModel(dtm);
        List<MiPaqueteDTO> list = obtenerListMisPaquetes();
        for (MiPaqueteDTO x : list) {
            dtm.addRow(x.vectorizar());
        }
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
