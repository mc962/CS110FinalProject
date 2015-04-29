// Michael Chilton
// CS 110
/**This class is designed to simulate a deck of cards, identifying a card's suit and rank based on input, with the capabilities to either 
return the suit individually, the rank indiviidually, or identify them together in one string
There is also a capability to test if the two cards are equal (which is determined by rank)*/
public class Card
{
// declares named constants for constant values for card suits and ranks as given by TA
   public static final int SPADES = 1;
   public static final int CLUBS = 3;
   public static final int HEARTS = 2;
   public static final int DIAMONDS =4;
   public static final int ACE = 1;
   public static final int JACK =11;
   public static final int QUEEN =12;
   public static final int KING =13;
   
// declares private variables for suit and ran
   private int rank, suit;
/**constructor that has suit and rank passed as int argumments, and uses this reference variable with them to overcome shadowing
@param suit represents inputted value of the suit
@param rank represents the inputted value of the rank
*/
   public Card(int suit, int rank) throws IllegalArgumentException
   {
      if (suit <SPADES || suit >DIAMONDS)
      {
         throw new IllegalArgumentException(suit + " suit is out of bounds");
      }
      else
      {
// sets a reference suit variable equal to the int suit argument
         this.suit = suit;
      }
      if (rank <ACE || rank > KING)
      {
         throw new IllegalArgumentException(rank + " rank is out of bounds");
      }
      else
      {
// sets a reference rank variable equal to int rank argument      
         this.rank = rank;
      }
   }

/**when called gets the suit value inputted for the object
@return returns the suit value
*/   
   public int getSuit()
   {
      return suit;
   }
/**when called gets the rank value inputted for the object
@return returns the rank value
*/   
   public int getRank()
   {
      return rank;
   }
/** String method that puts both the suit and rank of the card object together as "'rank' of 'suit'" and returns that string
@return returns the suitString rankString together as "'rank' of 'suit'"*/   
   public String toString()
   {
// declares string variables for suit and rank and initializes them as blank strings
      String suitString = "", rankString = "";
// suit decision structure that assigns the name of the suit to suitString based on the inputted number for suit
      if (suit == 1)
      {
         suitString = "SPADES";
      }
      else if (suit == 2)
      {
         suitString = "HEARTS";
      }
      else if (suit == 3)
      {
         suitString = "CLUBS";
      }
      else if (suit == 4)
      {
         suitString = "DIAMONDS";
      }
// rank decision structure that assigns the name of the rank to rankString based on the inputted number for rank
      if (rank == 1)
      {
         rankString = "ACE";
      }
      else if (rank == 2)
      {
         rankString = "TWO";
      }
      else if (rank == 3)
      {
         rankString = "THREE";
      }      
      else if (rank == 4)
      {
         rankString = "FOUR";
      }                 
      else if (rank == 5)
      {
         rankString = "FIVE";
      }
      else if (rank == 6)
      {
         rankString = "SIX";
      }
      else if (rank == 7)
      {
         rankString = "SEVEN";
      }
      else if (rank == 8)
      {
         rankString = "EIGHT";
      }
      else if (rank == 9)
      {
         rankString = "NINE";
      }
      else if (rank == 10)
      {
         rankString = "TEN";
      }      
      else if (rank == 11)
      {
         rankString = "JACK";
      }
      else if (rank == 12)
      {
         rankString = "QUEEN";
      }
      else if (rank == 13)
      {
         rankString = "KING";
      }
      

      // returns rank and suit together
      return rankString + " of " + suitString; 
   }
/**boolean method that checks if the object made from the first card input has equal value to that of the second card, where value is based on rank, and
assigns true or false to the status based on whether or not the card is equal, then returns that status
@return status returns the status as true if the cards are equal or false if they are not equal
*/   
   public boolean equals(Card otherCard)
   {
// declares boolean status variable for use to determine equality
      boolean status;
// decision structure that sets boolean value of status to true if the card ranks are equal, or false if the ranks are not equal      
      if (rank == otherCard.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
// returns status of whether they are equal      
      return status;
   }
   public boolean isGreater(Card otherCard)
   {
      boolean status;
      if (rank > otherCard.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
      return status;
   }
}