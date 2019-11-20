<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>

<section class="Carro">
 <form action="/productos/ventas"  method = "POST"> 
    <table>
        <thead>
        <th>Foto</th>
        <th>Nombre</th>       
        <th>Precio de Venta</th>
        <th>Añadir </th>
         
  
    </thead>
    <tbody>
        <%
            int total=0;
            ArrayList <Producto> temp = (ArrayList)request.getAttribute("a"); 
         for(int i=0;i<temp.size();i++){
        
        total+=temp.get(i).getPrecioVenta();
        %>
            <tr>
                <td><%=temp.get(i).getNomFoto() %></td>
                <td><%=temp.get(i).getNombre()%></td>
                <td><%=temp.get(i).getPrecioVenta()%></td>
              


                <td>
                    <input type="checkbox"  value="<%=temp.get(i).getId()%>" name="select"  checked><br><br>
                </td>
                
            </tr>
            
            <% } %>
            
              <section >
                  Total:<p><%= total %></p>
              </section>
             <input type="submit" name="seleccion"  value="añadir al carrito"><br>
             <input type="checkbox"  name="select"  checked>
        </tbody>
        
    </table>
        <section id="datos">
            
        </section>
         </form>
</section> 

</div>

