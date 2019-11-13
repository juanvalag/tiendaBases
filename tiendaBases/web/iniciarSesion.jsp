<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/Layouts/navigationBar.jsp"/>
<div class="loginForm">
    <form action="/tiendaBases/sesion/iniciar" method="POST">
        <label>Nombre de Usuario: </label><input type="text" name="usename" required><br>
        <label>Contraseña: </label><input type="password" name="password" required><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
</div>
</body>
</html>
