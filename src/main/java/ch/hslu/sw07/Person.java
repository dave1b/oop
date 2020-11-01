package ch.hslu.sw07;

import java.util.Objects;

public final class Person implements Comparable{

	final private long ID = 0;
	private String surname;
	private String prename;
	private int vintage;
	
	
	public Person(String surname, String prename, int vintage) {
		this.surname = surname;
		this.prename = prename;
		this.vintage = vintage;
	}
	
	@Override
	public String toString() {
		return " Surname: " + surname + "\n Prename: " + prename + "\n Vintage: " + vintage;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPrename() {
		return prename;
	}

	public void setPrename(String prename) {
		this.prename = prename;
	}

	public int getVintage() {
		return vintage;
	}

	public void setVintage(int vintage) {
		this.vintage = vintage;
	}

	
//	public void equalsContract() {
//		EqualsVerifier.forClass()
//		
//	}
	
	
	
	
		@Override
	public int hashCode() {
		return Objects.hash(prename, surname, vintage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(prename, other.prename) && Objects.equals(surname, other.surname)
				&& vintage == other.vintage;
	}
	 
	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.vintage, other.vintage);
	}
	
	
}
