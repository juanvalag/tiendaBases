/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class Producto implements Serializable {

    private String id, nombre, nomFoto;
    private int existencias;

    public Producto() {
        this.id = "";
        this.nombre = "";
        this.nomFoto = "";
        this.existencias = 0;
    }

    public Producto(String id, String nombre, String nomFoto, int exis) {
        this.id = id;
        this.nombre = nombre;
        this.nomFoto = nomFoto;
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



}
