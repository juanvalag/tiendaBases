<%@page import="model.Compra"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verTodosProductos">
    <form action="/tiendaBases/compras/deudas" method="POST">
        <table class="blueTable">
        <thead>
        <th>Identificador</th>
        <th>Fecha</th>
        <th>Valor Total</th>     
        <th>Saldo Restante</th>
        <th>Proveedor</th>
        <th>Abono</th>
        </thead>
    <tbody>
        <% ArrayList<Compra> compras = (ArrayList) request.getAttribute("deudas");
            for (Compra temp : compras) {
        %>
            <tr>
                <td><%=temp.getId()%></td>
                <td><%=temp.getFecha()%></td>
                <td><%=temp.getValorT()%></td>
                <td><%=temp.getSaldoRes()%></td>
                <td><%=temp.getProveedor()%></td>
                <td><input type="number" name="abonos" value="0" min="0" required></td>
            </tr>
            
            <% } %>
        </tbody>
        </table>
        <section>
            <% for (Compra temp : compras) {%>
            <input type="hidden" name="ids" value="<%=temp.getId()%>">
            <%}%>
        </section>
            <input type="submit" value="Enviar Abonos">

    </form>
    <section>
        ${mensaje2}
    </section>
</section> 

</div>


