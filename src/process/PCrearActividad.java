package process;

import dao.CategoriaDAO;
import dao.PortadaDAO;
import dto.ActividadDTO;
import dto.AlojamientoDTO;
import dto.CategoriaDTO;
import dto.PortadaDTO;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.VCrearActividad;

public class PCrearActividad {

    public static void construirForma(VCrearActividad f) {
        completarCombox(f);
    }

    private static void completarCombox(VCrearActividad f) {
        f.cbxIdCategoria.removeAllItems();
        f.cbxPortadaPrincipal.removeAllItems();
        f.cbxPortadaSecundaria.removeAllItems();
        List<PortadaDTO> listPortadas = obtenerListPortadasParaActividades();
        for (PortadaDTO p : listPortadas) {
            f.cbxPortadaPrincipal.addItem(p.getIdPortada() + " - " + p.getPath());
            f.cbxPortadaSecundaria.addItem(p.getIdPortada() + " - " + p.getPath());
        }
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<CategoriaDTO> listCategorias = categoriaDAO.readAll();
        for (CategoriaDTO c : listCategorias) {
            f.cbxIdCategoria.addItem(c.getIdCategoria() + " - " + c.getTipoCategoria());
        }
    }

    private static List<PortadaDTO> obtenerListPortadasParaActividades() {
        PortadaDAO portadaDAO = new PortadaDAO();
        List<PortadaDTO> list = portadaDAO.readAll().stream().
                filter(x -> x.getIdTipoPortada() == 4).
                collect(Collectors.toList());
        return list;
    }

    public static ActividadDTO instanciar(VCrearActividad f){
        ActividadDTO actividadDTO = new ActividadDTO();
        actividadDTO.setNombreActividad(f.txtNombreActividad.getText());
        actividadDTO.setDescripcion(f.txtDescripcion.getText());
        actividadDTO.setIdCategoria(Parse.getPK(f.cbxIdCategoria.getSelectedItem().toString()));
        actividadDTO.setCostoActividad(Double.parseDouble(f.txtCostoActividad.getText()));
        actividadDTO.setPortadoPrincipal(Parse.getPK(f.cbxPortadaPrincipal.getSelectedItem().toString()));
        actividadDTO.setPortadaSecundaria(Parse.getPK(f.cbxPortadaSecundaria.getSelectedItem().toString()));
        limpiarEntradas(f);
        return actividadDTO;
    }
    
    public static void completarTabla(JTable jTable, String[] header, List<ActividadDTO> list) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        jTable.setModel(dtm);
        for (ActividadDTO x : list) {
            dtm.addRow(x.vectorizar());
        }
    }
    
    private static void limpiarEntradas(VCrearActividad f){
        f.txtNombreActividad.requestFocus();
        f.txtNombreActividad.setText("");
        f.txtDescripcion.setText("");
        f.txtCostoActividad.setText("");
        f.cbxIdCategoria.setSelectedIndex(0);
        f.cbxPortadaPrincipal.setSelectedIndex(0);
        f.cbxPortadaSecundaria.setSelectedIndex(0);
    }
    
}
