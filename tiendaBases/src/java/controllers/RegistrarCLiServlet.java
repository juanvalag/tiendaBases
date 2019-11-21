package controllers;

import gestores.GestionCliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet(
        name = "RegistrarCLi",
        urlPatterns = {"/sesion/RegistrarCLi"}
)
public class RegistrarCLiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //(String id, String nombre, String nomUsuario, String passw, String tipo, String nomFoto, String tel, String dir)
        Cliente paco = new Cliente(req.getParameter("docu"), req.getParameter("name"), req.getParameter("usename"),
                req.getParameter("password"), req.getParameter("tipo"), req.getParameter("foto"), req.getParameter("tel"),
                req.getParameter("dir"));
        GestionCliente gest = new GestionCliente();
        String url = "";
        if (gest.guardaCliente(paco)) {
            url = "/sesion/iniciar";
        } else {
            url = "/index.jsp";
        }

        this.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

}
