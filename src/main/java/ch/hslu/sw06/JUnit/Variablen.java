package ch.hslu.sw06.JUnit;

public class Variablen {

	
	
	    	    
	    /**
	     * Konstruktor für Objekte der Klasse Variablen
	     */
	    public Variablen()
	    {
	         
	    }

	   
	    public int max(int x, int y, int z)
	    {
	        if(x >= y && x >= z) {
	            return x;   // Den häufigsten Ausgang als Erstes auflisten
	        }
	        else if (y > x && y >= z){
	            return y;
	        }
	        else {
	            return z; // Den unwahrscheinlichsten Ausgang als Letztes auflisten
	        }
	        
	    }
	    
	        public int min(int x, int y, int z)
	    {
	        if(x <= y && x <= z) {
	            return x; 
	        }
	        else if (y < x && y <= z){
	            return y;
	        }
	        else {
	            return z;
	        }
	        
	    }
	    
	}

	

