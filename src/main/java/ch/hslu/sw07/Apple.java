package ch.hslu.sw07;

import java.util.ArrayList;

public class Apple extends Fruits{
	
	
	ArrayList<Apple> fruits = new ArrayList<Apple>();
	
	

	public Apple() {
		
		fruits.add(this);
	}
	
	
}
