package ch.hslu.sw09v2;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.Temperature;
import ch.hslu.sw08.TemperatureHistory;
import ch.hslu.sw10.MaxMinListener;
import ch.hslu.sw10.TemperaturEvent;

public class ExceptionhandlingBasics implements MaxMinListener {

	static private final Logger LOG = LogManager.getLogger(ExceptionhandlingBasics.class);
	static private String input;
	static private Scanner scanner = new Scanner(System.in);
	static private Temperature t;

	// Main-Methode
	public static void main(final String[] args) {

		// Test all Logging-Levels
//		LOG.error("Hallo! Das ist ein Error Log!");
//		LOG.warn("Hallo! Das ist ein Warn Log!");
//		LOG.info("Hallo! Das ist ein Info Log!");
//		LOG.debug("Hallo! Das ist ein Debug Log!");
//		LOG.trace("Hallo! Das ist ein Trace Log!");		
		interactTemperatur();
//		playGame();
	}

	
	
	final static public void interactTemperatur() {
		TemperatureHistory h1 = new TemperatureHistory();
		do {
			LOG.debug("Bitte Temperatur eingeben ('exit' zum Beenden): ");
			try {			
				input = scanner.next();
				h1.add(Float.parseFloat(input));
				LOG.info(h1.getWithIndex(h1.getCount()-1));
			} catch(NumberFormatException e) {
				LOG.warn(e.toString());
			}
		} while (!input.equals("exit"));
		LOG.info(h1.toString());
		LOG.debug("Programm wurde beeendet.");
	
	}

	@Override
	public void extremeValueChanged(TemperaturEvent e) {
		LOG.info("Type: " + e.getPropertName() + " \n Source: " + e.getSource() + "\n new extreme Value: " + e.getNewExtremeValue());
	}
	
	
	
	
	/**
	 * The methods checks if a String only constist of digits. This method can avoid
	 * java.lang.NumberFormatException.
	 * 
	 * @param input from the console
	 * @return true if the String consist only of numbers
	 * 
	 */
	
	
	
	final private static boolean onlyNumber(String input) {
		int n = input.length();
		boolean onlyNumber = true;
		if (input.length() == 0) {
			onlyNumber = false; 
		}

		// Traverse the string from
		// start to end
		for (int i = 0; i < n; i++) {
			// Check if character is digit from 0-9
			// then return true
			// else false
			if (!(Character.isDigit(input.charAt(i))))
//	            (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) 
			{
				onlyNumber = false;
			}
		}
		// if String has 0 chars
		return onlyNumber;
	}

	static public void playGame() {
		System.out.println("Möchten Sie ein Spiel spielen? \n Antworten Sie mit 'ja' oder 'nein'");
		input = scanner.next();
		if (input.equals("ja")) {
			try {
				enterBirthday();
			} catch (YouDontKnowMyBirthdayException e) {
				LOG.warn(e.toString());
				System.out.println("Sie haben das Spiel verloren.");
			} finally {
				LOG.info("Das Spiel wurde beendet.");
			}
		} else if (input.equals("nein")) {
			System.out.println("Dann halt nicht.");
			LOG.info("Das Spiel wurde beendet.");
		} else {
			throw new IllegalArgumentException("Valid arguments are: 'ja' and 'nein'");
		}
	}

	private static void enterBirthday() throws YouDontKnowMyBirthdayException {
		System.out.println("Raten Sie meinen Geburstag (xx.xx.xxxx):");
		input = scanner.next();
		if (!(input.equals("01.08.1291"))) {
			throw new YouDontKnowMyBirthdayException(input);
		} else {
			System.out.println("Sehr gut! Sie haben das Spiel gewonnen!");
		}
	}

}
