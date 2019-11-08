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
                            <li><a href="/productos">Productos</a></li> 
                            <div class="linkProducDeslis">    
                                <li><a href="/productos/ventas">Carrito de Compra</a></li> 
                                <li><a href="/productos/todos">Ver Productos</a></li> 
                            </div>
                        </div> 
                        <div class="linkVentaContendor">
                            <li><a href="/productos">Productos</a></li> 
                            <div class="linkVentaDeslis">    
                                <li><a href="/usuario/ventas">Productos Comprados</a></li> 
                                <li><a href="/usuario/deudas">Deudas</a></li> 
                            </div>
                        </div> 
                    </c:if>
                    <c:if test="${admin}">
                        <div class="linkProducContendor">
                        <li><a href="/productos">Productos</a></li> 
                        <div class="linkProducDeslis">
                            <li><a href="/productos/operaciones">Operaciones</a></li> 
                                <li><a href="/productos/todos-admin">Ver Productos</a></li> 
                        </div>
                        </div>
                        <div class="linkProveeContendor">
                                <li><p>Proveedores</p></li> 
                                <div class="linkProveeDeslis">
                                    <li><a href="/proveedores/operaciones">Añadir</a></li>   
                                    <li><a href="/proveedores/todos">Ver Proveedores</a></li>
                                </div>
                        </div>
                        <div class="linkCompraContendor">
                                    <li><p>Compras Productos</p></li> 
                                    <div class="linkCompraDeslis">
                                        <li><a href="/compras/operaciones">Comprar</a></li>   
                                        <li><a href="/proveedores/todos">Ver Compras</a></li>
                                        <li><a href="/proveedores/deudas">Deudas</a></li>
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

        <%--   <div id="header-wrapper" className={classes.wrapper}>
            <header className={classes.header}>
                <div className={classes.logo} >
                    <img alt="" src="img/papel-airplane-icon.png" />
                    <img className={classes.logo_name} alt="" src="img/readme-name.png" />
                    {/*  <img alt="" src={require("../../img/papel-airplane-icon.png")} />
                    <img className={classes.logo_name} alt="" src={require("../../img/readme-name.png")} /> */}
                </div>

                <nav className={classes.nav}>
                    <ul className={classes.ulnav}>
                        <li>
                            <Link to="/">Inicio</Link>
                        </li>
                        <li>
                            <Link to="/">Top Libros</Link>
                        </li>
                        <li>
                            <Link to="/session/sign-in">Iniciar Sesión</Link>
                        </li>
                        <li>
                            <input type="text" placeholder="¿Qué estás buscando?" />
                        </li>
                        <li>
                            <a href="/">Sobre Nosotros</a>
                        </li>
                    </ul>
                </nav>
            </header>
            {userNav}
        </div>


        .header{
        background: #D52349;
        width: 100%;
        height: 66px;
        }

        .wrapper{
        width: 100%;
        position: fixed;
        top:0;
        }

        .logo{
        width: 20%;
        float: left;
        display: flex;
        justify-content: center;
        align-items: center;
        }

        .logo_name{

        width: 50%;
        }



        .nav{
        width: 80%;
        height: 100%;
        text-align: center;
        float: left;
        }


        nav ul{
        width: 100%;
        height: 100%;
        margin:0;
        padding: 0;
        list-style:none;


        }

        .ulnav a{
        font-size: initial;
        width: 99.7%;
        color: #fff;
        display: block;
        height: inherit;
        line-height: 58px;
        text-decoration: none;
        text-align: center;
        letter-spacing: 2px;
        position: relative;
        }

        .ulnav{
        float: left;
        vertical-align: top; 

        }

        .ulnav li{
        position: relative;
        display: flex;
        justify-content: center;
        align-items: center;
        }

        .ulnav > li { 
        width: 19.89%;
        height: 92.5%;
        float: left; 
        border-bottom: 4px #fff solid; 
        margin-right: 1px;
        }


        .ulnav li:hover{
        border-bottom-color: #EEEEEE;
        }

        .ulnav a:hover{
        color:#EEEEEE;
        font-size: 19px;
   }
        --%>
