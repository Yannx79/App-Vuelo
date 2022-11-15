package dao;

import conexion.Conexion;
import dto.CategoriaDTO;
import interfaces.*;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

public class CategoriaDAO implements ObjectIDAO<CategoriaDTO> {

    private static final String SQL_INSERT = "";
    private static final String SQL_READ = "SELECT * FROM categoria WHERE "
            + "id_categoria=?";
    private static final String SQL_READ_ALL = "SELECT * FROM categoria";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(CategoriaDTO t) {
        return true;
    }

    @Override
    public CategoriaDTO read(Object key) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoriaDTO.setIdCategoria(rs.getInt(1));
                categoriaDTO.setTipoCategoria(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return categoriaDTO;
    }

    @Override
    public List<CategoriaDTO> readAll() {
        List<CategoriaDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                categoriaDTO.setIdCategoria(rs.getInt(1));
                categoriaDTO.setTipoCategoria(rs.getString(2));
                list.add(categoriaDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(CategoriaDTO t) {
        return true;
    }

    @Override
    public boolean delete(Object key) {
        return true;
    }

}
