package ch.hslu.sw05.übung;

public class Main {

	
	
	
	public static void main(final String[] args) {
		
		Point point1 = new Point(4,5);
		Point point2 = new Point(-4,-5);
		Point point3 = new Point(point2);
		System.out.println(point1.toString());
		point1.moveRealative(4, 5);
		System.out.println(point1.toString());
		point1.moveRealative(point2);
		System.out.println(point1.toString());
		System.out.println(point3.toString());
	
	}
	
	
	
}
