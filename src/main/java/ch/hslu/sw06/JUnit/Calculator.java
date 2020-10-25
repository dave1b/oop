package ch.hslu.sw06.JUnit;

public class Calculator implements Addition{

	@Override
	public int addition(int x, int y) {
		System.out.println(x+y);
		return x+y;
	}

	
	
	
	
}
