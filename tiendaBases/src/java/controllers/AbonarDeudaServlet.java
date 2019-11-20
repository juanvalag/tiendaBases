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

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "HacerCompraServlet", urlPatterns = {"/compras/deudas"})
public class AbonarDeudaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionCompra gc = new GestionCompra();
        ArrayList<Compra> deudas = gc.getDeudas();
        String url = "", mensaje = "";
        if (deudas.size() > 0) {
            request.setAttribute("deudas", deudas);
            url = "/verTodosDeudas.jsp";
            } else {
            mensaje = "No hay ninguna deuda pendiente";
                url = "/productos/crearProducto";
        }
        request.setAttribute("mensaje", mensaje);
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getAttribute("mostrar") == null) {
        String[] abonos = request.getParameterValues("abonos");
        String[] ids = request.getParameterValues("ids");
        GestionCompra gc = new GestionCompra();
        String url = "/compras/deudas", mensaje = "", muestra = "true";
        boolean abonosExitosos = true;
        for (String abono : abonos) {
            for (String id : ids) {
                if (Integer.parseInt(abono) > 0) {
                    abonosExitosos = gc.actualizaSaldoAdmin(id, Integer.parseInt(abono));
                    if (!abonosExitosos) {
                        mensaje = "No se pudo actualizar algunos registros, Intente de nuevo";
                        break;
                    }
                }
            }
        }
        if (abonosExitosos) {
            mensaje = "abonos realizados exitosamente!!!";
        }
        request.setAttribute("mensaje2", mensaje);
        request.setAttribute("mostrar", muestra);
            doGet(request, response);
        } else {
            doGet(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
