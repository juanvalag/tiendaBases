<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Producto</title>
    </head>
    <body>
        <section>
            <header>
                <h1>Crear un producto:</h1>
            </header>  
        </section>
        <section id="formulario">
            <form action="crearProducto" method="POST">
                
                ID del producto:<input type="text" name="idpro" placeholder="Ingrese el ID del producto" ><br><br>
                Nombre del producto:<input type="text" name="namepro" placeholder="Ingrese el Nombre del producto" ><br><br>
                Foto del producto: <input type="file" name="foto" value="">  <br><br>
                Precio de la venta: <input type="number" name="precio" placeholder="Ingrese el ID del producto"><br><br>
                Cantidad:<input type="number" name="cant" value="0" min="0"><br><br>
                <input type="submit" name="CrearP"  value="Adicionar"><br>
                
                
            </form>
            <section>
                <p>
                    ${mensaje}
                </p>
            </section>
        </section>

    </body>
</html>
