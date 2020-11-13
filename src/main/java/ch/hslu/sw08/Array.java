package ch.hslu.sw08;

public class Array {

    int[] hours = new int[24];
	int[] minutes = new int[60];
	
	public Array() {
		
//		int[] minutes = new int[60];
	}
	
	
	public void assignArrays() {
		for(int i = 0; i < hours.length; i++) {
			hours[i] = i;
		}
		
		for(int i = 0; i < minutes.length; i++) {
			minutes[i] = i;
		}
	}
	
	public void printArrays() {
		
//		for(int hour: hours) {
//			System.out.println(" : " + hour);
//		}
		
		System.out.println("\n  \n" + "Hours: ");
		int i = 0;
		while(i < hours.length) {
			System.out.println(i + ": " + hours[i]);
			i++;
		}
		
		System.out.println("\n \n" + "Minutes: ");
		
		i = 0;
		while(i < minutes.length) {
			System.out.println(i + ": " + minutes[i]);
			i++;
		}
				
	}
	
	
	
	public static void main(String[] args) {
		Array ar1 = new Array();
		ar1.assignArrays();
		ar1.printArrays();
		
		
	}
	
	
}
