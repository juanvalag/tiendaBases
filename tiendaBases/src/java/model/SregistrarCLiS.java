/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.IOException;
import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name ="RegistrarCLi" ,    
        urlPatterns = {"/RegistrarCLi"}   
    )
public class SregistrarCLiS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        Singleton temp =Singleton.laconstructora();
        
        
        Cliente paco=new Cliente(req.getParameter("docu"),req.getParameter("name"),
                                 req.getParameter("tipo"),req.getParameter("foto"));

        
         
        
         temp.agregarCliente(paco);
     
        

       
       
    }

}