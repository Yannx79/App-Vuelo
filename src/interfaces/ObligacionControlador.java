package interfaces;

/**
 * Intención es garantizar un comportamiento semejante en todos los
 * controladores
 *
 * @autor x
 */
public interface ObligacionControlador {

    public abstract void construirVista();

    public abstract void agregarTodosListeners();

    public abstract void inicializarObjetos();

}
