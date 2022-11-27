package dao;

import dto.PaisDTO;
import interfaces.*;
import java.sql.*;
import conexion.*;
import java.util.LinkedList;
import java.util.List;

public class PaisDAO implements ObjectIDAO<PaisDTO> {

    private static final String SQL_CREATE = "";
    private static final String SQL_READ = "SELECT * FROM paises "
            + "WHERE id_pais=?";
    private static final String SQL_READ_ALL = "SELECT * FROM paises";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(PaisDTO t) {
        return false;
    }

    @Override
    public PaisDTO read(Object key) {
        PaisDTO paisDTO = new PaisDTO();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                paisDTO.setIdPais(rs.getInt(1));
                paisDTO.setNombrePais(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Error read PaisDAO: " + e);
        } finally {
            CONEXION.closeConexion();
        }
        return paisDTO;
    }

    @Override
    public List<PaisDTO> readAll() {
        List<PaisDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PaisDTO paisDTO = new PaisDTO();
                paisDTO.setIdPais(rs.getInt(1));
                paisDTO.setNombrePais(rs.getString(2));
                list.add(paisDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(PaisDTO t) {
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return false;
    }

}
