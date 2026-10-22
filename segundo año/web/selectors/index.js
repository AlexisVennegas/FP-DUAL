// juego de memory

var contador = 0;
let imagenes = document.querySelectorAll('.imagen1, .imagen2, .imagen3, .imagen4, .imagen5, .imagen6');
const sound = new Audio('../examen/imagenes/aplausos.mp3');

for(let i = 0; i < imagenes.length; i++) {
        imagenes[i].addEventListener("click", function() {
   
        console.log(imagenes[i].id);
        console.log(imagenes[i]);
        // cambiamos el src de la imagen a la imagen correspondiente
          imagenes[i].src = "../examen/imagenes/" + imagenes[i].id + ".png";
        for(let j = 0; j < imagenes.length; j++) {
            
            imagenes[j].addEventListener("click", function() {
                
                console.log(imagenes[j].id);
                console.log(imagenes[j]);
            // si son iguales y no son la misma imagen, cambiamos el src de la segunda imagen a la imagen correspondiente
            if(imagenes[i].id == imagenes[j].id && i != j) {
               imagenes[j].src = "../examen/imagenes/" + imagenes[j].id + ".png";
                sound.play();
                imagenes[i].style.transition = "opacity 0.5s";
                imagenes[j].style.transition = "opacity 0.5s";
                setTimeout(function() {
                    imagenes[i].style.opacity = 0;
                    imagenes[j].style.opacity = 0;
                }, 1000);
                contador++;
            }
            // si no son iguales y no son la misma imagen, cambiamos el src de la segunda imagen a la imagen correspondiente
            else if (imagenes[i].id != imagenes[j].id && i != j) {
                setTimeout(function() {
                    // volver a las imagenes originales
                    imagenes[i].src = "../examen/imagenes/carta memory reves.png";
                    imagenes[j].src = "../examen/imagenes/carta memory reves.png";
                }, 1000);
            }
            if(contador == 3) {
                alert("muy Bien");
                contador = 0;
            }
            });
        }
    });
}

