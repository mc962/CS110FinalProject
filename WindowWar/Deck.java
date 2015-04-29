// Michael Chilton
// CS 110
/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck, inherits from generic card pile
 *
 * @author Jackie Horton
 modified by Michael Chilton
 */

import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

public class Deck extends CardPile
{
// declares an Card array list deck
   private ArrayList<Card> deck;
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   private static final int CARDS_IN_DECK = 52;

   /** The collection of Cards */
  // private ArrayList<Card> deck;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {            
      freshDeck();
   }
/** accepts an integer argument and  creates a blank deck (used to distinguish from 
no-args constructor
*/   
   public Deck(int i)
   {
      deck = new ArrayList<Card>();
   }
/** Create a new collection of 52 cards, in sorted order
@exception IllegalArgumentException exits the program in the event that an IllegalArgument
happens, such as making a card that has a suit outside of the standard 4 
or rank outside of the standard 13
*/
   public void freshDeck()
   {
      try
      {
         deck = new ArrayList<Card>();
   
         for (int r = Card.ACE; r<=Card.KING;r++)
         {
            for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
            {           
              deck.add(new Card(s,r));
            }
         }      
// passes the newly made deck to cardpile to make the 
// new deck (didnt work properly otherwise)      
         setDeck(deck);
      }
      catch (IllegalArgumentException i)
      {
         JOptionPane.showMessageDialog(null,"Card rank/suit invalid. Contact game distributor to correct game's card data.\n\n"
                                             +"Click OK to exit.");
         System.exit(0);
      }   
   }

   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
///////////////////////////////////////////////
//    public static void main(String [] args) 
//    {
//       Deck deck = new Deck();
//       deck.shuffle();
//       System.out.println(deck.getCard(51));
//       System.out.println("test size: " + deck.cardsRemaining());
//       int count = 0;
//       
// //       
// //       
//        while(!deck.isEmpty())
//       {
//          count++;
//          System.out.println(count + ": " +  deck.dealCard());
//       }
//       
// //       // Deck1 deck = new Deck1();
// // //       deck.shuffle();
// // //       int i = 0;
// // //       while (!(deck.isEmpty()))
// // //          System.out.println(i++ + " : " + deck.dealCard().toString());
// // //       System.out.println(deck.cardsRemaining());
// // //       deck.freshDeck();
// // //       while (!(deck.isEmpty()))
// // //          System.out.println(i++ + " : " + deck.dealCard().toString());
// // //          
// // //       Card c1 = new Card(Card.ACE,Card.HEARTS);
// // //       Card c2 = new Card(Card.JACK,Card.SPADES);
// // //       Card c3 = new Card(4,Card.HEARTS);
// // //       
// // //       System.out.println(highCard(c1,c2,c3));
// // //       
// // // 
// // //    }
// // //    public static Card highCard(Card...cards)
// // //    {
// // //    
// // //       Card high = cards[0];
// // //       for (int i=1;i<cards.length;i++)
// // //       {
// // //          if (cards[i].getRank() > high.getRank())
// // //          {
// // //          
// // //             high = cards[i];
// // //          }
// // //       }
// // //       return high;
// //    
//     }
///////////////////////////////////////////////    
}
