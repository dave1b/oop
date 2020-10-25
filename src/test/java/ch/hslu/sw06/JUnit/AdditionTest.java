package ch.hslu.sw06.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdditionTest {

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

}
