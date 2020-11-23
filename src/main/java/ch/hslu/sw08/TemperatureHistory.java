package ch.hslu.sw08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



import ch.hslu.sw10.MaxMinListener;
import ch.hslu.sw10.TemperaturEvent;
import ch.hslu.sw10.TemperaturEvent.Type;

public class TemperatureHistory extends Temperature implements Comparable<Temperature>, MaxMinListener {

	final List<Temperature> verlauf = new ArrayList<>();
	private final List<MaxMinListener> changeListeners = new ArrayList<>();


	public void add(float temp) {

		if(!verlauf.contains(new Temperature(temp)))
		{
			if(Float.compare(temp, this.getMaxItem().getTemperatureInCelsius()) == 1 && temp > -Temperature.KELVINOFFSET) {
				newMax();
			} else if(Float.compare(temp, this.getMinItem().getTemperatureInCelsius()) == -1 && temp > -Temperature.KELVINOFFSET) {
				newMin();
			}
			verlauf.add(Temperature.createFromCelsius(temp));
		}
	}


	public void clear() {
		verlauf.clear();
	}

	public int getCount() {
		return verlauf.size();
	}
	public Temperature getWithIndex(int index) {
		return verlauf.get(index);
	}

	@Override
	public int compareTo(Temperature other) {
		if(this == other) {
			return 0;
		} else {	
			return Float.compare(this.getTemperatureInCelsius(), other.getTemperatureInCelsius());
		}	
	}

	public Temperature getMaxItem() {
		if(verlauf.size() > 0) {
			return (Collections.max(verlauf));
		}
		return new Temperature();
	}

	public Temperature getMinItem() {
		if(verlauf.size() > 0) {
			return (Collections.min(verlauf));
		} 
		return new Temperature();			
	}

	public float getAverage() {
		int i = 0;
		float sum = 0f;
		Iterator<Temperature> iterator = verlauf.iterator();
		while(iterator.hasNext()) {
			i++;
			Temperature t = iterator.next();		
			sum += t.getTemperatureInCelsius();
		}
		if(i != 0) {
			return sum/i;
		} else {
			return 0f;
		}


	}







	public void newMax() {
		final TemperaturEvent pcEvent = new TemperaturEvent(this, Type.MAX, this.getMaxItem());
		this.extremValueChanged(pcEvent);
	}


	private void newMin() {
		final TemperaturEvent pcEvent = new TemperaturEvent(this, Type.MIN, this.getMinItem());
		this.extremValueChanged(pcEvent);		
	} 

	public void addPropertyChangeListener(MaxMinListener listener) {
		if(listener != null) {        	
			changeListeners.add(listener);
		}
	}

	public void removePropertyChangeListener(MaxMinListener listener) {
		if(listener != null) {        	
			changeListeners.remove(listener);
		}
	}

	@Override
	public void extremValueChanged(TemperaturEvent pcEvent) {
		for(final MaxMinListener listener : this.changeListeners) {
			(listener).extremValueChanged(pcEvent);
		}		
	}


	public String toString() {
		return "Size: " + this.getCount() + "\nAverage: " + this.getAverage() + "\nMax: " + this.getMaxItem() + "\nMin: " + this.getMinItem();
	}


	










}
