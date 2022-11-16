package process;

import dao.AvionDAO;
import dao.PortadaDAO;
import views.*;
import dto.*;
import java.util.List;
import java.util.stream.Collectors;

public class PCrearVuelo {

    public static void construirForma(VCrearVuelo f) {
        completarCombox(f);
    }

    private static void completarCombox(VCrearVuelo f) {
        f.cbxIdAvion.removeAllItems();
        f.cbxPortadaPrincipal.removeAllItems();
        f.cbxPortadaSecundaria.removeAllItems();
        List<PortadaDTO> listPortadas = obtenerListPortadasParaVuelos();
        for (PortadaDTO p : listPortadas) {
            f.cbxPortadaPrincipal.addItem(p.getIdPortada() + " - " + p.getPath());
            f.cbxPortadaSecundaria.addItem(p.getIdPortada() + " - " + p.getPath());
        }
        AvionDAO avionDAO = new AvionDAO();
        List<AvionDTO> listAviones = avionDAO.readAll();
        for (AvionDTO a : listAviones) {
            f.cbxIdAvion.addItem(a.getIdAvion() + " - " + a.getNombreAvion());
        }
    }

    private static List<PortadaDTO> obtenerListPortadasParaVuelos() {
        PortadaDAO portadaDAO = new PortadaDAO();
        List<PortadaDTO> list = portadaDAO.readAll().stream().
                filter(x -> x.getIdTipoPortada() == 3).
                collect(Collectors.toList());
        return list;
    }

    public static VueloDTO instanciar(VCrearVuelo f) {
        VueloDTO vueloDTO = new VueloDTO();
        vueloDTO.setNumeroPasajeros(Integer.parseInt(f.txtNumeroPasajeros.getText()));
        vueloDTO.setCostoVuelo(Double.parseDouble(f.txtCostoVuelo.getText()));
        vueloDTO.setIdAvion(Parse.getPK(f.cbxIdAvion.getSelectedItem().toString()));
        vueloDTO.setPortadaPrincipal(Parse.getPK(f.cbxPortadaPrincipal.getSelectedItem().toString()));
        vueloDTO.setPortadaSecundaria(Parse.getPK(f.cbxPortadaSecundaria.getSelectedItem().toString()));
        limpiar(f);
        return vueloDTO;
    }

    private static void limpiar(VCrearVuelo f){
        f.txtNumeroPasajeros.requestFocus();
        f.txtNumeroPasajeros.setText("");
        f.txtCostoVuelo.setText("");
        f.cbxPortadaPrincipal.setSelectedIndex(0);
        f.cbxPortadaSecundaria.setSelectedIndex(0);
    }
    
}
