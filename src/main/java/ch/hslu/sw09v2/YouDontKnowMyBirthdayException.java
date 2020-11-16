package ch.hslu.sw09v2;

public class YouDontKnowMyBirthdayException extends Exception {

	private static final long serialVersionUID = 1L;
	private String key;
	
	public YouDontKnowMyBirthdayException(String key) {
		this.key = key;
	}
	
	public String toString() {
		return "Sie wissen meinen Geburtstag nicht! Es ist nicht: "  + key;
	}
	
	
}
