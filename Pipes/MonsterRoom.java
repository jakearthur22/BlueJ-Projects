import javax.swing.*;
import java.util.Random;
/**
 * Write a description of class MonsterRoom here.
 * 
 * @author (Jake) 
 * @version (1.0)
 */
public class MonsterRoom extends Room
{
  private String description;
  private Character player;
  private Character monster;
  private static final int FACE_DAMAGE = 40;
  private static final int SLASH_DAMAGE = 50;
  private static final int GUTPUNCH_DAMAGE = 40;
  private int itemDamage;
  private Random random;
  private String guiCommand;
  private boolean usingItem;
  private boolean leave;
  private boolean deadMonster;
  

  /**
   * Constructor for objects of class MonsterRoom
   */
  public MonsterRoom(String description, int monsterMaxHealth, String monsterName, int currentHealth)
  {
    super(description);
    player = new Character(200, currentHealth);
    monster = new Character(monsterMaxHealth, monsterName);
    itemDamage = 0;
    random = new Random();
    guiCommand = "";
    leave = false;
    deadMonster = false;
  }
  
  /**
   * Write a description of class Character here.
   * 
   * @author (Jake) 
   * @version (2.0)
   */
  public class Character
  {
    private String name;
    private int maxHealth;
    private int health;
    private boolean dead;
    
    /**
     * Constructor for objects of class Character
     */
    public Character(int maxHealth, int health)
    {
      name = "Your";
      this.maxHealth = maxHealth;
      this.health = health;
      dead = false;
    }
    
    /**
     * Constructor for objects of class Character
     */
      public Character()
     {
       name = null;
       maxHealth = 200;
       health = 200;
       dead = false;
     }
     
     /**
     * Constructor for monsters
     */
    public Character(int maxHealth, String name)
    {
      this.name = name;
      this.maxHealth = maxHealth;
      this.health = maxHealth;
    }
    
    public String getName()
    {
      return name;
    }

    /**
     *  
     */
    public int getMaxHealth()
    {
      return maxHealth;
    }
  
    /**
     *  
     */
    public int getHealth()
    {
      return health;
    }
    
    /**
     *  
     */
    public int reduceHealth(int damage)
    {
      health = health - damage;
      if(health <= 0)
      {
        health = 0;
        dead = true;
      }
      if(health > maxHealth)
      {
        health = maxHealth;
      }
      return health;
    }
  }
  
  public Character getPlayer()
  {
    return player;
  }
  
  public Character getMonster()
  {
    return monster;
  }
  
  public int getSetDamage(String type)
  {
    if(type.equals("face"))
    {
      return FACE_DAMAGE;
    }
    else if(type.equals("slash"))
    {
      return SLASH_DAMAGE;
    }
    else if(type.equals("gutpunch"))
    {
      return GUTPUNCH_DAMAGE;
    }
    return 0;
  }
  
  public void setGui(String command)
  {
    guiCommand = command;
  }
  
  public String getGuiCommand()
  {
    return guiCommand;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public void noMonster()
  {
    description = "Just a monster carcass on the floor.";
  }
  
  public void setDescription(String desc)
  {
    description = desc;
  }
  
  public boolean isUsingItem()
  {
    return usingItem;
  }
  
  public void isUsingItem(boolean is)
  {
    usingItem = is;
  }
  
  public void printDisplay()
  {
    System.out.println();
    System.out.println("         " + monster.getName());
    System.out.println("    Health:" + monster.getHealth() + "/" + monster.getMaxHealth());
    System.out.println();
    System.out.println("          vs.");
    System.out.println();
    System.out.println("          You");
    System.out.println("    Health:" + player.getHealth() + "/" + player.getMaxHealth());
  }
  
   public void printHelp()
  {
    System.out.println();
    System.out.println("<o> Get the enemy's health down to zero to win!");
    System.out.println();
  }
  
  public void killMonster()
  {
    deadMonster = true;
  }
  
  public boolean getDeadMonster()
  {
    return deadMonster;
  }
}