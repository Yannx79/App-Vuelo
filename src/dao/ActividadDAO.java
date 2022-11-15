package dao;

import conexion.Conexion;
import interfaces.ObjectIDAO;
import dto.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadDAO implements ObjectIDAO<ActividadDTO> {

    private static final String SQL_INSERT = ""
            + "INSERT INTO actividades (nombre_actividad, descripcion, "
            + "id_categoria, costo_actividad, portada_principal, portada_secundaria) "
            + "VALUES (?,?,?,?,?,?)";
    private static final String SQL_READ = ""
            + "SELECT * FROM actividades WHERE id_actividad=?";
    private static final String SQL_READ_ALL = ""
            + "SELECT * FROM actividades";
    private static final String SQL_UPDATE = ""
            + "UPDATE alojamientos SET nombre_actividad=?, descripcion=?, "
            + "id_categoria=?, costo_actividad=?, portada_principal=?, portada_secundaria=?";
    private static final String SQL_DELETE = ""
            + "DELETE FROM actividades WHERE id_actividad=?";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(ActividadDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1, t.getNombreActividad());
            ps.setString(2, t.getDescripcion());
            ps.setInt(3, t.getIdCategoria());
            ps.setDouble(4, t.getCostoActividad());
            ps.setInt(5, t.getPortadoPrincipal());
            ps.setInt(6, t.getPortadaSecundaria());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public ActividadDTO read(Object key) {
        ActividadDTO actividadDTO = new ActividadDTO();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                actividadDTO.setIdActividad(rs.getInt(1));
                actividadDTO.setNombreActividad(rs.getString(2));
                actividadDTO.setDescripcion(rs.getString(3));
                actividadDTO.setIdCategoria(rs.getInt(4));
                actividadDTO.setCostoActividad(rs.getDouble(5));
                actividadDTO.setPortadoPrincipal(rs.getInt(6));
                actividadDTO.setPortadaSecundaria(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return actividadDTO;
    }

    @Override
    public List<ActividadDTO> readAll() {
        List<ActividadDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ActividadDTO actividadDTO = new ActividadDTO();
                actividadDTO.setIdActividad(rs.getInt(1));
                actividadDTO.setNombreActividad(rs.getString(2));
                actividadDTO.setDescripcion(rs.getString(3));
                actividadDTO.setIdCategoria(rs.getInt(4));
                actividadDTO.setCostoActividad(rs.getDouble(5));
                actividadDTO.setPortadoPrincipal(rs.getInt(6));
                actividadDTO.setPortadaSecundaria(rs.getInt(7));
                list.add(actividadDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(ActividadDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_UPDATE);
            ps.setString(1, t.getNombreActividad());
            ps.setString(2, t.getDescripcion());
            ps.setInt(3, t.getIdCategoria());
            ps.setDouble(4, t.getCostoActividad());
            ps.setInt(5, t.getIdActividad());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, Integer.parseInt(key.toString()));
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

}
