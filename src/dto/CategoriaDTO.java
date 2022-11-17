package dto;

public class CategoriaDTO {

    private int idCategoria;
    private String tipoCategoria;

    public CategoriaDTO(int idCategoria, String tipoCategoria) {
        this.idCategoria = idCategoria;
        this.tipoCategoria = tipoCategoria;
    }

    public CategoriaDTO(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
    
    public CategoriaDTO(){
        
    }

    @Override
    public String toString() {
        return "*********** DATOS CATEGORIA *****************" 
                + "\n Id Categoria          : " + idCategoria 
                + "\n Tipo Categoria        : " + tipoCategoria;
    }

    
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
    
    
    
}
