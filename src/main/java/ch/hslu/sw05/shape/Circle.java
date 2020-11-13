package ch.hslu.sw05.shape;

public class Circle extends Shape {

	private int diameter;
	
	public Circle(int x, int y, int diameter) {
		super(x,y);
		this.diameter = diameter;
	}
	
	final public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
	final public int getDiameter() {
		return this.diameter;
	}
	
	@Override
	final public int getPerimeter() {
		return (this.diameter/2*2*3);
	}
	
	@Override
	final public int getArea() {
		return(this.diameter/2 * this.diameter/2 * 3);
	}
}
