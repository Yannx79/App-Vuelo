package process;

import dao.VueloDAO;
import dto.VueloDTO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProcesoTable {

    public static void completarTabla(JTable jTable, String[] header, List<VueloDTO> list){
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        jTable.setModel(dtm);
        for (VueloDTO x: list) {
            dtm.addRow(x.vectorizar());
        }
    }
    
}
