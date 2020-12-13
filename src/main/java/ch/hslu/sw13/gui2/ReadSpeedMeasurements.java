package ch.hslu.sw13.gui2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
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


public class ReadSpeedMeasurements implements  ActionListener{


	private String path;
	private String filename;
//			"C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\Speedtest.csv";
	private static final Logger LOG = LogManager.getLogger(ReadSpeedMeasurements.class);

	SpeedMeasurementHistory history;
	SpeedMeasurementsView view;

	public ReadSpeedMeasurements() {
		history = new SpeedMeasurementHistory();
		view = new	SpeedMeasurementsView();
		this.view.getButtonOK().addActionListener(this::actionPerformed);
		this.view.getButtonOpenFile().addActionListener(this::actionPerformed);
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		ReadSpeedMeasurements r = new ReadSpeedMeasurements();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.getButtonOK()) {
			if(path != null) {
			System.out.println(path);
			this.readCSVFile(path);
			} else {
			this.view.displayInfoMessage("Please select a File.");
			}
			LOG.debug("ButtonOK pressed");
		} 
		if (e.getSource() == view.getButtonOpenFile()) {
			File file = this.view.selectFile();	
			path = file.getAbsolutePath();
			filename = file.getName();
			this.view.setTextAreaFile(filename);
			LOG.debug("openFileButton pressed");
		}
	}








	public void readCSVFile(String path) {
		this.path = path;
		if(!FileExists.checkFileExistance(path)) {
			LOG.info(path + " doesnt exists.");
			return;
		}
		else {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("UTF-8"))))
			{
				String line = br.readLine();
				int i = 0;				
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
					history.addSpeedMeasurement(ID, timestamp, latency, download, upload, connectionType, serverLocation );
					i++;
				}
				this.view.setTextAreaMax(history.getMaxItem());
				this.view.setTextAreaMin(history.getMinItem());
				this.view.setTextAreaAverage(history.getAverage());
				
				System.out.println("Fastest Downloadspeed\n" + history.getMaxItem());
				System.out.println("");
				System.out.println("Slowest Downloadspeed\n" + history.getMinItem());
				System.out.println("");
				System.out.println("Avergage Speed: " + history.getAverage() + " MBit/s");
			} catch(IOException e) {
				LOG.error(e.getLocalizedMessage(), e);
			}

		}
	}











}
