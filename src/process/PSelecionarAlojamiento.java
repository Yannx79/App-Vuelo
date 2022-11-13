package process;

import controllers.CMenu;
import views.*;
import dao.*;
import dto.*;
import java.util.List;
import java.util.stream.Collectors;

public class PSelecionarAlojamiento {
    
    public static void construirForma(VSelecionarAlojamiento f){
        completarCombox(f);
    }
    
    public static void completarCombox(VSelecionarAlojamiento f) {
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
