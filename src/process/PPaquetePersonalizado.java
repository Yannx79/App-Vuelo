package process;

import controllers.CMenu;
import views.*;
import dao.*;
import dto.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PPaquetePersonalizado {
    
    public static void construirForma(VPaquetePersonalizado f) {
        completarCombox(f);
    }

    private static void completarCombox(VPaquetePersonalizado f) {
        f.cbxPortadaPrincipal.removeAllItems();
        f.cbxPortadaSecundaria.removeAllItems();
        List<PortadaDTO> listPortadas = obtenerListPortadasParaPaquetes();
        for (PortadaDTO p : listPortadas) {
            f.cbxPortadaPrincipal.addItem(p.getIdPortada() + " - " + p.getPath());
            f.cbxPortadaSecundaria.addItem(p.getIdPortada() + " - " + p.getPath());
        }
        f.cbxLugarDestino.removeAllItems();
        f.cbxLugarPartida.removeAllItems();
        List<PaisDTO> listPaises = obtenerListPaises();
        for (PaisDTO p : listPaises) {
            f.cbxLugarDestino.addItem(p.getIdPais() + " - " + p.getNombrePais());
            f.cbxLugarPartida.addItem(p.getIdPais() + " - " + p.getNombrePais());
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

    public static MiPaqueteDTO instanciar(VPaquetePersonalizado f){
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        miPaqueteDTO.setNombrePaquete(f.txtNombrePaquete.getText());
        miPaqueteDTO.setIdOrigen(Parse.getPK(f.cbxLugarPartida.getSelectedItem().toString()));     
        miPaqueteDTO.setIdDestino(Parse.getPK(f.cbxLugarDestino.getSelectedItem().toString()));
        miPaqueteDTO.setPortadaPrincipal(Parse.getPK(f.cbxPortadaPrincipal.getSelectedItem().toString()));
        miPaqueteDTO.setPortadaSecundaria(Parse.getPK(f.cbxPortadaSecundaria.getSelectedItem().toString()));
        miPaqueteDTO.setFechaRegreso(Parse.formatearFecha(f.dcFechaRegreso.getDate()));
        miPaqueteDTO.setFechaSalida(Parse.formatearFecha(f.dcFechaPartida.getDate()));
        miPaqueteDTO.setIdUsuario(CMenu.usuario.getIdUsuario());
        limpiar(f);
        return miPaqueteDTO;
    }

    public static void limpiar(VPaquetePersonalizado f){
        f.txtNombrePaquete.setText("");
    }
    
}
