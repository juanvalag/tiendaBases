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
import javax.swing.JOptionPane;
import model.Proveedor;

/**
 *
 * @author LUZDA
 */
public class GestionProveedor extends AbstractDB 
{

    public GestionProveedor() 
    {
        
        super();
    }
    public void cierraConexion()
    {
        try
        {
            this.conn.close();
            System.out.println("tranquilos he cerrado la conexion...!!");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public boolean GuardaProveedor(Proveedor prove) 
    {
        boolean ok =false;
       try 
       {
           ResultSet res;
           PreparedStatement stmt= this.conn.prepareStatement("call newProveedor(?,?)");
           stmt.setString(1, prove.getId());
           stmt.setString(2, prove.getNombre());
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
