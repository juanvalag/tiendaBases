/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionProveedor;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;

@WebServlet(
        name ="crearProveedor" ,    
        urlPatterns = {"/crearProveedor"}   
    )
public class crearProveedor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
   
        Proveedor prove=new Proveedor(req.getParameter("idprove"),req.getParameter("nomProve"));
        
         
        new GestionProveedor().GuardaProveedor(prove);
       
                
        
        
        
       
    }
}
       
