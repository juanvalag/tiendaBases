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

public class GestionProductoDelProveedor extends AbstractDB {


public GestionProductoDelProveedor(){
    super();
}

    public boolean guardaProduProve(String pro, String idProv) {
        boolean ok = false;
        try {
            ResultSet res;

            PreparedStatement stmt = this.conexionSQL.prepareStatement("call newProduProve(?,?)");
            stmt.setString(1, idProv);
            stmt.setString(2, pro);
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
