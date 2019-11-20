<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="Layouts/navigationBar.jsp"/>
<section class="verProveedores">

    <table class="blueTable">
        <thead>
        <th>Identificador</th>
        <th>Nombre</th>
    </thead>
    <tbody>
        <c:forEach var="tempProve" items="${proveedores}">
            <tr>
                <td>${tempProve.getId()}</td>
                <td>${tempProve.getNombre()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

</body>
</html>
