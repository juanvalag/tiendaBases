package model;

import java.io.Serializable;

public class Venta implements Serializable {

    private String id, cliente, fecha;
    private float valorTotal;

    public Venta() {
        this.id = "";
        this.cliente = "";
        this.fecha = "";
        this.valorTotal = 0;
}

    public Venta(String id, String cliente, String fecha, Float valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }


}
