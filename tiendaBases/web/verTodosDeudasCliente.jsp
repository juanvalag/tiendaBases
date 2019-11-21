<%@page import="model.Venta"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verTodosProductos">
    <form action="/tiendaBases/usuario/deudas" method="POST">
        <table class="blueTable">
        <thead>
        <th>Identificador</th>
        <th>Fecha</th>
        <th>Valor Total</th>     
        <th>Saldo Restante</th>
        <th>Abono</th>
        </thead>
    <tbody>
        <% ArrayList<Venta> ventas = (ArrayList) request.getAttribute("deudas");
            for (Venta temp : ventas) {
        %>
            <tr>
                <td><%=temp.getId()%></td>
                <td><%=temp.getFecha()%></td>
                <td><%=temp.getValorTotal()%></td>
                <td><%=temp.getDeuda()%></td>
                <td><input type="number" name="abonos" value="0" min="0" max="<%=temp.getDeuda()%>"></td>
            </tr>
            
            <% } %>
        </tbody>
        </table>
        <section>
            <% for (Venta temp : ventas) {%>
            <input type="hidden" name="ids" value="<%=temp.getId()%>">
            <%}%>
        </section>
            <input type="submit" value="Enviar Abonos">

    </form>
    <section>
        ${mensaje}
    </section>
</section> 

</div>


