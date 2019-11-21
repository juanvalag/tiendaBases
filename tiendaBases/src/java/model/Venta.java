package model;

import java.io.Serializable;

public class Venta implements Serializable {

    private String id, cliente, fecha;
    private int valorTotal ,deuda;

    public Venta() {
        this.id = "";
        this.cliente = "";
        this.fecha = "";
        this.valorTotal = 0;
        this.deuda=0;
}

    public Venta(String id, String cliente, String fecha, int valorTotal, int deuda) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.deuda=deuda;
}

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
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

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }


}
