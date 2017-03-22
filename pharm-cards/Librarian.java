import java.util.Scanner;


public class Librarian()
{
  private ArrayList<String> cards;
  private ArrayList<Card> library;
  private ArrayList<Element> els;
  private Scanner scan;
  private Scanner fullScan;
  
  public Librarian(File file)
  {
    cards = new ArrayList<String>;
    library = new ArrayList<Card>;
    els = new ArrayList<Element>;
      scan = new Scanner();
      String f = scan.toString();
      f = f.replaceAll("\n","");
      f = f.replaceAll(")","");
      f = f.replaceAll("(","");
    fullScan = new Scanner(f);
    sort();
    fullScan.close();
  }
  
  private void sort()
  {
    fullScan.useDelimiter("|NEW CARD|");
    while(fullScan.hasNext())
    {
      cards.add(fullScan.next());
    }
    for(String card : cards)
    {
      Scanner cardScan = new Scanner(card);
      cardScan.useDelimiter("|ELEMENT|");
      String cName = cardScan.next(); 
      String cCat = cardScan.next();
      String cText = cardScan.next();
      while(cardScan.hasNext())
      {
        Scanner elScan = new Scanner(cardScan.next());
        elScan.useDelimiter("//");
        String eName = elScan.next();
        String eText = elScan.next();
        els.add(new Element(eName, eText));
        elScan.close();
      }
      library.add(new Card(cName, cCat, cText, els));
      els.clear();
      cardScan.close();
    }    
  }
  
  public ArrayList<Card> getLibrary()
  {
    return library;
  }
  
}
