/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import gestores.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Compra;
import model.Producto;
import model.Proveedor;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "HacerCompraServlet", urlPatterns = {"/compras/comprare"})
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
        request.setAttribute("mensaje2", mensaje);
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] productos = request.getParameterValues("productos");
        String total = request.getParameter("valorTotal");
        String provee = request.getParameter("proveedor");
        String credito = request.getParameter("credito");
        String fecha = request.getParameter("fecha");
        int max = 1000;
        int min = 1;
        int rango = max - min;
        String id = "compra--" + (int) (Math.random() * rango) + min;
        GestionProductoDelProveedor gpdp = new GestionProductoDelProveedor();
        GestionCompra gc = new GestionCompra();
        GestionProducto gp = new GestionProducto();
        GestionproductoCompra gpc = new GestionproductoCompra();
        Compra compra;
        if (credito != null) {
            compra = new Compra(id, provee, fecha, Integer.parseInt(total), Integer.parseInt(total));
        } else {
            compra = new Compra(id, provee, fecha, Integer.parseInt(total), 0);
        }
        boolean guardado = gc.guardaCompra(compra);
        String url = "/compras/todos";
        String mensage = "";
        boolean guardaProduCompra = true;
        if (guardado) {
        for (String temp : productos) {
            int canti = Integer.parseInt(request.getParameter(temp));
            gpdp.guardaProduProve(temp, provee);
            guardaProduCompra = gpc.guardaProduCompra(id, temp, canti);
            boolean actualizado = gp.actualizaExistencias(temp, canti);
            if (!guardaProduCompra || !actualizado) {
                mensage = "Se creó la compra pero no se guardo los productos o no se actualizó las exitencias";
                request.setAttribute("mensaje", mensage);
                doGet(request, response);
                break;
            }
        }
        } else {
            mensage = "No se puco crear";
            request.setAttribute("mensaje", mensage);
            doGet(request, response);
        }

        if (guardaProduCompra) {

            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
