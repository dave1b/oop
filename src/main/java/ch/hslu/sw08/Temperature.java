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
	final static float KELVINOFFSET = 273.15f;


	// The temperature is stated in °C
	private float temp;


	public enum TempType {
		Celsius(), Kelvin(), Gurke();
	} 




	/**
	 * Factory-Methode für Objekte mit einer Celsius-Temperatur.
	 * @param Grad in Celsius.
	 * @return ein Temperatur-Objekt.
	 */
	final public static Temperature createFromCelsius(final float celsius) {
		LOG.debug("createFromCelsius: Anfang");
		if(celsius < -KELVINOFFSET) {
			throw new IllegalArgumentException("The entered temperature must be >= "+ -KELVINOFFSET);
		} else {
			LOG.debug("createFromCelsius: Ende");	
			return new Temperature(TempType.Celsius, celsius);		
		}		
	}

	/**
	 * Factory-Methode für Objekte mit einer Kelvin-Temperatur.
	 * @param Grad in Kelvin
	 * @return ein Temperatur-Objekt.
	 */
	final public static Temperature createFromKelvin(final float kelvin) {
		if(kelvin < 0f) {
			throw new IllegalArgumentException("The entered temperature must be >= 0f");
		} else {
			return new Temperature(TempType.Kelvin, kelvin);
		}
	}



	/**
	 * Einfacher Konstruktor.
	 * @param Temperatur in Grad Celsious als float.
	 * 
	 */
	public Temperature(float temp)
	{
		// Instanzvariable initialisieren
		this.temp = temp;
	}
	/**
	 * Konstruktor mit der Option den Temperaturwert in Celsius oder Grad anzugeben.
	 * @param Enum als typ entweder TempType.Celsius für Celsious oder TempType.Kelcin für Kelvin. Wirft eine IllegalArgumentException bei nichteinhalten der Parametervorgaben.
	 * 
	 */
	public Temperature(TempType typ, float temp)
	{
		if(typ.equals(TempType.Celsius)){
			this.temp = temp;
		} else if(typ.equals(TempType.Kelvin)) {
			this.temp = convertTemperatureFromKelvinToCelsious(temp);
		} else {
			throw new IllegalArgumentException("The Enum typ must either be 'TempType.Celsius' or 'TempType.Kelvin!'");
		}
	}

	/*
	 * Konstruktor mit Default-Initialwert.
	 */
	public Temperature()
	{
		// Instanzvariable initialisieren
		this.temp = 20f;      
	}










	/**
	 * @return der Temperatur in Grac Celsious als float.
	 */
	final public float getTemperatureInCelsius()
	{
		return temp;
	}

	/**
	 * Umwandlung von Kelvin nach Celsius.
	 * @param temp in Kelvin.
	 */
	final public float getTemperatureInKelvin()
	{
		return  this.temp+KELVINOFFSET;

	}

	/**
	 * Ausgabe der Temperatur in Fahrenheit.
	 */
	final public float getTemperatureInFahrenheit()
	{
		return (this.temp * 1.8f) + 32f;

	}














	@Override
	final public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(temp);
		return result;
	}


	@Override
	final public boolean equals(Object obj) {
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
			return Float.compare(this.getTemperatureInCelsius(), other.getTemperatureInCelsius());
		}		
	}








	// ------------------------------- Ab hier: Getter & Setter ------------------------------------	   
	/**
	 * Setzen der Temperatur in Celcius.
	 * @param neuer float-Wert in Celcius.
	 */
	final public void setTemperatureCelsius(float temp)
	{
		this.temp = temp;
	}

	/**
	 * Relative Veränderung der Temperatur in Celcius.
	 */
	final public void setTemperaturRelativeCelsius(float tempChange)
	{
		this.temp += tempChange;    
	}






	/**
	 * Setzen der Temperatur in Kelvin.
	 * @param temp in Kelvin
	 */
	final public void setTemperaturKelvin(float temp)
	{
		this.temp =  temp-KELVINOFFSET;

	}

	/**
	 * Relative Veränderung der Temperatur in Kelvin.
	 */
	final public void setTemperaturRelativeKelvin(float tempChange)
	{
		tempChange +=  -KELVINOFFSET;
		this.temp += tempChange;

	}




	/**
	 * Relative Veränderung der Temperatur in Fahrenheit.
	 */
	final public void setTemperaturRelativeFahrenheit(float tempChange)
	{
		tempChange = (tempChange - 32f)/1.8f;
		this.temp += tempChange;      
	}




	/**
	 * Umwandlung von Kelvin nach Celsius.
	 * @param temp in Kelvin.
	 * @return der Temperatur in Celcius
	 */
	final static public float convertTemperatureFromKelvinToCelsious(float temp)
	{
		return  temp-KELVINOFFSET;

	}

	/**
	 * Umwandlung von Celsius nach Kelvin.
	 * @param temp in Celcius.
	 * @return der Temperatur in Kelvin.
	 */
	final static public float convertTemperatureFromCelsiousToKelvin(float temp)
	{       
		return temp + KELVINOFFSET;    
	}




























	/*
---------------------- Alte aggregateState-Methode ---------------------------------------------

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
            } else {
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
       } else {
           System.out.println("Geben Sie ein valides Elementenkürzel ein.");
           System.out.println("'N' , 'Hg', 'Pb' ");
           return "0";

       }                 
   }


	 */
}






