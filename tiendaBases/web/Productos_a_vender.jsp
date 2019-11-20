<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>

<section class="verTodosProductos">
 <form action="/tiendaBases/productos/todos"  method = "POST"> 
    <table>
        <thead>
        <th>Foto</th>
        <th>Nombre</th>       
        <th>Precio de Venta</th>
        <th>Añadir </th>
        
     
       
        
        
    </thead>
    <tbody>
        <% ArrayList <Producto> productos = (ArrayList)request.getAttribute("productos"); 
         for(Producto temp: productos){
        %>
            <tr>
                <td><%=temp.getNomFoto() %></td>
                <td><%=temp.getNombre()%></td>
                <td><%=temp.getPrecioVenta()%></td>
               


                <td>
                    <input type="checkbox"  value="<%=temp.getId()%>" name="select"><br><br>
                </td>
                
            </tr>
            
            <% } %>
             <input type="submit" name="seleccion"  value="añadir al carrito"><br>
        </tbody>
        
    </table>
        <section id="datos">
            
        </section>
         </form>
</section> 

</div>


