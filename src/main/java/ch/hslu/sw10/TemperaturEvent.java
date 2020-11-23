package ch.hslu.sw10;


import java.util.EventObject;


public class TemperaturEvent extends EventObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Type {
		MAX, MIN;
	}
	
	
	private Type type;
	private Object newExtremeValue;
	
	public TemperaturEvent(Object source, Type type, Object newExtremeValue) {
		super(source);
		this.type = type;
		this.newExtremeValue = newExtremeValue;
		
	}

	
	public Type getPropertName() {
		return this.type;
	}
	
	public Object getNewExtremeValue() {
		return this.newExtremeValue;
	}
	
	public String toString() {
		return "Type: " + this.getPropertName() + " \nSource: " + this.getSource() + "\n new extreme Value: " + this.getNewExtremeValue();
	}
	
}
