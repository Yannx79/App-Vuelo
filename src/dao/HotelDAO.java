package dao;

import conexion.Conexion;
import dto.HotelDTO;
import interfaces.ObjectIDAO;
import java.util.List;

public class HotelDAO implements ObjectIDAO<HotelDTO>{

    private static final String SQL_INSERT = "";
    private static final String SQL_READ = "";
    private static final String SQL_READ_ALL = "";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(HotelDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HotelDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HotelDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(HotelDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
