package controllers;

import gestores.GestionProducto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Producto;

@WebServlet(
        name = "/seleccion" ,
        urlPatterns = {"/productos/todos"}
)
public class Productos_a_venderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {
        if (req.getAttribute("toInicio") == null) {
        String[] idPros = req.getParameterValues("select");
        HttpSession sesion = req.getSession();
        ArrayList<String> productos = new ArrayList();
        if (sesion.getAttribute("array") != null) {
            productos = (ArrayList) sesion.getAttribute("array");
        }
        for (String id : idPros) {
            productos.add(id);
        }
        sesion.setAttribute("array", productos);
        doGet(req, resp);
        } else {
            doGet(req, resp);
        }
    }
           @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 GestionProducto gp=new GestionProducto();
               ArrayList<Producto> pross = gp.getTodosConExis();
               HttpSession sesion = req.getSession();
               if (sesion.getAttribute("array") != null) {
                   ArrayList<String> yaAnadidos = (ArrayList) req.getSession().getAttribute("array");
                   ArrayList<Producto> paraEliminar = new ArrayList();
                   for (Producto tempPro : pross) {
                       for (String yaAnadido : yaAnadidos) {
                           if (tempPro.getId().equals(yaAnadido)) {
                               paraEliminar.add(tempPro);
                           }
                       }
                   }
                   pross.removeAll(paraEliminar);
               }
        req.setAttribute("productos", pross);
               this.getServletContext().getRequestDispatcher("/Productos_a_vender.jsp").forward(req, resp);

    }

}
