<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<div class="formCreaUser">
                <nav class="navCreaUser">
                    <label onclick="menus()">Cliente</label>
                <label onclick="menus()">Administrador</label>
            </nav>
            <section id="cliente">
                <form action="RegistrarCLi" method = "post">  
                    <label>Nombre: </label> <input type="text" name="name" value="" required>  <br><br>
                    <label>Documento: </label> <input type="text" name="docu" value="" required>  <br><br>
                    <label> Cliente: </label> <input type="radio" name="tipo" value="Cliente" checked="true">  <br><br>
                    <label>  Empresa: </label> <input type="radio" name="tipo" value="Empresa"> <br><br>                    <label>  Foto:</label> <input type="file" name="foto" value="" required>  <br><br>
                    <label>Nombre de Usuario:</label><input type="text" name="Usu" value="" required>  <br><br>
                    <label> Contraseña: </label> <input type="password" name="passw" value="" required>  <br><br>
                    <label>Telefono:</label><input type="text" name="tel" value="" required>  <br><br>
                    <label> Direccion: </label> <input type="text" name="dir" value="" required>  <br><br>
                    <input type="submit" name="Crear"  value="Crear"><br>
                </form>
            </section>
            <section id="admin">
                <form action="RegistrarAdmin" method = "post">  
                    <label>Nombre: </label> <input type="text" name="name" value="" required>  <br><br>
                    <label>Documento: </label> <input type="text" name="docu" value="" required>  <br><br>
                    <label>  Foto:</label> <input type="file" name="foto" value="" required>  <br><br><br>
                    <label>Nombre de Usuario:</label><input type="text" name="Usu" value="" required>  <br><br>
                    <label> Contraseña:</label> <input type="password" name="passw" value="" required>  <br><br>
                    <input type="submit" name="Crear" value="Crear"><br>
                </form>
            </section>
        </div>
        </div>
        <script src="/tiendaBases/Recursos/JS/index.js">
        </script>
    </body>
</html>
