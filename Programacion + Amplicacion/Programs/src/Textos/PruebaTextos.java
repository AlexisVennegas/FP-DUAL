package Textos;

public class PruebaTextos {

    public static void main(String[] args) {
        String texto = "hola mundo";

        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());

        if (texto.length() > 2) System.out.println(texto.substring(0, 2));
        if (texto.length() > 2) System.out.println(
            texto.substring(texto.length() - 2)
        );

        int i = 0;
        int contains = 0;

        while (++i < texto.length()) {
            if (texto.charAt(i) == 'o') contains++;
        }
        System.out.println(contains);

        // • La cadena con todas las ocurrencias del primer carácter en mayúsculas.
        //
        String result = texto.replace(
            texto.charAt(0),
            Character.toUpperCase(texto.charAt(0))
        );
        System.out.println(result);
    }
}
