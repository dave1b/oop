package ch.hslu.sw11;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteChartToFile {

	
	final private String filename = "C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\ChartWrite.txt";
	private static final Logger LOG = LogManager.getLogger(WriteChartToFile.class);
	static private Scanner scanner = new Scanner(System.in);
	//US-ASCII
	
	
	public void writeToFile() {
		
		if(FileExists.checkFileExistance(filename)) {
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), Charset.forName("US-ASCII"))))){
			String input;
			System.out.println("Schreiben Sie hier:");
			do {
				input = scanner.next();
				if(!input.equals("save")) {
				pw.write(input + " ");				
				}				
			}while(!input.equals("save"));	
			pw.flush();
			LOG.info("Die Daten wurden erfolgreich gespeichert");
		} catch(IOException e) {
			LOG.error(e.getMessage());
		}
		}
		else {
			LOG.warn("Filen existiert nicht!");
		}
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		WriteChartToFile writer = new WriteChartToFile();
		writer.writeToFile();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
