const URLImagenes = "https://api.arasaac.org/api/pictograms/6964?download=false";
const URL_BUSQUEDA = "https://api.arasaac.org/api/pictograms/es/search/"
let resultado;
let palabraUsuario;
let datos;

//async = comando asincrono
async function obtenerImagenCasa(palabra, tipo, codigoImagen) {

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

            dataCasa = await resultado.blob();

            if (dataCasa === null) {
                // Forzamos la salida inmediata hacia el catch
                throw new Error("Salto a catch desde blob");
                alert("Error en el contenido");
                //                return null;
            }
            return dataCasa;
        } catch (error) {
            alert(`Error generico [${error.name}]: ${error.message} en la linea ${error.stack}`);
            console.error('Hubo un error al conectar con ARASAAC:', error);
            return null;
        }
    }
}

let boton = document.querySelector('#miBoton');

boton.onclick = async function () {

    // pediral usuario una palabra por pantalla con js promt 

    palabraUsuario = prompt("Introduce una palabra:");



    let imagenPalabra = await obtenerImagenCasa(palabraUsuario, "json", null);

    let codigoImagen = imagenPalabra[0]._id;

    let imagenObtenida = await obtenerImagenCasa(codigoImagen, "blob", codigoImagen);
    let imagenHtml = document.querySelector("img");
 
    imagenHtml.src = URL.createObjectURL(imagenObtenida);



}