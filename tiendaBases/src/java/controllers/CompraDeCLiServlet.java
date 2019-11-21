package controllers;
import gestores.GestionProducto;
import gestores.GestionProductoDeVenta;
import gestores.GestionVentas;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Producto;
import model.Usuario;
import model.Venta;

@WebServlet(
        name = "/ComprarSel" ,
        urlPatterns = {"/productos/ventas"}
)
public class CompraDeCLiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 GestionProducto gp=new GestionProducto();
        HttpSession sesion = req.getSession();
        String url = "/CompraDeCLi.jsp", mensaje = "";
        if (sesion.getAttribute("array") != null) {
        ArrayList<String> ids = (ArrayList) sesion.getAttribute("array");
        ArrayList<Producto> pross = new ArrayList();
        for (String id : ids) {
            Producto pro = gp.BuscaProducto(id);
              pross.add(pro);
            }
            req.setAttribute("productos", pross);
        } else {
            url = "/productos/todos";
            mensaje = "No se ha seleccionado ningún producto";
            req.setAttribute("mensaje", mensaje);
        }
        this.getServletContext().getRequestDispatcher(url).forward(req, resp);
        
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] seleccionados = request.getParameterValues("seleccionados");
        String total = request.getParameter("valorTotal");
        String credito = request.getParameter("select");
        String patron = "yyyy-MM-dd";
        SimpleDateFormat formato = new SimpleDateFormat(patron);
        String fecha = formato.format(new Date());
        int max = 1000;
        int min = 1;
        int rango = max - min;
        String id = "venta--" + (int) (Math.random() * rango) + min;
        HttpSession sesion = request.getSession();
        Usuario cli = (Usuario) sesion.getAttribute("usuario");
        String idCliente = cli.getId();
        GestionProductoDeVenta gpdv = new GestionProductoDeVenta();
        GestionVentas gv = new GestionVentas();
        GestionProducto gp = new GestionProducto();
        Venta vta;
        if (credito != null) {
            //String id, String cliente, String fecha, int valorTotal, int deuda
            vta = new Venta(id, idCliente, fecha, Integer.parseInt(total), Integer.parseInt(total));
        } else {
            vta = new Venta(id, idCliente, fecha, Integer.parseInt(total), 0);
        }
        boolean guardado = gv.guardaVenta(vta);
        String url = "/productos/todos";
        String mensage = "";
        boolean guardaProduVenta = true;
        if (guardado) {
            for (String temp : seleccionados) {
                int canti = Integer.parseInt(request.getParameter(temp));
                guardaProduVenta = gpdv.guardaProduVentPro(id, temp, canti);
                boolean actualizado = gp.actualizaExistencias(temp, (canti * -1));
                if (!guardaProduVenta || !actualizado) {
                    mensage = "Se creó la venta pero no se guardo los productos o no se actualizó las existencias";
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

        if (guardaProduVenta) {
            request.setAttribute("mensaje", "Se realizó la compra satisfactoriamente");
            request.setAttribute("toInicio", "si");
            sesion.removeAttribute("array");
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }

    }

    }
           

    

