let btnInicio = document.querySelector("button");
let buttonBuscarImagenes = document.getElementById("buscarImagenes");
let inputPalabraImagen = document.getElementById("inputImagen");

let miGaleria = document.querySelector(".galeria");
let misImagenes;

var numGiradas = 0; // puede valer 0,1,2
var cartaGirada1;
var cartaGirada2;
const cartas = [];
const cartaTapada = "./carta memory reves.png";
var fin = 3;
var filas;
var columnas;

// LOGICA PARA BUSCAR LAS IMAGENES USANDO OBTENERiMAGEN DE OTR OARCHIVO
const URLImagenes = "https://api.arasaac.org/api/pictograms/6964?download=false";
const URL_BUSQUEDA = "https://api.arasaac.org/api/pictograms/es/search/"

//async = comando asincrono
async function obtenerImagen(palabra, tipo, codigoImagen) {

    let resultado;
    let palabraUsuario;
    let datos;


    if (tipo === "json") {
        try {
            //await = identifica el comando asincrono
            const respuesta = await fetch(`${URL_BUSQUEDA}${palabra}`);


            if (!respuesta.ok) {
                if (respuesta.status === 404) {
                    console.warn("No se encontró la palabra en la API.");
                    return null;
                }
                throw new Error(`Error HTTP: ${respuesta.status}`);
            }

            datos = await respuesta.json();
            if (datos === null) {
                // Forzamos la salida inmediata hacia el catch
                throw new Error("Salto a catch desde blob");
                alert("Error en el contenido");
                //                return null;
            }
            return datos
        } catch (error) {
            alert(`Error generico [${error.name}]: ${error.message} en la linea ${error.stack}`);
            console.error('Hubo un error al conectar con ARASAAC:', error);
            return null;
        }
    }
    else if (tipo === "blob") {
        try {
            //await = identifica el comando asincrono
            const resultado = await fetch(`https://api.arasaac.org/api/pictograms/${codigoImagen}?download=false`);

            if (!resultado.ok) {
                alert("Error de la API");
                // Forzamos la salida inmediata hacia el catch
                throw new Error("Salto a catch desde fetch");
                //                return null;
            }

            let datos = await resultado.blob();

            if (datos === null) {
                // Forzamos la salida inmediata hacia el catch
                throw new Error("Salto a catch desde blob");
                alert("Error en el contenido");
                //                return null;
            }
            return datos;
        } catch (error) {
            alert(`Error generico [${error.name}]: ${error.message} en la linea ${error.stack}`);
            console.error('Hubo un error al conectar con ARASAAC:', error);
            return null;
        }
    }
}


async function mostrarImagen(palabra) {

    // pediral usuario una palabra por pantalla con js promt 

    let imagenPalabra = await obtenerImagen(palabra, "json", null);

    let codigoImagen = imagenPalabra[0]._id;

    let imagenObtenida = await obtenerImagen(codigoImagen, "blob", codigoImagen);

    return imagenObtenida;


}



//Cuando inicio el juego pido el num de columnas y filas
btnInicio.onclick = async function () {
    //Muestro un prompt pidiendo el numero de columnas, max 6
    do {
        columnas = prompt("Numero de Columnas (max 6)");
    } while (isNaN(columnas) || columnas > 6 || columnas < 1);

    //Muestro un prompt pideindo el numero de filas. max 6
    //Tengo también que comprobar que filas*columnas de un numero par de cartas, si no vuelvo a pedir el numero de filas.
    let numParCartas = false;
    while (!numParCartas) {
        //Muestro un prompt pidiendo el numero de filas, max 6
        do {
            filas = prompt("Numero de Filas (max 6)");
        } while (isNaN(filas) || filas > 6 || filas < 1);
        if ((filas * columnas) % 2 === 0) numParCartas = true;
    }


    //Inicializo variables para el juego
    fin = filas * columnas / 2;

    for (let i = 0; i < fin; i++) {

        let prompUsuario = prompt("Imagen que quieres en la carta:");

        let imagen = await mostrarImagen(prompUsuario);

        if (!imagen) {
            alert("No se ha podido obtener la imagen");
            return;
        }

        // Convertimos el Blob en una URL
        let urlImagen = URL.createObjectURL(imagen);

        // Guardamos dos cartas con la misma imagen
        cartas[i] = {
                  imagen: urlImagen,
                    pareja: i
};
     cartas[i + fin] = {
    imagen: urlImagen,
    pareja: i
    };
    }
    //Mezclo las cartas escondidas
    cartas.sort(() => Math.random() - 0.5);

    //Hago desaparecer el botón
    btnInicio.style.opacity = "0";
    btnInicio.style.transition = "opacity 2s ease-in-out";


    //Hago aparecer la regilla con las imagenes
    //Modifico el DOM (el HTML) para insertar en el html la rejilla de cartas en el contenedor div con class galeria
    //Modifico el estilo de galeria para que use el numero de columnas introducidas por el usuario

    miGaleria.style.gridTemplateColumns = `repeat(${columnas}, 1fr)`;

    // Creo columnas*filas imagenes
    for (let i = 0; i < (filas * columnas); i++) {
        let nuevaImg = document.createElement("img");
        // Le asignamos sus atributos 
        nuevaImg.src = cartaTapada;

        // Añado el evento click a la imágen
        nuevaImg.onclick = function () {

            //Compruebo si no he girado todavía ninguna carta
            if (numGiradas === 0) {
                //Giro una carta y pongo al dia el estado del juego
                nuevaImg.setAttribute("src", cartas[i].imagen);
                numGiradas = 1;
                cartaGirada1 = nuevaImg;
                nuevaImg.style.pointerEvents = "none";
            } else if (numGiradas === 1) {
                nuevaImg.setAttribute("src", cartas[i].imagen);
                numGiradas = 2;
                cartaGirada2 = nuevaImg;
                nuevaImg.style.pointerEvents = "none";
                 if (numGiradas === 2) {
                // si hay dos cartas iguales las elimino
              if(cartas[Array.from(miGaleria.children).indexOf(cartaGirada1)].pareja ===
                cartas[Array.from(miGaleria.children).indexOf(cartaGirada2)].pareja) {
                    //sonido
                    let sonidoAplausos = new Audio('sonidos/aplausos.mp3');
                    sonidoAplausos.play();
                    //Desvanecer
                    cartaGirada1.style.opacity = "0";
                    cartaGirada1.style.transition = "opacity 2s ease-in-out";
                    cartaGirada2.style.opacity = "0";
                    cartaGirada2.style.transition = "opacity 2s ease-in-out";

                    //marco un acierto menos hacia el fin
                    fin = fin - 1;

                } else {
                    let sonidoFallo = new Audio('sonidos/fallo.mp3');
                    sonidoFallo.play();

                    //Espero 2 segundos y tapo las cartas
                    setTimeout(() => {
                        cartaGirada1.style.pointerEvents = "auto";
                        cartaGirada2.style.pointerEvents = "auto";

                        cartaGirada1.setAttribute("src", cartaTapada)
                        cartaGirada2.setAttribute("src", cartaTapada)

                    }, 1000);

                }
                //reseteo las varialbles
                numGiradas = 0;

            }

            }
            //compruebo si tengo dos cartas giradas y tengo que hacer algo
           

            //Compruebo si he terminado
            if (fin === 0) {
                setTimeout(() => {
                    alert("HAS TERMINADO. CIAO");
                }, 1000);

                //Borro del DOM las imagenes del contenedor div
                miGaleria.replaceChildren();

                //Vuelvo a hacer aparecer el boton de inico
                btnInicio.style.opacity = "1";
            }

        }

        // Metemos la nueva imagen al final del div galeria 
        miGaleria.appendChild(nuevaImg);
    };


};