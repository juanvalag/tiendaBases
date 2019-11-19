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
import model.Producto;
import model.Proveedor;

@WebServlet(
        name = "ModificarPro1",
        urlPatterns = {"/productos/ModificarPro1"}
    )
public class Modifica1ProServlet extends HttpServlet {
     
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        boolean listo;
    Producto Pro = new Producto(req.getParameter("idp"),req.getParameter("namep"),req.getParameter("fotop"),
                                Integer.parseInt(req.getParameter("preciop")),Integer.parseInt(req.getParameter("exisp")) ,Integer.parseInt(req.getParameter("preciop")));
        
   listo=gp.ModificaProducto(Pro, req.getParameter("idp"));
   if(listo)
   {
       
       System.out.println("Modificado");
   }
   
   else
   {
       System.out.println("paila");
   }
    }
    
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/ModificarPro1.jsp").forward(req, resp);

    }
    
}
       
