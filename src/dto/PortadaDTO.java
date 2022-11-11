
package dto;

public class PortadaDTO {

    private int idPortada;
    private String path;
    private int idTipoPortada;

    public PortadaDTO(int idPortada, String path, int idTipoPortada) {
        this.idPortada = idPortada;
        this.path = path;
        this.idTipoPortada = idTipoPortada;
    }

    public PortadaDTO(String path, int idTipoPortada) {
        this.path = path;
        this.idTipoPortada = idTipoPortada;
    }

    public PortadaDTO(int idPortada) {
        this.idPortada = idPortada;
    }
    
    public PortadaDTO(){
        
    }

    public int getIdPortada() {
        return idPortada;
    }

    public void setIdPortada(int idPortada) {
        this.idPortada = idPortada;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIdTipoPortada() {
        return idTipoPortada;
    }

    public void setIdTipoPortada(int idTipoPortada) {
        this.idTipoPortada = idTipoPortada;
    }
    
    
    
}
