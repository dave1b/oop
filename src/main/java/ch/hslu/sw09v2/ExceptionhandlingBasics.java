package ch.hslu.sw09v2;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.Temperature;
 

public class ExceptionhandlingBasics  {

	
	static private final Logger LOG = LogManager.getLogger(ExceptionhandlingBasics.class);
	static private String input;
	static private Scanner scanner = new Scanner(System.in);
	
	
	// Main-Methode
	public static void main(final String[] args) {
		
		// Test all Logging-Levels
//		LOG.error("Hallo! Das ist ein Error Log!");
//		LOG.warn("Hallo! Das ist ein Warn Log!");
//		LOG.info("Hallo! Das ist ein Info Log!");
//		LOG.debug("Hallo! Das ist ein Debug Log!");
		LOG.trace("Hallo! Das ist ein Trace Log!");		
//		printTempInFloat();		
		playGame();
	}
		
	
	
	
		final static public void printTempInFloat() {
		do {
			LOG.debug("Bitte Temperatur eingeben ('exit' zum Beenden): ");
		input = scanner.next();
		
		if(onlyNumber(input)) {	
			Temperature t = new Temperature(Float.parseFloat(input));			
			LOG.debug(t.toString());
			System.out.println("\n");
		} else if (input.equals("exit")){
			LOG.debug("Programm wurde beeendet.");
		}
		else {
			LOG.warn("Geben Sie eine gültige Float ein. \n");
		}
		} while(!input.equals("exit"));
				
		}
		

	
/**
 * The methods checks if a String only constist of digits.
 * This method can avoid java.lang.NumberFormatException 
 * java.lang.NumberFormatException
 * @param input from the console
 * @return true if the String consist only of numbers
 * 
 */
	final private static boolean onlyNumber(String input) 
	    { 
		 int n = input.length();
	    
		 	boolean onlyNumber = true;
		 	if(input.length() == 0) {
		 		onlyNumber = false;
		 	}
		 	
	        // Traverse the string from 
	        // start to end 
	        for (int i = 0; i < n; i++) { 
	            // Check if character is 
	            // digit from 0-9 
	            // then return true 
	            // else false 
	            if(!(Character.isDigit(input.charAt(i))))
//	            (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) 
	            { 
	               	onlyNumber = false; 
	            } 
	        } 
	        // if String has 0 chars
	        return onlyNumber; 
	 
	    }
	
	
	
	static public void playGame() {
		LOG.debug("Möchten Sie ein Spiel spielen? \n Antworten Sie mit 'ja' oder 'nein'");
		input = scanner.next();
		if(input.equals("ja")) {
			try {
				enterMyAge();
			} catch (YouDontKnowMyBirthdayException e)	{
				LOG.debug(e.toString());
			} finally {
				LOG.debug("Sie haben das Spiel verloren.n");
			}
		} else if(input.equals("nein")) {
			LOG.debug("Dann halt nicht.");
		} else {
			throw new IllegalArgumentException("Valid arguments are: 'ja' and 'nein'");
		}
			
	} 
	

	
	 private static void enterMyAge() throws YouDontKnowMyBirthdayException   {
		LOG.debug("Raten Sie meinen Geburstag (xx.xx.xxxx):");
		input = scanner.next();	
		if(!(input.equals("22.01.1999"))) {
			throw new YouDontKnowMyBirthdayException(input);
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	 
	
	
	
}
	
