package formato;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ManejadorTablas {

    //Metodo que especifica un ancho de las columnas de tabla    
    public static void AnchoColumnas(JTable t, int numcolumna, int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);
    }

    //metodo que justifica los datos de una columna
    public static void JustificarCelda(JTable t, int numcolumna) {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);
    }
    
    public static void setFormatoTablaPaquetes(JTable table) {
        for (int i = 0; i < 10; i++) {
            if (i != 5 && i != 6 && i != 10) {
                AnchoColumnas(table, i, 100);
            }
        }
        AnchoColumnas(table, 5, 200);
        AnchoColumnas(table, 6, 200);
        AnchoColumnas(table, 10, 250);
        centrarTodo(table);
    }

    public static void setFormatoTablaMisPaquetesCliente(JTable jTable){
        AnchoColumnas(jTable, 0, 50);
        JustificarCelda(jTable, 0);
        AnchoColumnas(jTable, 7, 150);
        AnchoColumnas(jTable, 8, 150);
    }
    
    public static void centrarTodo(JTable jTable){
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            JustificarCelda(jTable, i);
        }
    }
    
}
