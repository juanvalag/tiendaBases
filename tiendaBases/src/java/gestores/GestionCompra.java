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
import model.Compra;

/**
 *
 * @author LUZDA
 */
public class GestionCompra extends AbstractDB 
{

    public GestionCompra() 
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
    public boolean guardaCompra(Compra comp) {
        boolean ok =false;
       try 
       {
           ResultSet contenedorEjecucion;
           PreparedStatement preparador = this.conexionSQL.prepareStatement("call newCompra(?,?,?,?,?)");
           preparador.setString(1, comp.getId());
           preparador.setString(2, comp.getFecha());
           preparador.setInt(3, comp.getValorT());
           preparador.setInt(4, comp.getSaldoRes());
           preparador.setString(5, comp.getProveedor());
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

    public ArrayList getTodas() {
        ArrayList<Compra> compras = new ArrayList();
        try {
            //String id, String proveedor, String fecha, int valorT, int saldoRes
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getAllCompra()");
            contenedorEjecucion = preparador.executeQuery();
            while (contenedorEjecucion.next()) {
                compras.add(new Compra(contenedorEjecucion.getString("idCompra"), contenedorEjecucion.getString("Proveedor"),
                         contenedorEjecucion.getString("Fecha"),
                        contenedorEjecucion.getInt("valorTotal"), contenedorEjecucion.getInt("SaldoRestante")));
            }

            contenedorEjecucion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return compras;

    }
    
    public ArrayList getDeudas() {
        ArrayList<Compra> compras = new ArrayList();
        try {
            //String id, String proveedor, String fecha, int valorT, int saldoRes
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call getDeudas()");
            contenedorEjecucion = preparador.executeQuery();
            while (contenedorEjecucion.next()) {
                compras.add(new Compra(contenedorEjecucion.getString("idCompra"), contenedorEjecucion.getString("Proveedor"),
                        contenedorEjecucion.getString("Fecha"),
                        contenedorEjecucion.getInt("valorTotal"), contenedorEjecucion.getInt("SaldoRestante")));
            }

            contenedorEjecucion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return compras;

    }

    public boolean actualizaSaldoAdmin(String idc, int abono) {
        boolean ok = false;
        try {
            ResultSet contenedorEjecucion;
            PreparedStatement preparador = this.conexionSQL.prepareStatement("call actualizaSaldoAdmin(?,?)");
            preparador.setString(1, idc);
            preparador.setInt(2, abono);
            contenedorEjecucion = preparador.executeQuery();
            contenedorEjecucion.close();
            ok = true;

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return ok;

    }

}
