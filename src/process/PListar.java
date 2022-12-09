package process;

import views.VListar;
import dao.*;
import dto.*;
import formato.*;
import interfaces.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PListar implements IHeaders {

    public static void construirForma(VListar f) {
        defaultRadioButton(f);
        f.setTitle("Listar");
        f.setVisible(true);
        mostrarInformacion(f);
        completarComboBox(f);
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

    public static void filtrarPaquetes(VListar f) {
        if (f.rbPaquetes.isSelected()) {
            //0: codigo, 1: nombres, 2: origen, 3: destino
            switch (f.cbxFiltro.getSelectedIndex()) {
                case 0:
                    fitrarPorCodigo(f);
                    break;
                case 1:
                    filtrarPorNombres(f);
                    break;
                case 2:
                    break;
                default:
                    Mensaje.mostrar("Opcion no valida");
                    break;
            }
            f.txtParametro.setText("");
        } else {
            Mensaje.mostrar("El fitro solo esta habilitado para los "
                    + "paquetes");
        }
    }

    private static void filtrarPorNombres(VListar f) {
        PaqueteDAO paqueteDAO = new PaqueteDAO();
        List<PaqueteDTO> listPaquetes = new LinkedList<>();
        listPaquetes = paqueteDAO.readAll();
        String parametro = f.txtParametro.getText().trim().toUpperCase();
        listPaquetes = listPaquetes.stream().
                filter(x -> x.getNombrePaquete().toUpperCase().contains(parametro)).
                collect(Collectors.toList());
        if (!listPaquetes.isEmpty()) {
            if (f.rbTodaInformacion.isSelected()) {
                FormatoModelo.listar(listPaquetes, f.tblDatos, HEADER_PAQUETE, true);
            } else {
                FormatoModelo.listar(listPaquetes, f.tblDatos, HEADER_PAQUETE_RESUMEN, false);
            }
        } else {
            Mensaje.mostrar("No hay ningun paquete que contenga en su nombre el parametro: " + parametro);
        }
    }

    private static void fitrarPorCodigo(VListar f) {
        PaqueteDAO paqueteDAO = new PaqueteDAO();
        List<PaqueteDTO> listPaquetes = new LinkedList<>();
        listPaquetes.add(paqueteDAO.read(f.txtParametro.getText().trim()));
        if (listPaquetes.get(0).getIdPaquete() != 0) {
            if (f.rbTodaInformacion.isSelected()) {
                FormatoModelo.listar(listPaquetes, f.tblDatos, HEADER_PAQUETE, true);
            } else {
                FormatoModelo.listar(listPaquetes, f.tblDatos, HEADER_PAQUETE_RESUMEN, false);
            }
        } else {
            Mensaje.mostrar("El codigo de paquete: " + f.txtParametro.getText() + ". No existe");
        }
    }

    private static void completarComboBox(VListar f) {
        f.cbxFiltro.removeAllItems();
        for (String x : ITEMS_FILTRO) {
            f.cbxFiltro.addItem(x);
        }
    }

}
