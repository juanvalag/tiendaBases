<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="formCreaProduct">
    <header>
                <h1>Crear un producto:</h1>
    </header>  
    <section id="formulario">
        <form action="/tiendaBases/productos/crearProducto" method="POST">
            <label>ID del Producto: </label><input type="text" name="idpro" placeholder="Ingrese el ID del producto" required><br><br>
            <label>Nombre: </label><input type="text" name="namepro" placeholder="Ingrese el Nombre del producto" required><br><br>
            <label>Foto: </label> <input type="file" name="foto" value="">  <br><br>
            <label>Precio de Venta: </label> <input type="number" name="precio" min="50" placeholder="Ingrese el ID del producto" required><br><br>
            <label>Precio de Compra: </label> <input type="number" name="precioCompra" min="50" placeholder="Ingrese el ID del producto" required><br><br>
            <!-- <label>Seleccione el proveedor a a�adir: </label>
           <select name="selectProves" id="proveedores" onchange="anadirProveedor()">
                <option required>Seleccione un proveedor</option>
                    <c:forEach var="tempProve" items="${proveedores}">
                        <option class="proves" id="${tempProve.getId()}" >${tempProve.getNombre()}</option>
                    </c:forEach>
                </select>
                <table>
                    <thead>
                    <th>Identificador</th>
                    <th>Nombre</th>
                    <th>Precio de Compra</th>
                </thead>
                    <tbody id="tbody">
                    </tbody>
                </table>
                <section id="provesSeleccionados"></section>
                Cantidad:<input type="number" name="cant" value="0" min="0" required><br><br> -->
                <input type="submit" name="CrearP"  value="Adicionar"><br>
            </form>
            <section>
                <p>
                    ${mensaje2}
                </p>
            </section>
        </section>
</section>
</div>
<script src="/tiendaBases/Recursos/JS/crearProducto.js"></script>
</body>
</html>
