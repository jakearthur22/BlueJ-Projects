import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Librarian()
{
  private File file;
  private ArrayList<String> cards;
  private ArrayList<Card> library;
  private ArrayList<Element> els;
  private Scanner scan;
  private Scanner fullScan;
  
  public Librarian(File thisFile)
  {
    file = new File(thisFile);
    cards = new ArrayList<String>;
    library = new ArrayList<Card>;
    els = new ArrayList<Element>;
      scan = new Scanner(file);
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
  
  public void addEntry(Card card)
  {
    String cString = "";
    cString = "\n|NEW CARD||ELEMENT|(" + card.getName() + ")|ELEMENT|(" + card.getCat() + ")|ELEMENT|(" + card.getExtraText()
      //now concat() the elements
    els = card.getEls();
    for(Element el : els)
    {
      cString.concat("\n|ELEMENT|(" + el.getName() + ")//(" + el.getText() + ")")
    }
    els.clear();
    try
    {
    BufferedWriter out = new BufferedWriter(new FileWriter(file));
    out.write(cString); 
    out.close();
    }
    catch (IOException e)
    {
      System.out.println("Exception ");
    }
  }
  
  public String locateCardName(String line)
  {
    Scanner locScan = new Scanner(line);
    locScan.useDelimiter("|ELEMENT|");
    locScan.next();
    return locScan.next(); //testthis, cause I can't tell if its returning the drug name or the category.
                           //It should return the drug name.
  }
  
  public void deleteEntry(Card card)
  {
    File tempFile = File.createTempFile("file", ".txt", file.getParentFile());
    String charset = "UTF-8";
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), charset));
    
    String removeThis = card.getName();
    String currentLine;
    
    while((currentLine = reader.readLine()) != null)
    {
      String lineLocator = locateCardName(currentLine.trim());
      if(lineLocator.equals(removeThis)) continue;
      writer.write(currentLine+System.getProperty("line.separator"));
    }
    writer.close();
    reader.close();
    file.delete();
    tempFile.renameTo(file);
  }
  
}
