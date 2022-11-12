package process;

import java.util.List;
import javax.swing.JTable;
import interfaces.*;
import javax.swing.table.DefaultTableModel;

public class ProcesoTable {

    public static void completarTabla(JTable jTable, String[] header, List<ObligacionModelo> list){
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        jTable.setModel(dtm);
        for (ObligacionModelo x: list) {
            dtm.addRow(x.vectorizar());
        }
    }
    
}
