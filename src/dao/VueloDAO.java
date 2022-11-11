package dao;

import interfaces.*;
import dto.*;
import conexion.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VueloDAO implements ObjectIDAO<VueloDTO> {

    private static final String SQL_INSERT = ""
            + "INSERT INTO vuelos (numero_pasajeros, costo_vuelo, "
            + "id_avion, portada_principal, portada_secundaria) "
            + "VALUES (?,?,?,?,?)";
    private static final String SQL_READ = ""
            + "SELECT * FROM vuelos WHERE id_vuelo=?";
    private static final String SQL_READ_ALL = ""
            + "SELECT * FROM vuelos";
    private static final String SQL_UPDATE = ""
            + "UPDATE vuelos SET numero_pasajeros=?, costo_vuelo=?, "
            + "id_avion=? portada_principal=?, portada_secundaria=? "
            + "WHERE id_vuelo=?";
    private static final String SQL_DELETE = ""
            + "DELETE FROM vuelos WHERE id_vuelo=?";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(VueloDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareCall(SQL_INSERT);
            ps.setInt(1, t.getNumeroPasajeros());
            ps.setDouble(2, t.getCostoVuelo());
            ps.setInt(3, t.getIdAvion());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VueloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public VueloDTO read(Object key) {
        VueloDTO vueloDTO = new VueloDTO();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            rs = ps.executeQuery();
            while (rs.next()) {
                vueloDTO.setIdVuelo(rs.getInt(1));
                vueloDTO.setNumeroPasajeros(rs.getInt(2));
                vueloDTO.setCostoVuelo(rs.getInt(3));
                vueloDTO.setIdAvion(rs.getInt(4));
                vueloDTO.setPortadaPrincipal(rs.getInt(6));
                vueloDTO.setPortadaSecundaria(rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return vueloDTO;
    }

    @Override
    public List<VueloDTO> readAll() {
        List<VueloDTO> list = new LinkedList<>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                VueloDTO vueloDTO = new VueloDTO();
                vueloDTO.setIdVuelo(rs.getInt(1));
                vueloDTO.setNumeroPasajeros(rs.getInt(2));
                vueloDTO.setCostoVuelo(rs.getInt(3));
                vueloDTO.setIdAvion(rs.getInt(4));
                vueloDTO.setPortadaPrincipal(rs.getInt(6));
                vueloDTO.setPortadaSecundaria(rs.getInt(6));
                list.add(vueloDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(VueloDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareCall(SQL_UPDATE);
            ps.setInt(1, t.getNumeroPasajeros());
            ps.setDouble(2, t.getCostoVuelo());
            ps.setInt(3, t.getIdAvion());
            ps.setInt(4, t.getIdVuelo());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VueloDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VueloDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

}
