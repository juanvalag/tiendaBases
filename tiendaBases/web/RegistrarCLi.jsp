<%-- 
    Document   : RegistrarCLi
    Created on : 25/10/2019, 01:23:18 PM
    Author     : LUZDA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Cliente</title>
    </head>
    <body>
       
       <form action="RegistrarCLi" method = "get">  
        
        
Nombre:

<input type="text" name="name" value="">  <br><br>


Documento:
<input type="text" name="docu" value="">  <br><br>



Cliente:
<input type="radio" name="tipo" value="Cliente" checked="true">  <br><br>

Empresa:
<input type="radio" name="tipo" value="Empresa"> <br><br><br>


 Foto:
<input type="file" name="foto" value="">  <br><br><br>


<div style="display: none">
    
            
   Nombre de Usuario:
<input type="text" name="Usu" value="">  <br><br>

   password:
<input type="text" name="passw" value="">  <br><br>


    
</div>
        



<input type="submit" name="Registtrar"  value="Registrarse"><br>


    	   

        
    </body>
</html>
