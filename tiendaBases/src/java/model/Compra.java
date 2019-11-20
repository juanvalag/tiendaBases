package model;

import java.io.Serializable;

public class Compra implements Serializable {

    private String id, proveedor, fecha;
    private int valorT, saldoRes;

    public Compra() {
        this.id = "";
        this.proveedor = "";
        this.fecha = "";
        this.valorT = 0;
        this.saldoRes = 0;
    }

    public Compra(String id, String proveedor, String fecha, int valorT, int saldoRes) {
        this.id = id;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.valorT = valorT;
        this.saldoRes = saldoRes;
    }

    public int getSaldoRes() {
        return saldoRes;
    }

    public void setSaldoRes(int saldoRes) {
        this.saldoRes = saldoRes;
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

    public int getValorT() {
        return valorT;
    }

    public void setValorT(int valorT) {
        this.valorT = valorT;
    }

}
