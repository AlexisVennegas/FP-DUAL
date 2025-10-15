package p01;

import java.util.Scanner;

public class Pulgadas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double numeroPulgadas = 0;
        double numeroCms = 2.54;
        double resultado = 0;

        System.out.println("introduce pulgadas: ");

        numeroPulgadas = teclado.nextFloat();

        resultado = numeroPulgadas * numeroCms;

        System.out.println("centrimetros: " + resultado);

        teclado.close();
    }
}
