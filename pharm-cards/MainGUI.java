import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JFrame
{
  private Librarian librarian;
  private ArrayList<Card> library;
  String[] catList;
  String[] drugList;
  
  public MainGUI()
  {
    librarian = new Librarian(new File(/*file location*/);
    library = librarian.getLibrary();
    catList = new String[];
    drugList = new String[];
    setCatList()
  }
  
  private void setCatList()
  {
    for(Card card : library)
    {
      boolean repeated = false;
      for(int i = 0; i < catList.length; i++)
      {
        if(catList[i].equals(card.getCategory)))
        {
          repeated = true;
        }
      }
      if(!repeated)
      {
        catList[catList.length] = card.getCategory();
      }
    }
  }
  
  private void setDrugList(String cat)
  {
    for(Card card : library)
    {
      if(card.getName().equals(cat)))
      {
        drugList[drugList.length] = card.getName();
      }
    }
  }
  
  public void addComponentsToPane(final Container pane)
  {
    //create JPanels and set layout manager
    
    //create buttons
    JComboBox catBox = new JComboBox(catList);
    
    //create action listeners for buttons
    //add all to the main pane
  }
  
  private static void createAndShowGUI()
  {
    //create frame
    JFrame frame = new JFrame(card.getName());
    //set frame to close
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //addComponentsToPane()
    addComponentsToPane(frame.getContentPane());
    //pack
    frame.pack();
    //set visible
    frame.setVisible(true);
  }
  
  public static void main(String[] args)
  {
    //try catch look and feel
    //run createAndShowGUI()
    try
    {
      //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException ex) 
    {
       ex.printStackTrace();
    } 
    catch (IllegalAccessException ex) 
    {
       ex.printStackTrace();
    } 
    catch (InstantiationException ex)
    {
       ex.printStackTrace();
    } 
    catch (ClassNotFoundException ex) 
    {
       ex.printStackTrace();
    }
       /* Turn off metal's use of bold fonts */
       UIManager.put("swing.boldMetal", Boolean.FALSE);
       //Schedule a job for the event dispatch thread:
       //creating and showing this application's GUI.
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
               createAndShowGUI();
            }
        });
  }
  
}
