package ch.hslu.demo;



/**
* Eine Klasse mit der man Temperaturen in verschiedenen Einheiten ausgeben kann 
* und den Aggregatszustand von 3 Elementen ausgeben kann.
* 
* @author Dave Brunner
* @version Version: 1.1 
*/







public class Temperature
{
	
	
	
	
	
	
   // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
   // The temperature is stated in °celcious
   private float temp;
   
  

   /**
    * @param Temperatur in Grad Celsious als float
    * Konstruktor für Objekte der Klasse Temparatur mit Initialwert
    */
   public Temperature(float temp)
   {
       // Instanzvariable initialisieren
       this.temp = temp;
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
    * @return der Temperatur in Grac Celsious als float
    */
   public float getTemperature()
   {
       // tragen Sie hier den Code ein
       return temp;
   }
   
   
   // Set the temperature to a new value
   /*
    * Setzen der Temperatur in Celcius
    */
   public void setTemperatureCelcious(float temp)
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
    * Ausgabe der Temperatur in Kelvin
    */
   public float getTemperatureInKelvin()
   {
       
       return temp + 273.15f;
       
   }
   
   
   /**
    * Relative Veränderung der Temperatur in Kelvin
    */
   public void setTemperaturRelativeKelvin(float tempChange)
   {
       tempChange +=  -273.15f;
       this.temp += tempChange;
       
   }
   
   /**
    * Ausgabe der Temperatur in Fahrenheit
    */
   public float getTemperatureInFahrenheit()
   {
       return (this.temp * 1.8f) + 32f;
       
   }
   
   /**
    * Relative Veränderung der Temperatur in Fahrenheit
    */
   public void setTemperaturRelativeFahrenheit(float tempChange)
   {
       tempChange = (tempChange - 32f)/1.8f;
       System.out.println(tempChange);
       this.temp += tempChange;
       
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






