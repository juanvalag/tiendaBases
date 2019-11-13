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
import model.Administrador;



/**
 *
 * @author LUZDA
 */
public class GestionAdministrador extends AbstractDB  

{

    public GestionAdministrador() {
        super();
    }

    public Administrador getAdmin(String nombreUs, String pass) {
        Administrador admin = null;
        try {
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getAdmin(?,?)");
            preparador.setString(1, nombreUs);
            preparador.setString(2, pass);
            contenedorEjecucion = preparador.executeQuery();
            //String id, String nombre, String nomUsuario, String passw, String nomFoto,String tipo
            while (contenedorEjecucion.next()) {
                admin = new Administrador(contenedorEjecucion.getString("idUsuario"), contenedorEjecucion.getString("Nombre"),
                        contenedorEjecucion.getString("NombreUsuario"), contenedorEjecucion.getString("Passw"), contenedorEjecucion.getString("NombreFoto"),
                        contenedorEjecucion.getString("Tipo"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return admin;
    }


    public boolean guardaAdmi(Administrador admi)    {
        boolean ok =false;
       try 
       {
           ResultSet res;

           

           PreparedStatement stmt = this.conexionSQL.prepareStatement("call newAdministrador(?,?,?,?,?,?)");
           stmt.setString(1, admi.getId());
           stmt.setString(2, admi.getNombre());
           stmt.setString(3, admi.getTipo());
           stmt.setString(4, admi.getNomFoto());
           stmt.setString(5, admi.getNomUsuario());
           stmt.setString(6, admi.getPass());


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

    
    
    
    
     public ArrayList<Administrador> getTodos() 
    
    {
        ArrayList<Administrador> admis=new ArrayList();
        try
        {
            Statement stmt = this.conexionSQL.createStatement();
            ResultSet res=stmt.executeQuery("call getAllUsuarios()");
             while(res.next())
        {
           Administrador donPaco= new Administrador();
           donPaco.setId(res.getString("idUsuario"));
           donPaco.setNombre(res.getString("Nombre"));
           donPaco.setNomFoto(res.getString("NombreFoto"));
           donPaco.setTipo(res.getString("Tipo"));
           donPaco.setNomUsuario(res.getString("NombreUsuario"));
           donPaco.setPass(res.getString("Passw"));
           
          
           admis.add(donPaco);
           
        }
            res.close();
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return admis;
        
        
        
 }
     
     

   
}
