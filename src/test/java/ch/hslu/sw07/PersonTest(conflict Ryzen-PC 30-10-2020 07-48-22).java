package ch.hslu.sw07;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PersonTest {
  
	static Person per1;  
	static Person per2;
	static Person per3;	
	static Person per4;
	static Person per5;
	static Person per10;
	static int counter = 0;
	

	@Test
	@BeforeAll
	static void setUp() {
		per1 = new Person("Brunner", "Dave", 1999);
		per2 = new Person("Brunner", "Dave", 1999);
		per3 = new Person("Brunner", "Karin", 1968);
		per4 = new Person("Kevin", "Tscherfinger", 2000);		
		per5 = per4;
		
	}
	
	
	@Test
	 void testConstructor()  {
		System.out.println(per1.toString());
		assertEquals("Dave", per1.getPrename());
		assertEquals("Brunner", per1.getSurname());
		assertEquals(1999,per1.getVintage());
		
	}
	
	
	@Test
	void testIdentity() {
		assertEquals(true, per4 == per5);
	}
	
	
	@Test	
	 void testInstanceOf()  {
		assertEquals(true,(per1 instanceof Person));	
		assertEquals(true,(per2 instanceof Person));	
		assertEquals(true,(per3 instanceof Person));	
		assertEquals(true,(per4 instanceof Person));	
	}

	@Test
	void testIfNull() {
		assertEquals(false, per1.equals(null));
//		assertEquals(true, per10.equals(null));		
	}
	

	@Test
	public void testEquals()  {
		assertEquals(true,per1.equals(per2));		
	}
	
	@Test
	public void testEquals2()  {
		Person per = new Person("Brunner", "Dave", 1999);
		Person per2 = new Person("Brunner", "Dave", 1999);
		assertEquals(true, per.hashCode() == per2.hashCode());		
	}

	@Test
	public void testEquals3()  {
		Person per = new Person("Brunner", "Dave", 1999);
		Person per2 = new Person("Brunner", "Dave", 1999);
		assertEquals(true, per.equals(per2));
		assertEquals(true, per.hashCode() == per2.hashCode());		
	}
	
	@Test
	public void testCompareTo()  {
		Person per = new Person("Brunner", "Dave", 1998);
		Person per2 = new Person("Brunner", "Dave", 1999);
		assertEquals(-1, per.compareTo(per2));
	}
	
	

	
	
	@Test
	void testEqualsContract() {
		EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).withIgnoredFields("ID").verify();
	}

	@Test
	@BeforeAll
	static void testStart() {
		System.out.println("Tests started.");
	}

	@Test
	@BeforeEach
	void testBeforeEach() {
		counter++;
		System.out.println(counter);
	}

	@Test
	@AfterAll
	static void testEnd() {
		System.out.println("Tests ended.");
	}

}




