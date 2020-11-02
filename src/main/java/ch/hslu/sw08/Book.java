package ch.hslu.sw08;

public class Book extends Library{
	private String name;
	
	
	public Book (String name)	{ 
		this.name = name;
		
	}
	
	public void addToBooks() {
		super.addBook(this);
	}
}