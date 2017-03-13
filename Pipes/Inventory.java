import java.util.ArrayList;
/**
 * Write a description of class Inventory here.
 * 
 * @author (Eric Slaweski) 
 * @version (5/3/14)
 */
public class Inventory
{
  private Item[] inv;
  private int lastSlotUsed;
  private int lastItemRemoved = -1;//-1 if nothing was removed, otherwise slot which was removed

  /**
   * Constructor for objects of class Inventory
   */
  public Inventory()
  {
    //Start with an empty invetrory
    inv = new Item[6];
  }

  public Item getItem(int itemSlot)
  {
    if(itemSlot > 5 || itemSlot < 0)
      return null;
    Item item = inv[itemSlot];
    return item;
  }

  public void removeItem(int itemSlot)   
  {
    inv[itemSlot] = null;
  }

  public boolean hasItem(int itemSlot)
  {
    if(inv[itemSlot] != null)
      if(itemSlot <= 5 && itemSlot >= 0)
        return true;
    return false;
  }

  public int getNewestItemSlot()
  {
    return lastSlotUsed;
  }

  public String pickUp(Room room)
  {
    if(room instanceof ItemRoom)
    {
      ItemRoom ir = (ItemRoom) room;
      boolean bool = true;
      for(int i = 0; i < 6 && bool; i++)
      {
        if(inv[i] == null)
        {
          inv[i] = ir.getItem();
          this.lastSlotUsed = i;
          bool = false;
          return "You have picked up the " + inv[i].getName();
        }

        if(i == 5)//it didnt find an empty slot
        {
          return "Your inventory is full. You cannot bear to carry a bigger burden.";   
        }
      }
    }
    return "There is Nothing to Pick Up";
  }

  public String getItemName(int itemSlot)
  {
    if(itemSlot > 5 || itemSlot < 0)
    {
      return null;
    }
    if(inv[itemSlot] == null)
      return null;
    return inv[itemSlot].getName();
  }
}