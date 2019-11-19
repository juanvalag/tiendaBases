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
        ArrayList<Proveedor> allProves = gp.getTodos();
        String url = "", mensaje = "";
        if (allProves.size() > 0) {
            GestionProducto gproduct = new GestionProducto();
            ArrayList<Proveedor> provesaEnviar = new ArrayList();
            for (Proveedor temp : allProves) {
                ArrayList<Producto> productosDelProve = gproduct.getProductosProve(temp.getId());
                if (productosDelProve.size() > 0) {
                    provesaEnviar.add(temp);
                    request.setAttribute(temp.getId(), productosDelProve);
                }
            }
            request.setAttribute("proveedores", provesaEnviar);
            url = "/hacerCompra.jsp";
        } else {
            mensaje = "No se ha creado ningún proveedor";
            url = "/productos/crearProducto";
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
