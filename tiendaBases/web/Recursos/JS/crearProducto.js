

var proveedores;
const init = () => {
    proveedores = document.getElementsByClassName("proves");
};
const anadirProveedor = (event) => {
    alert("hola");
    let fila = document.createElement("tr");
    let idaAnadir = document.createElement("td");
    let nombreaAnadir = document.createElement("td");
    let id = event.target.id;
    let nombre = event.target.innerHTML;
    for (let temp of proveedores) {
        if (temp.id === id && temp.innerHTML === nombre) {
            idaAnadir.innerHTML = temp.id;
            nombreaAnadir.innerHTML = temp.innerHTML;
        }
    }
    event.target.parentNode.removeChild(event.target);
    fila.appendChild(idaAnadir);
    fila.appendChild(nombreaAnadir);
    document.getElementById("tbody").appendChild(fila);
    alert("hola");
};
window.onload = init;
