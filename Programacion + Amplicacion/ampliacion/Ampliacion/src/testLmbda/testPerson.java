package testLmbda;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class testPerson {
	public static void main(String[] args) {
        List<Person> lista = new ArrayList<>();    
        LocalDate birthDate = LocalDate.of(1995, 5, 20);
        lista.add(new Person("Juan", birthDate, Person.Sex.MALE, "juan@email.com"));
     
        System.out.println("primero caso");
        printPersonsOlderThan1(lista, 20);
        
        System.out.println("segundo caso");
        printPersonsWithinAgeRange2(lista, 30, 60);
        
        System.out.println("tercer caso");
        
        CheckPersonEligibleForSelectiveService selector = new CheckPersonEligibleForSelectiveService();
        printPersonsWithinAgeRange3(lista, selector);
  
        System.out.println("caso 4");
        
        printPersonsWithinAgeRange3(lista, new CheckPerson() {
			
        	@Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 30
                    && p.getAge() <= 60;
            }
        });
        
        
        System.out.println("case 5");
        
        printPersonsWithinAgeRange3(lista, p -> p.getAge() >= 30);
        
    }
	
	public static void printPersonsWithinAgeRange3(List<Person> roster, CheckPerson tester) {
	    for (Person p : roster) {
	    	 if (tester.test(p)) { 
	             p.printPerson(); 
	         } 
	    }
	}
    
	public static void printPersonsWithinAgeRange2( 
		    List<Person> roster, int low, int high) { 
		    for (Person p : roster) { 
		        if (low <= p.getAge() && p.getAge() < high) { 
		            p.printPerson(); 
		        } 
		    } 
		}

	
	
	public static void printPersonsOlderThan1(List<Person> roster, int age) { 
	    for (Person p : roster) { 
	        if (p.getAge() >= age) { 
	            p.printPerson(); 
	        } 
	    } 
	}
}
