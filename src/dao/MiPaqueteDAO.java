package dao;

import conexion.Conexion;
import dto.MiPaqueteDTO;
import interfaces.ObjectIDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiPaqueteDAO implements ObjectIDAO<MiPaqueteDTO> {

    private static final String SQL_INSERT = ""
            + "INSERT INTO mis_paquetes (id_alojamiento, id_vuelo, "
            + "id_origen, id_destino, fecha_salida, "
            + "fecha_regreso, id_actividad, portada_principal, portada_secundaria, "
            + "id_usuario, nombre_paquete) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_INSERT_PAQUETE = ""
            + "INSERT INTO mis_paquetes (id_origen, id_destino, fecha_salida, "
            + "fecha_regreso, portada_principal, portada_secundaria, "
            + "id_usuario, nombre_paquete) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_READ = ""
            + "SELECT * FROM mis_paquetes WHERE id_mis_paquetes=?";
    private static final String SQL_READ_ALL = ""
            + "SELECT * FROM mis_paquetes";
    private static final String SQL_UPDATE = ""
            + "UPDATE mis_paquetes SET id_alojamiento=?, id_vuelo=?, "
            + "id_origen=?, id_destino=?, fecha_salida=?, "
            + "fecha_regreso=?, id_actividad=?, portada_principal=?, "
            + "portada_secundaria=?, id_usuario=?, nombre_paquete=?"
            + "WHERE id_mis_paquetes=?";
    private static final String SQL_UPDATE_PAQUETE_ALOJAMIENTO = "UPDATE mis_paquetes "
            + "SET id_alojamiento=? WHERE id_mis_paquetes=?";
    private static final String SQL_UPDATE_PAQUETE_VUELO = "UPDATE mis_paquetes "
            + "SET id_vuelo=? WHERE id_mis_paquetes=?";
    private static final String SQL_UPDATE_PAQUETE_ACTIVIDAD = "UPDATE mis_paquetes "
            + "SET id_actividad=? WHERE id_mis_paquetes=?";
    private static final String SQL_DELELE = ""
            + "DELETE FROM mis_paquetes WHERE id_mis_paquetes=?";
    private static final Conexion CONEXION = Conexion.getConexion();

    public boolean createPaquete(MiPaqueteDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_INSERT_PAQUETE);
            ps.setInt(1, t.getIdOrigen());
            ps.setInt(2, t.getIdDestino());
            ps.setString(3, t.getFechaSalida());
            ps.setString(4, t.getFechaRegreso());
            ps.setInt(5, t.getPortadaPrincipal());
            ps.setInt(6, t.getPortadaSecundaria());
            ps.setInt(7, t.getIdUsuario());
            ps.setString(8, t.getNombrePaquete());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public boolean create(MiPaqueteDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_INSERT);
            ps.setInt(1, t.getIdAlojamiento());
            ps.setInt(2, t.getIdVuelo());
            ps.setInt(3, t.getIdOrigen());
            ps.setInt(4, t.getIdDestino());
            ps.setString(5, t.getFechaSalida());
            ps.setString(6, t.getFechaRegreso());
            ps.setInt(7, t.getIdActividad());
            ps.setInt(8, t.getPortadaPrincipal());
            ps.setInt(9, t.getPortadaSecundaria());
            ps.setInt(10, t.getIdUsuario());
            ps.setString(11, t.getNombrePaquete());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public MiPaqueteDTO read(Object key) {
        MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            rs = ps.executeQuery();
            while (rs.next()) {
                miPaqueteDTO.setIdPaquete(rs.getInt(1));
                miPaqueteDTO.setIdAlojamiento(rs.getInt(2));
                miPaqueteDTO.setIdVuelo(rs.getInt(3));
                miPaqueteDTO.setIdOrigen(rs.getInt(4));
                miPaqueteDTO.setIdDestino(rs.getInt(5));
                miPaqueteDTO.setFechaSalida(rs.getString(6));
                miPaqueteDTO.setFechaRegreso(rs.getString(7));
                miPaqueteDTO.setIdActividad(rs.getInt(8));
                miPaqueteDTO.setPortadaPrincipal(rs.getInt(9));
                miPaqueteDTO.setPortadaSecundaria(rs.getInt(10));
                miPaqueteDTO.setIdUsuario(rs.getInt(11));
                miPaqueteDTO.setNombrePaquete(rs.getString(12));
            }
            return miPaqueteDTO;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return miPaqueteDTO;
    }

    @Override
    public List<MiPaqueteDTO> readAll() {
        List<MiPaqueteDTO> listPaquetes = new LinkedList<>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                MiPaqueteDTO miPaqueteDTO = new MiPaqueteDTO();
                miPaqueteDTO.setIdPaquete(rs.getInt(1));
                miPaqueteDTO.setIdAlojamiento(rs.getInt(2));
                miPaqueteDTO.setIdVuelo(rs.getInt(3));
                miPaqueteDTO.setIdOrigen(rs.getInt(4));
                miPaqueteDTO.setIdDestino(rs.getInt(5));
                miPaqueteDTO.setFechaSalida(rs.getString(6));
                miPaqueteDTO.setFechaRegreso(rs.getString(7));
                miPaqueteDTO.setIdActividad(rs.getInt(8));
                miPaqueteDTO.setPortadaPrincipal(rs.getInt(9));
                miPaqueteDTO.setPortadaSecundaria(rs.getInt(10));
                miPaqueteDTO.setIdUsuario(rs.getInt(11));
                miPaqueteDTO.setNombrePaquete(rs.getString(12));
                listPaquetes.add(miPaqueteDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return listPaquetes;
    }

    public boolean updateAlojamiento(MiPaqueteDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_UPDATE_PAQUETE_ALOJAMIENTO);
            ps.setInt(1, t.getIdAlojamiento());
            ps.setInt(2, t.getIdPaquete());
            if (ps.executeUpdate()> 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }
    public boolean updateVuelo(MiPaqueteDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_UPDATE_PAQUETE_VUELO);
            ps.setInt(1, t.getIdVuelo());
            ps.setInt(2, t.getIdPaquete());
            if (ps.executeUpdate()> 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }
    public boolean updateActividad(MiPaqueteDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_UPDATE_PAQUETE_ACTIVIDAD);
            ps.setInt(1, t.getIdActividad());
            ps.setInt(2, t.getIdPaquete());
            if (ps.executeUpdate()> 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public boolean update(MiPaqueteDTO t) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_UPDATE);
            ps.setInt(1, t.getIdAlojamiento());
            ps.setInt(2, t.getIdVuelo());
            ps.setInt(3, t.getIdOrigen());
            ps.setInt(4, t.getIdDestino());
            ps.setString(5, t.getFechaSalida());
            ps.setString(6, t.getFechaRegreso());
            ps.setInt(7, t.getIdActividad());
            ps.setInt(8, t.getPortadaPrincipal());
            ps.setInt(9, t.getPortadaSecundaria());
            ps.setInt(10, t.getIdPaquete());
            ps.setInt(11, t.getIdUsuario());
            ps.setString(12, t.getNombrePaquete());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_DELELE);
            ps.setInt(1, Integer.parseInt(key.toString()));
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return false;
    }
}
