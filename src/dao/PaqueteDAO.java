package dao;

/**
 * *
 * Esta clase puede ser utilizado por los clientes y los empleados
 */
import interfaces.ObjectIDAO;
import dto.*;
import conexion.Conexion;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaqueteDAO implements ObjectIDAO<PaqueteDTO> {

    private static final String SQL_INSERT = ""
            + "INSERT INTO paquetes (id_alojamiento, id_vuelo, "
            + "id_origen, id_destino, fecha_salida, "
            + "fecha_regreso, id_actividad, portada_principal, portada_secundaria) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_READ = ""
            + "SELECT * FROM paquetes WHERE id_paquete=?";
    private static final String SQL_READ_ALL = ""
            + "SELECT * FROM paquetes";
    private static final String SQL_UPDATE = ""
            + "UPDATE paquetes SET id_alojamiento=?, id_vuelo=?, "
            + "id_origen=?, id_destino=?, fecha_salida=?, "
            + "fecha_regreso=?, id_actividad=?, portada_principal=?, "
            + "portada_secundaria=? WHERE id_paquete=?";
    private static final String SQL_DELELE = ""
            + "DELETE FROM paquetes WHERE id_paquete=?";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(PaqueteDTO t) {
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
    public PaqueteDTO read(Object key) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            rs = ps.executeQuery();
            while (rs.next()) {
                paqueteDTO.setIdPaquete(rs.getInt(1));
                paqueteDTO.setIdAlojamiento(rs.getInt(2));
                paqueteDTO.setIdVuelo(rs.getInt(3));
                paqueteDTO.setIdOrigen(rs.getInt(4));
                paqueteDTO.setIdDestino(rs.getInt(5));
                paqueteDTO.setFechaSalida(rs.getString(6));
                paqueteDTO.setFechaRegreso(rs.getString(7));
                paqueteDTO.setIdActividad(rs.getInt(8));
                paqueteDTO.setPortadaPrincipal(rs.getInt(9));
                paqueteDTO.setPortadaSecundaria(rs.getInt(10));
            }
            return paqueteDTO;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return paqueteDTO;
    }

    @Override
    public List<PaqueteDTO> readAll() {
        List<PaqueteDTO> listPaquetes = new LinkedList<>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listPaquetes.add(new PaqueteDTO(
                        rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10)
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return listPaquetes;
    }

    @Override
    public boolean update(PaqueteDTO t) {
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
