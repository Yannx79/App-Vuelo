package process;

import dao.*;
import dto.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.*;

public class PCrearAlojamiento {

    public static void construirForma(VCrearAlojamiento f) {
        completarCombox(f);
    }

    private static void completarCombox(VCrearAlojamiento f) {
        f.cbxIdHotel.removeAllItems();
        f.cbxPortadaPrincipal.removeAllItems();
        f.cbxPortadaSecundaria.removeAllItems();
        List<PortadaDTO> listPortadas = obtenerListPortadasParaAlojamientos();
        for (PortadaDTO p : listPortadas) {
            f.cbxPortadaPrincipal.addItem(p.getIdPortada() + " - " + p.getPath());
            f.cbxPortadaSecundaria.addItem(p.getIdPortada() + " - " + p.getPath());
        }
        HotelDAO hotelDAO = new HotelDAO();
        List<HotelDTO> listHoteles = hotelDAO.readAll();
        for (HotelDTO h : listHoteles) {
            f.cbxIdHotel.addItem(h.getIdHotel() + " - " + h.getNombreHotel());
        }
    }

    private static List<PortadaDTO> obtenerListPortadasParaAlojamientos() {
        PortadaDAO portadaDAO = new PortadaDAO();
        List<PortadaDTO> list = portadaDAO.readAll().stream().
                filter(x -> x.getIdTipoPortada() == 2).
                collect(Collectors.toList());
        return list;
    }

    public static AlojamientoDTO instanciar(VCrearAlojamiento f){
        AlojamientoDTO alojamientoDTO = new AlojamientoDTO();
        alojamientoDTO.setCostoAlojamiento(Double.parseDouble(f.txtCostoAlojamiento.getText()));
        alojamientoDTO.setNumeroPersonas(Integer.parseInt(f.txtNumeroPersonas.getText()));
        alojamientoDTO.setNumeroHabitaciones(Integer.parseInt(f.txtNumeroHabitaciones.getText()));
        alojamientoDTO.setIdHotel(Parse.getPK(f.cbxIdHotel.getSelectedItem().toString()));
        alojamientoDTO.setPortadoPrincipal(Parse.getPK(f.cbxPortadaPrincipal.getSelectedItem().toString()));
        alojamientoDTO.setPortadoPrincipal(Parse.getPK(f.cbxPortadaSecundaria.getSelectedItem().toString()));
        return alojamientoDTO;
    }
    
    public static void completarTabla(JTable jTable, String[] header, List<AlojamientoDTO> list) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        jTable.setModel(dtm);
        for (AlojamientoDTO x : list) {
            dtm.addRow(x.vectorizar());
        }
    }

}
