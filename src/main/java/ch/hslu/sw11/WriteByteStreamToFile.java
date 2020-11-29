package ch.hslu.sw11;
import ch.hslu.sw08.*;



import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ch.hslu.sw10.InteractWithTemperatures;

import ch.hslu.sw08.*;

public class WriteByteStreamToFile {
	
	static private final Logger LOG = LogManager.getLogger(InteractWithTemperatures.class);
	
	
	
	




//	static public void writeSingleInt(final int number, final String filename) {
//		
//		try(final DataOutputStream dis = new DataOutputStream(new FileOutputStream(filename))) {
//	
//		} catch (IOException e) {
//			LOG.error("Problem in writeSingleInt() aufgetaucht: " + e.getMessage() + e.toString());
//		}
//	}
	
	
	
	static public void writeInFile(final int number, List<Temperature> list, String filename) {
		
		try(final DataOutputStream dis = new DataOutputStream(new FileOutputStream(filename))) {
			dis.writeInt(number);			
			LOG.info("Einzelne Int in Datei geschrieben: " + number);
			for(Object temp: list) {
			dis.writeFloat(((Temperature) temp).getTemperatureInCelsius());
			}
			LOG.info("Datei geschrieben.");
		} catch (IOException e) {
			LOG.error("Problem in writeArray aufgetaucht: " + e.getMessage() + e.toString());
		}
	}

	
	}
	
	
	
	
	
	
	
	
	
	
	
	


