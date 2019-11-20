<%@page import="model.Compra"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verTodosProductos">

    <table class="blueTable">
        <thead>
        <th>Identificador</th>
        <th>Fecha</th>
        <th>Valor Total</th>     
        <th>Saldo Restante</th>
        <th>Proveedor</th>
        <th>Productos</th>
    </thead>
    <tbody>
        <% ArrayList<Compra> compras = (ArrayList) request.getAttribute("compras");
            for (Compra temp : compras) {
        %>
            <tr>
                <td><%=temp.getId()%></td>
                <td><%=temp.getFecha()%></td>
                <td><%=temp.getValorT()%></td>
                <td><%=temp.getSaldoRes()%></td>
                <td><%=temp.getProveedor()%></td>


                <td>
                    <ul>
                        <%ArrayList<Producto> temppro = (ArrayList) request.getAttribute(temp.getId());
                            for (Producto pro : temppro) {
                        %>
                        <li><%=pro.getNombre()%> : <%=pro.getExistencias()%></li>
                        <% } %>
                    </ul>
                        
                </td>
            </tr>
            
            <% } %>
        </tbody>
    </table>

</section> 

</div>


