<%-- 
    Document   : index
    Created on : 21-oct-2019, 14:03:59
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <div>
            <nav>
                <button>Iniciar Sesión</button>
                <button>Registrarse</button>
            </nav>
            <section>
                <form action="RegistrarCLi" method = "post">  
                    <label>Nombre: </label> <input type="text" name="name" value="">  <br><br>
                    <label>Documento: </label> <input type="text" name="docu" value="">  <br><br>
                    <label> Cliente: </label> <input type="radio" name="tipo" value="Cliente" checked="true">  <br><br>
                    <label>  Empresa: </label> <input type="radio" name="tipo" value="Empresa"> <br><br>                    <label>  Foto:</label> <input type="file" name="foto" value="">  <br><br>
                    <label>Nombre de Usuario:</label><input type="text" name="Usu" value="">  <br><br>
                    <label> Contraseña: </label> <input type="password" name="passw" value="">  <br><br>
                    <label>Telefono:</label><input type="text" name="Usu" value="">  <br><br>
                    <label> Direccion: </label> <input type="text" name="passw" value="">  <br><br>
                    <input type="submit" name="Crear"  value="Crear"><br>
                </form>
            </section>
            <section>
                <form action="RegistrarAdmin" method = "post">  
                    <label>Nombre: </label> <input type="text" name="name" value="">  <br><br>
                    <label>Documento: </label> <input type="text" name="docu" value="">  <br><br>
                    <label>  Foto:</label> <input type="file" name="foto" value="">  <br><br><br>
                    <label>Nombre de Usuario:</label><input type="text" name="Usu" value="">  <br><br>
                    <label> password:</label> <input type="password" name="passw" value="">  <br><br>
                    <input type="submit" name="Crear" value="Crear"><br>
                </form>
            </section>
        </div>
        <script src="/tiendaBases/Recursos/JS/index.js"></script>
    </body>
</html>
