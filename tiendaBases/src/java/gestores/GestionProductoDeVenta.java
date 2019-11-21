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
import model.Producto;

public class GestionProductoDeVenta extends AbstractDB {


public GestionProductoDeVenta(){
    super();
}

    public boolean guardaProduVentPro(String Vent, String Pro, int Cant) {
        boolean ok = false;
        try {
            ResultSet res;

            PreparedStatement stmt = this.conexionSQL.prepareStatement("call newProduVenta(?,?,?)");
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

    public ArrayList<Producto> getTodos(String id)    
    {
        ArrayList<Producto> npps = new ArrayList();
        try
        {
            PreparedStatement stmt = this.conexionSQL.prepareStatement("call getProducVenta(?)");
            stmt.setString(1, id);
            ResultSet res= stmt.executeQuery();
            
            
             while(res.next())
        {
            Producto temp = new Producto();
            temp.setNombre(res.getString("Nombre"));
            temp.setExistencias(res.getInt("Cantidad"));
 
            npps.add(temp);
           
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