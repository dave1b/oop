package ch.hslu.sw12;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;




import ch.hslu.sw07.Person;

public class StreamAPI {


	final Comparator<Person> nameComp= (p1, p2) ->p1.getSurname().compareTo(p2.getSurname());
//	final Comparator<Person> nameComp= (p1, p2) -> p1.getSurname().compareTo(p2.getSurname());
	


	public StreamAPI() {
	}


	public void printExamples() {

		// Arrays to Stream
		Arrays.asList("a1", "a2", "a3")
		.stream()
		.findFirst()
		.ifPresent(System.out::println);  // a1

		// Array.stream
		Arrays.stream(new int[] {1, 2, 3})
		.map(n -> 2 * n + 1)
		.average()
		.ifPresent(System.out::println); 

		// Stream.of
		Stream.of("a1", "a2", "a3")
		.findFirst()
		.ifPresent(System.out::println);

		// IntStream
		IntStream.range(1, 4)
		.forEach(System.out::println);

		IntStream.range(1, 4)
		.mapToObj(i -> "a" + i)
		.forEach(System.out::println);


	}

	
	
	
	public void sortArray() {
		
		//List erstellen
		List<Person> persons =
				Arrays.asList(
						new Person("Müller","Max", 1898),
						new Person("Meier", "Peter",2398),
						new Person("Anderson", "Sarah", 2388),
						new Person("Kaufmann", "David", 1291));
		
		Collections.sort(persons, nameComp);
		
//		Collection<Person> persons2 = persons.stream()
//				.sort(persons, nameComp);
//				.collect(Collectors.toList());

		persons.stream()
		.forEach(System.out::println);
		
	}


	public void makeArray() {
		//List erstellen
		List<Person> persons =
				Arrays.asList(
						new Person("Müller","Max", 1898),
						new Person("Meier", "Peter",2398),
						new Person("Anderson", "Pamela", 2388),
						new Person("Golliath", "David", 1291));

		// List filtern und in neue List
		List<Person> filtered =	persons
				.stream()
				.filter(p -> p.getPrename().startsWith("D"))
				.collect(Collectors.toList());

		System.out.println(filtered);


		// Durchschnitts-Jahrgang
		Double averageVintage = persons
				.stream()
				.collect(Collectors.averagingInt(p -> p.getVintage()));

		System.out.println(averageVintage); 


		// Durchschnitts-Jahrgang
		IntSummaryStatistics sumVintage = persons
				.stream()
				.collect(Collectors.summarizingInt(p -> p.getVintage()));

		System.out.println(sumVintage); 
		
		
		Collector<Person, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.getPrename().toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

			String names = persons
			    .stream()
			    .collect(personNameCollector);

			System.out.println(names);

	}

	public void doMore() {
		
		IntStream.range(1, 1000)
			.asLongStream()
			.average()
			.ifPresent(System.out::println);
		
		int[] intList = 
		IntStream.range(1, 1000)
		.toArray();
		
		long[] longList =
		IntStream.range(3, 500)
		.asLongStream()
		.toArray();
		
		
		
		
	}




	public static void main(String args[]) {
		StreamAPI api = new StreamAPI();
//		api.printExamples();
//		api.makeArray();
//		api.doMore();
		api.sortArray();

	}








}
