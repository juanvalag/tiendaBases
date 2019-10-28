/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

@WebServlet(
        name ="crearProducto" ,    
        urlPatterns = {"/crearProducto_"}   
    )
public class CrearProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        Producto pro=new Producto(req.getParameter("idpro"),req.getParameter("namepro"),req.getParameter("foto"),
                                  Integer.parseInt(req.getParameter("precio")),Integer.parseInt(req.getParameter("cant")));
       
    }
}