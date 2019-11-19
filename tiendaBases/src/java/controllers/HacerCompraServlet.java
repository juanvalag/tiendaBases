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
@WebServlet(name = "HacerCompraServlet", urlPatterns = {"/compras/comprar"})
public class HacerCompraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionProveedor gp = new GestionProveedor();
        GestionProducto gproduct = new GestionProducto();
        ArrayList<Proveedor> allProves = gp.getTodos();
        ArrayList<Producto> productos = gproduct.getTodos();
        String url = "", mensaje = "";
        if (allProves.size() > 0) {
            if (productos.size() > 0) {
                request.setAttribute("proveedores", allProves);
                request.setAttribute("productos", productos);
                url = "/hacerCompra.jsp";
            } else {
                mensaje = "No se ha creado ningún Producto";
                url = "/productos/crearProducto";
            }
        } else {
            mensaje = "No se ha creado ningún proveedor";
            url = "/proveedores/crearProveedor";
        }
        request.setAttribute("mensaje", mensaje);
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
