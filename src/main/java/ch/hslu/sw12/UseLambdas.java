package ch.hslu.sw12;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class UseLambdas {

	
	public UseLambdas() {
		
	}
	
	final static BinaryOperator<Integer> sum = (x,y) -> x+y;
	final int summe = sum.apply(23, 17);
		
	
	final static Predicate<Integer> biggerThanZero = x -> x>0;
	
	final static UnaryOperator<Integer> squaring = x -> x*x;
	
	final static UnaryOperator<Double> binarPowerCalc = x -> Math.pow(2, x);
	
	public static void main(String[] args) {
		System.out.println(sum.apply(3, 3));
		System.out.println(biggerThanZero.test(-55));
		System.out.println(squaring.apply(2));
		System.out.println(binarPowerCalc.apply(8d));
	
	}
	
	
	
	
	
	
}
