package ch.hslu.sw05.aggregateState;

import java.util.Objects;

/**
 * Abstract class for different Objects. By entering a temperature the objects return their aggregate State at the given temperature.
 * 1 -> liquid / flüssig
 * 2 -> solid / fest
 * 3 -> gaseous / gasförmig
 * 
 * @author Dave
 * @version 1.1 (2020.10.14)
 *
 */

public abstract class Element implements Comparable<Element> {

	private float meltingPoint;
	
	private float boilingPoint;
	
	
	private float temp;
	
	
	protected Element(float meltingPoint, float boilingPoint, float temp) {
		this.meltingPoint = meltingPoint;
		this.boilingPoint = boilingPoint;
		this.temp = temp;
	}
	
	
	public enum States {
		FLÜSSIG("liquid"),FEST("solid"), GASFÖRMIG("gaseous"), UNDEFINED("undefined");
		
		private final String state;
		
		private States(final String state) {
			this.state = state;
		}
		public String getValue() {
			return this.state;
			}	
	}
	
	
	
	

	/**
	 * Method that gives back the aggregate state of the element at the temperature given as the parameter.
	 * @param the temperature to test the aggregate state of the element.
	 * 
	 */
	public int getState() {
		if(temp < meltingPoint) {
			return 1;
		} else if(temp > boilingPoint) {
			return 3;
		} else {
			return 2;
		}
		
	}
	
	/**
	 * Gives back a String which describes the aggregate state by the given temp.
	 * @return String
	 */
	private String getStateString() {
		switch(getState()) {
			case 1:
				return States.FLÜSSIG.getValue();
			case 2:
				return States.FEST.getValue();
			case 3:
				return States.GASFÖRMIG.getValue();
			default:
				return States.UNDEFINED.getValue();			
		}			
	}
	
	
	@Override
	public String toString() {
		return "The aggregate state at " + temp + "°C is: " + getStateString();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (!(obj instanceof Element)) {
			return false;
		}
		Element other = (Element) obj;
		return Objects.equals(this.getState(), other.getState());
				
	}
	
	@Override
	public int hashCode() {
		return this.getState() * 7 + this.getState();
		
	}
	
	public int compareTo(Element other) {
		return Float.compare(this.temp, other.temp);
	}
	

	
	public static void main(final String[] args) {
		 Nitrogen nitrogen1;
		 Mercury mercury1;
		 Mercury mercury2;
		 Mercury mercury3;
		nitrogen1 = new Nitrogen(-200f);
		mercury1 = new Mercury(35f);
		mercury2 = mercury1;
		mercury3 = new Mercury(-135f);
		System.out.println(nitrogen1.toString());
	
	}
	
}
