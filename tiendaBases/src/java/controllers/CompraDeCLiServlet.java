import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import gestores.GestionAdministrador;
import gestores.GestionProducto;
import java.io.IOException;
import java.util.*;
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
        name = "/ComprarSel" ,
        urlPatterns = {"/productos/ventas"}
)
public class CompraDeCLiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {
      
        

    }
           @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 GestionProducto gp=new GestionProducto();
        HttpSession sesion=req.getSession();
          String[]pros=(String[])sesion.getAttribute("array");
          req.setAttribute("a", pros);
            ArrayList<Producto>pross=new ArrayList();
        
          for(int i=0;i<pros.length;i++)
          {
              Producto pro=new Producto();
              pro=gp.BuscaProducto(pros[i]);
              pross.add(pro);
          }
          req.setAttribute("a", pross);
          
          
          
          
          
          
          
        this.getServletContext().getRequestDispatcher("/CompraDeCLi.jsp").forward(req, resp);
        
         

    }

}
