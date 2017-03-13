import java.util.HashMap;
import java.util.Set;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room
{
  private String description;
  private HashMap <String, Room> exits;
  private Item item;
  boolean itemUsed = false;

  /**
   * Create a room described "description". Initially, it has
   * no exits. "description" is something like "a kitchen" or
   * "an open court yard".
   * @param description The room's description.
   */
  public Room(String description)
  {
    this.description = description;
    exits = new HashMap<String, Room>();
  }

  /**
   * Define an exit from this room.
   */
  public void setExit(String direction, Room neighbor)
  {
    exits.put(direction, neighbor);
  }

  /**
   * @param direction The direction in question.
   * @return The direction of the exit to return.
   */
  public Room getExit(String direction)
  {
    return exits.get(direction);
  }

  /**
   * Return a long description of this room, in the form:
   *  You are in the kitchen.
   *  Exits: north west
   *@return: A description of the room including exits.
   */
  public String getLongDescription()
  {
    return description + ".\n" + getExitString();
  }

  public String getDescription()
  {
    return description;
  }
  
  public void itemUsed()
  {
    itemUsed = true;
  }
  
  public boolean getItemUsed()
  {
    return itemUsed;
  }
  
  public void addUsableItem(Item item)
  {
    this.item = item;
  }

  /**
   * Return a string describing the room's exits
   * e.g. "Exits : north east"
   */
  public String getExitString()
  {
    String returnString = "Exits: ";
    Set<String> keys = exits.keySet();
    for(String exit : keys)
    {
      returnString += " " + exit;
    }
    return returnString;
  }
}


