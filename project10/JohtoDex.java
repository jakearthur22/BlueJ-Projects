import java.util.ArrayList;
/**
 * This is the class that creates Pokedex
 * entries of the Johto region.
 * 
 * @author (Jacob Arthur, 20140070, period 8) 
 * @version (Wednesday, February 26, 2014)
 */
public class JohtoDex extends KantoDex
{
  final String region = "Johto";
  String shinyColor;
  ArrayList<String> johtoTypes;
  
  /**
   * Constructor for objects of class JohtoDex
   * @param dexNum the index number of the Pokemon
   * @param type1 the first type of the Pokemon
   * @param type2 the second type of the Pokemon
   *              ("" if no second type)
   * **the available types are Normal, Fire, Water, Flying, Fighting, and Steel**
   * @param evolutionStage (Basic, Stage 1, or Stage 2)
   * @param ability the Pokemon's special ability
   * @param area the location where the Pokemon can be found
   * @param the color of the Pokemon's shiny form
   */
  public JohtoDex(String dexNum, String name, String type1, String type2, String evolutionStage, String ability, String area, String shinyColor)
  {
    super(dexNum, name, type1, type2, evolutionStage, ability, area);
    johtoTypes = new ArrayList<String>();
    addJohtoTypes();
    
    this.shinyColor = shinyColor;
  }
  
  /**
   * Adds the Pokemon types that can be used
   * for Johto region entries.
   */
  protected void addJohtoTypes()
  {
    johtoTypes.addAll(super.getKantoTypes());
    johtoTypes.add("Dark");
    johtoTypes.add("Steel");
  }
  
  /**
   * @return johtoTypes the ArrayList of all possible types
   * for this region.
   */
  public ArrayList<String> getJohtoTypes()
  {
    return johtoTypes;
  }
  
  /**
   * @return types the usable ArrayList of all possible types
   * for this region.
   */
  public ArrayList<String> getTypes1()
  {
    return johtoTypes;
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
    return super.toString() + "     Shiny Color: " + shinyColor;
  }
}
