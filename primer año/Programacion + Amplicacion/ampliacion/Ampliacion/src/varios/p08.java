package varios;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class p08 {
	public static void main(String[] args) {
		// 8. Crear una función lambda que verifique si una cadena comienza con "A".
		
		Predicate<String> veriPredicate = str -> str.contains("A");
		
		System.out.println(veriPredicate.test("^^a^^^^^^"));
	}
}
