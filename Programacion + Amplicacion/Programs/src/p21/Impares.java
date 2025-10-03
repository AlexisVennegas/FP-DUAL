package p21;

public class Impares {
	public static void main(String[] args) {
		int i = 0,
			result = 0;
		
		
		while(i <= 10) {
			if(i % 2 != 0) {
				result += i;
				System.out.println(i);
			}
			i++;
		}
		System.out.println("resultado: " + result);
		
	}
}
