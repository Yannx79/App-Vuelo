package dao;

import dto.ClienteDTO;
import interfaces.*;
import conexion.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClienteDAO implements ObjectIDAO<ClienteDTO> {

    private final String SQL_READ = "";
    private final String SQL_READ_ALL = "SELECT * FROM usuarios";

    private static final Conexion CONEXION = Conexion.getConexion();

    @Override
    public boolean create(ClienteDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteDTO> readAll() {
        List<ClienteDTO> list = new LinkedList<>();
        try {
            PreparedStatement ps = CONEXION.getConnection().prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setIdUsuario(rs.getInt(1));
                clienteDTO.setNombres(rs.getString(2));
                clienteDTO.setApellidoPaterno(rs.getString(3));
                clienteDTO.setApellidoMaterno(rs.getString(4));
                clienteDTO.setEmail(rs.getString(5));
                clienteDTO.setPassword(rs.getString(6));
                list.add(clienteDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public boolean update(ClienteDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
