package ch.hslu.sw06.exercise;

public class Main {

	
	
	
	public static void main(final String[] args) {
		
//		Point point1 = new Point(4,5);
//		Point point2 = new Point(-4,-5);
//		Point point3 = new Point(point2);
//		System.out.println(point1.toString());
//		point1.moveRealative(4, 5);
//		System.out.println(point1.toString());
//		point1.moveRealative(point2);
//		System.out.println(point1.toString());
//		System.out.println(point3.toString());
		
		
		
		
		// Polarkoordination
		
		Point point4 = new Point(11.402d, 52.125d);
		System.out.println(point4.getXByPolar());
		System.out.println(point4.getYByPolar());
		
		
		
		
		// Int Koordinaten
		Point point5 = new Point(5,5);
		Point point6= new Point(point5);
		point6.moveRealative(2,2);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(point6.toString());
	}
	
	
	
}
