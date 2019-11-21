var productos = JSON.parse(document.getElementById("objetojs").innerHTML);
var total = document.getElementById("total").innerHTML;

const cambioCanti = (e) => {

    let id = e.id;
    let producto = productos.find(produ => produ.id === id);
    let canti = e.value;
    let precio = producto.precioVenta;
    total -= precio * producto.cantidad;
    total += canti * precio;
    producto.cantidad = canti;
    document.getElementById("totalServlet").innerHTML = total;
    document.getElementById("total").innerHTML = total;
};