package ch.hslu.sw12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

import ch.hslu.sw07.Person;

public class TemperatureHistory2 {

	
	Collection<Temperature2> history = new ArrayList<>();
	final Comparator<Temperature2> comp= (p1, p2) -> p1.compareTo(p2);
	int v = 1;

			
			
//			.map(t -> {				
//			return t.getTemperatureInCelsius();}
//			.max(Comparator.comparing(Temperature2::getTemperatureInCelsius))
//			.max(Float::compare)
//			.get());
	
	
	public TemperatureHistory2() {
		
	}
	
	public void add(float temp) {
		
//		if(history.contains(new Temperature2(temp))) {
//			return;
//		} else {
//			if()
//		}
			
		
		history.add(new Temperature2(temp));
	}
	
	public static void main(String args[]) {
		TemperatureHistory2 history = new TemperatureHistory2();
		history.add(44f);
		history.add(41f);
		history.add(41f);
		history.add(41f);
		history.add(1f);
//		System.out.println(history.getMax);
//		history.getAmount(41);
//		history.biggerThanZero();
//		history.printAll();
//		System.out.println(history.getAmmount());
//		System.out.println(history.getMin());
//		System.out.println(history.getMax());
//		history.createIntegerTempList();
		System.out.println(history.getAverage());
		System.out.println(history.getAverage2());
		System.out.println(history.getAverage3());
		
	}
	
	
	
	public void getAmount(float temp) {
		history.stream()
		.map(t -> t.getTemperatureInCelsius())
		.filter(t -> t.equals(temp))
		.forEach(t -> System.out.println(t));
	
	}
	
	public void printAll() {
		history.stream()
		.map(t -> t.getTemperatureInCelsius())
		.forEach(t -> System.out.println(t));
	}
	public void biggerThanZero() {
		history.stream()
		.map(t -> t.getTemperatureInCelsius())
		.filter(t -> t>0f)
		.forEach(t -> System.out.println(t));
	}
	public void smallerThanZero() {
		history.stream()
		.map(t -> t.getTemperatureInCelsius())
		.filter(t -> t<0f)
		.forEach(t -> System.out.println(t));
	}
	public double getAmmount() {
		return history.stream()
		.count();	
	}
	
	public float getMax() {
		float f = history.stream()
		.map(t -> t.getTemperatureInCelsius())
		.max(Float::compare)
		.get();
		return f;
	}
	public float getMin() {
		float f = history.stream()
				.map(t -> t.getTemperatureInCelsius())
				.min(Float::compare)
				.get();
		return f;
	}
	
	
	public void createIntegerTempList() {
	Collection<Integer> tempInt = history.stream()
			.map(Temperature2::getTemperatureInCelsius)
			.map(t -> t.intValue())
			.collect(Collectors.toList());
	
	tempInt.forEach(System.out::println);
	}
	
	public void createDoubleTempList() {
		Collection<Double> tempInt = history.stream()
				.map(t -> t.getTemperatureInCelsius())
				.map(t -> t.doubleValue())
				.collect(Collectors.toList());	
		tempInt.forEach(System.out::println);
	}
	
	
	public float getAverage() {		
		float sum = history.stream()
				.map(Temperature2::getTemperatureInCelsius)
				.reduce((total,count) ->  total + count)
				.get();
		float i = history.stream()
				.map(Temperature2::getTemperatureInCelsius)
				.count();
				return sum/i;
				
	}
	public float getAverage2() {		
		Double i = history.stream()
				.map(Temperature2::getTemperatureInCelsius)
				.collect(Collectors.averagingDouble(t -> t.doubleValue()));
		return i.floatValue();		
	}
	public float getAverage3() {		
		Double i = history.stream()
				.map(Temperature2::getTemperatureInCelsius)
				.map(t -> t.doubleValue())
				.collect(Collectors.averagingDouble(t -> t));
		return i.floatValue();		
	}
	
	
	
//			history.stream
////			.mapToDouble(t -> t.getTemperatureInCelsius())
//			.collect(Collectors.summarizingDouble(t -> (t.getTemperatureInCelsius())));
	
	
	
	
}
