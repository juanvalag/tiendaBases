/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class Producto implements Serializable {

    private String id, nombre, nomFoto;
    private int existencias, precio;

    public Producto() {
        this.id = "";
        this.nombre = "";
        this.nomFoto = "";
        this.precio = 0;
        this.existencias = 0;
        
    }

    public Producto(String id, String nombre, String nomFoto,int precio, int exis) {
        this.id = id;
        this.nombre = nombre;
        this.nomFoto = nomFoto;
        this.precio = precio;
        this.existencias = exis;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", nomFoto=" + nomFoto + ", existencias=" + existencias + ", precio=" + precio + '}';
    }



}
