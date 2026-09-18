const titulo = document.querySelector("#titulo");
const parrafo = document.querySelector("p");
const boton = document.getElementById("boton");

boton.addEventListener("click", function() {
    titulo.textContent = "¡Has hecho clic en el botón!";
    titulo.style.color = "blue";
    titulo.style.fontSize = "40px";
    titulo.style.backgroundColor = "lightgray";
});