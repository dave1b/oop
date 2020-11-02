package ch.hslu.sw07;

public class PersonNameComparator implements Comparator<Person>{

	
	@Override
	public int compare(Person p1, Person p2) {
		int compare = p1.getPrename().compareTo(p2.getPrename());
		if(compare == 0) {
			compare = p1.getSurname().compareTo(p2.getSurname());
		}		
		return compare;
	}
	
}
