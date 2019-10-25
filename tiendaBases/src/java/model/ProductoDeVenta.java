/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class ProductoDeVenta implements Serializable {

    private String venta, producto;
    private int cantidad;

    public ProductoDeVenta() {
        this.venta = "";
        this.producto = "";
        this.cantidad = 0;
}

    public ProductoDeVenta(String venta, String producto, int canti) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = canti;
}

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
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
