const button = document.getElementById('buttonChange');
let  img = document.getElementById('img');
let buttonVolver = document.getElementById('buttonChange2');

button.addEventListener('click', () => {   
    img.src = "../imagenes/jerry the mouse.png" 
})
buttonVolver.addEventListener('click', () => {
    img.src = "../imagenes/tom the cat.png"
})
