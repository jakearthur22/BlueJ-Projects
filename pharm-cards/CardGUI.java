import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CardGUI extends JFrame
{
  //main variables here
  private Card card;
  private ArrayList<Element> els;
  private ArrayList<JButton> jbutts;
  private JTextArea outputTxt;
  private boolean pressed;
  private int gridX;
  private int gridY;
  
  public CardGUI(Card c)
  {
    //set variables & other things
    pressed = false;
    gridX = 0;
    gridY = 0;
    card = c;
    els = card.getEls();
    setGridCoordinates();
    jbutts = new ArrayList<JButton>();
    outputTxt = new JTextArea(5,10);
  }
  
  //any other methods here!
  private void addElButtons()
  {
    for(Element el : els)
    {
      jbutts.add(new JButton(el.getName()));
    }
  }
  
  private void setGridCoordinates()
  {
    int n = card.getNumber();
    if(n < 4)
    {
      gridX = 1; gridY = 3;
    }
    else if(n < 7)
    {
      gridX = 3; gridY = 2;
    }
    else if(n < 10)
    {
      gridX = 3; gridY = 3;
    }
    else
    {
      gridX = 4; gridY = (n/4 + 1);
    }
  }
  
  public void addComponentsToPane(final Container pane)
  {
    //create JPanels and set layout manager
    JPanel txtPanel = new JPanel();
    txtPanel.add(new JScrollPane(outputTxt));
    JPanel mainCardPanel = new JPanel(new FlowLayout());
    JPanel elPanel = new JPanel(new GridLayout(gridX, gridY));
    
    //create buttons
    addElButtons();
    mainCardPanel.add(jbutts.get(0));
    jbutts.remove(0);
    for(JButton button : jbutts)
    {
      elPanel.add(button);
    }
    //create action listeners for buttons
    int i = 0;
    for (Element el : els)
    {
      jbutts.get(i).addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent evt)
        {
          if(pressed = false)
          {
            outputTxt.setText(el.getText());
            pressed = true;
          }
          else
          {
            outputTxt.setText("");
            pressed = false;
          }
        }
      });
      i++;
    }
    //add all to the main pane
    pane.add(txtPanel, BorderLayout.PAGE_START);
    pane.add(mainCardPanel, BorderLayout.CENTER);
    pane.add(elPanel, BorderLayout.PAGE_END);
  }
  
  public static void createAndShowGUI()
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
