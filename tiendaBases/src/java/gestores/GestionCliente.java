/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;





import Conexion.AbstractDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author LUZDA
 */
public class GestionCliente extends AbstractDB  

{

    public GestionCliente() {
        super();
    }
    
    
    
     public boolean GuardaCliente(Cliente cli) 
            
    {
        boolean ok =false;
       try 
       {
           ResultSet res;
           PreparedStatement stmt= this.conn.prepareStatement("call newCliente(?,?,?,?,?)");
           stmt.setString(1, cli.getId());
           stmt.setString(2, cli.getNombre());
           stmt.setString(3, cli.getNomFoto());
           stmt.setString(4, cli.getTipo());
           stmt.setString(5, cli.getNomUsuario());
           
           
           
           res=stmt.executeQuery();
           res.close();
           ok=true;
           
   
       }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        

        
        return ok;

    
}
}

