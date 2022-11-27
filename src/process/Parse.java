package process;

import dto.MiPaqueteDTO;
import dto.PaqueteDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parse {

    public static MiPaqueteDTO parsePaqueteToMiPaquete(PaqueteDTO p) {
        MiPaqueteDTO mp = new MiPaqueteDTO();
        mp.setFechaRegreso(p.getFechaRegreso());
        mp.setFechaSalida(p.getFechaSalida());
        mp.setIdActividad(p.getIdActividad());
        mp.setIdAlojamiento(p.getIdAlojamiento());
        mp.setIdDestino(p.getIdDestino());
        mp.setIdOrigen(p.getIdOrigen());
        mp.setIdPaquete(p.getIdPaquete());
        mp.setIdVuelo(p.getIdVuelo());
        mp.setPortadaPrincipal(p.getPortadaPrincipal());
        mp.setPortadaSecundaria(p.getPortadaSecundaria());
        mp.setNombrePaquete(p.getNombrePaquete());
        return mp;
    }

    public static String formatearFecha(Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        return formato.format(date);
    }

    public static Date formatearStringToFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        try {
            return formato.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Parse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date();
    }
    
    public static int getPK(String valor) {
        String valores[] = valor.split(" - ");
        return Integer.parseInt(valores[0]);
    }

}
