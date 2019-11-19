var productos = JSON.parse(document.getElementById("productos").innerHTML);
var proveedores = document.getElementsByClassName("proves");

const anadirProductos = () => {

    let fila = document.createElement("tr");
    let productsSelect = document.getElementById("products");
    let seleccion = productsSelect.options[productsSelect.selectedIndex];
    for (let producto of productos) {
        alert("class: " + seleccion.className);
        if (seleccion.className === producto.id)
        {

            let columnaActual = "foto";
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
                    let cantidad = document.createElement("input");
                    cantidad.type = "number";
                    cantidad.min = 1;
                    cantidad.class = producto.id;
                    cantidad.value = 1;
                    cantidad.oninput = (e) => calcularSub(e);
                    cantidad.required = true;
                    td.appendChild(cantidad);
                    columnaActual = "subTotal";
                }
                else {
                    td.id = producto.id;
                    td.innerHTML = producto.precioCompra;
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
            hiddenCantidad.value = 1;
            seccionDatos.appendChild(hiddenProducto);
            seccionDatos.appendChild(hiddenCantidad);
            document.getElementById("tbody").appendChild(fila);
            break;
        }
    }
};

const calcularSub = (e) => {
    let canti = e.target.value;
    let producto = productos.filter(prod => prod.id === e.target.class)[0];
    alert(producto);
    if (canti > 0) {
        document.getElementById(producto.id).innerHTML = canti * producto.precioCompra;
    }
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