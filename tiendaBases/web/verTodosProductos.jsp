<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verTodosProductos">

    <table>
        <thead>
        <th>Foto</th>
        <th>Identificador</th>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Existencias</th>
        <th>Proveedores</th>
        
        
    </thead>
    <tbody>
        <c:forEach var="tempPros" items="${productos}">
            <tr>
                <td>${tempPros.getNomFoto() }</td>
                <td>${tempPros.getId()}</td>
                <td>${tempPros.getNombre()}</td>
                <td>${tempPros.getExistencias()}</td>
                <td>${tempPros.getPrecio()}</td>
                <td>${tempPros.getPrecio()}</td>
                <td>
                    <ul>
                        
                        <c:forEach var="temprove" items="${provedores}">
                            
                            
                            
                        </c:forEach>
                        
                    </ul>
                        
                    
                    
                    
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</section> 

</div>


