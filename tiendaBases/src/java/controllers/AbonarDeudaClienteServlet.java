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
import model.Usuario;
import model.Venta;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "AbonarDeudaCliente", urlPatterns = {"/usuario/deudas"})
public class AbonarDeudaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestionVentas gv = new GestionVentas();
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        ArrayList<Venta> deudas = gv.getDeudas(user.getId());
        String url = "", mensaje = "";
        if (deudas.size() > 0) {
            request.setAttribute("deudas", deudas);
            url = "/verTodosDeudasCliente.jsp";
            } else {
            mensaje = "No hay ninguna deuda pendiente";
            url = "/productos/todos";
            request.setAttribute("toInicio", "si");
        }
        request.setAttribute("mensaje2", mensaje);
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("iniciosesion", "si");
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        String idUsuario = user.getId();
        String[] abonos = request.getParameterValues("abonos");
        String[] ids = request.getParameterValues("ids");
        GestionVentas gv = new GestionVentas();
        String mensaje = "";
        boolean abonosExitosos = true;
        for (String abono : abonos) {
            for (String id : ids) {
                if (Integer.parseInt(abono) > 0) {
                    abonosExitosos = gv.actualizaSaldoCliente(idUsuario, id, Integer.parseInt(abono));
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
        request.setAttribute("mensaje", mensaje);
            doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
