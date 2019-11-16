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
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import model.Producto;
import model.ProductoDelProveedor;

public class GestionProductoDelProveedor extends AbstractDB {


public GestionProductoDelProveedor(){
    super();
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
