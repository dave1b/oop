package ch.hslu.sw11;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw10.InteractWithTemperatures;

public class ReadByteStreamFromFile {
	static private final Logger LOG = LogManager.getLogger(InteractWithTemperatures.class);

	
	
	public static void read(String filename) {

		try(final DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {

			final int value = dis.readInt();
			Float f;
			System.out.println("Anzahl Einträge: " + value);			
			for(int i = 0; i < value; i++) {
				f = dis.readFloat();
				System.out.println("Temperature " + i + ": " + f + " °C");
			}
		} catch (IOException e) {
			LOG.error("Problem aufgetaucht in read() " + e.getMessage() + e.toString());
		}
	}	
}