import java.util.ArrayList;

/**
 * JacobDatabase, this is the main class and database that 
 * will print out information on Pokedex entries based on
 * specified parameters.
 * 
 * @author (Jacob Arthur, 20140070, period 8) 
 * @version (Wednesday, February 26, 2014)
 */
public class JacobDatabase
{
  ArrayList<KantoDex> entries;

  /**
   * Constructor for objects of class JacobDatabase
   */
  public JacobDatabase()
  {
    entries = new ArrayList<KantoDex>();
    
  }
  
  /**
   * @return the full list of entries
   */
  public ArrayList<KantoDex> getEntries()
  {
    return entries;  
  }
  
  /**
   * Adds an object of KantoDex and its subclasses
   * to the database of entries.
   * Will not add the same entry more than once.
   */
  public void addEntry(KantoDex entry)
  {
    if(entries.isEmpty())
    {
      entries.add(entry);
    }
    else
    {
      boolean notFound = true;
      for(KantoDex entryInit : entries)
      {
        if(entry.getDexNumInt() == entryInit.getDexNumInt())
        {
          System.out.println("Error: Attempted to add an entry that already exists, or should not exist.");
          notFound = false;
        }
      }
      if(notFound)
      {
        entries.add(entry);
      }
    }
  }
  
  /**
   * Prints out the Pokedex number, name,
   * and types of every entry in the
   * database.
   */
  public void printAllSummaries()
  {
    String sum = "";
    for(KantoDex entry : entries)
    {
      sum = entry.getDexNum() + ":  " + entry.getName() + "   Types: " + entry.getType1();
      if(!entry.getType2().equals(""))
      {
        sum += "/" + entry.getType2();
      }
      System.out.println(sum);
    }
  }
  
  /**
   * Finds an entry based on its
   * Pokedex number and prints out all its
   * information.
   * @param dexNum the Pokedex number
   */
  public void findByDexNumber(String dexNum)
  {
    boolean found = false;
    for(KantoDex entry : entries)
    {
      if(dexNum.equals(entry.getDexNum()))
      {
        found = true;
        entry.display();
      }
    }
    if(!found)
    {
      System.out.println("No entries were found with the Pokedex number '" + dexNum + "'.");
    }
  }
  
  /**
   * Finds all of the entries under a 
   * specific type and prints out all their 
   * information.
   * @param type the specified type
   */
  public void findByType(String type)
  {
    boolean found = false;
    for(KantoDex entry : entries)
    {
      if(entry.getTypes1().contains(type) && !type.equals(""))
      {
        found = true;
      }      
    }
    if(!found)
    {
      System.out.println("You have input a nonexistent type, or the type was not applicable to this entry.");  
    }
    else
    {
      System.out.println("All Pokedex entries of type " + type + ":");
      for(KantoDex entry : entries)
      {
        if(entry.getType1().equals(type) || entry.getType2().equals(type))
        {
          entry.display();
        }
      }
    }
  }
  
  /**
   * Finds all entries from a specific region and
   * prints out all their information.
   * @param region the specified region
   */
  public void findByRegion(String region)
  {
    boolean found = false;
    for(KantoDex entry : entries)
    {
      if(entry.getRegion().equals(region))
      {
        found = true;
      }
    }
    if(!found)
    {
      System.out.println("You have input a nonexistent region.");  
    }
    else
    {
      System.out.println(region + " Region entries:");
      for(KantoDex entry : entries)
      {
        if(entry.getRegion().equals(region))
        {
          entry.display();
        }
      }
    }
  }
}
