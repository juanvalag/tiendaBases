/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionAdministrador;
import gestores.GestionCliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/sesion/iniciar"})
public class IniciarSesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        this.getServletContext().getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        HttpSession sesion = request.getSession();
        
        
        GestionCliente gest = new GestionCliente();
        GestionAdministrador gest2 = new GestionAdministrador();
        
     
        
        
//        Usuario usu =new Usuario(request.getParameter("usename"),request.getParameter("password"));
//        sesion.setAttribute("usuario", usu);
      
        
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
