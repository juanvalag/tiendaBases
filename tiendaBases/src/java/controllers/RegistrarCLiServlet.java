package controllers;

import gestores.GestionCliente;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

@WebServlet(
        name = "RegistrarCLi",
        urlPatterns = {"/RegistrarCLi"}
)
public class RegistrarCLiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        
        
        
        
        Cliente paco= new Cliente(req.getParameter("docu"),req.getParameter("name"),req.getParameter("tipo"),
                req.getParameter("foto"), req.getParameter("Usu"), req.getParameter("passw"));
        
       
        

    }

}
