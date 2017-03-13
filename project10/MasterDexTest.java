

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MasterDexTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MasterDexTest
{
  private KantoDex kantoDex1;
  private JohtoDex johtoDex1;
  private HoennDex hoennDex1;
  private UnovaDex unovaDex1;
  private KalosDex kalosDex1;
  private SinnohDex sinnohDe1;
  private KantoDex kantoDex2;
  private JohtoDex johtoDex2;
  private HoennDex hoennDex2;
  private UnovaDex unovaDex2;
  private KalosDex kalosDex2;
  private SinnohDex sinnohDe2;
  private JacobDatabase masterDe2;

    
    
    
    
    
    
    

    
    
    
    
    
    

    
    
    
    

    

    /**
     * Default constructor for test class MasterDexTest
     */
    public MasterDexTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    kantoDex1 = new KantoDex("006", "Charizard", "Fire", "Flying", "Stage 2", "Blaze", "Not Known");
        johtoDex1 = new JohtoDex("036", "Skarmory", "Steel", "Flying", "Basic", "Sturdy", "Mt. Silver", "Gold");
        hoennDex1 = new HoennDex("012", "Loudred", "Normal", "", "Stage 1", "Soundproof", "Victory Road", "Purple", 5);
        unovaDex1 = new UnovaDex("106", "Sawk", "Fighting", "", "Basic", "Mold Breaker", "Route 152", "Pink", 3);
        kalosDex1 = new KalosDex("045", "Gardevoir", "Psychic", "Fairy", "Stage 2", "Pixelate", "Not Known", "Green", false, true);
        sinnohDe1 = new SinnohDex("132", "Magmortar", "Fire", "", "Stage 2", "Flash Fire", "Link Trade", "Black", 9, "Magmarizer");
    kantoDex2 = new KantoDex("061", "Poliwhirl", "Water", "", "Stage 1", "Damp", "Cerulean City");
    johtoDex2 = new JohtoDex("189", "Jumpluff", "Grass", "Flying", "Stage 2", "Cotton Guard", "Route 5", "Green");
    hoennDex2 = new HoennDex("298", "Makuhita", "Fighting", "", "Basic", "Thick Fat", "Dewford Cave", "Orange", 4);
    unovaDex2 = new UnovaDex("598", "Ferrothorn", "Grass", "Steel", "Stage 1", "Iron Barbs", "Victory Road", "Magenta", 8);
    kalosDex2 = new KalosDex("668", "Pyroar", "Normal", "Fire", "Stage 1", "Moxie", "Fusion Labs", "Black", false, false);
    sinnohDe2 = new SinnohDex("468", "Togekiss", "Normal", "Flying", "Stage 2", "Hustle", "Not Known", "Gray", 9, "Shiny Stone");
    masterDe2 = new JacobDatabase();
  }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
