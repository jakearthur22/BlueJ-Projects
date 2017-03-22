public class MainGUI() extends JFrame
{
  private Librarian librarian;
  private ArrayList<Card> library;
  
  public MainGUI()
  {
    librarian = new Librarian(new File(/*file location*/);
    library = librarian.getLibrary();
  }
  
}
