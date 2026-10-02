public class solution { // Asume fichero llamado solution.java

    static java.util.Scanner in;

    public static void casoDePrueba() {
      
        
        int numProblema;
        numProblema = in.nextInt();
        
        System.out.println(numProblema / 100);
    } 

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            System.out.println(i + 1 + ". caso de prueba:");
            casoDePrueba();
    } // main
} // cla