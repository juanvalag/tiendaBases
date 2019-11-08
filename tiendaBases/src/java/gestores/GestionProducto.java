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

/**
 *
 * @author LUZDA
 */
public class GestionProducto extends AbstractDB  
{
    public GestionProducto() {
        super();
    }
    
    public boolean guardaProducto(Producto pro)    {
        boolean ok =false;
       try 
       {
           ResultSet res;

           

           PreparedStatement stmt = this.conn.prepareStatement("call newProducto(?,?,?,?,?)");
           stmt.setString(1, pro.getId());
           stmt.setString(2, pro.getNombre());
           stmt.setString(3, pro.getNomFoto());
           stmt.setInt(4,pro.getPrecio());
           stmt.setInt(5, pro.getExistencias());
          


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
    
    
    
    
     public Producto BuscaProducto(String id)
    {
        Producto pro=null;
       
        try 
        {
             
         ResultSet res;
          PreparedStatement stmt= this.conn.prepareStatement("call getProducto(?)");
          stmt.setString(1, id);
           res=stmt.executeQuery();
   
        while(res.next())
        {
            
           pro= new Producto();
           pro.setId(res.getString("idProducto"));
           pro.setNombre(res.getString("Nombre"));
           pro.setNomFoto(res.getString("NombreFoto"));
           pro.setPrecio(res.getInt("PrecioVenta"));
           pro.setExistencias(res.getInt("Existencias"));
          
        }
           res.close(); 
       }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        
        
        return pro;
    }

    
     
     
     
     public ArrayList<Producto> getTodos() 
    
    {
        ArrayList<Producto> productos=new ArrayList();
        try
        {
            Statement stmt=this.conn.createStatement();
            ResultSet res=stmt.executeQuery("call getAllProductos()");
             while(res.next())
        {
           Producto dema= new Producto();
           dema.setId(res.getString("idProducto"));
           dema.setNombre(res.getString("Nombre"));
           dema.setNomFoto(res.getString("NombreFoto"));
           dema.setPrecio(res.getInt("PrecioVenta"));
           dema.setExistencias(res.getInt("Existencias"));
           productos.add(dema);
           
        }
            res.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return productos;
        
        
        
 }
     
     
     
     public boolean ModificaProducto(Producto pro,String oldId) 
    {
        boolean ok=false;  
        try
            
        {
          ResultSet res;
          
          PreparedStatement stmt= this.conn.prepareStatement("call modifyProducto(?,?,?,?,?,?)");
          
           stmt.setString(1, pro.getId());
           stmt.setString(2, pro.getNombre());
           stmt.setString(3, pro.getNomFoto());
           stmt.setInt(4, pro.getPrecio());
           stmt.setInt(5, pro.getExistencias());       
           stmt.setString(6, oldId);
           
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
     
    
    public boolean eliminarProducto(String id) 
   {
                
                
                
                    boolean ok=false;
        
        try
        {
            
             PreparedStatement stmt=this.conn.prepareStatement("call DeleteProducto(?)");
             
             stmt.setString(1, id);
             stmt.execute();
             ok=true;       
              System.out.println("este");
        }
        catch(SQLException ex)
                {
                    System.out.println(ex);
                   
                }
        
        
        return ok;
                
   }
    
}
