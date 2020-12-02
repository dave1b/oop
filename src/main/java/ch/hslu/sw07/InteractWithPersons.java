package ch.hslu.sw07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InteractWithPersons extends PersonNameComparator{

	public InteractWithPersons() {
	}



	Collection<Person> personList = new ArrayList<Person>();
	
	
	public void add(String surname,String firstName,int vintage) {
		personList.add(new Person( surname, firstName, vintage));
	}
	
	public void sort() {
		Collections.sort(personList, nameComp);
	}
	
	public void printList() {		
		// Mit lambda
		personList.forEach((p) -> System.out.println(p));
		/*for(Person p: personList) {
			System.out.println(p);
		}*/
	}
	
	
	
	public static void main(String[] args) {
		InteractWithPersons interaction = new InteractWithPersons();
		interaction.add("Brunner", "Dave", 1999);
		interaction.add("Müller", "Mike", 1965);
		interaction.printList();
		
	}
	
	
	
	
	
	
	
	
	
}
