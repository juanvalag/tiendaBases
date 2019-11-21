<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>

<section class="Carro">
    <div>${mensaje}</div>
    <header>
        <h1>Carrito de Compras</h1>
        <p>Los productos no seleccionados no serán parte de la compra: </p>
    </header>
    <form action="/tiendaBases/productos/ventas"  method = "POST"> 
        <table class="blueTable">
            <thead>
        <th>Foto</th>
        <th>Nombre</th>       
        <th>Precio de Venta</th>
        <th>Cantidad </th>
        </thead>
    <tbody>
        <%
            int total=0;
            ArrayList<Producto> temp = (ArrayList) request.getAttribute("productos");
                String objetojs = "[";
         for(int i=0;i<temp.size();i++){
            total+=temp.get(i).getPrecioVenta();
objetojs += "{\"id\":\"" + temp.get(i).getId() + "\",\"precioVenta\":\"" + temp.get(i).getPrecioVenta() + "\",\"cantidad\": 1}";
                 if (i < temp.size() - 1) {
        objetojs += ",";
    }
        %>
            <tr>
                <td><img src="/tiendaBases/Recursos/img/food_and_drinks/<%=temp.get(i).getNomFoto()%>" alt="<%=temp.get(i).getNombre()%>" ></td>
                <td><%=temp.get(i).getNombre()%></td>
                <td><%=temp.get(i).getPrecioVenta()%></td>
                <td>
                     <input type="number"  value="1" min="1" id="<%=temp.get(i).getId()%>" 
                            name="<%=temp.get(i).getId()%>" max="<%=temp.get(i).getExistencias()%>" oninput="cambioCanti(this)"><br><br>
                </td>
                <td>
                    <input type="checkbox" value="<%=temp.get(i).getId()%>" name="seleccionados" checked><br><br>
                </td>
                 
            </tr>
            
            <% }
                objetojs += "]";
            %>
                </tbody>
                
    </table>
              <section >
                  Total:<p id="total"><%= total %></p>
                  <input type="hidden" name="valorTotal" id="totalServlet" value="<%= total%>">
              </section>
              <label>Desea comprar a credito: </label><input type="checkbox"  name="select" value="true"><br>
              <input type="submit" name="seleccion"  value="Comprar"><br>
              <section id="datos">
            <% for (Producto pro : temp) {%>  
            <input type="hidden" name="productos" class="<%=pro.getId()%>" 
                   value="<%=pro.getId()%>">
            <% }%>
        </section>

    </form>
            <div style="display: none;" id="objetojs">
                <%=objetojs%>
            </div>
</section> 

              
</div>
<script src="/tiendaBases/Recursos/JS/CompraDeCLi.js"></script>
</body>


