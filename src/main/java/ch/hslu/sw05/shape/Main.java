package ch.hslu.sw05.shape;

public class Main {

	public static void main(final String[] args) {
		
		Shape shape1 = new Circle(0,0,5);
		System.out.println(shape1.getX());
		System.out.println(shape1.getY());
		shape1.move(2, 1);
		System.out.println(shape1.getX());
		System.out.println(shape1.getY());
		
		
		// Downcasten
		Circle circle1 = (Circle) shape1;
		
		System.out.println(circle1.getDiameter());
		System.out.println(circle1.getPerimeter());
		System.out.println(circle1.getArea());
		System.out.println(circle1.getX());
	}
		
	
}
