import java.util.ArrayList;
/**
 * This is the class that creates Pokedex
 * entries of the Kalos region.
 * 
 * @author (Jacob Arthur, 20140070, period 8) 
 * @version (Wednesday, February 26, 2014)
 */
public class KalosDex extends JohtoDex
{
  final String region = "Kalos";
  ArrayList<String> types;
  boolean skyEligible;
  boolean megaForm;

  /**
   * Constructor for objects of class KalosDex
   * @param dexNum the index number of the Pokemon
   * @param type1 the first type of the Pokemon
   * @param type2 the second type of the Pokemon
   *              ("" if no second type)
   * **the available types are Normal, Fire, Water, Flying, Psychic, Fighting, Steel, and Fairy**
   * @param evolutionStage (Basic, Stage 1, or Stage 2)
   * @param ability the Pokemon's special ability
   * @param area the location where the Pokemon can be found
   * @param the color of the Pokemon's shiny form
   * @param skyEligible whether the Pokemon can participate in Sky Battles
   * @param megaForm whether the Pokemon has a Mega Form
   */
  public KalosDex(String dexNum, String name, String type1, String type2, String evolutionStage, String ability, String area, String shinyColor, boolean skyEligible, boolean megaForm)
  {
    super(dexNum, name, type1, type2, evolutionStage, ability, area, shinyColor);
    types = new ArrayList<String>();
    addTypes();
    this.skyEligible = skyEligible;
    this.megaForm = megaForm;
  }

  /**
   * Adds the Pokemon types that can be used
   * for Kalos region entries.
   */
  protected void addTypes()
  {
    types.addAll(super.getJohtoTypes());
    types.add("Fairy");
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
    String entry = super.toString() + "\n";
    if(skyEligible)
    {
      entry += "     This Pokemon can participate in Sky Battles.";
    }
    else
    {
      entry += "     This Pokemon cannot participate in Sky Battles.";
    }
    if(megaForm)
    {
      entry += "\n" + "     This Pokemon has a Mega Form.";
    }
    else
    {
      entry += "\n" + "     This Pokemon does not have a Mega Form.";
    }
    return entry;
  }
}
