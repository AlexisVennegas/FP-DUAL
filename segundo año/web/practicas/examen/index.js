let miGaleria=document.querySelector(".galeria");
var numGiradas = 0; // puede valer 0,1,2
var cartaGirada1 = 0; //puede valer 0, 1, 2,3,4 o 5
var cartaGirada2 = 0; //puede valer 0, 1, 2,3,4 o 5
const cartas = [];
const cartaTapada = "imagenes/carta memory reves.png"
var fin = 3;

var crearRejilla = document.querySelector(".crearRejilla");

crearRejilla.addEventListener("click", function() {
 
    let filas = parseInt(prompt("Introduce el número de filas:"));
    let columnas = parseInt(prompt("Introduce el número de columnas:"));

    while(filas < 1 || columnas < 1 || filas > 6 || columnas > 6 || filas * columnas % 2 !== 0) {
        alert("El número de filas y columnas debe ser mayor que 0 y el producto no puede superar 6.");
        filas = parseInt(prompt("Introduce el número de filas:"));
        columnas = parseInt(prompt("Introduce el número de columnas:"));
    }
   
    for (let i = 0; i < filas * columnas; i++) {
        let nuevaImagen = document.createElement("img");
        nuevaImagen.setAttribute("src", cartaTapada);
        nuevaImagen.setAttribute("alt", "Imagen " + (i + 1));
        miGaleria.appendChild(nuevaImagen);

    }

miGaleria.style.display = "grid";
miGaleria.style.gridTemplateColumns = `repeat(${columnas}, 1fr)`;
})
// miGaleria.style.gridTemplateRows = `repeat(${filas}, 1fr)`;




// crear la estructura de datos
//Creo la estructura de datos
cartas[0] = "imagenes/picto comer.png";
cartas[1] = "imagenes/picto saludar.jpg";
cartas[2] = "imagenes/picto saludar.jpg";
cartas[3] = "imagenes/picto jugar.png";
cartas[4] = "imagenes/picto comer.png";
cartas[5] = "imagenes/picto jugar.png";
cartas[6] = "imagenes/picto comer.png";
cartas[7] = "imagenes/picto saludar.jpg";
cartas[8] = "imagenes/picto jugar.png";



miGaleria.addEventListener("click", function (evento) {
   console.log(evento)
   if (evento.target.tagName !== "IMG") return;

   // Las imágenes se crean dinámicamente, así que se localizan al hacer clic.
   const misImagenes = miGaleria.querySelectorAll("img");
   const i = Array.from(misImagenes).indexOf(evento.target);
   if (i < 0 || i >= cartas.length || evento.target.style.opacity === "0") return;

   //Compruebo si no he girado todavÃ­a ninguna carta
   if (numGiradas === 0) {
	 //Giro una carta y pongo al dia el estado del juego
         misImagenes[i].setAttribute("src", cartas[i]);
         numGiradas = 1;
         cartaGirada1 = i; 
   } else if (numGiradas === 1) { 
         misImagenes[i].setAttribute("src", cartas[i]);
         numGiradas = 2;
         cartaGirada2 = i;
   }   
   //compruebo si tengo dos cartas giradas y tengo que hacer algo
   if ( numGiradas === 2) {
	// si hay dos cartas iguales las elimino
	if ( misImagenes[cartaGirada1].getAttribute("src") === misImagenes[cartaGirada2].getAttribute("src") ) {
	  //sonido
          let sonidoAplausos = new Audio('sonidos/aplausos.mp3');
          sonidoAplausos.play();
          //Desvanecer
          misImagenes[cartaGirada1].style.opacity = "0";
          misImagenes[cartaGirada1].style.transition = "opacity 2s ease-in-out";
          misImagenes[cartaGirada2].style.opacity = "0";
          misImagenes[cartaGirada2].style.transition = "opacity 2s ease-in-out";
          
          //marco un acierto menos hacia el fin
          fin = fin - 1;

        } else {
          let sonidoFallo = new Audio('sonidos/fallo.mp3');
          sonidoFallo.play();
          //Espero 2 segundos y tapo las cartas
          setTimeout(() => {
             misImagenes[cartaGirada1].setAttribute("src", cartaTapada)
             misImagenes[cartaGirada2].setAttribute("src", cartaTapada)
          }, 2000);

	}
        //reseteo las varialbles
        numGiradas = 0;

   }          
//Compruebo si he terminado
   if (fin === 0) {
      alert("HAS TERMINADO. CIAO");
   }
 
});