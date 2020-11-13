package ch.hslu.sw08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;




public class TemperatureHistory extends Temperature implements Comparable<Temperature> {

	final List<Temperature> verlauf = new ArrayList<>();
	
	
	public void add(float temp) {
		
		if(!verlauf.contains(new Temperature(temp)))
		{
		verlauf.add(new Temperature(temp));
		}
	}
	
	
	public void clear() {
		verlauf.clear();
	}
	
	public int getCount() {
		return verlauf.size();
	}

	
	@Override
	public int compareTo(Temperature other) {
		if(this == other) {
			return 0;
		} else {	
		return Float.compare(this.temp, other.temp);
		}	
	}
	
	public float getMaxItem() {
		if(verlauf.size() > 0) {
		return (Collections.max(verlauf,null)).getTemperature();
		}
		return 0;
	}
	
	public float getMinItem() {
		if(verlauf.size() > 0) {
			return (Collections.min(verlauf,null)).getTemperature();
		} 
			return 0;
	}
		
	public float getAverage() {
		int i = 0;
		float sum = 0f;
		Iterator<Temperature> iterator = verlauf.iterator();
		while(iterator.hasNext()) {
			i++;
			Temperature t = iterator.next();		
			sum += t.getTemperature();
		}
		if(i != 0) {
		return sum/i;
		} else {
		return 0f;
		}
	}
	
	
	
}
