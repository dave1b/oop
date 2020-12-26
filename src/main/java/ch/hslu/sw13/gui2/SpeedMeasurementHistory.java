package ch.hslu.sw13.gui2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class SpeedMeasurementHistory extends SpeedMeasurement {


	@SuppressWarnings("unused")
	private static final Logger LOG = LogManager.getLogger(SpeedMeasurementHistory.class);
	private List<SpeedMeasurement> history = new ArrayList<SpeedMeasurement>();

	public SpeedMeasurementHistory () {

	}

	public void addSpeedMeasurement(String ID, String timestamp, float latency, float download, float upload, String connectionType, String serverLocation) {

		if(!history.contains(new SpeedMeasurement(ID, timestamp, latency, download, upload, connectionType, serverLocation))) {
		}
		history.add(new SpeedMeasurement(ID, timestamp, latency, download, upload, connectionType, serverLocation));
	}

	public void clear() {
		history.clear();
	}

	public int getCount() {
		return history.size();
	}
	public SpeedMeasurement getWithIndex(int index) {
		return history.get(index);
	}


	public SpeedMeasurement getMaxItem() {
		if(history.size() > 0) {
			SpeedMeasurement s = 
					history.stream()
					.max(Comparator.comparing(m -> m.getDownload()))
					.get();
			return s;
		}
		return new SpeedMeasurement();
	}	
	// Alternativer Lösungsweg
	//		if(history.size() > 0) {
	//			return (Collections.max(history, Comparator.comparing(m -> m.getDownload())));
	//		}
	//		return new SpeedMeasurement();
	//	}

	public SpeedMeasurement getMinItem() {
		if(history.size() > 0) {
			SpeedMeasurement s = history.stream()
					.min(Comparator.comparing(m -> m.getDownload()))
					.get();
			return s;
		} 
		return new SpeedMeasurement();		
	}

	public float getAverage() {
		int i = 0;
		float sum = 0f;
		Iterator<SpeedMeasurement> iterator = history.iterator();
		while(iterator.hasNext()) {
			i++;
			SpeedMeasurement t = iterator.next();		
			sum += t.getDownload();
		}
		if(i != 0) {
			return sum/i;
		} else {
			return 0f;
		}


	}



}
