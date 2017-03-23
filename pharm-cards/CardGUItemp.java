import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.util.*;

/**
 *
 *
 * 
 * @author Jake Arthur
 * @version 2017.13.3
 */
public class CardGUI extends JFrame
{
  private Card card;
  private ArrayList<Element> els;
  private ArrayList<JButton> jbutts;
  private JTextArea outputTxt;
  private boolean pressed;
  
  public CardGUI(Card c)
  {
    card = c;
    els = card.getEls();
    jbutts = new ArrayList<JButton>;
    outputTxt = new JTextArea();
    pressed = false;
    initComponents();
    this.setVisible(true);
  }
  
  private void addElButtons()
  {
    int i = 1;
    for(Element el : els)
    {
      jbutts.add(new JButton(el.getName()));
      i++;
    }
  } //end of addElButtons()
  
  private void initComponents()
  {
    addElButtons(); //initially create the buttons
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    //for loop to set the name of each element
    int i = 0;
    for(Element el : els)
    {
      jbutts.get(i).setText(el.getName());
      i++;
    }
    //for loop to set the output text for each element
    i = 0;
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
    }// end of for loop to set the output text for each element
    
    
    
  }// end of initComponents()
  
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
  
}//end of class