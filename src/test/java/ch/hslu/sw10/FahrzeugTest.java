package ch.hslu.sw10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FahrzeugTest {


	@Test
	public void testConstructor() {
		Fahrzeug car = new Fahrzeug(0001, Fahrzeug.Brand.VW);
		assertEquals(0001, car.getSerialNumber());
		assertEquals(Fahrzeug.Brand.VW, car.getBrand());
	}
	
	

	@Test
	public void testPropertyChangeMotor() {
		Fahrzeug car = new Fahrzeug(0001, Fahrzeug.Brand.VW);
		assertEquals(false, car.getMotorState());
		assertEquals(false, car.propertyChange);
		car.switchMotorOn();
		assertEquals(true, car.getMotorState());
		assertEquals(true, car.propertyChange);
		car.switchMotorOff();
		assertEquals(false, car.getMotorState());	
	}

}
