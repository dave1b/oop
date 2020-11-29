package ch.hslu.sw11;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.TemperatureHistory;


public class ReadCharStreamFromFile {

	final private String filename;
	private static final Logger LOG = LogManager.getLogger(ReadCharStreamFromFile.class);

	public ReadCharStreamFromFile() {
		filename = "C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\netatmo-export-201801-201804.csv";
	}
	public ReadCharStreamFromFile(String filename) {
		this.filename = filename;
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
				TemperatureHistory h = new TemperatureHistory();
				while((line = br.readLine()) != null) {
					String[] values;
					values = line.split(";");
					float temp = Float.valueOf(values[2]);
					LocalDateTime timestamp = DateConverter.convertToDate(values[1]);	

					h.addWithTimestamp(temp, timestamp);
					//					System.out.println(h.getCount());
					System.out.println("Wert " + i + ": " + timestamp + " " + temp + "°C");

					i++;
				}
				System.out.println("Max: " + h.getMaxItem() + " messured at: " + h.getMaxItem().getTimestamp());
				System.out.println("Min: " + h.getMinItem() + " messured at: " + h.getMinItem().getTimestamp());
				System.out.println("Avergage: " + h.getAverage() + "°C");
			} catch(IOException e) {
				LOG.error(e.getLocalizedMessage(), e);
			}




		}
	}

	public static void main(String[] args) {
		ReadCharStreamFromFile reader = new ReadCharStreamFromFile();
		reader.readCSVFile();
	}



}
