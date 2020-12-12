package ch.hslu.sw07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InteractWithPersons extends PersonNameComparator{

	public InteractWithPersons() {
	}



	List<Person> personList = new ArrayList<Person>();
	
	
	public void add(String surname,String firstName,int vintage) {
		personList.add(new Person( surname, firstName, vintage));
	}
	
//	public void sort() {
//		final Comparator<Person> nameComp= (p1, p2) -> p1.getSurname().compareTo(p2.getSurname());
//		Collection<Person> personList2 = Collections.sort(personList, nameComp);
//	}
	
	
	public void printList() {		
		// Mit lambda
		personList.forEach((p) -> System.out.println(p));
		personList.forEach(System.out::println);
		
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
