package dao;

import conexion.Conexion;
import dto.AlojamientoDTO;
import interfaces.*;
import java.util.List;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlojamientoDAO implements ObjectIDAO<AlojamientoDTO> {

    private static final String SQL_INSERT = ""
            + "INSERT INTO alojamientos (costo_alojamiento, "
            + "numero_personas, numero_habitaciones, id_hotel, portada_principal, "
            + "portada_secundaria) VALUES (?,?,?,?,?,?)";
    private static final String SQL_READ = ""
            + "SELECT * FROM alojamientos WHERE id_alojamiento=?";
    private static final String SQL_READ_ALL = ""
            + "SELECT * FROM alojamientos";
    private static final String SQL_UPDATE = ""
            + "UPDATE alojamientos costo_alojamiento=?, "
            + "numero_personas=?, numero_habitaciones=?, "
            + "id_hotel=?, portada_principal=?, portada_secundaria=? "
            + "WHERE id_alojamiento=?";
    private static final String SQL_DELETE = ""
            + "DELETE FROM alojamientos WHERE id_alojamiento=?";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(AlojamientoDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_INSERT);
            ps.setDouble(1, t.getCostoAlojamiento());
            ps.setInt(2, t.getNumeroPersonas());
            ps.setInt(3, t.getNumeroHabitaciones());
            ps.setInt(4, t.getIdHotel());
            ps.setInt(5, t.getPortadoPrincipal());
            ps.setInt(6, t.getPortadaSecundaria());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public AlojamientoDTO read(Object key) {
        AlojamientoDTO alojamientoDTO = new AlojamientoDTO();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            rs = ps.executeQuery();
            while (rs.next()) {
                alojamientoDTO.setIdAlojamiento(rs.getInt(1));
                alojamientoDTO.setCostoAlojamiento(rs.getDouble(2));
                alojamientoDTO.setNumeroPersonas(rs.getInt(3));
                alojamientoDTO.setNumeroHabitaciones(rs.getInt(4));
                alojamientoDTO.setIdHotel(rs.getInt(5));
                alojamientoDTO.setPortadoPrincipal(rs.getInt(6));
                alojamientoDTO.setPortadaSecundaria(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return alojamientoDTO;
    }

    @Override
    public List<AlojamientoDTO> readAll() {
        List<AlojamientoDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AlojamientoDTO alojamientoDTO = new AlojamientoDTO();
                alojamientoDTO.setIdAlojamiento(rs.getInt(1));
                alojamientoDTO.setCostoAlojamiento(rs.getDouble(2));
                alojamientoDTO.setNumeroPersonas(rs.getInt(3));
                alojamientoDTO.setNumeroHabitaciones(rs.getInt(4));
                alojamientoDTO.setIdHotel(rs.getInt(5));
                alojamientoDTO.setPortadoPrincipal(rs.getInt(6));
                alojamientoDTO.setPortadaSecundaria(rs.getInt(7));
                list.add(alojamientoDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(AlojamientoDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_UPDATE);
            ps.setDouble(1, t.getCostoAlojamiento());
            ps.setInt(2, t.getNumeroPersonas());
            ps.setInt(3, t.getNumeroHabitaciones());
            ps.setInt(4, t.getIdHotel());
            ps.setInt(5, t.getIdAlojamiento());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlojamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AlojamientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

}
