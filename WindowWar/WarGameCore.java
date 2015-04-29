// Michael Chilton
// CS 110

/**Class that simulates the game of war card game. Players each get half the deck,
and show each other a card. Whoever has the highest card (determined by rank), win both cards.
If the cards are equal then a war occurs, and the player that eventually wins the war
wins all the cards. **Only supports 2 players!!!*/

//import java.util.Scanner;
public class WarGameCore
{
// creates an array deck, to be loaded into player decks later
   private Deck deck;   
// declares Decks for player1  and player2 decks  
  private Deck player1Deck, player2Deck;
// creates a queue to hold the winnings from all the war rounds (allows multiple rounds
// without losing cards from previous rounds)  
   private QueueInterface warQueue; // originally I used queues, and just didnt have time to change
   // to arraylist like everything else, but game still works just fine
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
   
 //   int roundCount;
//    int deckCount1;
//    int deckCount2;
// declares int choice that will be used  to determine the win message to display who wins   
   private int choice;
// constants that are used to represent who wins   
   private static final int PLAYER_1_WINS = 1;
   private static final int PLAYER_2_WINS = 2;
   private static final int NO_WIN = 3;
// string that displays who wins
   private String winMessage;

// declares boolean warsEnd where false means the game still goes on and true means 
//it should end
   private boolean warsEnd; 
// declares boolean battleStatus where false means war is not happening and true means WAR!
   private boolean battleStatus;
// represents player scores   
   private int player1Score, player2Score;
/** no-args constructor that sets up the game, and gets the decks ready
*/    
   public WarGameCore()
   {
      // initializes warsEnd at false so that the game goes on
      warsEnd = false;
      winMessage = ""; 
      battleStatus = false;
      // makes a new deck, and then shuffles it
      deck = new Deck();     
      deck.shuffle();
// makes new Deck(s) for the deck, player1's deck, and player 2's deck, as well as a queue
// for the war winnings      
      player1Deck = new Deck(0);
      player2Deck = new Deck(0);
      warQueue = new QueueReferenceBased();
      
      
     //  roundCount = 0;
//       deckCount1 = 0;
//       deckCount2 = 0;


// deals cards to player1 followed by player2 until the deck has no cards remaining
        
     while (deck.cardsRemaining() != 0) // can test to make sure game ends properly by changing the loop
        // so that it deals less cards, allows one to actually play through whole game in
        // reasonable amount of time
     {
         player1Deck.addCard(deck.dealCard());
         player2Deck.addCard(deck.dealCard());
     }  
   }
   
/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////  
/**sets warsEnd to true or false depending on if the game goes on
@param wStatus represents the status of the game assigned to warsEnd
*/  
   public void setWarStatus(boolean wStatus)
   {
      warsEnd = wStatus;
   }
/**gets the value represented by warsEnd
@return warsEnd gets the value stored in warsEnd
*/   
   public boolean getWarStatus()
   {
      return warsEnd;
   }
/**sets battleStatus to true or false depending on if the game goes on
@param bStatus represents the status of the game assigned to battleStatus
*/     
   public void setBattleStatus(boolean bStatus)
   {
      battleStatus = bStatus;
   }
/**gets the value represented by battleStatus
@return battleStatus gets the value stored in battleStatus
*/   
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
/** gets the score for player 1 represented by the number of cards left in the deck
@return player1Deck.cardsRemaining() represents the number of cards left in player 1 deck
*/
   public int getPlayer1Score()
   {
      return player1Deck.cardsRemaining();
   }
/** gets the score for player 2 represented by the number of cards left in the deck
@return player2Deck.cardsRemaining() represents the number of cards left in player 2 deck
*/   
   public int getPlayer2Score()
   {
      return player2Deck.cardsRemaining();
   }
/**sets the winMessage to a particular message depending on the int passe to it
@param choice represents the integer for who did/did not passed from win()
*/   
   public void setWinMessage(int choice)
   {
      if (choice == PLAYER_1_WINS)
      {
         winMessage = "Player 1 Wins!";
      }
      else if (choice == PLAYER_2_WINS)
      {
         winMessage = "Player 2 Wins!";
      }
      else
      {
         winMessage = "Nobody wins...";
      }
   }
/**gets the the message for who won
@return winMessage returns the message stored in winMessage
*/   
   public String getWinMessage()
   {
      return winMessage;
   }
///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////   
/** called when a win is detected (empty player decks), or when end button is pressed in GUI
displays appropriate strings as needed
*/
   public void win()
   {    
// decision structure that first decides if both players still have cards (GUI prematurely terminated game)
// or if 1 deck is out of cards (game went to completion)
      if (player1Deck.cardsRemaining()!=0 && player2Deck.cardsRemaining()!=0)
      {
      // sets the winMessage to the appropriate message depending on who had more cards
         if (player1Deck.cardsRemaining() > player2Deck.cardsRemaining())
         {         
            setWinMessage(PLAYER_1_WINS);
         } 
         else if (player2Deck.cardsRemaining()> player1Deck.cardsRemaining())
         {         
            setWinMessage(PLAYER_2_WINS);
         }
         else if (player1Deck.cardsRemaining() == player2Deck.cardsRemaining())
         {
            setWinMessage(NO_WIN);
         }        
      }
      else
      {
   // in the event that a win is triggered in the middle of a war round (as in, a player 
   // can only put down 1 out of the 2 required cards for war), then this segment will add the 
   // cards that are in warQueue (roundCards) to the deck that is not empty (which has to 
   // be possible because as one deck empties the other fills). This avoids lost cards at the 
   // end of the game      
         if (player1Deck.cardsRemaining()!=0)
         {
            while(!warQueue.isEmpty())
            {                 
              player1Deck.addCard(Card.class.cast(warQueue.dequeue()));
            }
         }
         else if (player2Deck.cardsRemaining()!=0)
         {
            while(!warQueue.isEmpty())
            {                 
              player2Deck.addCard(Card.class.cast(warQueue.dequeue()));
            }
         }
         ////////////////////////      
         //initializes default value of str to where nobody wins
        // String str = ("Nobody wins");

         // sets str to say that player 2 wins if player1's deck is empty
         if (player1Deck.cardsRemaining() == 0)
         {
          //  str = ("Player 2 wins");
            setWinMessage(2);
         }
         // sets str to say that player 1 wins if player1's deck is empty
         else if (player2Deck.cardsRemaining()==0)
         {
      //      str = ("Player 1 wins");
            setWinMessage(1);
         }
         //prints who won or lost
       //  System.out.println(str);         
       //  System.out.println(roundCount);         
        //    deckCount1 = player1Deck.cardsRemaining();
        //    deckCount2 = player2Deck.cardsRemaining();
         
       //  System.out.println("Player 1 Left: " + deckCount1);
        // System.out.println("Player 2 Left: " + deckCount2);      
      }
      player1Score = player1Deck.cardsRemaining();
      player2Score = player2Deck.cardsRemaining();   
      ////////////////
      // calls setWarStatus and passes true to it, leading to warsEnd = true leading to game's end
      setWarStatus(true);
   }
/**Represents a single round of the war game. Before any card is taken out of the deck,
it is checked to see if there is anything empty. Then it dequeues from each players deck
and plays a card. Whoever has a higher ranked card wins both cards, and if they are equal
then a war starts, and whoever wins the war wins all the cards
*/
   public void gameRound() 
   {
   // starts off by setting battleStatus to false, meaning that a war is not initially happening by default
      setBattleStatus(false);
//      roundCount++;
// checks if either deck is empty, and if at least one is then win is called
// otherwise it proceeds with the game      
      if (player1Deck.cardsRemaining()==0 || player2Deck.cardsRemaining()==0)
      {         
         win();
      }
      else
      {
// sets roundCards equal to the card taken from the player deck
         roundCard1 = player1Deck.dealCard();            
         roundCard2 = player2Deck.dealCard();            
// if player1's card is greater then 1 wins and both cards are added to 1         
         if (roundCard1.isGreater(roundCard2))
         {
         //   System.out.println("Player 1 Wins");
            player1Deck.addCard(roundCard1);
            player1Deck.addCard(roundCard2);
         }
// if player2's card is greater then 2 wins and both cards are added to 2
         else if (roundCard2.isGreater(roundCard1))
         {
      //     System.out.println("Player 2 Wins");
            player2Deck.addCard(roundCard1);
            player2Deck.addCard(roundCard2);
         }
// if both cards are equal, then a war is initiated, and both roundCards are enqueued
// into the warQueue of deckWinnings      
         else if (roundCard1.equals(roundCard2))
         {
//            System.out.println("WAR!!!");
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
// checks if either deck is empty, and if at least one is then win is called and war is ended
// otherwise it proceeds with the war            
      if (player1Deck.cardsRemaining()==0 || player2Deck.cardsRemaining()==0)
      {

         setBattleStatus(false); 
         win();         
      }

      else
      {

// sets warcard one equal to the the top card in the deck         
         warCardOne1 = player1Deck.dealCard();
// sets winnings card equal to the card that was taken from the deck top
         warCardWinningsOne1 = warCardOne1;   
// queues the warcard winnings into warQueue               
         warQueue.enqueue(warCardWinningsOne1);
//////////////////////////////////////
// repeats same process for player 2

         warCardOne2 = player2Deck.dealCard();    
         warCardWinningsOne2 = warCardOne2;               
// queues the warcard winnings into warQueue      
         warQueue.enqueue(warCardWinningsOne2);           
//////////////////////////
// checks if either deck is empty, and if at least one is then win is called and war is ended
// otherwise it proceeds with the war      
         if (player1Deck.cardsRemaining()==0 || player2Deck.cardsRemaining()==0)
         {
            setBattleStatus(false); 
            win();
         }
////////////////////////////
         else
         {
            // sets warcard two equal to the the top card in the deck    
            warCardTwo1 = player1Deck.dealCard();
         // sets winnings card equal to the card that was taken from deck top
            warCardWinningsTwo1 = warCardTwo1;            
   ////////////////////////////
   // repeats same process for player 2
            warCardTwo2 = player2Deck.dealCard();                                   
            warCardWinningsTwo2 = warCardTwo2;            
   ////////////////////////////                            
// queues the warcard winnings into warQueue               
            warQueue.enqueue(warCardWinningsTwo1);
            warQueue.enqueue(warCardWinningsTwo2);
// if warCardTwo for player 1 is greater than 2, then player 1 wins the war
// and the winnings are added into player 1             
            if (warCardTwo1.isGreater(warCardTwo2))
            {          
                while(!warQueue.isEmpty())
                {  
                // System.out.println("Player 1 Wins the war");                
                  player1Deck.addCard(Card.class.cast(warQueue.dequeue()));
                 // setBattleStatus(false);
                }          
             }
// if warCardTwo for player 2 is greater than 1, then player 2 wins the war
// and the winnings are added into player 2             
             else if (warCardTwo2.isGreater(warCardTwo1))
             {          
                while(!warQueue.isEmpty())
                {
                // System.out.println("Player 2 Wins the war");
                  player2Deck.addCard(Card.class.cast(warQueue.dequeue()));
                  //setBattleStatus(false);
                } 
             }
// if the 2 warCardTwo cards are equal, then warRound is called again, passing the 
// roundCards to it again, leading to wars within wars             
             else if (warCardTwo1.equals(warCardTwo2))
             {
            //  System.out.println("MULTIPLE WARS!!!");
               warRound(roundCard1, roundCard2);
             }
         }   
      }           
   }
///////////////////////////////////////////////////////
  //  public static void main(String[] args)
//    {
// //      Scanner keyboard = new Scanner(System.in);
//       WarGameCore warGame = new WarGameCore();
// 
//       while (!warGame.getWarStatus())
//       {
//       System.out.println(warGame.getPlayer1RoundCard());
//       System.out.println(warGame.getPlayer2RoundCard());
//       warGame.gameRound();
// //            
// // //      // System.out.print("Enter");
// // // //      String input = keyboard.nextLine(); 
//       System.out.println(warGame.getWinMessage());
//       }    
//    }      
/////////////////////////////////////////////////   
}