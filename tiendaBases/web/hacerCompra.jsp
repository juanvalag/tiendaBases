<%@page import="model.Proveedor"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<%
    ArrayList<Proveedor> proves = (ArrayList) request.getAttribute("proveedores");
    String objetojs = "{";
    for (int index = 0; index < proves.size(); index++) {
            Proveedor temp = proves.get(index);
        ArrayList<Producto> products = (ArrayList) request.getAttribute(temp.getId());
        objetojs += "\"" + temp.getId() + "\":[";
        for (int index2 = 0; index2 < products.size(); index2++) {
                Producto pro = products.get(index2);
            objetojs += "{\"id\":\"" + pro.getId()
                        + "\",\"nombre\":\"" + pro.getNombre() + "\",\"foto\":\"" + pro.getNomFoto()
                        + "\",\"precio\":" + pro.getPrecio() + ",\"cantidad\": 0}";
                            if (index2 < products.size() - 1) {
                                objetojs += ",";
                            }
        }
        objetojs += "]";
            if (index < proves.size() - 1) {
                objetojs += ",";
            }
    }
    objetojs += "}";
%>
<section class="hacerCompra">
    <header>
        <h1>Factura: </h1>
        <p>Selccione un proveedor para acceder a los productos de este y escoger la cantidad a comprar</p>
    </header>
    <form action="/tiendaBases/compras/comprar" method="POST">
        <label>Seleccione un proveedor: </label>
        <select>
            <option></option>
            <c:forEach var="tempProve" items="${proveedores}">
                <option id="${tempProve.id}">${tempProve.nombre}</option> 
            </c:forEach>
        </select>
        <label>Seleccione un producto: </label>
        <select>
            <option></option>
        </select>
        <table>
            <thead>
            <th>Foto</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            </thead>
            <tbody id="tbody">

            </tbody>
        </table>
    </form>
    <div id="proves" style="display: none;"><%out.print(objetojs);%></div>
</section>
    </div>
    <script src="/tiendaBases/Recursos/JS/hacerCompra.js">
        
</script>
</body>
</html>
