package ch.hslu.sw05.aggregateState;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ElementTest {

	static Nitrogen nitrogen1;
	static Mercury mercury1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Tets started.");
		nitrogen1 = new Nitrogen(-200f);
		mercury1 = new Mercury(35f);
		System.out.println(nitrogen1.hashCode());
	}

	@Test
	void testHashCode() {
		assertEquals(true, nitrogen1.hashCode() == mercury1.hashCode());
	}

	@Test
	void testEquals() {
		assertEquals(true,nitrogen1.equals(mercury1));
	}


}
