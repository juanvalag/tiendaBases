package controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import gestores.GestionAdministrador;
import gestores.GestionProducto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
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
          GestionProducto gp=new GestionProducto();
          String[ ] idPros = req.getParameterValues("select");    
          HttpSession sesion=req.getSession();
          sesion.setAttribute("array", idPros);
          ArrayList<Producto>pros=new ArrayList();
          
          System.out.println(idPros.length);
          String url="CompraDeCLi.jsp";
       

    }
           @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 GestionProducto gp=new GestionProducto();
       ArrayList<Producto>pross= gp.getTodos();
        req.setAttribute("productos", pross);
        this.getServletContext().getRequestDispatcher("/Productos_a_vender.jsp").forward(req, resp);
        
         

    }

}
