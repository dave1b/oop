package ch.hslu.mashup;

import java.util.ArrayList;

public class Main {

	
	   public static void main(final String[] args) {
			
		   final String element1 = "Hg";
		   Temperature temperature = new Temperature();
		   System.out.println(temperature.aggregateState(element1));
		   
		    ArrayList<String> cars = new ArrayList<String>();
		    cars.add("Volvo");
		    cars.add("BMW");
		    cars.add("Ford");
		    cars.add("Mazda");
		    System.out.println(cars);
		    
		    for (String i : cars) {
		        System.out.println(i);
		      }
			
			//aggregateState("Hg");
		}


	
	
}
