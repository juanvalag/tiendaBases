package controllers;

import gestores.GestionAdministrador;
import gestores.GestionCliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Cliente;

@WebServlet(
        name = "RegistrarAdmin",
        urlPatterns = {"/RegistrarAdmin"}
)
public class RegistrarAdmiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();


        //(String id, String nombre, String nomUsuario, String passw, String tipo, String nomFoto, String tel, String dir)
        Administrador donPaco = new Administrador(req.getParameter("docu"), req.getParameter("name"), req.getParameter("Usu"),
                req.getParameter("passw"),  req.getParameter("foto"),"Administrador");
        GestionAdministrador gest = new GestionAdministrador();
        if (gest.guardaAdmi(donPaco)) {
            System.out.println("Ya lo Guarde al admi:V");
            
        }


    }

}
