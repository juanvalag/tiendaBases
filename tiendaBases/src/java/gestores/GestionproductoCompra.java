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
import java.util.ArrayList;
import model.Producto;

public class GestionproductoCompra extends AbstractDB {


public GestionproductoCompra(){
    super();
}

    public boolean guardaProduCompra(String idComp, String idPro, int canti) {
        boolean ok = false;
        try {
            ResultSet res;

            PreparedStatement stmt = this.conexionSQL.prepareStatement("call newProduCompra(?,?,?)");
            stmt.setString(1, idComp);
            stmt.setString(2, idPro);
            stmt.setInt(3, canti);
            res = stmt.executeQuery();
            res.close();
            ok = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ok;
    }

    public ArrayList<String> getTodos(String id) 
    
    {
        ArrayList<String> npps=new ArrayList();
        try
        {
            PreparedStatement stmt = this.conexionSQL.prepareStatement("call getProductoprovee(?)");
            stmt.setString(1, id);
            ResultSet res= stmt.executeQuery();
            
            
             while(res.next())
        {
          
           String pp=res.getString("Nombre");
 
           npps.add(pp);
           
        }
            res.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return npps;
    }

    public ArrayList<Producto> getProductoCompra(String id) {
        ArrayList<Producto> npps = new ArrayList();
        try {
            PreparedStatement stmt = this.conexionSQL.prepareStatement("call getProductoCompra(?)");
            stmt.setString(1, id);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {

                Producto dema = new Producto();
                dema.setNombre(res.getString("Nombre"));
                dema.setExistencias(res.getInt("Cantidad"));
                npps.add(dema);

            }
            res.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return npps;
    }

}







