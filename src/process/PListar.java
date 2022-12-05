package process;

import views.VListar;
import dao.*;
import dto.*;
import formato.*;
import interfaces.*;

public class PListar implements IHeaders {

    public static void construirForma(VListar f) {
        defaultRadioButton(f);
        f.setTitle("Listar");
        f.setVisible(true);
        mostrarInformacion(f);
    }

    private static void defaultRadioButton(VListar f) {
        f.rbResumen.setSelected(true);
        f.rbPaquetes.setSelected(true);
    }

    public static void mostrarInformacion(VListar f) {
        if (f.rbResumen.isSelected()) {
            comprobarEntidad(f, false);
        } else if (f.rbTodaInformacion.isSelected()) {
            comprobarEntidad(f, true);
        } else {
//            defaultRadioButton(f);
//            mostrarInformacion(f);
        }
    }

    private static void comprobarEntidad(VListar f, boolean completo) {
        if (f.rbUsuarios.isSelected()) {
            ClienteDAO clienteDAO = new ClienteDAO();
            listar(clienteDAO, f, HEADER_CLIENTE, HEADER_CLIENTE_RESUMEN, completo);
        } else if (f.rbPaquetes.isSelected()) {
            PaqueteDAO paqueteDAO = new PaqueteDAO();
            listar(paqueteDAO, f, HEADER_PAQUETE, HEADER_PAQUETE_RESUMEN, completo);
        } else if (f.rbActividades.isSelected()) {
            ActividadDAO actividadDAO = new ActividadDAO();
            listar(actividadDAO, f, HEADER_ACTIVIDAD, HEADER_ACTIVIDAD_RESUMEN, completo);
        } else if (f.rbVuelos.isSelected()) {
            VueloDAO vueloDAO = new VueloDAO();
            listar(vueloDAO, f, HEADER_VUELO, HEADER_VUELO_RESUMEN, completo);
        } else if (f.rbAlojamiento.isSelected()) {
            AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
            listar(alojamientoDAO, f, HEADER_ALOJAMIENTO, HEADER_ALOJAMIENTO_RESUMEN, completo);
        } else if (f.rbAviones.isSelected()) {
            AvionDAO avionDAO = new AvionDAO();
            listar(avionDAO, f, HEADER_AVION, HEADER_AVION_RESUMEN, completo);
        } else if (f.rbHoteles.isSelected()) {
            HotelDAO hotelDAO = new HotelDAO();
            listar(hotelDAO, f, HEADER_HOTEL, HEADER_HOTEL_RESUMEN, completo);
        } else {
//            defaultRadioButton(f);
//            mostrarInformacion(f);
        }
    }

    private static void listar(ObjectIDAO dao, VListar f,
            String[] headerCompleto, String[] headerResumen, boolean completo) {
        if (completo) {
            FormatoModelo.listar(dao.readAll(), f.tblDatos, headerCompleto, completo);
        } else {
            FormatoModelo.listar(dao.readAll(), f.tblDatos, headerResumen, completo);
        }
    }

}
