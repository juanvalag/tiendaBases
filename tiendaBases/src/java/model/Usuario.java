package model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String id, nombre, nomUsuario, pass;

    public Usuario() {
        this.id = "";
        this.nombre = "";
        this.nomUsuario = "";
        this.pass = "";

    }

    public Usuario(String id, String nombre, String nomUsuario, String passw) {
        this.id = id;
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.pass = passw;
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProveedor() {
        return nombre;
    }

    public void setProveedor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
