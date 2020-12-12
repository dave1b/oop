package ch.hslu.sw13.gui2;

import java.time.LocalDateTime;

public class SpeedMeasurement implements Comparable<SpeedMeasurement>{

	private String ID;
	private String timestamp;
	private float latency;
	private float download;
	private float upload;
	private String connectionType;
	private String serverLocation;
	
	
	
	public SpeedMeasurement() {
	}
	
	public SpeedMeasurement(String ID, String timestamp, float latency, float download, float upload, String connectionType, String serverLocation) {
		this.ID = ID;
		this.timestamp = timestamp;
		this.latency = latency;
		this.download = download;
		this.upload = upload;
		this.connectionType = connectionType;
		this.serverLocation = serverLocation;
	}


	public String getID() {
		return ID;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public float getLatency() {
		return latency;
	}


	public float getDownload() {
		return download;
	}


	public float getUpload() {
		return upload;
	}


	public String getConnectionType() {
		return connectionType;
	}


	public String getServerLocation() {
		return serverLocation;
	}

	public int compareTo(SpeedMeasurement other) {
		if(this == other) {
			return 0;
		} else {	
			return Float.compare(this.getDownload(), other.getUpload());
		}	
	}

	public String toString() {
		return "Date: " + timestamp + "\nPing: " + latency + "ms \nDownload: " + download + " MBit/s \nupload: " + upload + " MBit/s \nConnection type: " + connectionType + "\nServer Location: " + serverLocation;
	}
	
	
	
}
