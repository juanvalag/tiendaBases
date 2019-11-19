<%@page import="model.Proveedor"%>
<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<%

        ArrayList<Producto> productos = (ArrayList) request.getAttribute("productos");
        String objetojs = "[";
        for (int index = 0; index < productos.size(); index++) {
            Producto pro = productos.get(index);
            objetojs += "{\"id\":\"" + pro.getId()
                    + "\",\"nombre\":\"" + pro.getNombre() + "\",\"foto\":\"" + pro.getNomFoto()
                    + "\",\"precioCompra\":\"" + pro.getPrecioCompra() + "\",\"cantidad\": 0}";
            if (index < productos.size() - 1) {
                objetojs += ",";
            }
        }
            objetojs += "]";
%>
<section class="hacerCompra">
    <header>
        <h1>Factura: </h1>
        <p>Selccione un proveedor para acceder a los productos de este y escoger la cantidad a comprar</p>
    </header>
    <form action="/tiendaBases/compras/comprar" method="POST">
        <label>Seleccione un proveedor: </label>
        <select id="provesSelect" onchange="anadirProveedor()">
            <option></option>
            <c:forEach var="tempProve" items="${proveedores}">
                <option class="proves" id="${tempProve.id}">${tempProve.nombre}</option> 
            </c:forEach>
        </select>
        <label>Seleccione uno o varios productos: </label>
        <select id="products" onchange="anadirProductos()">
            <option></option>
            <c:forEach var="tempProduc" items="${productos}">
                <option class="${tempProduc.id}">${tempProduc.nombre}</option> 
            </c:forEach>
        </select>
        <input type="checkbox" name="credito"> <label>¿Desea que sea a credito la compra? </label>
        <table>
            <thead>
            <th>Foto</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>        
            <th>SubTotal</th>
        </thead>
            <tbody id="tbody">

            </tbody>
        </table>
    </form>
    <div id="productos" style="display: none;"><%out.print(objetojs);%></div>
    <section id="datos">
    </section>
</section>
    </div>
    <script src="/tiendaBases/Recursos/JS/hacerCompra.js">
    </script>
</body>
</html>
