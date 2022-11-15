package dao;

import conexion.Conexion;
import dto.HotelDTO;
import interfaces.ObjectIDAO;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

public class HotelDAO implements ObjectIDAO<HotelDTO> {

    private static final String SQL_INSERT = "";
    private static final String SQL_READ = "";
    private static final String SQL_READ_ALL = "SELECT * FROM hoteles";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(HotelDTO t) {
        return true;
    }

    @Override
    public HotelDTO read(Object key) {
        return null;
    }

    @Override
    public List<HotelDTO> readAll() {
        List<HotelDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HotelDTO hotelDTO = new HotelDTO();
                hotelDTO.setIdHotel(rs.getInt(1));
                hotelDTO.setNombreHotel(rs.getString(2));
                hotelDTO.setCantidadEstrellas(rs.getInt(3));
                list.add(hotelDTO);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(HotelDTO t) {
        return true;
    }

    @Override
    public boolean delete(Object key) {
        return true;
    }

}
