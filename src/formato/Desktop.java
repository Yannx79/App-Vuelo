package formato;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class Desktop {

    public static void agregarAlDesktop(JDesktopPane desktop, JInternalFrame internal) {
        Dimension dimensionDesktop = desktop.getSize();
        Dimension dimensionInternal = internal.getSize();
        internal.setLocation(
                (dimensionDesktop.width - dimensionInternal.width) / 2,
                (dimensionDesktop.height - dimensionInternal.height) / 2
        );
        desktop.add(internal);
    }

}
