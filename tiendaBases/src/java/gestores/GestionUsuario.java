/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import conexion.AbstractDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class GestionUsuario extends AbstractDB {


public GestionUsuario(){
    super();
}

    public Usuario getUsuario(String nomUsuario, String pass) {
        Usuario recuperado = new Usuario();
        try {
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("getUsuario(?,?)");
            preparador.setString(1, nomUsuario);
            preparador.setString(0, pass);
            contenedorEjecucion = preparador.executeQuery();
            while (contenedorEjecucion.next()) {
                //recuperado= new Usuario()
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return recuperado;
    }


}
