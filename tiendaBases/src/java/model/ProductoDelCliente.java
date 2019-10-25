/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class ProductoDelCliente implements Serializable {

    private String cliente, producto;

    public ProductoDelCliente() {
        this.cliente = "";
        this.producto = "";
}

    public ProductoDelCliente(String cliente, String producto) {
        this.cliente = cliente;
        this.producto = producto;
}

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }


}
