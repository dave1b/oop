package ch.hslu.sw10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


final public class Licht implements Switchable {

	private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
	private boolean state = false;
	private int switches;
	
    @Override
	public void switchOn()
	{
    	if(!isSwitchedOn()) {
    		this.state = true;
    		final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"state",false, true);
    		this.propertyChange(pcEvent);
    		increaseSwitches();   		
    	}
	}
    @Override
	public void switchOff()
	{
    	if(isSwitchedOn()) {
    		this.state = false;
    		final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"state",true, false);
    		this.propertyChange(pcEvent);
    		increaseSwitches();   		
    	}

	}
    @Override
	public boolean isSwitchedOn()
	{
		return state;
	}
    
    @Override
	public void increaseSwitches() {
		switches++;
	}
    @Override
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
	
	public void propertyChange(final PropertyChangeEvent pcEvent) {
		for(final PropertyChangeListener listener : this.changeListeners) {
			listener.propertyChange(pcEvent);
		}		
	}
    
    
    
    
    
}
