package ch.hslu.sw13.gui2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.TemperatureHistory;
import ch.hslu.sw11.DateConverter;
import ch.hslu.sw11.FileExists;


public class ReadSpeedMeasurements {

	
	final private String filename = "C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\Speedtest.csv";
	private static final Logger LOG = LogManager.getLogger(ReadSpeedMeasurements.class);
	
	
	
	
	
	
	public static void main(String args[]) {
		ReadSpeedMeasurements r = new ReadSpeedMeasurements();
		r.readCSVFile();
	}
	
	
	
	
	
	
	
	public void readCSVFile() {
		if(!FileExists.checkFileExistance(filename)) {
			LOG.info(filename + " doesnt exists.");
			return;
		}
		else {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8"))))
			{
				String line;
				int i = 0;
				SpeedMeasurementHistory h = new SpeedMeasurementHistory();
				line = br.readLine();
				while((line = br.readLine()) != null) {
					String[] values;
					
					values = line.split(",");
					String ID = values[0];
					String timestamp = values[1];	
					float latency = Float.valueOf(values[2]);
					float download = Float.valueOf(values[3]);
					float upload = Float.valueOf(values[4]);
					String connectionType = values[5];
					String serverLocation = values[6];
//					public SpeedMeasurement(String ID, LocalDateTime timestamp, float latency, float download, float upload, String connectionType, String serverLocation)
					h.addSpeedMeasurement(ID, timestamp, latency, download, upload, connectionType, serverLocation );
					i++;
				}
				System.out.println("Fastest Downloadspeed\n" + h.getMaxItem());
				System.out.println("");
				System.out.println("Slowest Downloadspeed\n" + h.getMinItem());
				System.out.println("");
				System.out.println("Avergage Speed: " + h.getAverage() + " MBit/s");
			} catch(IOException e) {
				LOG.error(e.getLocalizedMessage(), e);
			}

		}
	}
	
	
	
	
	
	
	
	
	
	
}
