<%@page import="model.Venta"%>
<%@page import="model.Compra"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verTodosProductos">

    <header>
        <h1>Compras Realizadas</h1>
        <p>Estas son las compras que ha realizado</p>
    </header>
    <table class="blueTable">
        <thead>
        <th>Identificador</th>
        <th>Fecha</th>
        <th>Valor Total</th>     
        <th>Saldo Restante</th>
        <th>Productos</th>
    </thead>
    <tbody>
        <% ArrayList<Venta> ventas = (ArrayList) request.getAttribute("ventas");
            for (Venta temp : ventas) {
        %>
            <tr>
                <td><%=temp.getId()%></td>
                <td><%=temp.getFecha()%></td>
                <td><%=temp.getValorTotal()%></td>
                <td><%=temp.getDeuda()%></td>


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


