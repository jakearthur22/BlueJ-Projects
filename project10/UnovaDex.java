import java.util.ArrayList;
/**
 * This is the class that creates Pokedex
 * entries of the Unova region.
 * 
 * @author (Jacob Arthur, 20140070, period 8) 
 * @version (Wednesday, February 26, 2014)
 */
public class UnovaDex extends JohtoDex
{
  final String region = "Unova";
  int musicalValue;
  ArrayList<String> types;

  /**
   * Constructor for objects of class UnovaDex
   * @param dexNum the index number of the Pokemon
   * @param type1 the first type of the Pokemon
   * @param type2 the second type of the Pokemon
   *              ("" if no second type)
   * **the available types are Normal, Fire, Water, Flying, Fighting, and Steel**
   * @param evolutionStage (Basic, Stage 1, or Stage 2)
   * @param ability the Pokemon's special ability
   * @param area the location where the Pokemon can be found
   * @param the color of the Pokemon's shiny form
   * @param musicalValue the Pokemon's value in musicals, 1-10 inclusive
   */
  public UnovaDex(String dexNum, String name, String type1, String type2, String evolutionStage, String ability, String area, String shinyColor, int musicalValue)
  {
    super(dexNum, name, type1, type2, evolutionStage, ability, area, shinyColor);
    types = new ArrayList<String>();
    addTypes();
    this.musicalValue = musicalValue;
  }
  
  /**
   * Adds the Pokemon types that can be used
   * for Unova region entries.
   */
  public void addTypes()
  {
    types.addAll(super.getJohtoTypes());
  }
  
  /**
   * @return types the usable ArrayList of all possible types
   * for this region.
   */
  public ArrayList<String> getTypes1()
  {
    return types;
  }
  
  /**
   * @return region the region which the Pokemon
   * hails from.
   */
  public String getRegion()
  {
    return region;
  }
  
  /**
   * Prints out all the necessary information
   * pertaining to this Pokedex entry.
   */
  public void display()
  {
    System.out.println(toString());
  }
  
  /**
   * Overrides the toString method.
   * @return entry the information pertaining
   * to the Pokedex entry.
   */
  public String toString()
  {
    return super.toString() + "  Musical Value: " + musicalValue + "/10";
  }

  
}
