package dto;

import interfaces.ObligacionModelo;

public class ClienteDTO implements ObligacionModelo {

    private int idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String password;

    public ClienteDTO(int idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.password = password;
    }

    public ClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.email = email;
        this.password = password;
    }

    public ClienteDTO() {

    }

    @Override
    public Object[] vectorizarResumen() {
        Object[] values = {
            idUsuario, nombres, email
        };
        return values;
    }

    @Override
    public Object[] vectorizar() {
        Object[] values = {
            idUsuario, nombres, apellidoPaterno, apellidoMaterno, email
        };
        return values;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "idUsuario=" + idUsuario + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", email=" + email + ", password=" + password + '}';
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
