package formato;

import interfaces.ObligacionModelo;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormatoModelo {

    public static void listar(List<? extends ObligacionModelo> list, JTable jTable, String[] header, boolean completo) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        jTable.setModel(dtm);
        for (ObligacionModelo x : list) {
            if (completo) {
                dtm.addRow(x.vectorizar());
            } else {
                dtm.addRow(x.vectorizarResumen());
            }
        }
        ManejadorTablas.centrarTodo(jTable);
    }
    
}
