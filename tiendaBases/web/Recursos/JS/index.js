var menuActual = "";
var seccionCliente = document.getElementById("cliente");
var seccionAdmin = document.getElementById("admin");
seccionAdmin.style.display = "none";
seccionCliente.style.display = "none";
function menus() {

    if (menuActual === "cliente") {
        seccionCliente.style.display = "none";
        seccionAdmin.style.display = "block";
        menuActual = "admin";
    } else {
        seccionCliente.style.display = "block";
        seccionAdmin.style.display = "none";
        menuActual = "cliente";
    }
}

