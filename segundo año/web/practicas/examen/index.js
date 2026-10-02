// juego de memory
let contenedorImagenes = document.querySelector('.galeria');
const sound = new Audio('../examen/imagenes/aplausos.mp3');





contenedorImagenes.addEventListener('click', (e) => {
    if (e.target.tagName === 'IMG') {
        e.target.classList.add('active');
        // cambiar el src
        let numeroRandom = Math.floor(Math.random() * 6) + 1;
        console.log(numeroRandom);
        e.target.src = "../examen/imagenes/" + numeroRandom + ".png";
        let imagenesActivas = document.querySelectorAll('.galeria .active');
        if (e.target.id ===  imagenesActivas[1].id ) {
            sound.play();
            setTimeout(() => {
                e.target.style.opacity = '0';
                imagenesActivas[0].style.opacity = '0';
                imagenesActivas[0].classList.remove('active');
                e.target.classList.remove('active');
            }, 500);
        }

    }   
});