package ch.hslu.sw07;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Person per = new Person("Brunner", "Dave", 1999);
		Person per2 = new Person("Brunner", "Dave", 1999);
		
		System.out.println(per.toString());
		
		System.out.println(per.hashCode());
		System.out.println(per.equals(per2));
		System.out.println(per.hashCode() == per2.hashCode());
		
		double ran = Math.random();
		Random rand = new Random();
		int ran2 = rand.nextInt(16);
		System.out.println(ran2);
	}

}
