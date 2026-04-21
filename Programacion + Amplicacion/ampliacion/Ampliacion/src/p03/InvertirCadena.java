package p03;

public class InvertirCadena {
    public static String invertir(String str) {
   
        if (str == null || str.length() <= 1)  return str;
        System.out.println(str.substring(1) + str.charAt(0));
        return invertir(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String original = "Hola Mundo";
        String invertida = invertir(original);
        System.out.println("resultado: " + invertida);
       }
}

