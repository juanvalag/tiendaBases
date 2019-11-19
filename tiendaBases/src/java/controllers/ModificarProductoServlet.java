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
        name = "ModificarPro",
        urlPatterns = {"/productos/ModificarPro"}
    )
public class ModificarProductoServlet extends HttpServlet {
    
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
      GestionProducto gp=new GestionProducto();
      Producto pro=new Producto();
      pro=gp.BuscaProducto(req.getParameter("codElP"));
      
      req.setAttribute("producto", pro);
      req.setAttribute("existe", true);
      this.getServletContext().getRequestDispatcher("/ModificarPro.jsp").forward(req, resp);
        
    }
    
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/ModificarPro.jsp").forward(req, resp);

    }
    
}
       
