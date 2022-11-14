package process;

import controllers.CMenu;
import dao.MiPaqueteDAO;
import dto.MiPaqueteDTO;
import java.util.List;
import java.util.stream.Collectors;
import views.*;

public class PSelecionarActividad {

    public static void construirForma(VSelecionarActividad f) {
        completarCombox(f);
    }

    public static void completarCombox(VSelecionarActividad f) {
        List<MiPaqueteDTO> list = obtenerListaMisPaquete();
        f.cbxMisPaquetes.removeAllItems();
        for (MiPaqueteDTO x : list) {
            f.cbxMisPaquetes.addItem(x.getIdPaquete() + " - " + x.getNombrePaquete());
        }
    }

    private static List<MiPaqueteDTO> obtenerListaMisPaquete() {
        MiPaqueteDAO miPaqueteDAO = new MiPaqueteDAO();
        List<MiPaqueteDTO> list = miPaqueteDAO.readAll();
        list = list.stream().
                filter(x -> x.getIdUsuario() == CMenu.usuario.getIdUsuario()).
                collect(Collectors.toList());
        return list;
    }
}
