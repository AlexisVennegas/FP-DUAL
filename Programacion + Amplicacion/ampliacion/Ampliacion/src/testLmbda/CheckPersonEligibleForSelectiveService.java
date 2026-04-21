package testLmbda;

public class CheckPersonEligibleForSelectiveService implements CheckPerson {

	@Override
	 public boolean test(Person p) { 
        return p.gender == Person.Sex.MALE && 
            p.getAge() >= 30 && 
            p.getAge() <= 60; 
    } 

}
