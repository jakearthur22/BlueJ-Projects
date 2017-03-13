import java.util.ArrayList;
/**
 * KantoDex, this is the superclass for all other
 * classes, and the class that creates Pokedex entries
 * from the Kanto region.
 * 
 * @author (Jacob Arthur, 20140070, period 8) 
 * @version (Wednesday, February 26, 2014)
 */
public class KantoDex
{
  final String region = "Kanto";
  String dexNum;
  String name;
  String type1;
  String type2;
  ArrayList<String> kantoTypes;
  String evolutionStage;
  String ability;
  String area;

  /**
   * Constructor for objects of class KantoDex
   * @param dexNum the index number of the Pokemon
   * @param type1 the first type of the Pokemon
   * @param type2 the second type of the Pokemon
   *              ("" if no second type)
   * **the available types are Normal, Fire, Water, Flying and Fighting**
   * @param evolutionStage (Basic, Stage 1, or Stage 2)
   * @param ability the Pokemon's special ability
   * @param area the location where the Pokemon can be found
   */
  public KantoDex(String dexNum, String name, String type1, String type2, String evolutionStage, String ability, String area)
  {
    kantoTypes = new ArrayList<String>();
    addKantoTypes();
    dexNum.trim();
    this.dexNum = dexNum;
    name.trim();
    this.name = name;
    type1.trim();
    this.type1 = type1;
    type2.trim();
    this.type2 = type2;
    this.evolutionStage = evolutionStage;
    this.ability = ability;
    this.area = area;
  }

  /**
   * Adds the Pokemon types that can be used
   * for Kanto region entries.
   */
  protected void addKantoTypes()
  {
    kantoTypes.add("Normal");
    kantoTypes.add("Fire");
    kantoTypes.add("Water");
    kantoTypes.add("Grass");
    kantoTypes.add("Electric");
    kantoTypes.add("Bug");
    kantoTypes.add("Fighting");
    kantoTypes.add("Psychic");
    kantoTypes.add("Ghost");
    kantoTypes.add("Ice");
    kantoTypes.add("Ground");
    kantoTypes.add("Dragon");
    kantoTypes.add("Flying");
    kantoTypes.add("Poison");
    kantoTypes.add("Rock");
    kantoTypes.add("");
  }
  
  /**
   * @return kantoTypes the ArrayList of all possible types
   * for this region.
   */
  public ArrayList<String> getKantoTypes()
  {
    return kantoTypes;
  }
  
  /**
   * @return types the usable ArrayList of all possible types
   * for this region.
   */
  public ArrayList<String> getTypes1()
  {
    return kantoTypes;
  }
  
  /**
   * @return dexNum the Pokemon's Pokedex number.
   */
  public String getDexNum()
  {
    return dexNum;
  }
  
  /**
   * @return dex the integer form of the Pokemon's
   * Pokedex number.
   */
  public int getDexNumInt()
  {
    Integer dex1 = new Integer(0);
    int dex = dex1.valueOf(getDexNum());
    return dex;
  }
  
  /**
   * @return name the Pokemon's name.
   */
  public String getName()
  {
    return name;
  }
  
  /**
   * @return type1 the Pokemon's first type
   */
  public String getType1()
  {
    return type1;
  }
  
   /**
   * @return type1 the Pokemon's second type,
   * if any.
   */
  public String getType2()
  {
    return type2;
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
    String entry = dexNum + ": " + name + "   Type: " + type1;
    if(!type2.equals(""))
    {
       entry += "/" + type2;
    }
    entry+= "\n" + "     " + evolutionStage + "  Ability: " + ability + "  Area Found: " + area + "\n";
    return entry;
  }
  
}
