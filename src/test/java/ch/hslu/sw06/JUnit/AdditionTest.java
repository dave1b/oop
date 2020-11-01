package ch.hslu.sw06.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdditionTest {

	static int counter = 0;
	
	@BeforeEach
	@Test
	void beforeEach() {
		counter += 1;
		System.out.println("Testfall: " + counter);
	}
	
	@Test
	void testAddition() {
		Addition add = new Calculator();
		assertEquals(10, add.addition(5, 5));
	}
	@Test
	void testAddition1() {
		Addition add = new Calculator();
		assertEquals(0, add.addition(0, 0));
	}
	@Test
	void testAddition2() {
		Addition add = new Calculator();
		assertEquals(10, add.addition(16, -6));
	}
	@Test
	void testAddition3() {
		Addition add = new Calculator();
		assertEquals(10, add.addition(-5, 15));
	}
	
	// Überlauf der Zahlen
	@Test
	void testAddition4() {
		Addition add = new Calculator();
		assertEquals((long)2* 2147483647, add.addition(Integer.MAX_VALUE, Integer.MAX_VALUE));
		System.out.println(Integer.MAX_VALUE + 1);
		System.out.println(add.addition(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	
	@Test
	void testAddition5() {
		Addition add = new Calculator();
		System.out.println((long)Integer.MIN_VALUE + Integer.MIN_VALUE);
		assertEquals((long)2*Integer.MIN_VALUE, add.addition(Integer.MIN_VALUE, Integer.MIN_VALUE));
	}
	@Test
	void testAddition6() {
		Addition add = new Calculator();
		assertEquals(10, add.addition(-5, 15));
	}
	

}
