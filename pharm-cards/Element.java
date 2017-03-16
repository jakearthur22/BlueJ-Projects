import java.util.ArryList;
/**
* This is the class for the elements of each card
* @author Jake Arthur
* @version 2017.3.16
*/

public class Element
{
  String elName;
  String txtBody;
  
  /**
  * Constructor for objects of class Element
  * @param elName the category of information for this element
  * @param txtBody the main body of text
  */
  public Element(String elName, String txtBody)
  {
    this.elName = elName;
    this.txtBody = txtBody;
  }
  
  /**
  * @return elName the category of information for this element
  */
  public String getName()
  {
    return elName;
  }
  
  /**
  * @return txtBody the main body of text
  */
  public String getText()
  {
    return txtBody;
  }
  
}
