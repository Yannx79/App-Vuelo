package dao;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import dto.PortadaDTO;
import interfaces.ObjectIDAO;
import conexion.*;
import java.util.List;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PortadaDAO implements ObjectIDAO<PortadaDTO> {

    private static final String SQL_READ = ""
            + "SELECT * FROM portadas WHERE id_portada=?";
    private static final String SQL_READ_ALL = ""
            + "SELECT * FROM portadas";
    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(PortadaDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PortadaDTO read(Object key) {
        PortadaDTO portadaDTO = new PortadaDTO();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1, Integer.parseInt(key.toString()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                portadaDTO.setIdPortada(rs.getInt(1));
                portadaDTO.setPath(rs.getString(2));
                portadaDTO.setIdTipoPortada(rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PortadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONEXION.closeConexion();
        }
        return portadaDTO;
    }

    @Override
    public List<PortadaDTO> readAll() {
        List<PortadaDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PortadaDTO portadaDTO = new PortadaDTO();
                portadaDTO.setIdPortada(rs.getInt(1));
                portadaDTO.setPath(rs.getString(2));
                portadaDTO.setIdTipoPortada(rs.getInt(3));
                list.add(portadaDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            CONEXION.closeConexion();
        }
        return list;
    }

    @Override
    public boolean update(PortadaDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
