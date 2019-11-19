<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   boolean cliente = false, admin = false;
    if (request.getSession().getAttribute("cliente") != null) {
        cliente = true;
    } else if (request.getSession().getAttribute("admin") != null) {
        admin = true;
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="/tiendaBases/Recursos/css/navigationBar.css">
        <link type="text/css" rel="stylesheet" href="/tiendaBases/Recursos/css/${"index"}.css">
        <title>${titulo}</title>
    </head>
    <body>
        <div class="navigationBar">
            <header class="navHeader"></header>
            <nav class="navBar">
                <ul>
                    <c:if test="${cliente}">
                        <div class="linkProducContendor">
                            <li><a href="/tiendaBases/productos">Productos</a></li> 
                            <div class="linkProducDeslis">    
                                <li><a href="/tiendaBases/productos/ventas">Carrito de Compra</a></li> 
                                <li><a href="/tiendaBases/productos/todos">Ver Productos</a></li> 
                            </div>
                        </div> 
                        <div class="linkVentaContendor">
                            <li><a href="/productos">Información Compras</a></li> 

                            <div class="linkVentaDeslis">    
                                <li><a href="/tiendaBases/usuario/ventas">Productos Comprados</a></li> 
                                <li><a href="/tiendaBases/usuario/deudas">Deudas</a></li> 
                            </div>
                        </div> 
                    </c:if>
                    <c:if test="${admin}">
                        <div class="linkProducContendor">
                            <li><p>Producto</p></li> 
                            <div class="linkProducDeslis">
                                <li><a href="/tiendaBases/productos/crearProducto">Crear Producto</a></li> 
                                <li><a href="/tiendaBases/productos/ModificarPro">Operaciones</a></li> 
                                <li><a href="/tiendaBases/productos/todos-admin">Ver Productos</a></li> 
                        </div>
                        </div>
                        <div class="linkProveeContendor">
                                <li><p>Proveedores</p></li> 
                                <div class="linkProveeDeslis">
                                    <li><a href="/tiendaBases/proveedores/crearProveedor">Añadir</a></li>   
                                    <li><a href="/tiendaBases/proveedores/todos">Ver Proveedores</a></li>
                                </div>
                        </div>
                        <div class="linkCompraContendor">
                                    <li><p>Compras Productos</p></li> 
                                    <div class="linkCompraDeslis">
                                        <li><a href="/tiendaBases/compras/operaciones">Comprar</a></li>   
                                        <li><a href="/tiendaBases/proveedores/todos">Ver Compras</a></li>
                                        <li><a href="/tiendaBases/proveedores/deudas">Deudas</a></li>
                                    </div>
                                </div>
                    </c:if>
                    <c:if test="${!admin && !cliente}">
                        <li><a href="/tiendaBases">Inicio</a></li>  
                        <li><a href="/tiendaBases/sesion/iniciar">Iniciar Sesión</a></li>  

                    </c:if>
                </ul>
            </nav>
        </div>
        <div class="fondo">
