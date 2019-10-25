/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class Producto implements Serializable {

    private String id, nombre, nomFoto;

    public Producto() {
        this.id = "";
        this.nombre = "";
        this.nomFoto = "";
    }

    public Producto(String id, String nombre, String nomFoto) {
        this.id = id;
        this.nombre = nombre;
        this.nomFoto = nomFoto;
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


}
