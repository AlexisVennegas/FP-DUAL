package OrdenadorNumeros;

public class Principal {
	public static void main(String[] args) {
		   int[] arr = {64, 34, 25, 12, 22, 11, 90};
		   
		   Ordenar prime = new Ordenar();
		   
		   arr = prime.ordenarArray(arr);
		   for(int i = 0; i < arr.length; i++) {
			   System.out.println(arr[i]);
		   }
	}
}
