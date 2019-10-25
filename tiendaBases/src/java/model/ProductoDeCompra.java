/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class ProductoDeCompra implements Serializable {

    private String compra, producto;
    private int cantidad;

    public ProductoDeCompra() {
        this.compra = "";
        this.producto = "";
        this.cantidad = 0;
}

    public ProductoDeCompra(String compra, String producto, int canti) {
        this.compra = compra;
        this.producto = producto;
        this.cantidad = canti;
}

    public String getCompra() {
        return compra;
    }

    public void setCompra(String compra) {
        this.compra = compra;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



}
