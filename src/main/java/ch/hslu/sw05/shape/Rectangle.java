package ch.hslu.sw05.shape;

public  class Rectangle extends Shape {

	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x,y);
		this.width = width;
		this.height = height;		
	}
	
	final public void changeDimension(int newWidth, int newHeight) {
		this.width = newWidth;
		this.height = newHeight;
		
	}
	
	final public int getWidth() {
		return this.width;
	}
	
	final public int getHeight() {
		return this.height;
	}
	
	@Override
	final public int getPerimeter() {
		return (2 * width + 2* height);
	}
	
	@Override
	final public int getArea() {
		return (width * height);
	}
	
	
	
}
