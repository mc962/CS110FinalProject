// Michael Chilton
// CS 110
/** represents a generic card pile
full of generic methods that can be used for a card pile
*/
import java.util.ArrayList;
import java.util.Random;

public class CardPile
{
// declares a Card arraylist of pile
   private ArrayList<Card> pile; 
/** constructor for CardPile that assigns pile to a new Card arraylistt
*/
   public CardPile()
   {
      pile = new ArrayList<Card>();
   }
/** accepts a Card arraylist deck and assigns it to pile
@param deck represents a Card arraylist passed from that which cllaed it
*/
   public void setDeck(ArrayList<Card> deck) 
   {
      pile = deck;
   }
/** adds card to the pile
@param card represents the card to be added
*/
   public void addCard(Card card)
   {
      pile.add(card);
   }
/** removes card from the pile
@param card represents the card to be removed
@exception EmptyDeckException is thrown if attempt is made to remove from an empty deck
*/
   public void removeCard(Card card) throws EmptyDeckException
   {
       if (pile.size()==0)
      {
         throw new EmptyDeckException("Deck is empty");
      }
      else
      {
      pile.remove(card);
      }
   }
/** gets the card specified by the passed int
@param i represents the integer index passed to grab from the pile
@return gets the card from the pile at i
@exception throws IndexOutOfBoundsException if i is out of bounds
*/
   public Card getCard(int i) throws IndexOutOfBoundsException
   {
      if (i<0 || i > pile.size())
      {
         throw new IndexOutOfBoundsException("Index passed is negative");
      }
      else
      {
      return pile.get(i);
      }
   }
/** gets the entire card pile
@return pile represents the entire card pile to be returned
*/
   public ArrayList<Card> getCardPile()
   {
      return pile;
   }
/** gets the amount of cards remaining in the pile
@return returns an integer representing the current size of the pile
*/
   public int cardsRemaining()
   {  
      return pile.size();
   }
/** checks if the pile is empty
@return true if the pile is empty, else false if it is not empty
*/
   public boolean isEmpty()
   {
      return (pile.size() == 0);
   }
/** deals a card from the top of the pile
@return c returns a Card representing the top card in the pile that was removed
@exception EmptyDeckException is thrown if attempt is made to remove from an empty deck
*/
   public Card dealCard() throws EmptyDeckException
   {
      if (pile.size()==0)
      {
         throw new EmptyDeckException("Deck is empty");
      }
      else
      {
      Card c = pile.remove(0);  //  remove it (returns removed object)
      return c;
      }
   }
/** shuffles the deck using random numbers
*/   
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < pile.size(); i++)
      {
         randNum = r.nextInt(pile.size());
         temp = pile.get(i);
         pile.set(i,pile.get(randNum));
         pile.set(randNum,temp);
      }      
   }
///////////////////////////////////////////////////////   
 //   public static void main(String[] args)
//    {
//       CardPile cards = new CardPile();
//       for (int r = Card.ACE; r<=Card.KING;r++)
//       {
//          for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
//          {
//            cards.addCard(new Card(r,s));
//          }
//       }
//       
//       System.out.println(cards.cardsRemaining());
//    }
///////////////////////////////////////////////////////   
}

