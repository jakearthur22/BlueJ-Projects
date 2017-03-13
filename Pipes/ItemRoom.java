
/**
 * Write a description of class ItemRoom here.
 * 
 * @author (Eric Slaweski) 
 * @version (5/3/14)
 */
public class ItemRoom extends Room
{
  // instance variables - replace the example below with your own
  private Item item;
  private boolean itemTaken;

  public ItemRoom(String description, String itemName, int itemDamage, String itemDescription, String itemUsedDescription, Room itemUsedIn)
  {
    super(description);
    this.item = new Item(itemName, itemDamage, itemDescription,itemUsedDescription, itemUsedIn);
    this.itemTaken = false;
  }

  /**
   * this should only be used in construcor of other methods
   */
  public Item getTheItem()
  {
    return item;
  }

  /**
   * this is the one you call during the game.
   */
  public Item getItem()
  {
    itemTaken = true;
    return item; 
  }
  
  public boolean itemTaken()
  {
    return itemTaken;
  }

  public String getLongDescription()
  {
    String returnString = getDescription();
    returnString += item.getDescription() + "\n";
    returnString += getExitString();
    return returnString;
  }
}