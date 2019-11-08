/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import gestores.GestionProducto;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

@WebServlet(
        name ="crearProducto" ,    
        urlPatterns = {"/crearProducto"}    )
public class CrearProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        GestionProducto gp=new GestionProducto();
        ArrayList<Producto> productos= new ArrayList();
        productos=gp.getTodos();
        boolean existe=false;
        
        for(int i=0;i<productos.size();i++)
        {
            if(req.getParameter("idpro").equals(productos.get(i).getId()))
            {
                existe=true;
                req.setAttribute("mensaje", "ya existe un codigo para ese producto ");
                this.getServletContext().getRequestDispatcher("/crearProducto.jsp").forward(req, resp);
                
                break;
            }
        }
        
        if(!existe)
        {
             Producto pro=new Producto(req.getParameter("idpro"),req.getParameter("namepro"),req.getParameter("foto"),
                                  Integer.parseInt(req.getParameter("precio")),Integer.parseInt(req.getParameter("cant")));

           gp.guardaProducto(pro);
        }
      
        
    
        
       
    }
}