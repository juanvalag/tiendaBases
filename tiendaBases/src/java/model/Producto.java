/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class Producto implements Serializable {

    private String id, nombre, nomFoto;
    private int existencias, precioVenta, precioCompra;

    public Producto() {
        this.id = "";
        this.nombre = "";
        this.nomFoto = "";
        this.precioVenta = 0;
        this.existencias = 0;
        this.precioCompra = 0;
    }

    public Producto(String id, String nombre, String nomFoto, int precioVenta, int exis, int precioCompra) {
        this.id = id;
        this.nombre = nombre;
        this.nomFoto = nomFoto;
        this.precioVenta = precioVenta;
        this.existencias = exis;
        this.precioCompra = precioCompra;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomFoto() {
        return nomFoto;
    }

    public void setNomFoto(String nomFoto) {
        this.nomFoto = nomFoto;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }


    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", nomFoto=" + nomFoto + ", existencias=" + existencias + ", precioVenta=" + precioVenta + '}';
    }



}
