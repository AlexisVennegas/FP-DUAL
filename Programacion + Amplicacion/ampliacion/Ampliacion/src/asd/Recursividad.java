package asd;

public class Recursividad {
		 public static int factorial(int n) {
		 if (n == 0) return 1;
		 return n * factorial(n - 1);
		 }
		 public static void main(String[] args) {
		 System.out.println(factorial(5)); // 720
		 System.out.println(factorial(6)); // 720
		 System.out.println(factorial(7)); // 720
		 System.out.println(factorial(8)); // 720
		 System.out.println(factorial(9)); // 720
		 System.out.println(factorial(10)); // 720
		 }
}


