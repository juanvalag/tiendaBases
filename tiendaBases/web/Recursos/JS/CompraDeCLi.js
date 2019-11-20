var productos= JSON.parse(document.getElementById("objetojs").innerHTML);

const anadirProducto=(e)=>{
    let check= e.target.checked;
    let id=e.target.id;
    let precio= productos.filter((produ)=>{
        if(produ.id===id){
            return produ.precioVenta;
    }
            )[0];
    let canti= document.getElementById(id).value;
    alert(check);
    let total= document.getElementById("total").innerHTML;
    if(check){
       total+=precio*canti; 
      if( document.getElementsByClassName(id)[0]){
          let hidden= document.createElement("input");
       hidden.type="hidden";
       hidden.name="productosSeleccionados";
       hidden.value=id;
       document.getElementById("datos").appendChild(hidden);
      }
    }else{
       total-=precio*canti; 
      let hiddenAeliminar= document.querySelector("input[value="+id+"]");
      document.getElementById("datos").removeChild(hiddenAeliminar);
    }
 document.getElementById("totalServlet").value=total;
   document.getElementById("total").innerHTML=total;
};

const cambioCanti(e)=>{
    let canti= e.target.value;
    let id= e.target.id;
     let total= document.getElementById("total").innerHTML;
    let precio= productos.filter((produ)=>{
        if(produ.id===id){
            return produ.precioVenta;
    }})[0];
document.getElementById("totalServlet").innerHTML=(total+=canti*precio);
 document.getElementById("total").innerHTML=(total+=canti*precio);
}