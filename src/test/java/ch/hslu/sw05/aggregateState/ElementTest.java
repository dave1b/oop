package ch.hslu.sw05.aggregateState;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

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

	@Test
	void testEqualsContract() {
		EqualsVerifier.forClass(Element.class)
		.suppress(Warning.NONFINAL_FIELDS)
		.withIgnoredFields("boilingPoint")
		.suppress(Warning.STRICT_INHERITANCE)
		.verify();
	}
}
