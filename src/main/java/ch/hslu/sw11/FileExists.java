package ch.hslu.sw11;

import java.io.File;


public class FileExists {

	
	final static boolean checkFileExistance(String filename) {
		final File file = new File(filename);
		return file.exists();
		
		
	}
	
	
	
}
