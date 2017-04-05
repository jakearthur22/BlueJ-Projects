import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MainGUI extends JFrame
{
  private Librarian librarian;
  private ArrayList<Card> library;
  private String[] catList;
  private String[] drugList;
  
  public MainGUI()
  {
    librarian = new Librarian(new File(/*file location*/));
    library = librarian.getLibrary();
    setCatList();
    initDrugList();
    run();
  }
  
  private void setCatList()
  {
    for(Card card : library)
    {
      boolean repeated = false;
      for(int i = 0; i < catList.length; i++)
      {
        if(catList[i].equals(card.getCategory))
        {
          repeated = true;
        }
      }
      if(!repeated)
      {
        catList[catList.length] = card.getCategory();
      }}}
  
  private void initDrugList()
  {
    for(Card card : library)
    {
      drugList[drugList.length] = card.getName();
    }
  }
  
  private void setDrugList(String cat)
  {
    for(Card card : library)
    {
      if(card.getCategory().equals(cat))
      {
        drugList[drugList.length] = card.getName();
      }}}
  
  @SuppressWarnings("unchecked")
  private void addComponentsToPane(Container pane)
  {
    //create JPanels and set layout manager//////////////////////////////////////////////////////////////////////////////////////
    //the panel to pick a card from the library
    JPanel pickCardPanel = new JPanel();
    pickCardPanel.setLayout(new BoxLayout(pickCardPanel, BoxLayout.Y_AXIS));
      JPanel pickPanel1 = new JPanel();
      JPanel pickPanel2 = new JPanel();
      JPanel pickPanel3 = new JPanel();
      JPanel pickPanel4 = new JPanel();
    
    //the panel to add a card to the library
    JPanel addCardPanel = new JPanel();
    addCardPanel.setLayout(new BoxLayout(addCardPanel, BoxLayout.Y_AXIS));
      JPanel addPanel0 = new JPanel();
      JPanel addPanel1 = new JPanel();
      JPanel addPanel2 = new JPanel();
      JPanel addPanel3 = new JPanel();
      JPanel addPanel4 = new JPanel();
      JPanel addElPanel = new JPanel();
      addElPanel.setLayout(new BoxLayout(addElPanel, BoxLayout.Y_AXIS));
      JPanel addPanel5 = new JPanel();
      JPanel addPanel6 = new JPanel();
    
    //the panel to delete a card from the library
    JPanel deleteCardPanel = new JPanel();
    deleteCardPanel.setLayout(new BoxLayout(deleteCardPanel, BoxLayout.Y_AXIS));
      JPanel deletePanel1 = new JPanel();
      JPanel deletePanel2 = new JPanel();
      JPanel deletePanel3 = new JPanel();
      JPanel deletePanel4 = new JPanel();
    //create components///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //componenets for the panel to pick a card from the library
    JLabel titleLabel = new JLabel("Pick a card:");
    JLabel catLabel = new JLabel("Category: ");
    JComboBox catBox = new JComboBox(catList);
    JLabel drugLabel = new JLabel("Drug Name: ");
    JComboBox drugBox = new JComboBox(drugList);
    JButton selectDrugButton = new JButton("Select");
    
    //componenets for the panel to add a card to the library
    JLabel addTitleLabel = new JLabel("Create a new card: ");
    JLabel addDrugNameLabel = new JLabel("Drug Name: ");
    JTextField addDrugNameText = new JTextField(15);
    JLabel addCatLabel = new JLabel("Category: ");
    JTextField addCatText = new JTextField(15);
    JLabel addExtraTextLabel = new JLabel("Main card text(optional): ");
    JTextField addExtraTextText = new JTextField(15);
    JLabel elNameLabel = new JLabel("Element Name: ");
    JTextField elNameText = new JTextField(15);
    JLabel elTextLabel = new JLabel("Element Text: ");
    JTextField elTextText = new JTextField(15);
    JButton addMoreElsButton = new JButton("Add Another Element");
      ArrayList<Element> elAddList = new ArrayList<Element>();
      ArrayList<JTextField> elNameList = new ArrayList<JTextField>();
      ArrayList<JTextField> elTextList = new ArrayList<JTextField>();
    JButton addCardButton = new JButton("Done: Add Card");
    
    //componenets for the panel to delete a card from the library
    JLabel deleteTitleLabel = new JLabel("Delete a card: ");
    JLabel deleteCatLabel = new JLabel("Category: ");
    JComboBox deleteCatBox = new JComboBox(catList);
    JLabel deleteDrugLabel = new JLabel("Drug Name: ");
    JComboBox deleteDrugBox = new JComboBox(drugList);
    JButton deletePreviewButton = new JButton("Preview");
    JButton deleteCardButton = new JButton("Delete");
    //add components to secondary panes//////////////////////////////////////////////////////////////////////////////////////////
    pickPanel1.add(titleLabel);
    pickPanel2.add(catLabel); pickPanel2.add(catBox);
    pickPanel3.add(drugLabel); pickPanel3.add(drugBox);
    pickPanel4.add(selectDrugButton);
    pickCardPanel.add(pickPanel1); pickCardPanel.add(pickPanel2); pickCardPanel.add(pickPanel3); pickCardPanel.add(pickPanel4);
    
    addPanel0.add(addTitleLabel);
    addPanel1.add(addDrugNameLabel); addPanel1.add(addDrugNameText);
    addPanel2.add(addCatLabel); addPanel2.add(addCatText);
    addPanel3.add(addExtraTextLabel); addPanel3.add(addExtraTextText);
    addElPanel.add(elNameLabel); addElPanel.add(elNameText); addElPanel.add(elTextLabel); addElPanel.add(elTextText);
    addPanel5.add(addMoreElsButton);
    addPanel6.add(addCardButton);
    addCardPanel.add(addPanel0); addCardPanel.add(addPanel1); addCardPanel.add(addPanel2); addCardPanel.add(addPanel3); addCardPanel.add(addPanel4); addCardPanel.add(addElPanel); addCardPanel.add(addPanel5); addCardPanel.add(addPanel6);
    
    deletePanel1.add(deleteTitleLabel);
    deletePanel2.add(deleteCatLabel); deletePanel2.add(deleteCatBox);
    deletePanel3.add(deleteDrugLabel); deletePanel3.add(deleteDrugBox);
    deletePanel4.add(deletePreviewButton); deletePanel4.add(deleteCardButton);
    deleteCardPanel.add(deletePanel1); deleteCardPanel.add(deletePanel2); deleteCardPanel.add(deletePanel3); deleteCardPanel.add(deletePanel4);
    //create action listeners for components////////////////////////////////////////////////////////////////////////////////////
    //for the the ComboBox that holds all available Categories, IN PICKPANEL
    catBox.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
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
      public void actionPerformed(ActionEvent evt)
      {
        if(drugBox.getSelectedItem() != null)
        {
          for(Card card : library)
          {
            if(card.getName().equals(drugBox.getSelectedItem().toString()))
            {
              initDrugList();
              CardGUI cardDisplay = new CardGUI(card);
              cardDisplay.setVisible(true);
            }}}}});
    //for the button used to add more textFields and Labels for elements, IN ADDPANEL
    addMoreElsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        addElPanel.add(new JLabel("Element Name: "));
        elNameList.add(new JTextField(15));
        addElPanel.add(elNameList.get(elNameList.size()-1));
        addElPanel.add(new JLabel("Element Text: "));
        elTextList.add(new JTextField(15));
        addElPanel.add(elTextList.get(elTextList.size()-1));
        addElPanel.validate();
        addElPanel.repaint();
      }
    });
    //for the button used to add a card to the library, IN ADDPANEL
    addCardButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        if(addDrugNameText.getText().isEmpty() ||
           addCatText.getText().isEmpty() ||
           elNameText.getText().isEmpty() ||
           elTextText.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(pane, "Card cannot be added until all required fields are filled.");
        }
        else
        {
          int parseName = 0;
          for(JTextField name : elNameList)
          {
            parseName++;
            int parseText = 0;
            for(JTextField text : elTextList)
            {
            parseText++;
              if(parseName == parseText)
              {
                elAddList.add(new Element(name.getText().toString(), text.getText().toString()));
              }
            }
          }
          try
          {
            librarian.addEntry(new Card(addDrugNameText.getText(), addCatText.getText(), addExtraTextText.getText(), elAddList));
            elAddList.clear(); elNameList.clear(); elTextList.clear();
            addElPanel.removeAll();
            addElPanel.add(elNameLabel); addElPanel.add(elNameText); addElPanel.add(elTextLabel); addElPanel.add(elTextText);
            JOptionPane.showMessageDialog(pane, "Card successfully added."); //may need to restart the program in order for changes to take effect!!!!!!!
          }
          catch(Exception ex)
          {
            ex.printStackTrace();
          }
        }
      }
    });
    //for the ComboBox that holds all available Categories, IN DELETEPANEL
    deleteCatBox.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        setDrugList(deleteCatBox.getSelectedItem().toString());
        deleteDrugBox.removeAllItems();
        for(int i = 0; i < drugList.length; i++)
        {
          deleteDrugBox.addItem(drugList[i]);
        }}});
    //for the button used to preview the card about to be deleted, IN DELETEPANEL
    deletePreviewButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        if(deleteDrugBox.getSelectedItem() != null)
        {
          for(Card card : library)
          {
            if(card.getName().equals(deleteDrugBox.getSelectedItem()))
            {
              CardGUI cardDisplay = new CardGUI(card);
              cardDisplay.setVisible(true);
            }}}}});
    //for the button used to delete the selected card from the library, IN DELETEPANEL
    deleteCardButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        if(deleteDrugBox.getSelectedItem() != null)
        {
          for(Card card : library)
          {
            if(card.getName().equals(deleteDrugBox.getSelectedItem().toString()))
            {
              int n = JOptionPane.showConfirmDialog(pane, "Sure to delete this card??");
              if(n ==JOptionPane.YES_OPTION)
              {
                initDrugList();
                try
                {
                librarian.deleteEntry(card);
                JOptionPane.showMessageDialog(pane, "Card successfully deleted.");
                //there might be a problem with this- this dialog boxes might be overlapping.
                }
                catch(Exception ex)
                {
                  ex.printStackTrace();
                }}}}}}});
    //add all to the main pane//////////////////////////////////////////////////////////////////////////////////////////////////////
    pane.add(deleteCardPanel, BorderLayout.LINE_START);
    pane.add(pickCardPanel, BorderLayout.CENTER);
    pane.add(addCardPanel, BorderLayout.LINE_END);
  }
  
  private void createAndShowGUI()
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
  
  public void run()
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
