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
        <title>JSP Page</title>
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

                    Empresa:
                    <input type="radio" name="tipo" value="Empresa"> <br><br><br>


                    Foto:
                    <input type="file" name="foto" value="">  <br><br><br>


                    <div id = "show" style="display: none">           
                        Nombre de Usuario:
                        <input type="text" name="Usu" value="">  <br><br>

                        password:
                        <input type="text" name="passw" value="">  <br><br>

                    </div>



                    <input type="button" name="Registtrar" onclick="hola()" value="Registrarse"><br><br><br>

                    <input type="submit" name="Crear"  value="Crear"><br>
                    </section>
                    <section></section>
                    </div>
                    </body>
</html>
