package ch.hslu.sw05.aggregateState;

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

public abstract class Element {

	private float meltingPoint;
	
	private float boilingPoint;
	
	
	private float temp;
	
	
	protected Element(float meltingPoint, float boilingPoint) {
		this.meltingPoint = meltingPoint;
		this.boilingPoint = boilingPoint;
	}
	
	/**
	 * Method that gives back the aggregate state of the element at the temperature given as the parameter.
	 * @param the temperature to test the aggregate state of the element.
	 * 
	 */
	public int getState(float temp) {
		this.temp = temp;
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
	private String getState() {
		switch(getState(temp)) {
			case 1:
				return "liquid";
			case 2:
				return "solid";
			case 3:
				return "gaseous";
			default:
				return "Error";			
		}			
	}
	
	
	@Override
	public String toString() {
		return "The aggregate stae is: " + getState();
	}
	
	
	
	
	
}
