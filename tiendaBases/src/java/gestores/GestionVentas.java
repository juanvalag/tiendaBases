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
import model.Proveedor;
import model.Venta;

/**
 *
 * @author LUZDA
 */
public class GestionVentas extends AbstractDB 
{

    public GestionVentas() 
    {
        
        super();
    }
    public void cierraConexion()
    {
        try
        {
            this.conexionSQL.close();
            System.out.println("tranquilos he cerrado la conexion...!!");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public boolean GuardaVenta(Venta v) 
    {
        boolean ok =false;
       try 
       {
           ResultSet contenedorEjecucion;
           PreparedStatement preparador = this.conexionSQL.prepareStatement("call newVenta(?,?,?,?,?)");
           preparador.setString(1, v.getId());
           preparador.setString(2, v.getCliente());
           preparador.setString(3, v.getFecha());
           preparador.setFloat(4, v.getValorTotal());
           preparador.setFloat(5, v.getDeuda());
           contenedorEjecucion = preparador.executeQuery();
           contenedorEjecucion.close();
           ok=true;
           
   
       }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        

        
        return ok;

    }

    public ArrayList getTodos() {
        ArrayList<Proveedor> proveedores = new ArrayList();
        try {
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getAllProveedor()");
            contenedorEjecucion = preparador.executeQuery();
            while (contenedorEjecucion.next()) {
                proveedores.add(new Proveedor(contenedorEjecucion.getString("idProveedor"), contenedorEjecucion.getString("Nombre")));
            }

            contenedorEjecucion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return proveedores;

    }
    
  
}
