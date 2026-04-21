package p06;

public class IsPalindromo {
	public static boolean ispalindromo(String str) {
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(str.length() - 1));
		System.out.println(str.length());
		if (str.length() <= 1) {
	        return true;
	    }
		else if(str.charAt(0) == str.charAt(str.length() - 1)) {
			System.out.println(str.substring(1, str.length() - 1));
			return ispalindromo(str.substring(1, str.length() - 1));
			
		}
	
	 return false;
			
		
	
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(	ispalindromo("anita lava la tina"));
	}
}
