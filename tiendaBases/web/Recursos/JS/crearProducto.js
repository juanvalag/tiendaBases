

var proveedores;
const init = () => {
    proveedores = document.getElementsByClassName("proves");
};
const anadirProveedor = () => {
    let selector = document.getElementById("proveedores");
    let seleccionado = selector.options[selector.selectedIndex];
    let fila = document.createElement("tr");
    let idaAnadir = document.createElement("td");
    let nombreaAnadir = document.createElement("td");
    let hiddenaAnadir = document.createElement("input");
    let inputPrecioAnadir = document.createElement("input");
    hiddenaAnadir.type = "hidden";
    hiddenaAnadir.name = "proveedores";
    let id = seleccionado.id;
    let nombre = seleccionado.innerHTML;
    for (let temp of proveedores) {
        if (temp.id === id && temp.innerHTML === nombre) {
            hiddenaAnadir.value = temp.id;
            idaAnadir.innerHTML = temp.id;
            nombreaAnadir.innerHTML = temp.innerHTML;
            inputPrecioAnadir.type = "number";
            inputPrecioAnadir.min = 1;
            inputPrecioAnadir.value = 1;
            inputPrecioAnadir.name = temp.id;
            inputPrecioAnadir.required = true;
            selector.removeChild(seleccionado);
            fila.appendChild(idaAnadir);
            fila.appendChild(nombreaAnadir);
            fila.appendChild(inputPrecioAnadir);
            document.getElementById("provesSeleccionados").appendChild(hiddenaAnadir);
            document.getElementById("tbody").appendChild(fila);
            break;
        }
    }

};
window.onload = init;
