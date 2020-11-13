package ch.hslu.sw08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

public class TemperatureHistoryTest {

	private TemperatureHistory h1 = new TemperatureHistory();
	
	
	
	
	
	@Test
	public void testAddAndCount() {
		h1.add(20f);
		h1.add(30f);
		h1.add(40f);
		h1.add(50f);
		assertEquals(4,h1.getCount());
		//System.out.println(h1.verlauf.get(0));;
	}

	
	@Test
	public void testClear() {
		h1.add(20f);
		h1.add(30f);
		h1.add(40f);
		h1.add(50f);
		assertEquals(4,h1.getCount());
		h1.clear();
		assertEquals(0,h1.getCount());
		
	}
	
	@Test
	public void testCompare() {
		h1.add(30f);
		h1.add(40f);
		h1.add(50f);
		h1.add(60f);
		assertEquals(-1,h1.verlauf.get(0).compareTo(h1.verlauf.get(1)));
		assertEquals(1,h1.verlauf.get(1).compareTo(h1.verlauf.get(0)));
		assertEquals(0,h1.verlauf.get(2).compareTo(h1.verlauf.get(2)));
	}

	@Test
	public void testGetMaxItem() {
		h1.add(30f);
		h1.add(20f);
		h1.add(60f);
		h1.add(20f);
		assertEquals(60f, h1.getMaxItem(), 0);		
	}
	
	@Test
	public void testGetMinItem() {
		h1.add(30f);
		h1.add(20f);
		h1.add(60f);
		h1.add(5f);
		assertEquals(5f, h1.getMinItem(), 0);		
	}
	
	@Test
	public void testGetAverage() {
		h1.add(30f);
		h1.add(20f);
		h1.add(60f);
		h1.add(5f);
		assertEquals(28.75f, h1.getAverage(), 0);	
	}
	@Test
	public void testDuplicate() {
		h1.add(20f);
		h1.add(20f);
		h1.add(20f);
		h1.add(20f);
		assertEquals(1, h1.getCount());	
		System.out.println(h1.getAverage());
	}
	
	

	@Test
	public void testWithZeroItems() {
		assertEquals(0,h1.getCount());
		assertEquals(0, h1.getMaxItem(), 0);
		assertEquals(0f, h1.getMinItem(), 0);
		assertEquals(0f, h1.getAverage(), 0);
	}
	
	

	

	
	
	
	
//	@Test
//	public void Main() {
//		h1.add(30f);
//		h1.getAverage();	
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
