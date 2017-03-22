import java.util.Scanner;


public class Librarian()
{
  private ArrayList<String> cards;
  private ArrayList<Card> library;
  private ArrayList<Element> els;
  
  public Librarian()
  {
    cards = new ArrayList<String>;
    library = new ArrayList<Card>;
    els = new ArrayList<Element>;
    File file = new File([insert location]);
    Scanner scanner = new Scanner(file);
    sort();
  }
  
  private void sort()
  {
    scanner.useDelimiter("NEW CARD ");
    while(scanner.hasNext())
    {
      cards.add(scanner.next());
    }
    for(String card : cards)
    {
      Scanner s = new Scanner(card);
      s.useDelimiter("ELEMENT ");
      while(s.hasNext())
      {
        els.add(s.next());
      }
      String name = els.get(0); 
      String cat = els.get(1);
      String text = els.get(2);
      els.removeRange(0-3);
      library.add(new Card(name, cat, text, els));
      els.clear();
    }    
  }
  
  public ArrayList<Card> getLibrary()
  {
    return library;
  }
  
}
