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
        drugList[drugList.length] = card.getName()
      }
    }
  }
  
}
