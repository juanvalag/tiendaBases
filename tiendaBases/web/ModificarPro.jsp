<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="ModificarPro">

<form action="ModificarPro" method = "POST">   
    <input type="hidden"  name="busca" value="buscar">
 <label>Codigo de producto: </label> <input type="text" name="codElP" value="" required>  <br><br>
 <input type="submit" name="boton1" value="Buscar">
 </form>
 
      <c:if test="${existe}">
      <form action="ModificarPro" method = "POST">           
<h1> Modificar Producto</h1>	  
Identification:
<input type="text" name="idp" value="${producto.id}"  <br><br>
Nombre:
<input type= "text" name="namep" value="${producto.nombre}">  <br><br>
Foto:
<input type="text" name="fotop" value="${producto.nomFoto}">  <br><br>
Precio de venta:
<input type="number" name="preciop"   value=${producto.precioVenta }>  <br><br>
Precio de compra:
<input type="number" name="preciop"   value=${producto.precioCompra }>  <br><br>
Existencias:
<input type="number" name="exisp" value="${producto.existencias}">  <br><br>
  
<input type="submit" name="uno"  value="Modificar"><br><br><br><br>
</form>
</c:if>


    

</section>
    
    
    
</body>
 <script src="/tiendaBases/Recursos/JS/Borra.js">
        </script>
    
    
    
    
    
</section>

</body>
</html>
