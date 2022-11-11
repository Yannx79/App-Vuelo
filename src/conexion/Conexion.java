package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion conexion;
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/app_viaje";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;

    private Conexion() {
        conexion = null;
        connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Conexion fallida: " + e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public synchronized static Conexion getConexion() {
        return (conexion == null) ? new Conexion() : conexion;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConexion() {
        this.conexion = null;
    }

}
