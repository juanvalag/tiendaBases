<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>

<section class="verTodosProductos">
    <div id="mensaje" style="color: red;">${mensaje}</div>
    <header>
        <h1>Productos</h1>
        <p>Seleccione los productos a añadir al carrito de compra</p>
    </header>
    <form action="/tiendaBases/productos/todos"  method = "POST"> 
     <table class="blueTable">
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
                <td><img src="/tiendaBases/Recursos/img/food_and_drinks/<%=temp.getNomFoto()%>" alt="<%=temp.getNombre()%>" ></td>
                <td><%=temp.getNombre()%></td>
                <td><%=temp.getPrecioVenta()%></td>
               


                <td>
                    <input type="checkbox"  value="<%=temp.getId()%>" name="select" ><br><br>
                </td>
                
            </tr>
            
            <% } %>

    </tbody>
        
     </table>
     <input type="submit" name="seleccion"  value="añadir al carrito"><br>
     <section id="datos">
            
        </section>
         </form>
</section> 

</div>


