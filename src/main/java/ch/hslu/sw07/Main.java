package ch.hslu.sw07;

public class Main {

	public static void main(String[] args) {
		Person per = new Person("Brunner", "Dave", 1999);
		Person per2 = new Person("Brunner", "Dave", 1999);
		
		System.out.println(per.toString());
		
		System.out.println(per.hashCode());
		System.out.println(per.equals(per2));
		System.out.println(per.hashCode() == per2.hashCode());
	}

}
