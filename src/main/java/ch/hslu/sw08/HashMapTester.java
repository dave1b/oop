package ch.hslu.sw08;

import java.util.HashMap;

public class HashMapTester {

	private HashMap<String, String> contacts = new HashMap<>();
	
	public HashMapTester() {
		contacts.put("dave", "0414602289");
		contacts.put("karin", "0414602289");
		contacts.put("mike", "0414602289");
		contacts.put("kevin", "0414602289");
//		contacts.put("kevin", "999999999");
	}
	
	public String getNumber(String key) {
		System.out.println(contacts.get(key.toLowerCase()));
		return contacts.get(key.toLowerCase());
	}
	
	public int getEntries() {
		System.out.println(contacts.size());
		return contacts.size();
	}
	
	public void printHashMap() {
		System.out.println(contacts.values());
	}
	
}
