/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author LUZDA
 */
public class Administrador extends Usuario implements Serializable {

    private String nomFoto, tipo;

    public Administrador() 
    {
        super();
        this.nomFoto="";
        this.tipo="";
    }

    public Administrador(String id, String nombre, String nomUsuario, String passw, String nomFoto,String tipo) {
        super(id, nombre, nomUsuario, passw);
        this.nomFoto=nomFoto;
        this.tipo=tipo;
    }

    public String getNomFoto() {
        return nomFoto;
    }

    public void setNomFoto(String nomFoto) {
        this.nomFoto = nomFoto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

 
    
    
}
