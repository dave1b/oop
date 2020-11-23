package ch.hslu.sw10;


/**
 * Interface for switchable objects.
 * @author Dave
 * @version 1.0
 *
 */

public interface Switchable {

	/**
	 * Turn the object on.
	 */
	void switchOn();
	
	
	/**
	 * Turn the object off.
	 */
	void switchOff();
	
	
	/**
	 * Checks if the object is turned on.
	 * @return boolean if object is turned on
	 */
	boolean isSwitchedOn();
	
	
	/**
	 * Increases the switch-counter i++.
	 */
	void increaseSwitches();
	
	/**
	 * @return Returns the amount of times the switchOn or switchOff Method has been trigered.
	 */
	int getSwitches();
	
}
