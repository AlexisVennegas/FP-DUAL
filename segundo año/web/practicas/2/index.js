// TIP: el codigo java script para sonido y desaparicion es este
let contador = 0;


const imagenes = document.querySelectorAll('.imagen1, .imagen2, .imagen3, .imagen4, .imagen5, .imagen6');


// luego recorremos el array y le agregamos un evento de click a cada imagen

for (let i = 0; i < imagenes.length; i++) {
  const sonido = new Audio('../imagenes/explosion.mp3');

    imagenes[i].addEventListener('click', function() {
        // reproducimos el sonido 
        sonido.play();
       
        //nido.currentTime = 0; // esto es para que 
      
        this.src = '../imagenes/blast.avif';
        this.style.opacity = "0";
        this.style.transition = "opacity 1s ease-in-out";
        contador++;
        if (contador === imagenes.length) {
                setTimeout(() => {
        console.log("Pasó un segundo");
         for (let j = 0; j < imagenes.length; j++) {
                    imagenes[j].src = '../imagenes/globo rojo.avif';
                    imagenes[j].style.opacity = "1";
                }
                contador = 0;
        }, 2000); 

               
         
        }
    });
    // reiniciar para volver a poner todas las imagenes cuando todos se exploten
    
}