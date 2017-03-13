
/**
 * Write a description of class Items here.
 * 
 * @author (Eric Slaweski) 
 * @version (5/3/14)
 */
public class Item
{
  private String name;
  private int damage;
  private Room roomUsedIn;
  private String description;
  private String usedDescription;
  /**
   * Constructor for objects of class Items
   */
  public Item(String name, int damage, String description, String usedDescription, Room roomUsedIn)
  {
    this.name = name;
    this.damage = damage;
    this.description = description;
    this.usedDescription = usedDescription;
    this.roomUsedIn = roomUsedIn;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getDamage()
  {
    return damage;
  }

  public String getDescription()
  {
    return description;
  }
  
  public String getUsedDescription()
  {
    return usedDescription;
  }
  
  public Room getRoomUsedIn()
  {
    return roomUsedIn;
  }
}