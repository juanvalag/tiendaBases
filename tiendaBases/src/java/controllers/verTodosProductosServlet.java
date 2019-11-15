/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionProducto;
import gestores.GestionProveedor;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import model.Proveedor;

/**
 *
 * @author USUARIO
 */
@WebServlet(
        name = "verTodosProveedorServlet",
        urlPatterns = {"/proveedores/todos"}
)
public class verTodosProductosServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionProducto gpro = new GestionProducto();
        ArrayList<Producto> pross = gpro.getTodos();
        request.setAttribute("productos", pross);
        this.getServletContext().getRequestDispatcher("/verTodosProductos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       GestionProducto gpro = new GestionProducto();
        ArrayList<Producto> pross = gpro.getTodos();
        req.setAttribute("productos", pross);
        this.getServletContext().getRequestDispatcher("/verTodosProductos.jsp").forward(req, resp);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
