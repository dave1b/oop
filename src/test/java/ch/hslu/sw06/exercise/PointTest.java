package ch.hslu.sw06.exercise;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void testGetQuadrant0() {
		final Point point = new Point(0,0);		
		assertEquals(0,point.getQuadrant());
	}

	@Test
	void testGetQuadrant1() {
		final Point point = new Point(4,5);		
		assertEquals(1,point.getQuadrant());
		}
	
	@Test
	void testGetQuadrant2() {
		final Point point = new Point(-4,4);		
		assertEquals(2,point.getQuadrant());
		}
	
	@Test
	void testGetQuadrant3() {
		final Point point = new Point(-3,-5);		
		assertEquals(3,point.getQuadrant());
		}
	
	@Test
	void testGetQuadrant4() {
		final Point point = new Point(4,-5);		
		assertEquals(4,point.getQuadrant());
		}
	
	
	
	
	
	

}
