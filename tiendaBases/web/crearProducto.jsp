<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="formCreaProduct">
    <header>
                <h1>Crear un producto:</h1>
    </header>  
    <section id="formulario">
            <form action="crearProducto" method="POST">
                
                ID del producto:<input type="text" name="idpro" placeholder="Ingrese el ID del producto" ><br><br>
                Nombre del producto:<input type="text" name="namepro" placeholder="Ingrese el Nombre del producto" ><br><br>
                Foto del producto: <input type="file" name="foto" value="">  <br><br>
                Precio de la venta: <input type="number" name="precio" placeholder="Ingrese el ID del producto"><br><br>
                <label>Seleccione el proveedor a añadir: </label>
                <select name="selectProves">
                    <c:forEach var="tempProve" items="${proveedores}">
                        <option class="proves" id="${tempProve.getId()}" onClick="(e) =>alert(e);">${tempProve.getNombre()}</option>
                    </c:forEach>
                </select>
                <table>
                    <thead>
                    <th>Identificador</th>
                    <th>Nombre</th>
                    </thead>
                    <tbody id="tbody">
                    </tbody>
                </table>
                Cantidad:<input type="number" name="cant" value="0" min="0"><br><br>
                <input type="submit" name="CrearP"  value="Adicionar"><br>
            </form>
            <section>
                <p>
                    ${mensaje}
                </p>
            </section>
        </section>
</section>
</div>
<script src="/tiendaBases/Recursos/JS/crearProducto.js"></script>
</body>
</html>
