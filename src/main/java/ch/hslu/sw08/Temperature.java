package ch.hslu.sw08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* Eine Klasse mit der man Temperaturen in verschiedenen Einheiten ausgeben kann 
* und den Aggregatszustand von 3 Elementen ausgeben kann.
* 
* @author Dave Brunner
* @version Version: 1.1 
*/







public class Temperature implements Comparable<Temperature>
{
	private static final Logger LOG = LogManager.getLogger(Temperature.class);
	final static float kelvinOffset = 273.15f;
	
	// The temperature is stated in °C
	protected float temp;
	

	
	
	
	
	/**
	 * Factory-Methode für Objekte mit einer Celcious-Temperatur.
	 * @param Grad in Celcious
	 * @return ein Temperatur-Objekt
	 */
	
//	IllegalArgumentException illegalArgumentException = IllegalArgumentException("The entered value must be >= -273.15f",  celcious < 273.15f);
	
	public static Temperature createFromCelcious(final float celcious) {
		LOG.debug("createFromCelcious: Anfang");
		if(celcious < -273.15f) {


			throw new IllegalArgumentException("The entered temperature must be >= -273.15f");
		} else {
			LOG.debug("createFromCelcious: Ende");	
			return new Temperature("c", celcious);		
		}
		
	}
	/**
	 * Factory-Methode für Objekte mit einer Kelvin-Temperatur.
	 * @param Grad in Kelvin
	 * @return ein Temperatur-Objekt
	 */
	public static Temperature createFromKelvin(final float kelvin) {
		if(kelvin < 0f) {
			throw new IllegalArgumentException("The entered temperature must be >= 0");
		} else {
			return new Temperature("k", kelvin);
		}


	}

 
  

   /**
    * @param Temperatur in Grad Celsious als float
    * Konstruktor für Objekte der Klasse Temparatur mit Initialwert
    */
   public Temperature(float temp)
   {
	   // Instanzvariable initialisieren
	   this.temp = temp;
   }
   /**
    * @param typ entweder c für Celsious oder k für KelvinTemperatur in Grad Celsious als float
    * Konstruktor für Objekte der Klasse Temparatur mit Initialwert
    */
   public Temperature(String typ, float temp)
   {
	   if(typ == "c") {
		   this.temp = temp;
	   } else {
		   setTemperaturKelvin(temp);
	   }
	   // Instanzvariable initialisieren
   }
   
   
   /*
    * Konstruktor für Objekte der Klasse Temparatur ohne Initialwert
    */
    public Temperature()
   {
       // Instanzvariable initialisieren
       this.temp = 20f;      
   }
   
    /**
     * Ausgabe der Temperatur in Kelvin
     */
    final static public float getTemperatureInKelvin(float temp)
    {       
    	return temp + kelvinOffset;    
    }
   
    
   

   /**
    * @return der Temperatur in Grac Celsious als float
    */
   public float getTemperatureInCelcious()
   {
       // tragen Sie hier den Code ein
       return temp;
   }
   
   
   // Set the temperature to a new value
   /*
    * Setzen der Temperatur in Celcius
    */
   final public void setTemperatureCelcious(float temp)
   {
       this.temp = temp;
   }
   
   
   /**
    * Relative Veränderung der Temperatur in Celcius
    */
   public void setTemperaturRelativeCelcious(float tempChange)
   {
       this.temp += tempChange;    
   }
  
   
   
   
   /**
    * Relative Veränderung der Temperatur in Kelvin
    */
   public void setTemperaturRelativeKelvin(float tempChange)
   {
       tempChange +=  -kelvinOffset;
       this.temp += tempChange;
       
   }
   /**
    * Setzen der Temperatur in Kelvin
    * @param temp in Kelvin
    */
   final public void setTemperaturKelvin(float temp)
   {
	   this.temp =  temp-kelvinOffset;
	   
   }
   /**
    * Umwandlung von Kelvin nach Celcious.
    * @param temp in Kelvin.
    */
   final public float getTemperatureFromKelvinToCelsious(float temp)
   {
	   return  temp-kelvinOffset;
	   
   }
   
   
   
   /**
    * Ausgabe der Temperatur in Fahrenheit
    */
   final public float getTemperatureInFahrenheit()
   {
       return (this.temp * 1.8f) + 32f;
       
   }
   
   /**
    * Relative Veränderung der Temperatur in Fahrenheit
    */
   public void setTemperaturRelativeFahrenheit(float tempChange)
   {
       tempChange = (tempChange - 32f)/1.8f;
       this.temp += tempChange;      
   }
   

   
   
   @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Float.floatToIntBits(temp);
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Temperature other = (Temperature) obj;
	if (Float.floatToIntBits(temp) != Float.floatToIntBits(other.temp))
		return false;
	return true;
} 










@Override
public String toString() {
	return "Temperature [temp=" + temp + "°C]";
}

@Override
public int compareTo(Temperature other) {
	if(this == other) {
		return 0;
	} else {	
	return Float.compare(this.temp, other.temp);
	}		
}







public String aggregateState(String element)
       {
       String flüssig = "Flüssig";
       String fest = "Fest";
       String gasförmig = "Gasförmig";
       
       if (element == "N") {   // Wenn nach Stickstoff gefragt wird (N)
               if( temp > -196f) {
                   return gasförmig;
               } else if (temp < -196f && temp > -210.01f) {
                   return flüssig;
               }
                   else {
                       return fest;
                   }
       }
       
       else if (element == "Hg") {  // Wenn nach Quecksilber gefragt wird (Hg)
           if (temp > -38.8344f && temp < 356.73f) {
               return flüssig;
           } else if (temp < -38.8344f) {
               return fest;
           } else {
               return gasförmig;
           } 
       }
       else if (element == "Pb") { // Wenn nach Blei gefragt wird (Pb)
           if (temp < 327.43f) {
               return fest;
           } else if (temp > 1750f) {
               return gasförmig;
               }
           else {
               return flüssig;
           }
       }
       else {
           System.out.println("Geben Sie ein valides Elementenkürzel ein.");
           System.out.println("Sie haben folgende Auswahl: 'N' , 'Hg', 'Pb' ");
           return "0";
           
       }                 
   }
   
   
   
   

   
   
}






