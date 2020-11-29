package ch.hslu.sw11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {

	
	
	
	
	public static LocalDateTime convertToDate(String date) {
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
		
	}
	
	
	
}
