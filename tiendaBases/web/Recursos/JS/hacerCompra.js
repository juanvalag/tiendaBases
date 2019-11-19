var productos = JSON.parse(document.getElementById("productos").innerHTML);
var proveedores = document.getElementsByClassName("proves");
var valorTotal = 0;
const anadirProductos = () => {

    let fila = document.createElement("tr");
    let productsSelect = document.getElementById("products");
    let seleccion = productsSelect.options[productsSelect.selectedIndex];
    for (let producto of productos) {
        if (seleccion.className === producto.id)
        {

            let columnaActual = "foto";
            let cantidad = 0;
            for (let i = 0; i < 5; i++) {

                let td = document.createElement("td");
                if (columnaActual === "foto") {
                    td.innerHTML = producto.foto;
                    columnaActual = "nombre";
                } else if (columnaActual === "nombre") {
                    td.innerHTML = producto.nombre;
                    columnaActual = "precio";
                } else if (columnaActual === "precio") {
                    td.innerHTML = producto.precioCompra;
                    columnaActual = "cantidad";
                } else if (columnaActual === "cantidad") {
                    cantidad = document.getElementById("cantidad").value;
                    td.innerHTML = cantidad;
                    columnaActual = "subTotal";
                }
                else {
                    let subtotal = producto.precioCompra * cantidad;
                    td.innerHTML = subtotal;
                    anadirTotal(subtotal);
                }
                fila.appendChild(td);
            }
            productsSelect.removeChild(seleccion);
            let seccionDatos = document.getElementById("datos");
            let hiddenProducto = document.createElement("input");
            let hiddenCantidad = document.createElement("input");
            hiddenProducto.name = "productos";
            hiddenProducto.type = "hidden";
            hiddenProducto.value = producto.id;
            hiddenCantidad.name = producto.id;
            hiddenCantidad.type = "hidden";
            hiddenCantidad.value = cantidad;
            seccionDatos.appendChild(hiddenProducto);
            seccionDatos.appendChild(hiddenCantidad);
            document.getElementById("tbody").appendChild(fila);
            break;
        }
    }
};


const anadirTotal = (newValor) => {
    valorTotal += newValor;
    document.getElementById("total").innerHTML = valorTotal;
    document.getElementById("valorTotal").value = valorTotal;
};


const anadirProveedor = () => {
    let proves = document.getElementById("provesSelect");
    let seleccion = proves.options[proves.selectedIndex];
    for (let prove of proveedores) {
        if (prove.id === seleccion.id) {
            proves.disabled = true;
            let hiddenaAnadir = document.createElement("input");
            hiddenaAnadir.type = "hidden";
            hiddenaAnadir.value = prove.id;
            hiddenaAnadir.name = "proveedor";
            document.getElementById("datos").appendChild(hiddenaAnadir);
            break;
        }
    }
};