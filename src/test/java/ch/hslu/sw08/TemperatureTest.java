package ch.hslu.sw08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;



public class TemperatureTest {

	
	final Temperature temp1 = new Temperature(20);
	final Temperature temp2 = new Temperature(20);
	final Temperature temp3 = new Temperature(10);
	
	
	
	
	
	
	
	@Test
	public void testConstruktor() {
		final Temperature temp = new Temperature("c",20f);
		assertEquals(20, temp.getTemperatureInCelcious(), 0);
	}
	@Test
	public void testConstruktor2() {
		final Temperature temp = new Temperature("k",250f);
		assertEquals(-23.15f, temp.getTemperatureInCelcious(), 0.1f);
	}
	
	@Test
	public void testConstruktor3() {
		final Exception e =
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			final Temperature temp = new Temperature("w", 30f);
			});
		assertEquals("The String typ must either be 'c' or 'k'!",e.getMessage());
		
		
	}
	@Test
	public void testStaticConstruktor() {
		final Temperature temp = Temperature.createFromCelcious(25f);
		assertEquals(25f, temp.getTemperatureInCelcious(), 0);
	}
	
	@Test
	public void testStaticConstruktor2() {
		final Temperature temp = Temperature.createFromKelvin(250f);
		assertEquals(-23.15f, temp.getTemperatureInCelcious(), 0.1f);
	}
	@Test
	public void testStaticConstruktor3() {
		final Exception e =
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			final Temperature temp = Temperature.createFromCelcious(-300f);
			});
		assertEquals("The entered temperature must be >= -273.15f", e.getMessage());
	}
	
	@Test
	public void testStaticConstruktor4() {
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			final Temperature temp = Temperature.createFromKelvin(-1f);
		});
	}
	
	@Test
	public void testGetCelcious() {
		final Temperature temp = new Temperature(20);
		assertEquals(20f, temp.getTemperatureInCelcious(), 0);
	}
	
	@Test
	public void testGetKelvin() {
		assertEquals(293.15f, Temperature.getTemperatureFromCelsiousToKelvin(20), 0);		
	}
	
	@Test
	public void testGetFahrenheit() {
		final Temperature temp = new Temperature(20);
		assertEquals(68f, temp.getTemperatureInFahrenheit(), 0);	
	}
	@Test
	public void setTemperaturRelativeCelcious() {
		Temperature temp = new Temperature(20);
		temp.setTemperaturRelativeCelcious(20);
		assertEquals(40, temp.getTemperatureInCelcious(), 0);	
	}
	@Test
	public void setTemperaturRelativeKelvin() {
		Temperature temp = new Temperature(20);
		temp.setTemperaturRelativeKelvin(293.15f);
		assertEquals(40, temp.getTemperatureInCelcious(),0);	
	}
	@Test
	public void setTemperaturRelativeFahrenheit() {
		Temperature temp = new Temperature(20);
		temp.setTemperaturRelativeFahrenheit(20);
		assertEquals(13.333333f, temp.getTemperatureInCelcious(), 1f);	
	}
	
	
	@Test
	public void testEquals()  {
		assertEquals(true,temp1.equals(temp2));		
	}
	@Test
	public void testEquals2()  {
		assertEquals(true,temp1.equals(temp1));		
	}
	@Test
	public void testHashCode()  {
		assertEquals(temp1.hashCode(),temp1.hashCode(),0);			
	}
	@Test
	public void testCompareTo()  {
		assertEquals(0, temp1.compareTo(temp2));			
	}
	@Test
	public void testCompareTo2()  {
		assertEquals(-1, temp3.compareTo(temp1));			
	}
	@Test
	public void testCompareTo3()  {
		assertEquals(1, temp1.compareTo(temp3));	
	}
	
	
	
	
	
	
	
	
	
}
