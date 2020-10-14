package ch.hslu.sw05.shape;

public  class Rectangle extends Shape {

	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x,y);
		this.width = width;
		this.height = height;		
	}
	
	public void changeDimension(int newWidth, int newHeight) {
		this.width = newWidth;
		this.height = newHeight;
		
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getPerimeter() {
		return (2 * width + 2* height);
	}
	
	public int getArea() {
		return (width * height);
	}
	
	
	
}
