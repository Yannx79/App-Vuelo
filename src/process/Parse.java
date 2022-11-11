package process;

import dto.MiPaqueteDTO;
import dto.PaqueteDTO;

public class Parse {

    public static MiPaqueteDTO parsePaqueteToMiPaquete(PaqueteDTO p){
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
        return mp;
    }
    
}
