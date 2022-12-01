package mvc;

import views.VMenu;
import controllers.CMenu;

public class App {

    private static VMenu vista;
    private static CMenu controlador;

    public static void main(String[] args) {
        vista = new VMenu();
        controlador = new CMenu(vista);
    }

}
