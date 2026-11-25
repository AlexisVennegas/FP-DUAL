
// Selecciona los siguientes elementos:

// BUTTON INICIAR
const buttonJugar = document.getElementById("btnInicio");

// INPUT PARA LAS COLUMNAS 
const inputColumnas = document.getElementById("numColumnas");

// INPUT PARA LAS FILAS
const inputFilas = document.getElementById("numFilas");

// FORMULARIO DONDE SE ENCUENTRAN LOS INPUTS FILAS Y COLUMNAS 
const formFilasColumnas = document.getElementById("formFilasColumnas");

// FORMULARIO PARA LAS IMAGENES DEL MEMORY
const formParejas = document.getElementById("formParejas");

// contenedor de las imagenes
const divGaleria = document.getElementById("galeria");


// DECLARAR VARIABLES: 

// NUMERRO DE FILAS QUE EL USUARIO INTRODUCE
let nF;

// NUMERO DE COLUMNAS QUE EL USUARIO INTRODUCE
let nC;

// UN ARRAY QUE CONTIENE LOS DATOS DE LAS IMAGENES QUE SE USARAN EN EL JUEGO con 3 elementos .palabra .imgDescargada y .urlimagenDescargada: 
let parejas = [];


// NUMERO DE IMAGENES DESCARGADAS CORRECTAMNETE
let nImagenesDescargadas;

// INDICADOR DE SI HAY UNA PARTIDA EN CURSO O NO, PARA QUE NO SE PUEDA INICIAR OTRA PARTIDA MIENTRAS HAYA UNA EN CURSO
let partidaEnCurso = false;


// PASO 2: EVENTO DOMCONTENTLOADES

document.addEventListener("DOMContentLoaded", function () {
    // TENEMOS QUE OCULTAR EL BUTTON DE JUGAR 
    buttonJugar.style.visibility = "hidden";
})

    // PASO 2.2 INABILITAR EL EVENTO SUBMIT DEL FORMULARIO DE FILAS Y COLUMNAS PARA QUE NO SE RECARGUE LA PAGINA
    // tambien se inabilitan el form de imagenes para que no se recargue la pagina al hacer submit
    formFilasColumnas.addEventListener("submit", function (event) {
            event.preventDefault();
        });
        formParejas.addEventListener("submit", function (event) {
            event.preventDefault();
        });




 // PASO 3 EVENTO CHANGE EN LOS INPUT PARA VALIDAR Y DEMAS COSAS
    inputFilas.addEventListener("change", (e) => {
        if(validarDato(e)) nF = e.target.value;
    });
    inputColumnas.addEventListener("change", (e) => {
        if(validarDato(e)) nC = e.target.value;
    }); 


    // EL ULTIMO INPUT ES QUE VALIDA AMBOS INPUTS Y SI EL PRODUCTO DE AMBOS ES PAR, SI NO LO ES MUESTRA UN ALERT
    inputFilas.addEventListener("change", () => {    
        nC = inputColumnas.value;
        nF = inputFilas.value;
        if(nF * nC % 2 != 0) {
            alert("no es numero par, no se puede jugar");
            inputFilas.value = "";
        }
    
    });




    
    


// FUNCIONES EXTRA PROPIAS

// VALIDAR INPUTS QUE SEAN DE TIPO NUMERICO Y QUE SEA UN RANGO DE 1 Y 6 
function validarDato(e) {
       // verificar que sea numerico o si es texto
       if(isNaN(e.target.value)){
        alert("el valor introducido no es un numero");
        e.target.value = "";
        return false;
       }
       // VERTIFICAR QUE ESTE EN UN RANG ODE 1 A 6
       if(e.target.value < 1 || e.target.value > 6){
        alert("el valor introducido no esta en el rango de 1 a 6");
        e.target.value = "";
        return false;
       }
       return true;
}