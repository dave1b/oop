package ch.hslu.sw09v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReaderWriter {

	static private Scanner scanner = new Scanner(System.in);
	static private final Logger LOG = LogManager.getLogger(ReaderWriter.class);
	static String input;
	private static String filename;

	public ReaderWriter() {


	}

	
	public static void main(String[] args) {



		interactWithFile();
			/*
C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/Read.txt
C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/Write.txt
			*/	

	}


	public static void interactWithFile()  {
		String pfad;
		LOG.debug("Möchten Sie lesen 'r' oder schreiben 'w' ?");
		input = scanner.next();
		LOG.debug("Geben Sie den gewünschten Pfad des Files ein:");
		pfad = scanner.next();
		
		if(input.equals("r")) {
			try {
				read(pfad);
			}  
			catch (IOException e) {
				LOG.warn("Cannot find filename: " + e.getMessage());
			}
		} else if(input.equals("w")) {
			try {
				write(pfad);
			}
			catch(IOException e){
				LOG.warn("Cannot find filename: " + e.getMessage());
			}
		}
	}




	static public void read(String Pfad) throws IOException {
		String line = null;

		Charset charset = Charset.forName("UTF-8");
		Path path = Paths.get(Pfad);
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
		System.out.println(output.size());			
	}




	static public void write(String pfad) throws IOException  {		
		
		FileWriter writer = new FileWriter("C:/Users/Dave/myCloud/HSLU/Module/OOP/IO-Files/.txt");
		LOG.debug("Geben Sie einen Text ein (Abbrechen mit 'exit')");
//		do {
		input = scanner.next();
		writer.write(input);	
//		} while (input != "exit"); 
		writer.write("\n");
		writer.close();
		LOG.debug("Erfolgreich gespeichert.");
	}





}
