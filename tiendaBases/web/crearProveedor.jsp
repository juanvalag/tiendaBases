<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="formCreaProveedor">
    <header>
        <h1>Crear un Proveedor:</h1>
    </header>  

    <section id="formulario">
        <form action="crearProveedor" method="post">
            <input type="text" name="idProve" placeholder="Ingrese el ID del proveedor" required><br><br>
                <input type="text" name="nomProve" placeholder="Ingrese el Nombre del proveedor" required> <br><br>
                <input type="submit" name="Crear"  value="Crear"><br>
            </form>
    </section>
    <section>
        <p>${mensaje2}</p>
    </section>
</section>
</div>
</body>
</html>
