package ch.hslu.sw10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Fahrzeug {
	static private final Logger LOG = LogManager.getLogger(Fahrzeug.class);
	private int serialNumber;
	private Brand brand;
	private Motor motor;
	private MultimediaSystem multimediaSystem;
	private Licht licht;
	private Lüftung lüftung;
	public boolean propertyChange = false;


	//Innere Klass (MotorPropertyChangeListener) welche Interface implementiert
	public class MotorPropertyChangeListener implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			LOG.info("Change von innerer Klasse " + event.toString());
			
		}

	}



	public Fahrzeug(int serialNumber, Brand brand) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		motor = new Motor();
		multimediaSystem = new MultimediaSystem();
		licht = new Licht();
		lüftung = new Lüftung();
		//  Sich selber als Listener registrieren.


		// Anonyme Innere Klasse
		this.motor.addPropertyChangeListener(new PropertyChangeListener() {  //-> Typ Interface
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				LOG.info("Change von anonymer innerer Klasse " + event.toString());
				propertyChange = true;		
			}			
		});	
		// Dasselbe mit Lambdas
		this.motor.addPropertyChangeListener( (PropertyChangeEvent event) -> {
			LOG.info("Change von Lamda " + event.toString());
			propertyChange = true;
		});		
		// Lambda mit Methodenreferenz
		this.motor.addPropertyChangeListener(this::handleMotorEvent);
		this.multimediaSystem.addPropertyChangeListener(this::handleMultimediaEvent);
		this.licht.addPropertyChangeListener(this::handleLichtEvent);
		this.lüftung.addPropertyChangeListener(this::handleLüftungEvent);
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


	private void handleMotorEvent(PropertyChangeEvent event) {
		LOG.info("Change von Lamda 2 " + event.toString());
		this.propertyChange = true;
	}
	private void handleMultimediaEvent(PropertyChangeEvent event) {
		LOG.info(event.getSource());
		LOG.info(event);
	}
	private void handleLichtEvent(PropertyChangeEvent event) {
		LOG.info(event.getSource());
		LOG.info(event);
	}
	private void handleLüftungEvent(PropertyChangeEvent event) {
		LOG.info(event.getSource());
		LOG.info(event);
	}





	/*
	@Override
	public void propertyChange(final PropertyChangeEvent event) {
		if(event.getSource() == this.motor) {
			this.handleMotorEvent("Motor", event);
			this.propertyChange = true;
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
	 */



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
