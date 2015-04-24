// Michael Chilton
// CS 110

/**Class that simulates the game of war card game. Players each get half the deck,
and show each other a card. Whoever has the highest card (determined by rank), win both cards.
If the cards are equal then a war occurs, and the player that eventually wins the war
wins all the cards. **Only supports 2 players!!!*/

//import java.util.Scanner;
public class WarGameCore
{

// declares queues for player1  and player2 decks  
   private QueueInterface player1Deck;
   private QueueInterface player2Deck;
// creates an array deck, to be loaded into queues later
   private Deck deck;   
// loads the deck into a queue   
   private QueueInterface deckQueue;
// creates a queue to hold the winnings from all the war rounds (allows multiple rounds
// without losing cards from previous rounds)  
   private QueueInterface warQueue;
// declares cards for player1 and player2 normal round cards
   private Card roundCard1;
   private Card roundCard2;
   
// declares cards for the first card to be put down in the war for 1 and 2
   private Card warCardOne1;
   private Card warCardOne2;
// declares cards for the second, faceup card to be put down in the war for 1 and 2   
   private Card warCardTwo1;
   private Card warCardTwo2;
// declares cards for the winnings from the war rounds   
   private Card warCardWinningsOne1;
   private Card warCardWinningsOne2;
   
   private Card warCardWinningsTwo1;
   private Card warCardWinningsTwo2;
   
   int roundCount;
   int deckCount1;
   int deckCount2;


// declares boolean warsEnd where false means the game still goes on and true means 
//it should end
   private boolean warsEnd; 
   private boolean battleStatus;
/** no-args constructor that sets up the game, and gets the decks ready
*/    
   public WarGameCore()
   {
      // initializes warsEnd at false so that the game goes on
      warsEnd = false;
      
      battleStatus = false;
      // makes a new deck, and then shuffles it
      deck = new Deck();     
      deck.shuffle();
// makes new queues for the deck, player1's deck, and player 2's deck, as well as a queue
// for the war winnings      
      deckQueue = new QueueReferenceBased();
      player1Deck = new QueueReferenceBased();
      player2Deck = new QueueReferenceBased();
      warQueue = new QueueReferenceBased();
      
      
      roundCount = 0;
      deckCount1 = 0;
      deckCount2 = 0;

// queues deck into the deckQueue until deck is empty      
      while (!deck.isEmpty())
     {
         deckQueue.enqueue(deck.dealCard());
     }
// deals cards to player1 followed by player2 until the deckQueue is empty
     while (!deckQueue.isEmpty()) 
     {
         player1Deck.enqueue(deckQueue.dequeue());
         player2Deck.enqueue(deckQueue.dequeue());
     }      
   }
   
/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////  
/**sets warsEnd to true or false depending on if the game goes on
@param status represents the status of the game assigned to warsEnd
*/  
   public void setWarStatus(boolean status)
   {
      warsEnd = status;
   }
/**gets the value represented by warsEnd
@return warsEnd gets the value stored in warsEnd
*/   
   public boolean getWarStatus()
   {
      return warsEnd;
   }
   
   public void setBattleStatus(boolean status)
   {
      battleStatus = status;
   }
   public boolean getBattleStatus()
   {
      return battleStatus;
   }
//////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////   
/** retrives card stored in player1's round card
@return roundCard1 represents card stored in player1's round card
*/
   public Card getPlayer1RoundCard()
   {
      return roundCard1;
   }
/** retrives card stored in player2's round card
@return roundCard2 represents card stored in player2's round card
*/
   public Card getPlayer2RoundCard()
   {
      return roundCard2;
   }   
/** retrives card stored in player1's second, faceup war card
@return roundCard1 represents card stored in player1's second, faceup war card
*/
   public Card getPlayer1WarCardTwo()
   {
      return warCardTwo1;
   }
/** retrives card stored in player2's second, faceup war card
@return roundCard1 represents card stored in player2's second, faceup war card
*/
   public Card getPlayer2WarCardTwo()
   {
      return warCardTwo2;
   }
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////   
/** called when a win is detected (empty player decks)
displays appropriate strings as needed
*/
   public void win()
   {    
   // in the event that a win is triggered in the middle of a war round (as in, a player 
   // can only put down 1 out of the 2 required cards for war), then this segment will add the 
   // cards that are in warQueue (roundCards) to the deck that is not empty (which has to 
   // be possible because as one deck empties the other fills). This avoids lost cards at the 
   // end of the game
         ////////////////////////
      if (!player1Deck.isEmpty())
      {
         while(!warQueue.isEmpty())
         {                 
           player1Deck.enqueue(warQueue.dequeue());
         }
      }
      else if (!player2Deck.isEmpty())
      {
         while(!warQueue.isEmpty())
         {                 
           player2Deck.enqueue(warQueue.dequeue());
         }
      }
      ////////////////////////      
      //initializes default value of str to where nobody wins
      String str = ("Nobody wins");
      // sets str to say that player 2 wins if player1's deck is empty
      if (player1Deck.isEmpty())
      {
         str = ("Player 2 wins");
      }
      // sets str to say that player 1 wins if player1's deck is empty
      else if (player2Deck.isEmpty())
      {
         str = ("Player 1 wins");
      }
      //prints who won or lost
      System.out.println(str);
      
      System.out.println(roundCount);


      while(!player1Deck.isEmpty())
      {
         deckCount1++;
         player1Deck.dequeue();
      }
      while(!player2Deck.isEmpty())
      {
         deckCount2++;
         player2Deck.dequeue();
      }
      System.out.println("Player 1 Left: " + deckCount1);
      System.out.println("Player 2 Left: " + deckCount2);      
      ////////////////
      // calls setWarStatus and passes true to it, leading to warsEnd = true leading to game end
      setWarStatus(true);
   }
/**Represents a single round of the war game. Before any card is taken out of the deck,
it is checked to see if there is anything empty. Then it dequeues from each players deck
and plays a card. Whoever has a higher ranked card wins both cards, and if they are equal
then a war starts, and whoever wins the war wins all the cards
*/
   public void gameRound() 
   {
      setBattleStatus(false);
      roundCount++;
// checks if either deck is empty, and if at least one is then win is called
// otherwise it proceeds with the game      
      if (player1Deck.isEmpty() || player2Deck.isEmpty())
      {         
         win();
      }
      else
      {
// sets roundCards equal to the card deqeueued from the player deck (wouldnt compile without cast)
         roundCard1 = Card.class.cast(player1Deck.dequeue());            
         roundCard2 = Card.class.cast(player2Deck.dequeue());            
// if player1's card is greater then 1 wins and both cards are enqueued to 1         
         if (roundCard1.isGreater(roundCard2))
         {
            System.out.println("Player 1 Wins");
            player1Deck.enqueue(roundCard1);
            player1Deck.enqueue(roundCard2);
         }
// if player2's card is greater then 2 wins and both cards are enqueued to 2
         else if (roundCard2.isGreater(roundCard1))
         {
           System.out.println("Player 2 Wins");
            player2Deck.enqueue(roundCard1);
            player2Deck.enqueue(roundCard2);
         }
// if both cards are equal, then a war is initiated, and both roundCards are enqueued
// into the warQueue of deckWinnings      
         else if (roundCard1.equals(roundCard2))
         {
            System.out.println("WAR!!!");
            setBattleStatus(true);
            warQueue.enqueue(roundCard1);
            warQueue.enqueue(roundCard2);
// calls warRound, passing roundCard1 and 2 to it
            warRound(roundCard1, roundCard2);
         }
////////////////////////////////         
      }      
   }          
/** Represents a round of war, where each player deals 1 card, that is facedown (not printed)
and 1 card face up. Whoever wins gets all the cards in warQueue, unless they are equal again
in which case another war is called
*/
   public void warRound(Card roundCard1, Card roundCard2)
   {
// checks if either deck is empty, and if at least one is then win is called
// otherwise it proceeds with the war            
      if (player1Deck.isEmpty() || player2Deck.isEmpty())
      {
         setBattleStatus(false); // might want to take this out, see what happens
         win();         
      }

      else
      {
// sets winnings card equal to the card that is about dequeued
         warCardWinningsOne1 = Card.class.cast(player1Deck.peek());
// sets warcard one equal to the the top card in the queue         
         warCardOne1 = Card.class.cast(player1Deck.dequeue());
//////////////////////////////////////
// repeats same process for player 2
         warCardWinningsOne2 = Card.class.cast(player2Deck.peek());
         warCardOne2 = Card.class.cast(player2Deck.dequeue());    
      
// queues the warcard winnings into warQueue      
         warQueue.enqueue(warCardWinningsOne1);
         warQueue.enqueue(warCardWinningsOne2);           
               ///1st dequeue done
//////////////////////////
// checks if either deck is empty, and if at least one is then win is called
// otherwise it proceeds with the war      
         if (player1Deck.isEmpty() || player2Deck.isEmpty())
         {
            setBattleStatus(false); //// !!!!!
            win();
         }
////////////////////////////
         else
         {
         // sets winnings card equal to the card that is about dequeued
            warCardWinningsTwo1 = Card.class.cast(player1Deck.peek());
            // sets warcard two equal to the the top card in the queue    
            warCardTwo1 = Card.class.cast(player1Deck.dequeue());
   ////////////////////////////
   // repeats same process for player 2
            warCardWinningsTwo2 = Card.class.cast(player2Deck.peek());
            warCardTwo2 = Card.class.cast(player2Deck.dequeue());                                   
   ////////////////////////////                            
// queues the warcard winnings into warQueue               
            warQueue.enqueue(warCardWinningsTwo1);
            warQueue.enqueue(warCardWinningsTwo2);
// if warCardTwo for player 1 is greater than 2, then player 1 wins the war
// and the winnings are queued into player 1             
            if (warCardTwo1.isGreater(warCardTwo2))
            {          
                while(!warQueue.isEmpty())
                {  
                 System.out.println("Player 1 Wins the war");                
                  player1Deck.enqueue(warQueue.dequeue());
                 // setBattleStatus(false);
                } 
         
             }
// if warCardTwo for player 2 is greater than 1, then player 2 wins the war
// and the winnings are queued into player 2             
             else if (warCardTwo2.isGreater(warCardTwo1))
             {          
                while(!warQueue.isEmpty())
                {
                 System.out.println("Player 2 Wins the war");
                  player2Deck.enqueue(warQueue.dequeue());
                  //setBattleStatus(false);
                } 
             }
// if the 2 warCardTwo cards are equal, then warRound is called again, passing the 
// roundCards to it again, leading to wars within wars             
             else if (warCardTwo1.equals(warCardTwo2))
             {
              System.out.println("MULTIPLE WARS!!!");
               warRound(roundCard1, roundCard2);
             }
         }   
      }           
   }
///////////////////////////////////////////////////////
   public static void main(String[] args)
   {
    //  Scanner keyboard = new Scanner(System.in);
      WarGameCore warGame = new WarGameCore();
           
      while (!warGame.getWarStatus())
      {
      System.out.println(warGame.getPlayer1RoundCard());
      System.out.println(warGame.getPlayer2RoundCard());
      warGame.gameRound();
           
     // System.out.print("Enter");
//      String input = keyboard.nextLine(); 
      }    
   }      
/////////////////////////////////////////////////   
}