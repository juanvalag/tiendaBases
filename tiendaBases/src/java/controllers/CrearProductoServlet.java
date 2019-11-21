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

@WebServlet(
        name = "crearProducto",
        urlPatterns = {"/productos/crearProducto"})
public class CrearProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String url = "";

        if (req.getAttribute("iniciosesion") == null) {
            GestionProducto gp = new GestionProducto();
            ArrayList<Producto> productos = new ArrayList();
            productos = gp.getTodos();
            boolean existe = false;

            for (int i = 0; i < productos.size(); i++) {
                if (req.getParameter("idpro").equals(productos.get(i).getId())) {
                    existe = true;
                    req.setAttribute("mensaje2", "ya existe un codigo para ese producto ");
                    this.getServletContext().getRequestDispatcher("/crearProducto.jsp").forward(req, resp);
                    break;
                }
            }
            String mensaje = "";
            if (!existe) {
                System.out.println(req.getParameter("precio"));
                Producto pro = new Producto(req.getParameter("idpro"), req.getParameter("namepro"), req.getParameter("foto"),
                        Integer.parseInt(req.getParameter("precio")), 0, Integer.parseInt(req.getParameter("precioCompra")));

                boolean guardado = true;
                guardado = gp.guardaProducto(pro);
                    if (guardado) {
                        url = "/productos/todosAdmin";
                    } else {
                        mensaje = "no se pudo guardar el producto";
                        url = "/crearProducto.jsp";
                    }
            }
            req.setAttribute("mensaje2", mensaje);
                this.getServletContext().getRequestDispatcher(url).forward(req, resp);

        } else {
            this.doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GestionProveedor gp = new GestionProveedor();
        ArrayList<Proveedor> proves = gp.getTodos();
        req.setAttribute("proveedores", proves);
        this.getServletContext().getRequestDispatcher("/crearProducto.jsp").forward(req, resp);


    }
    
    
}