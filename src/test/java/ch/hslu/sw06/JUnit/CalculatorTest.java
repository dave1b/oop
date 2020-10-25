package ch.hslu.sw06.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	@Disabled
	void testAddition() {
		Calculator calc = new Calculator();
		assertEquals(10, calc.addition(5,5));
	}

}
