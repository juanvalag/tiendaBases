<%-- 
    Document   : crearCompra
    Created on : 8/11/2019, 05:44:59 PM
    Author     : LUZDA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
    </head>
    
    <body>
       <section>
            <header>
                <h1>Compra:</h1>
            </header>  
           
        </section>
        
        <section id="formulario">
            <form action="crearProveedor" method="POST">
                <input type="text" name="idComp" placeholder="Ingrese el ID del proveedor" ><br><br>
                <input type="text" name="nomProve" placeholder="Ingrese el Nombre del proveedor" > <br><br>
                <input type="submit" name="Crear"  value="Crear"><br>
            </form>
        </section>
        
    </body>
</html>
