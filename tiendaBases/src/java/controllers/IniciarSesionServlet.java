/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionAdministrador;
import gestores.GestionCliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
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
        String usuario = request.getParameter("usename"), pass = request.getParameter("password");
        System.out.println("use: " + usuario + "pass: " + pass);
        GestionCliente gc = new GestionCliente();
        GestionAdministrador ga = new GestionAdministrador();
        Usuario tempoCli = gc.getCliente(usuario, pass);
        String url = "";
        HttpSession sesion;
        if (tempoCli != null) {
            url = "/index.jsp";
            sesion = request.getSession();
            sesion.setAttribute("usuario", tempoCli);
            sesion.setAttribute("cliente", true);
        } else {
            Administrador tempoAdmi = ga.getAdmin(usuario, pass);
            if (tempoAdmi != null) {
                url = "/crea_producto.jsp";
                sesion = request.getSession();
                sesion.setAttribute("usuario", tempoAdmi);
                sesion.setAttribute("admin", true);
            } else {
                url = "/index.jsp";
                request.setAttribute("mensaje", "El nombre de usuario o contraseña son incorrectos");
            }
        }
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
