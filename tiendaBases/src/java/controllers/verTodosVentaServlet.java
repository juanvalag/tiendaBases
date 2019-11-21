/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.GestionProductoDeVenta;
import gestores.GestionVentas;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author USUARIO
 */
@WebServlet(
        name = "verTodosVenta",
        urlPatterns = {"/usuario/ventas"}
)
public class verTodosVentaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionVentas gv = new GestionVentas();
        GestionProductoDeVenta gpv = new GestionProductoDeVenta();
        HttpSession sesion = request.getSession();
        String url = "/productos/todos", mensaje = "";
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        String id = user.getId();
        ArrayList<Venta> ventas = gv.getTodas(id);
        if (ventas.size() > 0) {
        for (Venta vent : ventas) {
            ArrayList<Producto> productos = gpv.getTodos(vent.getId());
            request.setAttribute(vent.getId(), productos);
            }
            url = "/verTodosVenta.jsp";
            request.setAttribute("ventas", ventas);
        } else {
            mensaje = "No se ha realizado ninguna compra";
            request.setAttribute("mensaje", mensaje);
        }
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
