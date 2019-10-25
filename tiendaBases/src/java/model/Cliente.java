package model;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String id, nombre, tipo, nomUsuario, pass, nomFoto;
    private int existencias;

    public Cliente() {
        this.id = "";
        this.nombre = "";
        this.nomFoto = "";
        this.tipo = "";
        this.nomUsuario = "";
        this.pass = "";
        this.existencias = 0;
    }

    public Cliente(String id, String nombre, String tipo, String nomFoto, String nomUsuario, String pass, int exis) {
        this.id = id;
        this.nombre = nombre;
        this.nomFoto = nomFoto;
        this.tipo = tipo;
        this.nomUsuario = nomUsuario;
        this.pass = pass;
        this.existencias = exis;
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

    public String getNomFoto() {
        return nomFoto;
    }

    public void setNomFoto(String nomFoto) {
        this.nomFoto = nomFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
