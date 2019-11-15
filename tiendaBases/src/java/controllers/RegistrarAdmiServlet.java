package controllers;

import gestores.GestionAdministrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;

@WebServlet(
        name = "RegistrarAdmin",
        urlPatterns = {"/RegistrarAdmin"}
)
public class RegistrarAdmiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //(String id, String nombre, String nomUsuario, String passw, String tipo, String nomFoto, String tel, String dir)
        Administrador donPaco = new Administrador(req.getParameter("docu"), req.getParameter("name"), req.getParameter("usename"),
                req.getParameter("password"), req.getParameter("foto"), "Administrador");
        GestionAdministrador gest = new GestionAdministrador();
        if (gest.guardaAdmi(donPaco)) {
            this.getServletContext().getRequestDispatcher("/sesion/iniciar").forward(req, resp);
        }


    }

}
