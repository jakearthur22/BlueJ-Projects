
/**
 * Write a description of class BlockedRoom here.
 * 
 * @author (Eric Slaweski) 
 * @version (5/3/14)
 */
public class BlockedRoom extends Room
{
  // instance variables - replace the example below with your own
  boolean northBlocked = false;
  boolean southBlocked = false;
  boolean eastBlocked = false;
  boolean westBlocked = false;
  boolean upBlocked = false;
  boolean downBlocked = false;

  /**
   * Constructor for objects of class BlockedRoom
   */
  public BlockedRoom(String description)
  {
    super(description);
  }

  public void setExit(String direction, Room neighbor, boolean blockedUntilOpened)
  {
    if(direction == "north")
      northBlocked = blockedUntilOpened;
    if(direction == "south")
      southBlocked = blockedUntilOpened;
    if(direction == "east")
      eastBlocked = blockedUntilOpened;
    if(direction == "west")
      westBlocked = blockedUntilOpened;
    if(direction == "up")
      upBlocked = blockedUntilOpened;
    if(direction == "down")
      downBlocked = blockedUntilOpened;
    super.setExit(direction, neighbor);
  }

  public boolean getBlocked(String direction)
  {
    if(direction == "north")
      return northBlocked;
    if(direction == "south")
      return southBlocked;
    if(direction == "east")
      return eastBlocked;
    if(direction == "west")
      return westBlocked;
    if(direction == "up")
      return upBlocked;
    if(direction == "down")
      return downBlocked;
    return false;
  }

  public boolean isBlocked()
  {
    return !super.getItemUsed();
  }
}
