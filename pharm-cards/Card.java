import java.util.ArrayList;
/**
* Card, this is the main class for the index card.
* @author Jake Arthur
* @version 2017.3.16
*/
public class Card
{
  String name;
  String category;
  String txtExtra;
  ArrayList<Element> els;
  public Element mainCard;
  
  /**
  * Constructor for objects of class Card
  * @param name the drug name
  * @param category the category that the drug is in
  * @param txtExtra any extra text that may be displayed on the main card
  * @param els the ArrayList of all the elements in this card
  */
  public Card(String name, String category, String txtExtra, ArrayList<Element> els)
  {
    this.name = name;
    this.category = category;
    this.txtExtra = txtExtra;
    this.els = els;
    mainCard = new Element(name, txtExtra);
    addMain();
  }
  
  /**
  * @return name the drug name
  */
  public String getName()
  {
    return name;
  }
  
  /**
  * @return category the category that the drug is in
  */
  public String getCat()
  {
    return category;
  }
  
  /**
  * @return txtExtra any extra text that may be displayed on the main card
  */
  public String getExtraText()
  {
    return txtExtra;
  }
  
  /**
  * @return els the ArrayList of elements in the card
  */
  public ArrayList<Element> getEls()
  {
    return els;
  }
  
  /**
  *
  */
  public int getNumber()
  {
    return (els.size() - 1);
  }
  
  /**
  * adds the main card to the ArrayList of elements
  */
  public void addMain()
  {
    int mid = (els.size() / 2)
    els.add(mid, mainCard);
  }
  
}
