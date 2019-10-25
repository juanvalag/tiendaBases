/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LUZDA
 */


public class Cliente 
{
    String ID,Nombre, tipo, Foto;

    public Cliente() {
        this.ID = "";
        this.Nombre = "";
        this.tipo = "";
        this.Foto = "";
    }
      public Cliente(String ID, String Nombre, String tipo, String Foto) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.Foto = Foto;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "ID=" + ID + ", Nombre=" + Nombre + ", tipo=" + tipo + ", Foto=" + Foto + '}';
    }
      
      
}
