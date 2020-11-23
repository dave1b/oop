package ch.hslu.sw09v2;


/**
 * Checked Exception for 
 * @author Dave
 *
 */

@SuppressWarnings("serial")
public class YouDontKnowMyBirthdayException extends Exception {
	
	private String key;
	
	public YouDontKnowMyBirthdayException(String key) {
		this.key = key;
	}
	
	public String toString() {
		return "Sie wissen meinen Geburtstag nicht! Es ist nicht: "  + key;
	}
	
	
}
