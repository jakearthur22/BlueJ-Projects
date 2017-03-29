import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

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
      }}}
  
  private void setDrugList(String cat)
  {
    for(Card card : library)
    {
      if(card.getCategory().equals(cat)))
      {
        drugList[drugList.length] = card.getName();
      }}}
  
  public void addComponentsToPane(final Container pane)
  {
    //create JPanels and set layout manager//////////////////////////////////////////////////////////////////////////////////////
    JPanel pickCardPanel = new JPanel();
    pickCardPanel.setLayout(new BoxLayout(pickCardPanel, BoxLayout.Y_AXIS));
      JPanel pickPanel1 = new JPanel();
      JPanel pickPanel2 = new JPanel();
      JPanel pickPanel3 = new JPanel();
      JPanel pickPanel4 = new JPanel();
    
    JPanel addCardPanel = new JPanel();
    addCardPanel.setLayout(new BoxLayout(addCardPanel, BoxLayout.Y_AXIS));
      JPanel addPanel1 = new JPanel();
      JPanel addPanel2 = new JPanel();
      JPanel addPanel3 = new JPanel();
      JPanel addPanel4 = new JPanel();
      JPanel addPanel5 = new JPanel();
      JPanel addPanel6 = new JPanel();
      JPanel addPanel7 = new JPanel();
      
    //create components///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    JLabel titleLabel = new JLabel("Pick a card:");
    JLabel catLabel = new JLabel("Category: ");
    JComboBox catBox = new JComboBox(catList);
    JLabel drugLabel = new JLabel("Drug Name: ");
    JComboBox drugBox = new JComboBox(drugList);
    JButton selectDrugButton = new JButton("Select");
    
    JLabel addDrugNameLabel = new JLabel("Drug Name: ");
    JTextField addDrugNameText = new JTextField(15);
    JLabel addCatLabel = new JLabel("Category: ");
    JTextField addCatText = new JTextField(15);
    JLabel addExtraTextLabel = new JLabel("Main card text(optional): ");
    JTextField addExtraTextText = new JTextField(15,15);
    JLabel el1NameLabel = new JLabel("Element Name: ");
    JTextField el1NameText = new JTextField(15);
    JLabel el1TextLabel = new JLabel("Element Text: ");
    JTextField el1TextText = new JTextField(15,15);
    JButton addMoreElsButton = new JButton("Add Another Element");
    JButton addCardButton = new JButton("Done: Add Card");
    
    //add components to secondary panes//////////////////////////////////////////////////////////////////////////////////////////
    pickPanel1.add(titleLabel);
    pickPanel2.add(catLabel); pickPanel2.add(catBox);
    pickPanel3.add(drugLabel); pickPanel3.add(drugBox);
    pickPanel4.add(selectDrugButton);
    pickCardPanel.add(pickPanel1); pickCardPanel.add(pickPanel2); pickCardPanel.add(pickPanel3); pickCardPanel.add(pickPanel4);
    
    addPanel1.add(addDrugNameLabel); addPanel1.add(addDrugNameText);
    addPanel2.add(addCatLabel); addPanel2.add(addCatText);
    addPanel3.add(addExtraTextLabel); addPanel3.add(addExtraTextText);
    addPanel4.add(el1NameLabel); addPanel4.add(el1NameText);
    addPanel5.add(el1TextLabel); addPanel5.add(el1TextText);
    addPanel6.add(addMoreElsButton);
    addPanel7.add(addCardButton);
    addCardPanel.add(addPanel1); addCardPanel.add(addPanel2); addCardPanel.add(addPanel3); addCardPanel.add(addPanel4); addCardPanel.add(addPanel5); addCardPanel.add(addPanel6); addCardPanel.add(addPanel7);
    
    //create action listeners for components////////////////////////////////////////////////////////////////////////////////////
    //for the the ComboBox that holds all available Categories, IN PICKPANEL
    catBox.addActionListener(new ActionListener()
    {
      public void catBoxActionPerformed(ActionEvent evt)
      {
        setDrugList(catBox.getSelectedItem());
        drugBox.removeAllItems();
        for(int i = 0; i < drugList.length; i++)
        {
          drugBox.addItem(drugList[i]);
        }}});
    //for the button used to call the selected index card, IN PICKPANEL
    selectDrugButton.addActionListener(new ActionListener()
    {
      public void selectDrugButtonActionPerformed(ActionEvent evt)
      {
        if(drugBox.getSelectedItem() != null)
        {
          for(Card card : library)
          {
            if(card.getName().equals(drugBox.getSelectedItem().toString()))
            {
              CardGUI cardDisplay = new CardGUI(card);
              cardDisplay.setVisible(true);
            }}}}});
    //for the button used to add a card to the library, IN ADDPANEL
    addCardButton.addActionListener(new ActionListener()
    {
      public void addCardButtonActionPerformed(ActionEvent evt)
      {
        if(addDrugNameText.getText().isEmpty() ||
           addCatText.getText().isEmpty() ||
           addEl1NameText.getText().isEmpty() ||
           addEl1TextText.getText().isEmpty())
        {
          
        }
        else
        {
          
        }
      }
    });
    //add all to the main pane//////////////////////////////////////////////////////////////////////////////////////////////////////
    pane.add(pickCardPanel, BorderLayout.CENTER);
    pane.add(addCardPanel, BorderLayout.LINE_END);
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
