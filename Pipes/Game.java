import java.util.Random;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Andrew Eric Jake and Nicholas.
 * @version 2011.07.31
 */

public class Game 
{
  private Room currentRoom;
  private Inventory inventory;
  private Item inUse;
  private Room start;
  private Room lastRoom;
  private int health;
  private MonsterRoom mr = null;
  private boolean isMR;
  private boolean inBattle;
  private boolean itemRemoved;
  private boolean monsterStopped;
  private boolean yourTurn;
  private String lastCommand;
  private String guiPressed;
  private boolean gameOver;

  /**
   * Create the game and initialise its internal map.
   */
  public Game() 
  {
    health = 200;
    createRooms();
    inventory = new Inventory();
    monsterStopped = false;
    yourTurn = true;
    inUse = null;
    inBattle = false;
    isMR = false;
    guiPressed = "";
    gameOver = false;
  }

  /**
   * Create all the rooms and link their exits together.
   */
  private void createRooms()
  {
    ItemRoom wrenchRoom, firstKeyRoom, treasureRoom, sludgeRed, secondKeyRoom, sludgeGreen, thirdKeyRoom;
    BlockedRoom secondGate, firstGate,  thirdGate, manhole;
    MonsterRoom monsterRoom, monsterRoom2, monsterRoom3, monsterRoom4, bossRoom;
    Room forkingHallway, startRoom, ladder3to2, ladder1to2, corpseRoom, threeWaySplit, basicRoom1, fourWaySplit, basicRoom2, ladder2to3, ladder2to1, theEnd; //Floor 3

    Room weapon = new Room("this is not an actual room");  
    //this room allows us to create an item but not assing it to an actual room, a weapon for example
    // should not be used in any room but a fight, so it is assigned to a fake room.

    // create the rooms on floor 3
    secondGate = new BlockedRoom("There is a gate blocking the pipe, reading \"Gate Two\"");
    monsterRoom = new MonsterRoom("Norman is dead on the floor. Revel in his blood" , 120 , "Norman", health);
    forkingHallway = new Room("The pipe splits");
    startRoom = new Room("You awoke in this pipe");
    ladder3to2 = new Room("There is a ladder. It reads \"2nd Level\"");
    firstGate = new BlockedRoom("There is a gate blocking the pipe, reading 'Gate One'");
    firstKeyRoom = new ItemRoom("There is a key in the pipe. It reads \"#1\"" , "Key #1" , 0 , "This is a key reading \"#1\"", "You put the key into the lock.\nSlowly turing it. The lock clicks and the door swings open.", firstGate);
    start = startRoom;

    //create the rooms on floor 2
    ladder2to3 = new Room("There is a ladder. It reads \"3rd Level\"");
    basicRoom1 = new Room("You enter an empty pipe");
    fourWaySplit = new Room("This pipe has an exit in every direction");
    ladder2to1 = new Room("There is a ladder.  It reads \"1st Level\".");
    monsterRoom2 = new MonsterRoom("Make sure not to trip on GobbleCauk’s corpse." , 300 , "GobbleCauk", health);
    treasureRoom = new ItemRoom("You have found the room where the monster stored his treasure", "Rusty Pipe", 75 , "This is a rusty pipe, it is a basic blunt weapon", "You swing the weapon wildly trying to hit the monsters ", weapon);
    basicRoom2 = new Room("You enter an empty pipe");
    sludgeRed = new ItemRoom("You notice there is a dripping pipe." , "Red Sludge" , -50 , "This is a form of sludge", "You eat the Sludge and feel invigoated.\n+50 Health.", weapon);
    monsterRoom3 = new MonsterRoom("'CaukGobbler is deceased" , 300 , "CaukGobbler", health);
    secondKeyRoom = new ItemRoom("You enter a room with a key that reads, '#2'." , "Key #2" , 0 , "This is the key to the second gated room", "The rusty key fits into the lock with a litte bit of shoving. It turns and unlocks the door", secondGate);

    //create the rooms on floor 1
    ladder1to2 = new Room("There is a ladder.  It reads \"2nd Level\".");
    corpseRoom = new Room("There are copius corpses littering the floor");
    sludgeGreen = new ItemRoom("You notice there is a dripping pipe." , "Green Sludge" , 50 , "This is a form of sludge", "You throw the sludge at the monster doing 50 points of raw damage", weapon);
    monsterRoom4 = new MonsterRoom("Casey remnants are before you" , 300 , "Casey", health);
    threeWaySplit = new ItemRoom("This pipe splits in three directions." , "Excalibur" , 100 , "The shinning lost Excalibur!", "With the well balanced sword you hit the monster right in the ", weapon);
    bossRoom = new MonsterRoom("The most mighty monster in all the sewers lies lifeless on the floor" , 425 , "Bosster", health);
    thirdGate = new BlockedRoom("There is a gate blocking the pipe, reading \"Gate Three\"");
    manhole = new BlockedRoom("Alas! Freedom is in front of you! Do you want to open the manhole cover with your wrench?!");
    thirdKeyRoom = new ItemRoom("You enter a room with a key that reads, \"#3\"." , "Key #3" , 0 , "This is a key to the third gated room", "You put the key into the lock, but before you could turn it, the gate opens up. Guess it wasn't locked after all.", thirdGate);
    theEnd = new Room("Success is yours. Welcome back to the surface of earth.");

    //ssh leave this here
    wrenchRoom = new ItemRoom("There is a wrench in the room" , "Wrench" , 0 , "This is a wrench that can be used to open manholes." , "You wield the wrench and use all of you might to open up the manhole. The manhole slides out of the way.", manhole);

    // initialize room exits floor 3
    wrenchRoom.setExit("east" , secondGate);

    secondGate.setExit("south" , firstKeyRoom);
    secondGate.setExit("west" , wrenchRoom, true);

    firstKeyRoom.setExit("north" , secondGate);
    firstKeyRoom.setExit("east" , forkingHallway);

    monsterRoom.setExit("east" , ladder3to2);

    forkingHallway.setExit("east" , firstGate);
    forkingHallway.setExit("south" , startRoom);
    forkingHallway.setExit("west" , firstKeyRoom);

    startRoom.setExit("north" , forkingHallway);

    ladder3to2.setExit("south" , firstGate);
    ladder3to2.setExit("west" , monsterRoom);
    ladder3to2.setExit("up" , ladder2to3);

    firstGate.setExit("north" , ladder3to2, true);
    firstGate.setExit("west" , forkingHallway);

    //initialize room exits floor 2
    ladder2to3.setExit("north" , basicRoom1);
    ladder2to3.setExit("down" , ladder3to2);

    basicRoom1.setExit("south" , ladder2to3);
    basicRoom1.setExit("north" , fourWaySplit);

    fourWaySplit.setExit("south" , basicRoom1);
    fourWaySplit.setExit("north" , basicRoom2);
    fourWaySplit.setExit("east" , ladder2to1);
    fourWaySplit.setExit("west" , monsterRoom2);

    ladder2to1.setExit("up" , ladder1to2);
    ladder2to1.setExit("west", fourWaySplit);

    monsterRoom2.setExit("east" , fourWaySplit);
    monsterRoom2.setExit("south" , treasureRoom);

    treasureRoom.setExit("north" , monsterRoom2);

    basicRoom2.setExit("south" , fourWaySplit);
    basicRoom2.setExit("north" , sludgeRed);

    sludgeRed.setExit("south" , basicRoom2);
    sludgeRed.setExit("north" , monsterRoom3);

    monsterRoom3.setExit("south" , sludgeRed);
    monsterRoom3.setExit("west" , secondKeyRoom);

    secondKeyRoom.setExit("east" , monsterRoom3);

    //initialize room exits floor 1
    ladder1to2.setExit("down" , ladder2to1);
    ladder1to2.setExit("east" , corpseRoom);

    corpseRoom.setExit("west" , ladder1to2);
    corpseRoom.setExit("east" , monsterRoom4);
    corpseRoom.setExit("south" , sludgeGreen);

    sludgeGreen.setExit("north" , corpseRoom);

    monsterRoom4.setExit("west" , corpseRoom);
    monsterRoom4.setExit("north" , threeWaySplit);

    threeWaySplit.setExit("west" , bossRoom);
    threeWaySplit.setExit("south" , monsterRoom4);

    thirdGate.setExit("south" , bossRoom);
    thirdGate.setExit("west" , manhole, true);

    bossRoom.setExit("east" , threeWaySplit);
    bossRoom.setExit("west" , thirdKeyRoom);
    bossRoom.setExit("north" , thirdGate);

    thirdKeyRoom.setExit("east" , bossRoom);

    manhole.setExit("east" , thirdGate);
    manhole.setExit("north" , theEnd, true);

    //level 3 ItemRooms

    // start game in start room
    currentRoom = startRoom;
    lastRoom = startRoom;
  }

  public String guiPressed(String button)
  {
    guiPressed = button;
    if(inBattle)
    {
      if(button.equals("hitFace") || button.equals("hitSholder"))
      {
        return Battle(button);
      }
      if(button.startsWith("inv") && !(inventory.getItem(getInt(button) - 1) == null))
      {
        return Battle(button);
      }
    }
    return "";
  }

  public Room getCurrentRoom()
  {
    return currentRoom;
  }

  public boolean isMR()
  {
    if(getCurrentRoom() instanceof MonsterRoom)
    {
      mr = (MonsterRoom) getCurrentRoom();
      return true;
    }
    return false;
  }

  public boolean getIsMR()
  {
    return isMR;
  }
  
  public String goBack()
  {
    if(currentRoom.getDescription().startsWith("Success is yours. Welcome "))
    {
      return printLocationInfo();
    }
    currentRoom = lastRoom;
    return printLocationInfo();
  }

  /** 
   * Try to go in one direction. If there is an exit, enter
   * the new room, otherwise print an error message.
   */
  public String goRoom(String direction) 
  {
    // Try to leave current room.
    if(currentRoom instanceof BlockedRoom)
    {
      BlockedRoom br = (BlockedRoom) currentRoom;
      if(br.isBlocked())// why is this here?
      {
        if(br.getBlocked(direction))
        {
          return "There is a gate in the way. you need to find a key in order to open it.\n" + 
          currentRoom.getExitString();
        }
      }
    }
    Room nextRoom = currentRoom.getExit(direction);
    if (nextRoom == null)
    {
      return "There is no door!" + "\n" + currentRoom.getExitString();
    }
    lastRoom = currentRoom;
    if(nextRoom instanceof MonsterRoom)
    {
      mr = (MonsterRoom) nextRoom;
      if(!mr.getDeadMonster())
      {
        isMR = true;
        currentRoom = nextRoom;
        return Battle("");
      }
      else
      {
        currentRoom = nextRoom;
        return printLocationInfo();
      }
    }
    else
    {
      currentRoom = nextRoom;
      return printLocationInfo();
    }
  }

  public String pickUp()
  {
    if(currentRoom instanceof ItemRoom)
    {
      ItemRoom ir = (ItemRoom) currentRoom ;
      if(!ir.itemTaken())
        return inventory.pickUp(currentRoom) + "\n" + currentRoom.getExitString();
    }
    return "There is nothing in this room.\n" + currentRoom.getExitString();
  }

  public int getNewestItemSlot()
  {
    return inventory.getNewestItemSlot();
  }

  public String getNewestItemName()
  {
    return inventory.getItemName(inventory.getNewestItemSlot());
  }

  public boolean itemRemoved()
  {
    boolean bool = itemRemoved;
    itemRemoved = false;
    return bool;
  }

  public String useItem(int itemSlot)
  {
    if(inventory.hasItem(itemSlot))
    {
      if(inventory.getItem(itemSlot).getRoomUsedIn() == currentRoom)
      {
        String ret = inventory.getItem(itemSlot).getUsedDescription();
        inventory.removeItem(itemSlot);
        currentRoom.itemUsed();
        itemRemoved = true;
        return ret;
      }
      return "You cannot use this item here";
    }
    return "You don't have an item in that slot!";
  }

  private String printLocationInfo()
  {
    return currentRoom.getLongDescription();
  }

  public int reduceHealth(int damage)
  {
    health = health - damage;
    if(health <= 0)
    {
      health = 0;
    }
    if(health > 200)
    {
      health = 200;
    }
    return health;
  }

  public int getInt(String itemTxt)
  {
    int num = 0;
    if(itemTxt.equals("inv1"))
    {
      num = 1;
    }
    else if(itemTxt.equals("inv2"))
    {
      num = 2;
    }
    else if(itemTxt.equals("inv3"))
    {
      num = 3;
    }
    else if(itemTxt.equals("inv4"))
    {
      num = 4;
    }
    else if(itemTxt.equals("inv5"))
    {
      num = 5;
    }
    else if(itemTxt.equals("inv6"))
    {
      num = 6;
    }
    return num;
  }

  public String Battle(String command)
  {
    inBattle = true;
    String returnString = "";
    Random rand = new Random();
    boolean gameOver = false;
    boolean win = false;//we assume they suck and will loose, otherwise change to true.
    mr = (MonsterRoom) currentRoom;

    int base = 0;
    int attack = 0;
    int modifier = 0;

    //look for commands
    if(command.equals("hitFace"))
    {
      if(rand.nextInt(2) == 1)
      {//add
        base += mr.getSetDamage("face");
        modifier = rand.nextInt(5);
        returnString += "You did: " + base + " +(" + modifier + ") Damage.\n";
        attack = base + modifier;
        mr.getMonster().reduceHealth(attack);
      }
      else
      {//subtract
        base = mr.getSetDamage("face");
        modifier = rand.nextInt(5);
        returnString += "You did: " + base + " -(" + modifier + ") Damage.\n";
        attack = base - modifier;
        mr.getMonster().reduceHealth(attack);
      }
      if(!monsterStopped)
      {
        if(rand.nextInt(2) == 1)
        {
          if(rand.nextInt(2) == 1)
          {//add
            base = mr.getSetDamage("slash");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " +(" + modifier + ") Damage.\n";
            attack = base + modifier;
            mr.getPlayer().reduceHealth(attack);
          }
          else
          {//subtract
            base = mr.getSetDamage("slash");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " -(" + modifier + ") Damage.\n";
            attack = base - modifier;
            mr.getPlayer().reduceHealth(attack);
          }
        }
        else
        {
          if(rand.nextInt(2) == 1)
          {//add
            base = mr.getSetDamage("gutpunch");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " +(" + modifier + ") Damage.\n";
            attack = base + modifier;
            mr.getPlayer().reduceHealth(attack);
          }
          else
          {//subtract
            base = mr.getSetDamage("gutpunch");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " -(" + modifier + ") Damage.\n";
            attack = base - modifier;
            mr.getPlayer().reduceHealth(attack);
          }
        }
      }
      else
      {
        returnString += mr.getMonster().getName() + " is unable to attack.\n";
        if(rand.nextInt(100) < 25)
        {
          returnString += mr.getMonster().getName() + " has recovered from his stupor.\n";
          monsterStopped = false;
        }
      }
    }
    else if(command.equals("hitSholder"))
    {
      if(rand.nextInt(100) < 66)
      {
        monsterStopped = true;
        returnString += "You have stunned " + mr.getMonster().getName() + ".\n";
      }
      else
      {
        returnString += "Your attack missed " + mr.getMonster().getName() + ".\n";
      }
      if(!monsterStopped)
      {
        if(rand.nextInt(2) == 1)
        {
          if(rand.nextInt(2) == 1)
          {//add
            base = mr.getSetDamage("slash");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " +(" + modifier + ") Damage.\n";
            attack = base + modifier;
            mr.getPlayer().reduceHealth(attack);
          }
          else
          {//subtract
            base = mr.getSetDamage("slash");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " -(" + modifier + ") Damage.\n";
            attack = base - modifier;
            mr.getPlayer().reduceHealth(attack);
          }
        }
        else
        {
          if(rand.nextInt(2) == 1)
          {//add
            base = mr.getSetDamage("gutpunch");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " +(" + modifier + ") Damage.\n";
            attack = base + modifier;
            mr.getPlayer().reduceHealth(attack);
          }
          else
          {//subtract
            base = mr.getSetDamage("gutpunch");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " -(" + modifier + ") Damage.\n";
            attack = base - modifier;
            mr.getPlayer().reduceHealth(attack);
          }
        }
      }
      else
      {
        returnString += mr.getMonster().getName() + " is unable to attack.\n";
        if(rand.nextInt(100) < 25)
        {
          returnString += mr.getMonster().getName() + " has recovered from his stupor.\n";
          monsterStopped = false;
        }
      }
    }
    else if(command.startsWith("inv"))
    {
      Item usingItem = inventory.getItem(getInt(command) - 1);
      if(rand.nextInt(2) == 1)
      {//add
        base = mr.getSetDamage("face") + usingItem.getDamage();
        modifier = rand.nextInt(5);
        returnString += "You used the " + usingItem.getName() + "!"
        + "\n" + "You did: " + base + " +(" + modifier + ") Damage.\n";
        attack = base + modifier;
        if(usingItem.getName().contains("Sludge"))
        {
          attack = attack - modifier;
          mr.getPlayer().reduceHealth(attack);
        }
        else
        {
          mr.getMonster().reduceHealth(attack);
        }
      }
      else
      {//subtract
        base = mr.getSetDamage("face") + usingItem.getDamage();
        modifier = rand.nextInt(5);
        returnString += "You used the " + usingItem.getName() + "!"
        + "\n" + "You did: " + base + " -(" + modifier + ") Damage.\n";
        attack = base - modifier;
        if(usingItem.getName().contains("Sludge"))
        {
          attack = attack + modifier;
          mr.getPlayer().reduceHealth(attack);
        }
        else
        {
          mr.getMonster().reduceHealth(attack);
        }
      }
      if(!monsterStopped)
      {
        if(rand.nextInt(2) == 1)
        {
          if(rand.nextInt(2) == 1)
          {//add
            base = mr.getSetDamage("slash");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " +(" + modifier + ") Damage.\n";
            attack = base + modifier;
            mr.getPlayer().reduceHealth(attack);
          }
          else
          {//subtract
            base = mr.getSetDamage("slash");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " -(" + modifier + ") Damage.\n";
            attack = base - modifier;
            mr.getPlayer().reduceHealth(attack);
          }
        }
        else
        {
          if(rand.nextInt(2) == 1)
          {//add
            base = mr.getSetDamage("gutpunch");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " +(" + modifier + ") Damage.\n";
            attack = base + modifier;
            mr.getPlayer().reduceHealth(attack);
          }
          else
          {//subtract
            base = mr.getSetDamage("gutpunch");
            modifier = rand.nextInt(5);
            returnString += "\n" + mr.getMonster().getName() + " did: " + base + " -(" + modifier + ") Damage.\n";
            attack = base - modifier;
            mr.getPlayer().reduceHealth(attack);
          }
        }
      }
      else
      {
        returnString += mr.getMonster().getName() + " is unable to attack.\n";
        if(rand.nextInt(100) < 25)
        {
          returnString += mr.getMonster().getName() + " has recovered from his stupor.\n";
          monsterStopped = false;
        }
      }
    }
    //check health
    if(mr.getPlayer().getHealth() <= 0)
    {
      gameOver = true;
    }
    else if(mr.getMonster().getHealth() <= 0)
    {
      win = true;
      gameOver = true;
    }//check if game is over
    //finish
    if(gameOver)
    {
      if(win)
      {
        inBattle = false;
        mr.killMonster();
        health = mr.getPlayer().getHealth();
        mr.getPlayer().reduceHealth(-300);
        return "You won!\nYou survived with " + health + "\n" + currentRoom.getExitString();
      }
      else
      {
        return "Because you suck, you have died.\nGAME OVER    GAME OVER    GAME OVER";
      }
    }
    returnString += battleScreen();
    return returnString;
  }

  private String battleScreen()
  {
    return mr.getPlayer().getName() + " Health: " + mr.getPlayer().getHealth() + "\n" +
    "\n" +
    mr.getMonster().getName() + "'s Health: " + mr.getMonster().getHealth() + "\n";
  }

  public boolean getInBattle()
  {
    return inBattle;
  }
}