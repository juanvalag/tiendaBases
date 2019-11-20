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
            String objetojs = "";
         for(int i=0;i<temp.size();i++){
            total+=temp.get(i).getPrecioVenta();
        
        %>
            <tr>
                <td><%=temp.get(i).getNomFoto() %></td>
                <td><%=temp.get(i).getNombre()%></td>
                <td><%=temp.get(i).getPrecioVenta()%></td>
                <td>
                     <input type="number"  value="1" min="1" id="<%=temp.get(i).getId()%>" 
                            name="<%=temp.get(i).getId()%>" oninput="cambioCanti(e)"><br><br>
                </td>
                <td>
                    <input type="checkbox"  value="<%=temp.get(i).getId()%>" name="select" checked><br><br>
                </td>
                 
            </tr>
            
            <% } 
            %>
                </tbody>
                
    </table>
              <section >
                  Total:<p id="total"><%= total %></p>
                  <input type="hidden" id="totalServlet" value="<%= total %>">
              </section>
             <input type="submit" name="seleccion"  value="Comprar"><br>
             <label>Deuda:</label><input type="checkbox"  name="select" value="true"  checked>
    
        
        <section id="datos">
        <% for(int i=0;i<temp.size();i++){ %>  
        <input type="hidden" name="productosSeleccionados" class="<%=temp.get(i).getId()%>" 
               value="<%=temp.get(i).getId()%>">
        <% }%>
        </section>
             <div id="objetojs">
                 <%=objetojs%>
             </div>
              
         </form>
</section> 

              
</div>
<script src="/tiendaBases/Recursos/JS/CompraDeCLi.js"></script>
</body>


