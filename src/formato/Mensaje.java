package formato;

import javax.swing.JOptionPane;

public class Mensaje {

    public static void mostrar(String text) {
        JOptionPane.showMessageDialog(null, text, "INFORMACION",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static String capturar(String text) {
        return JOptionPane.showInputDialog(null, text, "CAPTURA",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static int confirmacion(String text, String title) {
        return JOptionPane.showConfirmDialog(null, text, title,
                JOptionPane.YES_NO_OPTION);
    }

}
