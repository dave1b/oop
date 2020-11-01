package ch.hslu.sw05.aggregateState;

public class Mercury extends Element{

	public Mercury (float temp) {
		super( -38.8344f, 356.73f, temp);
	}

	public String toString() {
		return super.toString() + ". -> Hinweis: GIFTIG";
		
	}
	
	
	
}
