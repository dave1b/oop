package ch.hslu.sw10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Fahrzeug implements PropertyChangeListener{
	static private final Logger LOG = LogManager.getLogger(Fahrzeug.class);
	private int serialNumber;
	private Brand brand;
	private Motor motor;
	private MultimediaSystem multimediaSystem;
	private Licht licht;
	private Lüftung lüftung;


	public Fahrzeug(int serialNumber, Brand brand) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		motor = new Motor();
		multimediaSystem = new MultimediaSystem();
		licht = new Licht();
		lüftung = new Lüftung();


		//  Sich selber als Listener registrieren.
		this.motor.addPropertyChangeListener(this);
		this.multimediaSystem.addPropertyChangeListener(this);
		this.licht.addPropertyChangeListener(this);
		this.lüftung.addPropertyChangeListener(this);
	}



	public enum Brand {
		VW(001), Audi(002), Porsche(004), Seat(003), Skoda(006), Bentley(005);		
		private int brandKey;
		private Brand(final int key) {
			this.brandKey = key;
		}		
		public int getKey() {
			return this.brandKey;
		}
	}


	@Override
	public void propertyChange(final PropertyChangeEvent event) {
		if(event.getSource() == this.motor) {
			this.handleMotorEvent("Motor", event);
		} else if (event.getSource() == this.multimediaSystem) {
			LOG.info(event.getSource());
			LOG.info(event);
		} else if(event.getSource() == this.licht) {
			LOG.info(event.getSource());
			LOG.info(event);
		} else if(event.getSource() == this.lüftung) {
			LOG.info(event.getSource());
			LOG.info(event);
		}
	}


	private void handleMotorEvent(String obj, PropertyChangeEvent event) {
		LOG.info(event.getSource());
		LOG.info(event);
	}


	public static void main(String[] args) {
		Fahrzeug car = new Fahrzeug(000, Brand.VW);
		car.motor.switchOn();
		car.multimediaSystem.switchOn();
		car.licht.switchOn();
		car.lüftung.switchOn();


	}

	
	
	
	// ------------------ Für Test-Zwecke ---------------------------
	public int getSerialNumber() {
		return this.serialNumber;
	}
	public Brand getBrand() {
		return this.brand;
	}
	
	public boolean getMotorState() {
		return this.motor.isSwitchedOn();
	}

	public void switchMotorOn() {
		this.motor.switchOn();
	}
	public void switchMotorOff() {
		this.motor.switchOff();
	}
	
	
	
	
	// --------------------------------------------------------------
}
