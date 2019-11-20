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

public class GestionProductoDeVenta extends AbstractDB {


public GestionProductoDeVenta(){
    super();
}

    public boolean guardaProduVentPro(String Vent, String Pro, int Cant) {
        boolean ok = false;
        try {
            ResultSet res;

            PreparedStatement stmt = this.conexionSQL.prepareStatement("call newProductodeventa(?,?,?)");
            stmt.setString(1, Vent);
            stmt.setString(2, Pro);
            stmt.setInt(3, Cant);
            
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
}       