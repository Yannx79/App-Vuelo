package formato;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen {

    public static void ajustar(JLabel label, String path) {
        if (label.getWidth() == 0 && label.getHeight() == 0) {
            System.out.println("Dimensiones nulas");
            label.setSize(270, 270);
        }
        ImageIcon imageIcon = new ImageIcon(path);
        Icon icon = new ImageIcon(
                imageIcon.getImage().
                        getScaledInstance(
                                label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT)
        );
        label.setIcon(icon);
        label.repaint();
    }

}
