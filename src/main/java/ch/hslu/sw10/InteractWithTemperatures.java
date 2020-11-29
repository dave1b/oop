package ch.hslu.sw10;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.TemperatureHistory;
import ch.hslu.sw09v2.ExceptionhandlingBasics;
import ch.hslu.sw11.ReadByteStreamFromFile;
import ch.hslu.sw11.WriteByteStreamToFile;

import java.util.Scanner;

public class InteractWithTemperatures  {

	
	static private final Logger LOG = LogManager.getLogger(InteractWithTemperatures.class);
	static private Scanner scanner = new Scanner(System.in);
	private String input = "";
	private TemperatureHistory history;
	final private String filename = "C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\Temperatures.dat";

	
	private class HistoryPropertyListener implements MaxMinListener {
		@Override
		public void extremeValueChanged(TemperaturEvent e) {
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
			System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
			try {	
				input = scanner.next();
				if(!input.equals("exit")) {
				history.add(Float.parseFloat(input));
				System.out.println(history.getWithIndex(history.getCount()-1)+"\n");
				}				
			} catch(NumberFormatException e) {
				LOG.warn(e.toString());
				
			}
		} while (!input.equals("exit"));
//		LOG.info(history.toString());
		System.out.println(history.getCount());
		WriteByteStreamToFile.writeInFile(history.getCount(), history.getArrayList(), filename);
		ReadByteStreamFromFile.read(filename);
		LOG.debug("Programm wurde beeendet.");
	
	}

		
	
	
	public static void main(String[] args) {
		InteractWithTemperatures i = new InteractWithTemperatures();
		i.interact();
		
	}












	




	
	
	
	
	
	
	
	
	
}
