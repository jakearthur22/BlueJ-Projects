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
  
  public CardGUI(Card c)
  {
    card = c;
    els = card.getEls();
    jbutts = new ArrayList<JButton>;
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
  }
  
  private void initComponents()
  {
    addElButtons();
    outputTxt = new JTextArea();
    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
  
}
