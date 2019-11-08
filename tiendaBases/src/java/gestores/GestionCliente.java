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

           

           PreparedStatement stmt = this.conexionSQL.prepareStatement("call newCliente(?,?,?,?,?,?,?,?)");
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
    
    
    public Cliente getCliente(String nombreUs, String pass) {
        Cliente cli = null;
        try {
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getCliente(?,?)");
            preparador.setString(1, nombreUs);
            preparador.setString(2, pass);
            contenedorEjecucion = preparador.executeQuery();
            //String id, String nombre, String nomUsuario, String passw, String tipo, String nomFoto, String tel, String dir
            while (contenedorEjecucion.next()) {
                cli = new Cliente(contenedorEjecucion.getString("idUsuario"), contenedorEjecucion.getString("Nombre"),
                        contenedorEjecucion.getString("NombreUsuario"), contenedorEjecucion.getString("Passw"), contenedorEjecucion.getString("NombreFoto"),
                        contenedorEjecucion.getString("Telefono"), contenedorEjecucion.getString("Telefono"),
                        contenedorEjecucion.getString("Direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cli;
    }
    
    
        public ArrayList<Cliente> getTodos() 
    
    {
        ArrayList<Cliente> clientes=new ArrayList();
        try
        {
            Statement stmt = this.conexionSQL.createStatement();
            ResultSet res=stmt.executeQuery("call getAllUsuarios()");
             while(res.next())
        {
           Cliente paco= new Cliente();
           paco.setId(res.getString("idUsuario"));
           paco.setNombre(res.getString("Nombre"));
           paco.setDireccion(res.getString("Direccion"));
           paco.setTelefono(res.getString("Telefono"));
           paco.setNomFoto(res.getString("NombreFoto"));
           paco.setTipo(res.getString("Tipo"));
           paco.setNomUsuario(res.getString("NombreUsuario"));
           paco.setPass(res.getString("Passw"));
           
          
           clientes.add(paco);
           
        }
            res.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return clientes;
        
        
        
 }

}



   /* public Usuario BuscaDemandante(String id)
    {
        Usuario dema=null;
       
        try 
        {
             
         ResultSet res;
          PreparedStatement stmt= this.conexionSQL.prepareStatement("call getCliente(?)");
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
            Statement stmt=this.conexionSQL.createStatement();
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
          
          PreparedStatement stmt= this.conexionSQL.prepareStatement("call modifyCliente(?,?,?,?,?,?)");
          
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
            
             PreparedStatement stmt=this.conexionSQL.prepareStatement("call DeleteCliente(?)");
             
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
