package ch.hslu.sw08;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomTester {

	Random randGenerator = new Random();
	
	
	// returns int between 0 and 4
	public int getRandom(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(5);
    
    }
	
	public IntStream getRandom(int x,int y){
        Random randomGenerator = new Random();
        return randomGenerator.ints(x,y);
    
    }
	
	
	
}
