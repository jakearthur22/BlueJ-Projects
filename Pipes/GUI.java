
/**
 *
 * @author Eric Slaweski
 */
public class GUI extends javax.swing.JFrame
{
  // Variables declaration                   
  private javax.swing.JButton back;
  private javax.swing.JButton down;
  private javax.swing.JButton east;
  private javax.swing.JButton hitFace;
  private javax.swing.JButton hitSholder;
  private javax.swing.JButton inv1;
  private javax.swing.JButton inv2;
  private javax.swing.JButton inv3;
  private javax.swing.JButton inv4;
  private javax.swing.JButton inv5;
  private javax.swing.JButton inv6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton north;
  private javax.swing.JTextArea outputText;
  private javax.swing.JButton pickUp;
  private javax.swing.JButton south;
  private javax.swing.JButton up;
  private javax.swing.JButton west;
  private Game game;
  // End of variables declaration  
  /**
   * Creates new form NewJFrame
   */
  public GUI()
  {
    initComponents();
    game = new Game();
    this.setVisible(true);
    welcome();    
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents()
  {

    jScrollPane1 = new javax.swing.JScrollPane();
    outputText = new javax.swing.JTextArea();
    west = new javax.swing.JButton();
    north = new javax.swing.JButton();
    east = new javax.swing.JButton();
    south = new javax.swing.JButton();
    inv4 = new javax.swing.JButton();
    inv1 = new javax.swing.JButton();
    inv5 = new javax.swing.JButton();
    inv6 = new javax.swing.JButton();
    inv3 = new javax.swing.JButton();
    inv2 = new javax.swing.JButton();
    pickUp = new javax.swing.JButton();
    up = new javax.swing.JButton();
    down = new javax.swing.JButton();
    hitFace = new javax.swing.JButton();
    hitSholder = new javax.swing.JButton();
    back = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    outputText.setColumns(20);
    outputText.setRows(5);
    jScrollPane1.setViewportView(outputText);

    west.setText("West");
    west.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          westActionPerformed(evt);
        }
      });

    north.setText("North");
    north.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          northActionPerformed(evt);
        }
      });

    east.setText("East");
    east.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          eastActionPerformed(evt);
        }
      });

    south.setText("South");
    south.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          southActionPerformed(evt);
        }
      });

    inv4.setText("inv4(Empty)");
    inv4.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          inv4ActionPerformed(evt);
        }
      });

    inv1.setText("inv1(Empty)");
    inv1.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          inv1ActionPerformed(evt);
        }
      });

    inv5.setText("inv5(Empty)");
    inv5.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          inv5ActionPerformed(evt);
        }
      });

    inv6.setText("inv6(Empty)");
    inv6.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          inv6ActionPerformed(evt);
        }
      });

    inv3.setText("inv3(Empty)");
    inv3.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          inv3ActionPerformed(evt);
        }
      });

    inv2.setText("inv2(Empty)");
    inv2.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          inv2ActionPerformed(evt);
        }
      });

    pickUp.setText("Pick Up");
    pickUp.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          pickUpActionPerformed(evt);
        }
      });

    up.setText("Up");
    up.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          upActionPerformed(evt);
        }
      });

    down.setText("Down");
    down.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          downActionPerformed(evt);
        }
      });

    hitFace.setText("Hit Face");
    hitFace.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          hitFaceActionPerformed(evt);
        }
      });

    hitSholder.setText("Hit Sholder");
    hitSholder.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          hitSholderActionPerformed(evt);
        }
      });

    back.setText("Back");
    back.addActionListener(new java.awt.event.ActionListener()
      {
        public void actionPerformed(java.awt.event.ActionEvent evt)
        {
          backActionPerformed(evt);
        }
      });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(60, 60, 60))
      .addGroup(layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(58, 58, 58)
            .addComponent(south)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(west)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(east)
                    .addGap(43, 43, 43))
                  .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(north)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(back)
                  .addComponent(up))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hitFace))
                  .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(inv4)
                        .addGap(18, 18, 18)
                        .addComponent(inv5)
                        .addGap(18, 18, 18)
                        .addComponent(inv6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hitSholder))
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(inv1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addGroup(layout.createSequentialGroup()
                            .addComponent(inv2)
                            .addGap(18, 18, 18)
                            .addComponent(inv3))
                          .addComponent(pickUp))))))))
            .addGap(109, 109, 109))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(82, 82, 82)
            .addComponent(north)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(east)
              .addComponent(west)
              .addComponent(back))
            .addGap(18, 18, 18)
            .addComponent(south)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(pickUp)
                .addGap(27, 27, 27))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(hitFace)
                    .addGap(13, 13, 13))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(up)
                    .addGap(3, 3, 3)))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(inv1)
              .addComponent(inv2)
              .addComponent(inv3))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(inv5)
              .addComponent(inv6)
              .addComponent(inv4)
              .addComponent(hitSholder))
            .addGap(18, 18, Short.MAX_VALUE)
            .addComponent(down)
            .addGap(45, 45, 45))))
    );

    pack();
    this.setSize(950, 555);
  }// </editor-fold>                             

  /**
   * The code handeling for the "Inv1" button.
   */
  private void inv1ActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                                         
    if(!game.getInBattle())
    {
      outputText.setText(game.useItem(0) + "\n" + game.getCurrentRoom().getExitString());
      if(game.itemRemoved())
        inv1.setText("inv1(empty)");
    }
    else
      outputText.setText(game.guiPressed("inv1"));
  }                                    

  /**
   * The code handeling for the "Inv2" button.
   */
  private void inv2ActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                                         
    if(!game.getInBattle())
    { 
      outputText.setText(game.useItem(1) + "\n" + game.getCurrentRoom().getExitString());
      if(game.itemRemoved())
        inv2.setText("inv2(empty)");
    }
    else
      outputText.setText(game.guiPressed("inv2"));

  }                                    

  /**
   * The code handeling for the "Inv3" button.
   */
  private void inv3ActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                                         
    if(!game.getInBattle())
    {
      outputText.setText(game.useItem(2) + "\n" + game.getCurrentRoom().getExitString());
      if(game.itemRemoved())
        inv3.setText("inv3(empty)");
    }
    else
      outputText.setText(game.guiPressed("inv3"));
  }                                    

  /**
   * The code handeling for the "Inv4" button.
   */
  private void inv4ActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                                         
    if(!game.getInBattle())
    {
      outputText.setText(game.useItem(3) + "\n" + game.getCurrentRoom().getExitString());
      if(game.itemRemoved())
        inv4.setText("inv4(empty)");
    }
    else
      outputText.setText(game.guiPressed("inv4"));
  }                                    

  /**
   * The code handeling for the "Inv5" button.
   */
  private void inv5ActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                                         
    if(!game.getInBattle())
    {
      outputText.setText(game.useItem(4) + "\n" + game.getCurrentRoom().getExitString());
      if(game.itemRemoved())
        inv5.setText("inv5(empty)");
    }
    else
      outputText.setText(game.guiPressed("inv5"));
  }                                    

  /**
   * The code handeling for the "Inv6" button.
   */
  private void inv6ActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                                         
    if(!game.getInBattle())
    {
      outputText.setText(game.useItem(5) + "\n" + game.getCurrentRoom().getExitString());
      if(game.itemRemoved())
        inv6.setText("inv6(empty)");
    }
    else
      outputText.setText(game.guiPressed("inv6"));
  }                                    

  /**
   * The code handeling for the "north" button.
   */
  private void northActionPerformed(java.awt.event.ActionEvent evt)                                      
  {                     
    if(!game.getInBattle())
      outputText.setText("You went north\n" + game.goRoom("north"));
  }                                     

  /**
   * The code handeling for the "east" button.
   */
  private void eastActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                     
    if(!game.getInBattle())
      outputText.setText("You went east\n " + game.goRoom("east"));
  }                                    

  /**
   * The code handeling for the "south" button.
   */
  private void southActionPerformed(java.awt.event.ActionEvent evt)                                      
  {                     
    if(!game.getInBattle())
      outputText.setText("You went south\n" + game.goRoom("south"));
  }                                     

  /**
   * The code handeling for the "west" button.
   */
  private void westActionPerformed(java.awt.event.ActionEvent evt)                                     
  {                       
    if(!game.getInBattle())
      outputText.setText("You went west\n" + game.goRoom("west"));
  }                                    

  /**
   * The code handeling for the "pick up" button.
   */
  private void pickUpActionPerformed(java.awt.event.ActionEvent evt)                                       
  {
    if(!game.getInBattle())
    {
      String text = game.pickUp();
      outputText.setText(text);
      if(text != "There is nothing in this room.\n")
      {
        int slot = game.getNewestItemSlot();
        String name = game.getNewestItemName();
        if(name != null)
        {
          if(slot == 0)
            inv1.setText(name);
          if(slot == 1)
            inv2.setText(name);
          if(slot == 2)
            inv3.setText(name);
          if(slot == 3)
            inv4.setText(name);
          if(slot == 4)
            inv5.setText(name);
          if(slot == 5)
            inv6.setText(name);
        }
      }
    }
  }                                      

  /**
   * The code handeling for the "up" button.
   */
  private void upActionPerformed(java.awt.event.ActionEvent evt)                                   
  {                                       
    if(!game.getInBattle())
      outputText.setText("You went up\n" + game.goRoom("up"));
  }                                  

  /**
   * The code handeling for the "down" button.
   */
  private void downActionPerformed(java.awt.event.ActionEvent evt)                                     
  {            
    if(!game.getInBattle())
      outputText.setText("You went down\n" + game.goRoom("down"));
  }

  /**
   * The code handeling for the "hit face" button.
   */
  private void hitFaceActionPerformed(java.awt.event.ActionEvent evt)                                        
  {         
    if(game.getInBattle())
      outputText.setText(game.guiPressed("hitFace"));
  }                                       

  /**
   * The code handeling for the "Inv1" button.
   */
  private void hitSholderActionPerformed(java.awt.event.ActionEvent evt)                                           
  {              
    if(game.getInBattle())
      outputText.setText(game.guiPressed("hitSholder"));
  }  

  /**
   * The code handeling for the "Back" button.
   */
  private void backActionPerformed(java.awt.event.ActionEvent evt)
  {
    if(!game.getInBattle())
      outputText.setText(game.goBack());
  }

  /**
   * This prints the welcome message to the textbox.
   */
  private void welcome()
  {
    outputText.setText("Welcome to Pipes.\n" +
      "Use the cardnal direction buttons to move around.\n" +
      "Use the Up or Down buttons to climb ladders.\n\n" + 
      "\n" +
      "The light is dim as you open your eyes. Your head is aching.\n" +
      "Your friend was working on the same level, and he had the wrench.\n" +
      "The wrench is the only way you can get out, it must be found in order to escape the sewers.\n" +
      "The path is filled with monsters and ladders, but you must escape.\n" +
      "Good luck on your journey.\n" +
      "\n" +
      game.getCurrentRoom().getDescription() + "\n" + game.getCurrentRoom().getExitString());
  }

  /**
   * @param args the command line arguments
   */
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
    //</editor-fold>

    /* Create and display the form */
  }                 
}