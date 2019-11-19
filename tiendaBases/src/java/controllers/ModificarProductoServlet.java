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
     String url="/ModificarPro.jsp";
        if(req.getParameter("busca")!= null){
      GestionProducto gp=new GestionProducto();
      Producto pro=new Producto();
      
      pro=gp.BuscaProducto(req.getParameter("codElP"));
      if(pro!=null)
      {
          req.setAttribute("producto", pro);
      req.setAttribute("existe", true);
      }
        }else
{      GestionProducto gp=new GestionProducto();
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
    this.getServletContext().getRequestDispatcher(url).forward(req, resp);
      
      
        
    }
    
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/ModificarPro.jsp").forward(req, resp);

    }
    
}
       
