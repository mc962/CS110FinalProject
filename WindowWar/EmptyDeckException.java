// Michael Chilton
// CS 110
/**Custom exception that is used in classes dealing with card piles/decks, and should
be thrown when one attempts to remove a card from an empty deck*/
public class EmptyDeckException extends RuntimeException
{
/**default no-args constructor that passes a String message to the super class when called
*/
  public EmptyDeckException()
  {
      super("Deck is empty.");
  }
/** constructor that passes a string argument to super
@param s represents String passed from that which called it
*/
  public EmptyDeckException(String s) 
  {
    super(s);
  } 
  

}  