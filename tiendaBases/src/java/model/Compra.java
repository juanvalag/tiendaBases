package model;

import java.io.Serializable;

public class Compra implements Serializable {

    private String id, proveedor, fecha;
    private float valorT;

    public Compra() {
        this.id = "";
        this.proveedor = "";
        this.fecha = "";
        this.valorT = 0;
    }

    public Compra(String id, String proveedor, String fecha, Float valorT) {
        this.id = id;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.valorT = valorT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getValorT() {
        return valorT;
    }

    public void setValorT(float valorT) {
        this.valorT = valorT;
    }

}
