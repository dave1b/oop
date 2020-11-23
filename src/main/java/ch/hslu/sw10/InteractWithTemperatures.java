package ch.hslu.sw10;



import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.TemperatureHistory;
import ch.hslu.sw09v2.ExceptionhandlingBasics;

public class InteractWithTemperatures  {

	
	static private final Logger LOG = LogManager.getLogger(ExceptionhandlingBasics.class);
	static private Scanner scanner = new Scanner(System.in);
	private String input = "";
	private TemperatureHistory history;

	
	private class HistoryPropertyListener implements MaxMinListener {
		@Override
		public void extremValueChanged(TemperaturEvent e) {
			LOG.debug("extremeValueChanged Methode auf InterActWithTemperatures aufgerufen.");
			System.out.println(e.toString());
		}
	}
	
	
	public InteractWithTemperatures () {
		history = new TemperatureHistory();
		this.history.addPropertyChangeListener(new InteractWithTemperatures.HistoryPropertyListener() );
		
	}
	
	
	
	

	
	
	
	final public void interact() {
		do {
			LOG.debug("Bitte Temperatur eingeben ('exit' zum Beenden): ");
			try {	
				if(!input.equals("exit")) {
				input = scanner.next();
				history.add(Float.parseFloat(input));
				LOG.info(history.getWithIndex(history.getCount()-1));
				}				
			} catch(NumberFormatException e) {
				LOG.warn(e.toString());
				
			}
		} while (!input.equals("exit"));
		LOG.info(history.toString());
		LOG.debug("Programm wurde beeendet.");
	
	}

		
	
	
	public static void main(String[] args) {
		InteractWithTemperatures i = new InteractWithTemperatures();
		i.interact();
		
	}












	




	
	
	
	
	
	
	
	
	
}
