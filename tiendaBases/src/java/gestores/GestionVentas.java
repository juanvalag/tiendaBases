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
    public boolean guardaVenta(Venta v)    {
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

    public ArrayList getTodas(String id) {
        ArrayList<Venta> ventas = new ArrayList();
        try {
            //String id, String proveedor, String fecha, int valorT, int saldoRes
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getAllVenta(?)");
            preparador.setString(1, id);
            contenedorEjecucion = preparador.executeQuery();
            while (contenedorEjecucion.next()) {
                ventas.add(new Venta(contenedorEjecucion.getString("idVenta"), contenedorEjecucion.getString("Cliente"),
                        contenedorEjecucion.getString("Fecha"),
                        contenedorEjecucion.getInt("valorTotal"), contenedorEjecucion.getInt("SaldoRestante")));
            }

            contenedorEjecucion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ventas;

    }

    public ArrayList getDeudas(String id) {
        ArrayList<Venta> ventas = new ArrayList();
        try {
            //String id, String proveedor, String fecha, int valorT, int saldoRes
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getDeudasCliente(?)");
            preparador.setString(1, id);
            contenedorEjecucion = preparador.executeQuery();
            while (contenedorEjecucion.next()) {
                ventas.add(new Venta(contenedorEjecucion.getString("idVenta"), contenedorEjecucion.getString("Cliente"),
                        contenedorEjecucion.getString("Fecha"),
                        contenedorEjecucion.getInt("valorTotal"), contenedorEjecucion.getInt("SaldoRestante")));
            }

            contenedorEjecucion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ventas;

    }

    public boolean actualizaSaldoCliente(String idUser, String idv, int abono) {
        boolean ok = false;
        try {
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call actualizaSaldoCliente(?,?,?)");
            preparador.setString(1, idUser);
            preparador.setString(2, idv);
            preparador.setInt(3, abono);
            contenedorEjecucion = preparador.executeQuery();
            contenedorEjecucion.close();
            ok = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ok;

    }


  
}
