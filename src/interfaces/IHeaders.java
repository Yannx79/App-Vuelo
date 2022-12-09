package interfaces;

public interface IHeaders {

    public static final String[] HEADER_PAQUETE = {
        "ID PAQUETE", "ID ALOJAMIENTO", "ID VUELO", "ID ORIGEN", "ID DESTINO",
        "FECHA SALIDA", "FECHA REGRESO", "ID ACTIVIDAD", "PORTADA PRINCIPAL",
        "PORTADA SECUNDARIA", "NOMBRE PAQUETE"
    };

    public static final String[] HEADER_PAQUETE_RESUMEN = {
        "ID PAQUETE", "NOMBRE ALOJAMIENTO", "NOMBRE VUELO",
        "ORIGEN", "DESTINO", "FECHA SALIDA", "FECHA REGRESO",
        "NOMBRE ACTIVIDAD", "NOMBRE PAQUETE"
    };

    public static final String[] HEADER_ACTIVIDAD = {
        "ID", "NOMBRE", "DESCRIPCION", "ID CATEGORIA", "COSTO",
        "ID PORTADA PRINCIPAL", "ID PORTADA SECUNDARIA"
    };

    public static final String[] HEADER_ACTIVIDAD_RESUMEN = {
        "ID", "NOMBRE", "DESCRIPCION", "COSTO", "CATEGORIA"
    };

    public static final String[] HEADER_ALOJAMIENTO = {
        "ID", "COSTO", "# PERSONAS", "# HABITACION", "ID HOTEL",
        "ID 1RA PORTADA", "ID 2DA PORTADA"
    };

    public static final String[] HEADER_ALOJAMIENTO_RESUMEN = {
        "ID", "COSTO", "# PERSONAS", "# HABITACION",};

    public static final String[] HEADER_VUELO = {
        "ID", "# PASAJEROS", "COSTO", "ID AVION", "ID 1RA PORTADA",
        "ID 2DA PORTADA"
    };

    public static final String[] HEADER_VUELO_RESUMEN = {
        "ID", "# PASAJEROS", "COSTO", "NOMBRE AVION"
    };

    public static final String[] HEADER_AVION = {
        "ID", "NOMBRE DEL AVION", "DISPONIBILIDAD"
    };

    public static final String[] HEADER_AVION_RESUMEN = {
        "ID", "NOMBRE DEL AVION"
    };

    public static final String[] HEADER_HOTEL = {
        "ID", "NOMBRE DEL HOTEL", "CANTIDAD DE ESTRELLAS"
    };

    public static final String[] HEADER_HOTEL_RESUMEN = {
        "ID", "NOMBRE DEL HOTEL"
    };

    public static final String[] HEADER_CLIENTE = {
        "ID", "NOMBRES", "APELLIDO PATERNO", "APELLIDO MATERNO",
        "EMAIL"
    };

    public static final String[] HEADER_CLIENTE_RESUMEN = {
        "ID", "NOMBRES", "EMAIL"
    };
    
    public static final String[] ITEMS_FILTRO = {"CODIGO", "NOMBRE"};
    
}
