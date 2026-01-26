package OrdenadorNumeros;



public class Ordenar {
	
	
	public static int[] bubbleShort(int[] arr) {
		
		int x = 0;
	
		while(x < arr.length - 1) {
			int y = 0;
			while(y < arr.length - 1) {
				if(arr[y] > arr[y + 1]) {
					int temporal = arr[y];
					arr[y] = arr[y + 1];
					arr[y + 1] = temporal;
				}
				y++;
			}	
			
			x++;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		   int[] arr = {64, 34, 25, 12, 22, 11, 90};
		   arr = bubbleShort(arr);
		   for(int i = 0; i < arr.length; i++) {
			   System.out.println(arr[i]);
		   }
	}
}
