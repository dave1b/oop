package ch.hslu.sw12;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.sw08.Temperature;

public class Temperature2 implements Comparable<Temperature2> {

	
	
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
		final public static Temperature2 createFromCelsius(final float celsius) {
			if(celsius < -KELVINOFFSET) {
				throw new IllegalArgumentException("The entered temperature must be >= "+ -KELVINOFFSET);
			} else {	
				return new Temperature2(TempType.Celsius, celsius);		
			}		
		}	
						
		

		/**
		 * Factory-Methode für Objekte mit einer Kelvin-Temperatur.
		 * @param Grad in Kelvin
		 * @return ein Temperatur-Objekt.
		 */
		final public static Temperature2 createFromKelvin(final float kelvin) {
			if(kelvin < 0f) {
				throw new IllegalArgumentException("The entered temperature must be >= 0f");
			} else {
				return new Temperature2(TempType.Kelvin, kelvin);
			}
		}



		/**
		 * Einfacher Konstruktor.
		 * @param Temperatur in Grad Celsious als float.
		 * 
		 */
		public Temperature2(float temp)
		{
			// Instanzvariable initialisieren
			this.temp = temp;
		}

		/**
		 * Konstruktor mit der Option den Temperaturwert in Celsius oder Grad anzugeben.
		 * @param Enum als typ entweder TempType.Celsius für Celsious oder TempType.Kelcin für Kelvin. Wirft eine IllegalArgumentException bei nichteinhalten der Parametervorgaben.
		 * 
		 */
		public Temperature2(TempType typ, float temp)
		{
			
			if(typ.equals(TempType.Celsius)){
				this.temp = temp;
				LOG.debug("Celcius");
			} else if(typ.equals(TempType.Kelvin)) {
				this.temp = convertTemperatureFromKelvinToCelsious(temp);
			} else {
				throw new IllegalArgumentException("The Enum typ must either be 'TempType.Celsius' or 'TempType.Kelvin!'");
			}
			LOG.debug(this.getTemperatureInCelsius());
		}



		/*
		 * Konstruktor mit Default-Initialwert.
		 */
		public Temperature2()
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
			Temperature2 other = (Temperature2) obj;
			if (Float.floatToIntBits(temp) != Float.floatToIntBits(other.temp))
				return false;
			return true;
		} 




		@Override
		public String toString() {
			return "Temperature [temp=" + temp + "°C]";
		}

		@Override
		public int compareTo(Temperature2 other) {
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


























	
	
	
	
	
	
	
	
	
	
	
	
	
}
