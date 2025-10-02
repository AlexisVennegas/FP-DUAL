package Exercies;

import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        
        int numero,
            i = 1;

        System.out.println("numeros primos entre el 1 y el 100");

        while(i <= 100) {
            boolean esPrimo = true;
            numero = i;
            int j = 1;
            while(j <= numero) {
                int resultado = numero % j;
                if(resultado == 0 && j != 1 && j != numero) {
                    esPrimo = false;
                }
                j++;
            }
            if(esPrimo) System.out.println(i);
            i++;
        }


    }
}
