package process;

import views.*;
import dao.*;
import dto.*;
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
    }

    private static List<PortadaDTO> obtenerListPortadasParaPaquetes() {
        PortadaDAO portadaDAO = new PortadaDAO();
        List<PortadaDTO> list = portadaDAO.readAll();
        list = list.stream().
                filter(x -> x.getIdTipoPortada() == 1).
                collect(Collectors.toList());
        return list;
    }

}
