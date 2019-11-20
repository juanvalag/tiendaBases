import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import gestores.GestionAdministrador;
import gestores.GestionProducto;
import gestores.GestionProductoDeVenta;
import gestores.GestionVentas;
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
import model.Cliente;
import model.Producto;
import model.ProductoDeVenta;
import model.Venta;

@WebServlet(
        name = "/ComprarSel" ,
        urlPatterns = {"/productos/ventas"}
)
public class CompraDeCLiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException 
    {    GestionProductoDeVenta gvv=new GestionProductoDeVenta();
        GestionVentas gv=new GestionVentas();
        int max = 1000;
        int min = 1;
        int rango = max - min;
        String id = "venta--" + (int) (Math.random() * rango) + min;
       HttpSession s= req.getSession();
       GestionProducto gp=new GestionProducto();
      
       Cliente cli= (Cliente) s.getAttribute("usuario");
       String []ids= req.getParameterValues("select");
       String total = req.getParameter("totalServlet");
       String deud= req.getParameter("select");
       Venta v ;
       
   
       if(deud != null){
        v = new Venta(id,cli.getId(),req.getParameter("dia"),Integer.parseInt(total),Integer.parseInt(total));
        gv.GuardaVenta(v);
       }else{
        v = new Venta(id,cli.getId(),req.getParameter("dia"),Integer.parseInt(total),0);
        gv.GuardaVenta(v);
       }
        
       
       for(String idTemp: ids)
       {
         int cantidad= Integer.parseInt(req.getParameter(idTemp));
         
         ProductoDeVenta pv=new ProductoDeVenta (v.getId(),idTemp,cantidad);}
       
       
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
           

    

