package ch.hslu.sw09;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.Temperature;
 

public class ExceptionhandlingBasics {

	
	static private final Logger LOG = LogManager.getLogger(ExceptionhandlingBasics.class);
	static private String input;
	static private Scanner scanner = new Scanner(System.in);
	
	public static void main(final String[] args) {
		
		// Test all Logging-Levels
		LOG.error("Hallo! Das ist ein Error Log!");
		LOG.warn("Hallo! Das ist ein Warn Log!");
		LOG.info("Hallo! Das ist ein Info Log!");
		LOG.debug("Hallo! Das ist ein Debug Log!");
		LOG.trace("Hallo! Das ist ein Trace Log!");
		
		printTempInFloat();
		
	}
		
		static private void printTempInFloat() {
		do {
			LOG.debug("Bitte Temperatur eingeben ('exit' zum Beenden): ");
		input = scanner.next();
		
		if(onlyNumber(input)) {	
			Temperature t = new Temperature(Float.parseFloat(input));			
			LOG.debug(t.toString());
		} else {
			LOG.warn("Geben Sie eine gültige Float ein. \n");
		}} while(!input.equals("exit"));
				
		}
		

	
	 @SuppressWarnings("unused")
	public static boolean onlyNumber(String str) 
	    { 
		 int n = str.length();
	    
	        // Traverse the string from 
	        // start to end 
	        for (int i = 0; i < n; i++) { 
	            // Check if character is 
	            // digit from 0-9 
	            // then return true 
	            // else false 
	            if (str.charAt(i) >= '0'
	                && str.charAt(i) <= '9') { 
	                return true; 
	            } 
	            else { 
	                return false; 
	            } 
	        } 
	        // if String has 0 chars
	        return false; 
	 
	    }
	
	// Erste Version
	 /*try {
			do {
			LOG.debug("Bitte Temperatur eingeben ('exit' zum Beenden): ");
			input = scanner.next();
			float value = Float.valueOf(input);
			System.out.println(value);
			} while (!input.equals("exit"));
			LOG.debug("Programm beendet.");
			} 
		catch (NumberFormatException e) {
			LOG.warn(e.getMessage() + "\n" + e.toString());
		}
	  */
	 
	 
	
	
	
}
	
