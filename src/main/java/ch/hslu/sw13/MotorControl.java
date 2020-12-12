package ch.hslu.sw13;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MotorControl implements  ActionListener, PropertyChangeListener {

	private static final Logger LOG = LogManager.getLogger(MotorControl.class);
	private Motor motor;
	private MotorView motorView;
	String on = "Motor is ON.";
	String off = "Motor is OFF.";
	
	public MotorControl() {
		motor = new Motor();
		motorView = new MotorView();
		this.motorView.getOnButton().addActionListener(this::actionPerformed);
		this.motorView.getOffButton().addActionListener(this::actionPerformed);
		this.motorView.getButtonIncreaseRPM().addActionListener(this::actionPerformed);
		this.motorView.getButtonDecreaseRPM().addActionListener(this::actionPerformed);
		this.motor.addPropertyChangeListener(this::propertyChange);
		LOG.debug("MotorControl Konstruktor aufgerufen");		
	}
	
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("rpm")) {
			if(motor.getRPM() == 200) {
				motorView.displayWarningMessage("Critical motor speed reached.");
			} else if(motor.getRPM() == 220) {
				motor.switchOff();
				motorView.setLabelState(off, Color.RED);
				motorView.setTextAreaSwitcher(motor.getSwitches());
				motorView.setTextAreaRPM(motor.getRPM());
				motorView.displayWarningError("Motor overloaded!");
			}
		}
		LOG.info("PropertyChange wurde auf MotorControl gestartet.");
		LOG.info("Neuer Motor Wert: " + evt.getNewValue());
	}

	// Method for OnButton & OffButton
	@Override
	public void actionPerformed(final ActionEvent event) {
		
		
		if(event.getSource().equals(motorView.getActiveJButton()))
			return;
		LOG.debug("actionPerformed auf MotorControl");
		if (event.getSource() == motorView.getOnButton()) {
			motor.switchOn();
			motorView.setLabelState(on, Color.GREEN);
			motorView.setTextAreaSwitcher(motor.getSwitches());
			motorView.setTextAreaRPM(motor.getRPM());
			LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
			
		}
		if (event.getSource() == motorView.getOffButton()) {
			motor.switchOff();
			motorView.setLabelState(off, Color.RED);
			motorView.setTextAreaSwitcher(motor.getSwitches());
			motorView.setTextAreaRPM(motor.getRPM());
			LOG.info("ActionEvent von OFF-Button empfangen und verarbeitet.");
		}
		if (event.getSource() == motorView.getButtonIncreaseRPM()) {
			if(motorView.getActiveJButton().equals(motorView.getOffButton())) {
				motorView.setTextAreaSwitcher(motor.getSwitches());
				motorView.setLabelState(on, Color.GREEN);				
			}
			motor.increaseRPM();
			motorView.setTextAreaSwitcher(motor.getSwitches());
			motorView.setTextAreaRPM(motor.getRPM());
		}
		if (event.getSource() == motorView.getButtonDecreaseRPM()) {
			if(motor.getRPM() <= 20){
				motorView.setTextAreaSwitcher(motor.getSwitches());
				motorView.setLabelState(off, Color.RED);
			}
			motor.decreaseRPM();
			motorView.setTextAreaSwitcher(motor.getSwitches());
			motorView.setTextAreaRPM(motor.getRPM());
		}
	}

		
}
