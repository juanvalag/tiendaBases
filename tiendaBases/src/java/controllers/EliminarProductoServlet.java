/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionProducto;
import gestores.GestionProductoDelProveedor;
import gestores.GestionProveedor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;

@WebServlet(
        name = "EliminarPro",
        urlPatterns = {"/productos/EliminarPro"}
    )
public class EliminarProductoServlet extends HttpServlet {
    
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       GestionProductoDelProveedor gpp=new GestionProductoDelProveedor();
       GestionProducto gp=new GestionProducto();
        boolean existe, existe2;
        
        existe=gpp.eliminarProducto(req.getParameter("codEli"));
        if(existe)
        {
             System.out.println("Eliminado");
             
            existe2=gp.eliminarProducto(req.getParameter("codEli"))
             
        }
           
        
        else
        {
             System.out.println("No Eliminado");
        }
           
        
        
    }
    
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/ModificarPro.jsp").forward(req, resp);

    }
    
}
       
