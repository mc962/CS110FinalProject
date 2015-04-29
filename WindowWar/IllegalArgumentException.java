// Michael Chilton
// CS 110
/**This class extends the Exception class by writing a custom IllegalArgumentException. When utilized it will inform the 
user that they are out of bounds if they are out of bounds and lead to an exception being thrown
*/
public class IllegalArgumentException extends Exception
{
/**default no-args constructor. It calls the super Exception class and passes the string in parenthesis to it
*/
   public IllegalArgumentException()
   {
      super("Out of bounds.");
   }

/**constructor that accepts a string for the custom mmessage to be passed to it
It calls the super Exception class and passes the string in parenthesis to it
@param s represents the passed string message
*/   
   public IllegalArgumentException(String s)
   {
      super(s);
   }
}