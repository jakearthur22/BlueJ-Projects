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
  private JScrollPane pane;
  private boolean pressed;
  
  public CardGUI(Card c)
  {
    card = c;
    els = card.getEls();
    jbutts = new ArrayList<JButton>;
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
    addElButtons();
    outputTxt = new JTextArea();
    pane = new JScrollPane()
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    outputTxt.setColumns(20);
    outputTxt.setRows(5);
    pane.setViewportView(outputTxt);
    
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
    
    FlowLayout layout = new FlowLayout(getContentPane());
    getContentPane.setLayout(layout);
    //put the code for the layout here. Refer to notes.
    
  }// end of initComponents()
  
  
  
}//end of class
