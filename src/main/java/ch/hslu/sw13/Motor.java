package ch.hslu.sw13;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Motor implements Switchable{

	private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
	//The state is stated in rpm.
	private MotorState state = MotorState.OFF;
	private int switches = 0;
	private int rpm = 0;

	static private enum MotorState {
		ON(), OFF(), STANDBY();	
	}

	@Override
	public void switchOn()
	{
		if(!isSwitchedOn()) {
			this.state = MotorState.ON;	
			if(rpm == 0) {
				this.rpm = 20;
			}
			final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"state",MotorState.OFF,MotorState.ON);
			this.firePropertyChange(pcEvent);
			increaseSwitches();   		
		}
	}

	@Override
	public void switchOff() 
	{
		if(isSwitchedOn()) {
			this.state = MotorState.OFF;
			rpm = 0;
			final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"state",MotorState.ON,MotorState.OFF);
			this.firePropertyChange(pcEvent);
			increaseSwitches();   		
		}
	}

	public void increaseRPM() {
		if(rpm == 0) {
			this.switchOn();
		} else {
			this.rpm += 20;
			final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"rpm", rpm-20, rpm);
			this.firePropertyChange(pcEvent);
		}
	}
	public void decreaseRPM() {
		if(rpm == 20) {
			this.switchOff();
		}
		else if(rpm == 0) {
			return;
		} else {
			this.rpm -= 20;
			final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"rpm", rpm+20, rpm);
			this.firePropertyChange(pcEvent);
		}
	}

	public int getRPM() {
		return this.rpm;
	}




	@Override
	public boolean isSwitchedOn()
	{             
		if(state == MotorState.ON) {
			return true;
		} 
		return false;
	}

	@Override
	public void increaseSwitches() {
		switches++;
	}

	public int getSwitches(){
		return switches;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if(listener != null) {        	
			changeListeners.add(listener);
		}
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if(listener != null) {        	
			changeListeners.remove(listener);
		}
	}

	public void firePropertyChange(final PropertyChangeEvent pcEvent) {
		for(final PropertyChangeListener listener : this.changeListeners) {
			listener.propertyChange(pcEvent);
		}		
	}
}



