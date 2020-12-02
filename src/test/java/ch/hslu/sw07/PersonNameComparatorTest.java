package ch.hslu.sw07;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonNameComparatorTest {

	Person per1 = new Person("Brunner", "Dave" , 1999 );
	Person per2 = new Person("Brunner", "Michele" , 2001 );
	
	
	
	
	
	
	
	
	@Test
	public void testCompare() throws Exception {
		assertEquals(-9, per1.compare(per1, per2));
	}

}
