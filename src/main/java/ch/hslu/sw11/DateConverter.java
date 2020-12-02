package ch.hslu.sw11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {

	
	
	
	/**
	 * Changes a date in the Typ String to an Object of LocalDateTime. The String must be in this order: "YYYY/MM/DD HH/MM/SS".
	 * @param Date as a String.
	 * @return The Date as a LocalDateTime - Object.
	 */
	public static LocalDateTime convertToDate(String date) {
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
		
	}
	
	
	
}
