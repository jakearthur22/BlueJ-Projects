
/**
 * Heater changes the temperature.
 * 
 * Gregory Elgart 
 * Per. 2 (Monday November 26, 2007)
 */
public class Heater
{
    private int temperature;        // current temperature
    private int min;                // minimum temperature
    private int max;                // maximum temperature
    private int increment;          // increment of change

    /**
     * Constructor for objects of class Heater
     */
    public Heater()
    {
      temperature = 15;
      min = 6;
      max = 23;
      increment = 5;
    }
    /**
     * Returns the temperature
     */
    public int getTemperature()
    {
     return temperature;
    }
    /**
     * Increases temperature.
     */
    public void warmer()
    {
     if (temperature + increment < max)   
     {
      temperature = temperature + increment;
     } 
     else
     {  
      System.out.println("The maximum temperature is " + max);
     } 
    }
    /**
     * Decreases temperature.
     */
    public void cooler()
    {
     if (temperature - increment > min)   
     { 
      temperature = temperature - increment;
     } 
     else
     {  
      System.out.println("The minimum temperature is " + min);
     }
    } 
    /**
     * Prints the details of Heater.
     */
    public void printDetails()
    {
     System.out.println("The current temperature is " + temperature);
     System.out.println("The minimum temperature is " + min);
     System.out.println("The maximum temperature is " + max);
     System.out.println("The temperature is raised by " + increment);
    }
    /**
     * Sets a new increment.
     */
    public void setIncrement(int newIncrement)
    {
     if (newIncrement < 0)
     {
      System.out.println("Increment can not be set to, " + newIncrement);
     }
     else
     {
      increment = newIncrement;
     } 
    }
}