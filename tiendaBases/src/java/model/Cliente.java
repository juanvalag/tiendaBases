/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {

    private String tipo, nomFoto, telefono, direccion;

public Cliente(){
    super();
    this.tipo = "";
    this.nomFoto = "";
    this.telefono = "";
    this.direccion = "";
}

    public Cliente(String id, String nombre, String nomUsuario, String passw, String tipo, String nomFoto, String tel, String dir) {
        super(id, nombre, nomUsuario, passw);
        this.tipo = tipo;
        this.nomFoto = nomFoto;
        this.telefono = tel;
        this.direccion = dir;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomFoto() {
        return nomFoto;
    }

    public void setNomFoto(String nomFoto) {
        this.nomFoto = nomFoto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



}
