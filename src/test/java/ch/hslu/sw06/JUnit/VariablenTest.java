package ch.hslu.sw06.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class VariablenTest extends Variablen {

	@Test
	void testmax() {
		Variablen var = new Variablen();
		assertEquals(5, var.max(3,4,5));
	}
	
	
	@Test
	void testmax1() {
		Variablen var = new Variablen();
		assertEquals(5, var.max(3,5,5));
	}
	
	@Test
	void testmax2() {
		Variablen var = new Variablen();
		assertEquals(5, var.max(5,5,5));
	}
	@Test
	void testmax3() {
		Variablen var = new Variablen();
		assertEquals(0, var.max(0,0,0));
	}
	@Test
	void testmax4() {
		Variablen var = new Variablen();
		assertEquals(5, var.max(5,4,4));
	}
	
	@Test
	void testmax5() {
		Variablen var = new Variablen();
		assertEquals(5, var.max(3,5,4));
	}	
	@Test
	void testmax6() {
		Variablen var = new Variablen();
		assertEquals(-4, var.max(-5,-4,-5), 1);
	}
	
	@Test
	@Disabled("Wiederholung")
	void testmax7() {
		Variablen var = new Variablen();
		assertEquals(-4, var.max(-5,-4,-5));
	}
	
	

	
	
	
	
}
