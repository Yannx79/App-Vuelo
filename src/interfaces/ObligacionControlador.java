package interfaces;

/**
 * Intención es garantizar un comportamiento semejante en todos los
 * controladores
 *
 * @autor x
 */
public abstract class ObligacionControlador {

    public void constructor() {
        this.inicializarObjetos();
        this.agregarTodosListeners();
        this.construirVista();
    }

    public abstract void construirVista();

    public abstract void agregarTodosListeners();

    public abstract void inicializarObjetos();

}
