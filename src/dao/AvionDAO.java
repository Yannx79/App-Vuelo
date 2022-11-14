package dao;

import conexion.Conexion;
import dto.AvionDTO;
import interfaces.ObjectIDAO;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

public class AvionDAO implements ObjectIDAO<AvionDTO> {

    private static final String SQL_INSERT = "";
    private static final String SQL_READ = "SELECT * FROM aviones "
            + "WHERE id_avion=?";
    private static final String SQL_READ_ALL = "SELECT * FROM aviones";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(AvionDTO t) {
        return true;
    }

    @Override
    public AvionDTO read(Object key) {
        AvionDTO avionDTO = new AvionDTO();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ps.setString(1, key.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                avionDTO.setIdAvion(rs.getInt(1));
                avionDTO.setNombreAvion(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return avionDTO;
    }

    @Override
    public List<AvionDTO> readAll() {
        List<AvionDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AvionDTO avionDTO = new AvionDTO();
                avionDTO.setIdAvion(rs.getInt(1));
                avionDTO.setNombreAvion(rs.getString(2));
                list.add(avionDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(AvionDTO t) {
        return true;
    }

    @Override
    public boolean delete(Object key) {
        return true;
    }

}
