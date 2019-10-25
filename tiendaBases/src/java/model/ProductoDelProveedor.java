/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

public class ProductoDelProveedor implements Serializable {

    private String proveedor, producto;
    private float precioCompra;

    public ProductoDelProveedor() {
        this.proveedor = "";
        this.producto = "";
        this.precioCompra = 0;
}

    public ProductoDelProveedor(String proveedor, String producto, float preciCom) {
        this.proveedor = proveedor;
        this.producto = producto;
        this.precioCompra = preciCom;
}

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

}
