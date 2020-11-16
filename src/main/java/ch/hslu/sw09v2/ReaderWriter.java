package ch.hslu.sw09v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReaderWriter {

	static private Scanner scanner = new Scanner(System.in);
	static private final Logger LOG = LogManager.getLogger(ReaderWriter.class);
	static private String input;
	
	@SuppressWarnings("unused")
	private static String filename;


	
	public static void main(String[] args) {



		interactWithFile();
			/*
C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/Read.txt
C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/Write.txt
			*/	

	}


	public static void interactWithFile()  {
		
		LOG.debug("Möchten Sie lesen 'r' oder schreiben 'w' ?");
		input = scanner.next();
		if(input.equals("r")) {
			LOG.debug("read \n");
			try {
				read();
			}  
			catch (IOException e) {
				LOG.warn("Cannot find filename: " + e.getMessage());
			}
		} else if(input.equals("w")) {
			LOG.debug("write \n");
			try {
				write();
			}
			catch(IOException e){
				LOG.warn("Cannot find filename: " + e.getMessage());
			}
		} else {
			LOG.debug("Starten Sie erneut und geben Sie 'r' oder 'w'.");
			return;
		}
	}




	static public void read() throws IOException {
		String line = null;
		Charset charset = Charset.forName("UTF-8");
		Path path = Paths.get("C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/Read.txt");
		filename = path.toString();
		BufferedReader reader = Files.newBufferedReader(path, charset);

		do {
			line = reader.readLine(); 
			if(line != null)
				System.out.println(line);
		}
		while(line != null);

		reader.close();

	}

	
	static public void readWithLines(String pfad) throws IOException  {
		Path path = Paths.get(pfad);
		ArrayList<String> output= new ArrayList<String>();
		output = (ArrayList<String>) Files.readAllLines(path);
		output.forEach((n) -> System.out.println(n)); 
	}




	static public void write() throws IOException  {	
		String input;
		
		FileWriter writer = new FileWriter("C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/Write.txt");
		LOG.debug("Geben Sie einen Text ein (Abbrechen mit 'exit')");
		do {
		input = scanner.next();
		if(!(input.equals("exit"))) {			
		writer.write(input);	
		writer.write(" ");
		}
		} while (!input.equals("exit")); 
		writer.write("\n");
		writer.close();
		LOG.debug("Erfolgreich gespeichert.");
	}





}