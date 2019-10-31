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
    
    
    
    public boolean guardaCliente(Cliente cli)    {
        boolean ok =false;
       try 
       {
           ResultSet res;
           PreparedStatement stmt = this.conn.prepareStatement("call newCliente(?,?,?,?,?,?,?,?)");
           stmt.setString(1, cli.getId());
           stmt.setString(2, cli.getNombre());
           stmt.setString(3, cli.getTipo());
           stmt.setString(4, cli.getNomFoto());
           stmt.setString(5, cli.getTelefono());
           stmt.setString(6, cli.getDireccion());
           stmt.setString(7, cli.getNomUsuario());
           stmt.setString(8, cli.getPass());

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
    
    
    /* public Usuario BuscaDemandante(String id)
    {
        Usuario dema=null;
       
        try 
        {
             
         ResultSet res;
          PreparedStatement stmt= this.conn.prepareStatement("call getCliente(?)");
          stmt.setString(1, id);
           res=stmt.executeQuery();
   
        while(res.next())
        {
            
           dema= new Usuario();
           dema.setIdCliente(res.getString("idCliente"));
           dema.setNombre(res.getString("Nombre"));
           dema.setDireccion(res.getString("Direccion"));
           dema.setTelefono(res.getString("Telefono"));
           dema.setEmail(res.getString("email"));
          
        }
           res.close(); 
       }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        
        
        return dema;
    }

    public ArrayList<Cliente> getTodos() 
    
    {
        ArrayList<Cliente> demandantes=new ArrayList();
        try
        {
            Statement stmt=this.conn.createStatement();
            ResultSet res=stmt.executeQuery("call getAllClientes()");
             while(res.next())
        {
           Usuario dema= new Usuario();
           dema.setIdCliente(res.getString("idCliente"));
           dema.setNombre(res.getString("Nombre"));
           dema.setDireccion(res.getString("Direccion"));
           dema.setTelefono(res.getString("Telefono"));
           dema.setEmail(res.getString("Email"));
           demandantes.add(dema);
           
        }
            res.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return demandantes;
        
        
        
 }
    
    
    
      public boolean ModificaCliente(Usuario dema,String oldId) 
    {
        boolean ok=false;  
        try
            
        {
          ResultSet res;
          
          PreparedStatement stmt= this.conn.prepareStatement("call modifyCliente(?,?,?,?,?,?)");
          
           stmt.setString(1, dema.getIdCliente());
           stmt.setString(2, dema.getNombre());
           stmt.setString(3, dema.getDireccion());
           stmt.setString(4, dema.getTelefono());
           stmt.setString(5, dema.getEmail());       
           stmt.setString(6, oldId);
           
           res=stmt.executeQuery();
           res.close();
           ok=true;
           
   
       }
        catch (SQLException ex)
        {
            System.out.println("es este");
            System.out.println(ex);
        }
        
                
        
        return ok;
    }

    public boolean eliminarCliente(String id) 
   {
                
                
                
                    boolean ok=false;
        
        try
        {
            
             PreparedStatement stmt=this.conn.prepareStatement("call DeleteCliente(?)");
             
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
    
    
    
    
    */
    
}
