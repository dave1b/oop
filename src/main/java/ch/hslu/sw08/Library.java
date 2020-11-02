package ch.hslu.sw08;
import java.util.ArrayList;



public class Library {

	private ArrayList<Book> books;
	private ArrayList<String> tracks;
	
	
	public Library() {
		books = new ArrayList<>();
		tracks = new ArrayList<>();
	}
	
	public void addTrack(String track) {
		this.tracks.add(track);
	}
	
	public void deleteTrack(int index) {
		if(index >= 0 && index <= tracks.size()) {
		this.tracks.remove(index);
		} else {
			System.out.println("Enter valid index.");
		}
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
		
	public void printTracks() {
		int l = 0;
		for(String i : tracks) {
			l++;
			System.out.println(l + ": " + i);
		}
	}
	
	public void printSearch(String key) {
		boolean found = false;
		for(String i : tracks) {
			if(i.contains(key)) {
				System.out.println(i);
				found = true;
			}
		}
		if(found == false) {
			System.out.println(key + " wasnt found in database.");
		}
	}
	
	public int getTracksSize() {
		return tracks.size();
	}
	
	public int getBookSize() {
		return books.size();
		
	}
	
	public void printBooks() {
		System.out.println(books.toString());
	}
	

	
	
	
}