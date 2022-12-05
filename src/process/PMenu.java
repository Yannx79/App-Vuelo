package process;

import javax.swing.ImageIcon;
import views.VMenu;

public class PMenu {

    public static void construirForma(VMenu f) {
        establecerImagenMenuItem(f);
    }

    private static void establecerImagenMenuItem(VMenu f) {
        f.jmHome.setIcon(new ImageIcon(""));
        f.jmOperacionesCliente.setIcon(new ImageIcon(""));
        f.jmOperacionesEmpleado.setIcon(new ImageIcon(""));
        
        f.miLogin.setIcon(new ImageIcon("imagenes/iconos/login.png"));
        f.miLogout.setIcon(new ImageIcon("imagenes/iconos/logout.png"));
        
        f.miVerMisPaquetes.setIcon(new ImageIcon("imagenes/iconos/package2.png"));
        f.miVerPaquetes.setIcon(new ImageIcon("imagenes/iconos/package.png"));
        f.miPaquetesPersonalizados.setIcon(new ImageIcon("imagenes/iconos/engine.png"));
        f.miSeleccionarAlojamiento.setIcon(new ImageIcon("imagenes/iconos/hotel.png"));
        f.miSeleccionarVuelo.setIcon(new ImageIcon("imagenes/iconos/avion.png"));
        f.miSeleccionarActividad.setIcon(new ImageIcon("imagenes/iconos/soccer.png"));
        
        f.miCrearPaquete.setIcon(new ImageIcon("imagenes/iconos/create.png"));
        f.miCrearAlojamiento.setIcon(new ImageIcon("imagenes/iconos/create.png"));
        f.miCrearVuelo.setIcon(new ImageIcon("imagenes/iconos/create.png"));
        f.miCrearActividad.setIcon(new ImageIcon("imagenes/iconos/create.png"));
        f.miListar.setIcon(new ImageIcon("imagenes/iconos/detail1.png"));
    }
    
}
