package ch.hslu.sw05.shape;

public class Square extends Shape {
	private int width;

	public Square(int x, int y, int width) {
		super(x,y);
		this.width = width;
	}

	public int getPerimeter() {
		return width;
	}

	public int getArea() {
		return (width * width);
	}
}
