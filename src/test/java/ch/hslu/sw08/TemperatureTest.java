package ch.hslu.sw08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import ch.hslu.sw08.Temperature.TempType;



public class TemperatureTest {

	
	final Temperature temp1 = new Temperature(20);
	final Temperature temp2 = new Temperature(20);
	final Temperature temp3 = new Temperature(10);
	

	@Test
	public void testConstruktorCelsius() {
		final Temperature temp = new Temperature(TempType.Celsius,20f);
		assertEquals(20, temp.getTemperatureInCelsius(), 0);
	}
	@Test
	public void testConstruktorKelvin() {
		final Temperature temp = new Temperature(TempType.Kelvin,250f);
		assertEquals(-23.15f, temp.getTemperatureInCelsius(), 0.1f);
	}
	
	@Test
	public void testConstruktorIllegalArgument() {
		final Exception e =
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			final Temperature temp = new Temperature(TempType.Gurke, 30f);
			});
		assertEquals("The Enum typ must either be 'TempType.Celsius' or 'TempType.Kelvin!'",e.getMessage());
		
		
	}
	@Test
	public void testCreateFromCelsius() {
		final Temperature temp = Temperature.createFromCelsius(25f);
		assertEquals(25f, temp.getTemperatureInCelsius(), 0);
	}
	
	@Test
	public void testCreateFromKelvin() {
		final Temperature temp = Temperature.createFromKelvin(250f);
		assertEquals(-23.15f, temp.getTemperatureInCelsius(), 0.1f);
	}
	@Test
	public void testCreateFromCelsiusIllegalArgument() {
		final Exception e =
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			final Temperature temp = Temperature.createFromCelsius(-300f);
			});
		assertEquals("The entered temperature must be >= -273.15", e.getMessage());
	}
	
	@Test
	public void testCreateFromKelvinIllegalArgument() {
		final Exception e =
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			final Temperature temp = Temperature.createFromKelvin(-1f);
		});
		assertEquals("The entered temperature must be >= 0f", e.getMessage());
	}
	
	@Test
	public void testGetCelsius() {
		final Temperature temp = new Temperature(20);
		assertEquals(20f, temp.getTemperatureInCelsius(), 0);
	}
	
	@Test
	public void testGetKelvin() {
		assertEquals(293.15f, Temperature.convertTemperatureFromCelsiousToKelvin(20), 0);		
	}
	
	@Test
	public void testGetFahrenheit() {
		final Temperature temp = new Temperature(20);
		assertEquals(68f, temp.getTemperatureInFahrenheit(), 0);	
	}
	@Test
	public void setTemperaturRelativeCelsius() {
		Temperature temp = new Temperature(20);
		temp.setTemperaturRelativeCelsius(20);
		assertEquals(40, temp.getTemperatureInCelsius(), 0);	
	}
	@Test
	public void setTemperaturRelativeKelvin() {
		Temperature temp = new Temperature(20);
		temp.setTemperaturRelativeKelvin(293.15f);
		assertEquals(40, temp.getTemperatureInCelsius(),0);	
	}
	@Test
	public void setTemperaturRelativeFahrenheit() {
		Temperature temp = new Temperature(20);
		temp.setTemperaturRelativeFahrenheit(20);
		assertEquals(13.333333f, temp.getTemperatureInCelsius(), 1f);	
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
