/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionCompra;
import gestores.GestionproductoCompra;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 *
 * @author USUARIO
 */
@WebServlet(
        name = "verTodosCompra",
        urlPatterns = {"/compras/todos"}
)
public class verTodosCompraServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionCompra gcomp = new GestionCompra();
        GestionproductoCompra gpc = new GestionproductoCompra();
        ArrayList<Compra> compras = gcomp.getTodas();
        for (Compra comp : compras) {
            ArrayList<Producto> productos = gpc.getProductoCompra(comp.getId());
            request.setAttribute(comp.getId(), productos);
        }
        request.setAttribute("compras", compras);
        this.getServletContext().getRequestDispatcher("/verTodosCompra.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
