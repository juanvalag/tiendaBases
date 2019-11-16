<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verTodosProductos">

    <table>
        <thead>
        <th>Foto</th>
        <th>Identificador</th>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Existencias</th>
        <th>Proveedores</th>
        
        
    </thead>
    <tbody>
        <% ArrayList <Producto> productos = (ArrayList)request.getAttribute("productos"); 
         for(Producto temp: productos){
        %>
            <tr>
                <td><%=temp.getNomFoto() %></td>
                <td><%=temp.getId()%></td>
                <td><%=temp.getNombre()%></td>
                <td><%=temp.getExistencias()%></td>
                <td><%=temp.getPrecio()%></td>
               
                <td>
                    <ul>
               
                       <%
                       ArrayList <String> proves= (ArrayList)request.getAttribute(temp.getId());
                       for(String prove: proves){
                       %>
                       <li><%=prove%></li>
                       <% } %>
                    </ul>
                        
                </td>
            </tr>
            
            <% } %>
        </tbody>
    </table>

</section> 

</div>


