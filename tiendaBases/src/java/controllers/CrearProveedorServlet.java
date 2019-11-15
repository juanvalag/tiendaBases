/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionProveedor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;

@WebServlet(
        name = "crearProveedor",
        urlPatterns = {"/proveedores/crearProveedor"}
    )
public class CrearProveedorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/crearProveedor.jsp").forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Proveedor prove = new Proveedor(req.getParameter("idProve"), req.getParameter("nomProve"));
        GestionProveedor gp = new GestionProveedor();
        boolean guardado = gp.GuardaProveedor(prove);
        String url = "";
        if (guardado) {
            url = "/proveedores/todos";
        } else {
            url = "/crearProveedor.jsp";
            req.setAttribute("mensaje", "No se pudo Guardar en la base de datos");
        }
        this.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
       
