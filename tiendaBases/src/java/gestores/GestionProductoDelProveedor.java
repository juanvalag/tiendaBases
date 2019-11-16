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
import model.Producto;

public class GestionProductoDelProveedor extends AbstractDB {


public GestionProductoDelProveedor(){
    super();
}

    public boolean guardaProduProve(Producto pro, String idProv, int precioCompra) {
        boolean ok = false;
        try {
            ResultSet res;

            PreparedStatement stmt = this.conexionSQL.prepareStatement("call newProduProve(?,?,?)");
            System.out.println(pro.getId());
            stmt.setString(1, idProv);
            stmt.setString(2, pro.getId());
            stmt.setInt(3, precioCompra);
            res = stmt.executeQuery();
            res.close();
            ok = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ok;

    }


}
