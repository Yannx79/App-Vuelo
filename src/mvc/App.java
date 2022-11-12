package mvc;

import views.VMenu;
import controllers.CMenu;
import dao.MiPaqueteDAO;
import dto.MiPaqueteDTO;
import java.util.List;

public class App {

    private static VMenu vista;
    private static CMenu controlador;

    public static void main(String[] args) {
        vista = new VMenu();
        controlador = new CMenu(vista);
    }

}
