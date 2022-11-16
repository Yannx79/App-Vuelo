package process;

import dao.*;
import dto.*;
import java.util.List;
import java.util.stream.Collectors;
import views.*;

public class PCrearPaquete {

    public static void construirForma(VCrearPaquete f) {
        llenarCombox(f);
    }

    public static void llenarCombox(VCrearPaquete f) {
        f.cbxLugarDestino.removeAllItems();
        f.cbxLugarPartida.removeAllItems();
        f.cbxPortadaPrincipal.removeAllItems();
        f.cbxPortadaSecundaria.removeAllItems();
        List<PaisDTO> listPaises = obtenerListPaises();
        List<PortadaDTO> listPortadas = obtenerListPortadasParaPaquetes();
        for (PaisDTO p : listPaises) {
            f.cbxLugarDestino.addItem(p.getIdPais() + " - " + p.getNombrePais());
            f.cbxLugarPartida.addItem(p.getIdPais() + " - " + p.getNombrePais());
        }
        for(PortadaDTO p: listPortadas){
            f.cbxPortadaPrincipal.addItem(p.getIdPortada() + " - " + p.getPath());
            f.cbxPortadaSecundaria.addItem(p.getIdPortada() + " - " + p.getPath());
        }
    }

    private static List<PaisDTO> obtenerListPaises() {
        PaisDAO paisDAO = new PaisDAO();
        return paisDAO.readAll();
    }

    private static List<PortadaDTO> obtenerListPortadasParaPaquetes() {
        PortadaDAO portadaDAO = new PortadaDAO();
        List<PortadaDTO> list = portadaDAO.readAll();
        list = list.stream().
                filter(x -> x.getIdTipoPortada() == 1).
                collect(Collectors.toList());
        return list;
    }

    public static PaqueteDTO instanciar(VCrearPaquete f){
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        paqueteDTO.setNombrePaquete(f.txtNombrePaquete.getText());
        paqueteDTO.setIdOrigen(Parse.getPK(f.cbxLugarPartida.getSelectedItem().toString()));     
        paqueteDTO.setIdDestino(Parse.getPK(f.cbxLugarDestino.getSelectedItem().toString()));
        paqueteDTO.setPortadaPrincipal(Parse.getPK(f.cbxPortadaPrincipal.getSelectedItem().toString()));
        paqueteDTO.setPortadaSecundaria(Parse.getPK(f.cbxPortadaSecundaria.getSelectedItem().toString()));
        paqueteDTO.setFechaRegreso(Parse.formatearFecha(f.dcFechaRegreso.getDate()));
        paqueteDTO.setFechaSalida(Parse.formatearFecha(f.dcFechaPartida.getDate()));
        limpiar(f);
        return paqueteDTO;
    }
    
    private static void limpiar(VCrearPaquete f){
        f.txtNombrePaquete.requestFocus();
        f.txtNombrePaquete.setText("");
        f.cbxLugarDestino.setSelectedIndex(0);
        f.cbxLugarPartida.setSelectedIndex(0);
        f.cbxPortadaPrincipal.setSelectedIndex(0);
        f.cbxPortadaSecundaria.setSelectedIndex(0);
    }
    
}
