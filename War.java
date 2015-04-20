import java.util.Scanner;
import java.util.ArrayList;

public class War
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      CardDeck cardsDeck = new CardDeck();
      StackInterface playDeck = new StackReferenceBased();
      StackInterface player1Deck = new StackReferenceBased();
      StackInterface player2Deck = new StackReferenceBased();

      QueueInterface player1DeckWinnings = new QueueReferenceBased();
      QueueInterface player2DeckWinnings = new QueueReferenceBased();
      
 
 //     System.out.println("************\n\n\n******************");
/////////////shuffle section, might want to optimize/ stick in the class later/////////
      ArrayList<Card> shuffledDeck = cardsDeck.shuffle();
     // System.out.print(shuffledDeck);
      cardsDeck.removeAll();
            
      for (int i = 0; i<shuffledDeck.size(); i++)
      {
         cardsDeck.addCard(shuffledDeck.get(i));

      }
///////////////////////////////////////////////////   

    //  System.out.println("************\n\n\n******************");

      for (Card element:shuffledDeck)
          {
            playDeck.push(element);
          }  
          

     while (!playDeck.isEmpty())
     {
         //Card card1 = Card.class.cast(playDeck.peek());
         player1Deck.push(playDeck.pop());
         
         //
         //Card card2 = Card.class.cast(playDeck.peek());
         player2Deck.push(playDeck.pop());
         
     }
     
     
     

///////////////////////////////////////////////////////////////////     
//////////////GAME START!!!////////////////////////////////////////
///////////////////////////////////////////////////////////////////
      boolean endGame = false;
      
      while (endGame == false)
      {
         if (player1Deck.isEmpty() || player2Deck.isEmpty())
         {
            endGame = true;
         }
////////////////////////////////////////////////////////////////////         
         else
         {
            Card roundCard1 = Card.class.cast(player1Deck.peek());
            player1Deck.pop();
            Card roundCard2 = Card.class.cast(player2Deck.peek());
            player2Deck.pop();
            //////////////////
            System.out.println("Player 1: " + roundCard1);
            System.out.println("Player 2: " + roundCard2);
            //////////////////
            if (roundCard1.isGreater(roundCard2))
            {
               System.out.println("\nPlayer 1 Wins this round.");
               player1DeckWinnings.enqueue(roundCard1);
               player1DeckWinnings.enqueue(roundCard2);
            }
            ////
            else if (roundCard2.isGreater(roundCard1))
            {
               System.out.println("\nPlayer 2 Wins this round.");
               player2DeckWinnings.enqueue(roundCard1);
               player2DeckWinnings.enqueue(roundCard2);
            }
            ////
            else if (roundCard1.equals(roundCard2))
            {
               System.out.println("WAR!!!");
               ///pops a facedown card, the first card
               Card WarCardOne1 = Card.class.cast(player1Deck.peek());
               player1Deck.pop();
               Card WarCardOne2 = Card.class.cast(player2Deck.peek());
               player2Deck.pop();
               ///next card goes faceup
               Card WarCardTwo1 = Card.class.cast(player1Deck.peek());
               player1Deck.pop();
               Card WarCardTwo2 = Card.class.cast(player2Deck.peek());
               player2Deck.pop();
               System.out.println("Player 1: " + WarCardTwo1);
               System.out.println("Player 2: " + WarCardTwo2);               
               ///////ask if i can discard a stalemate war, because otherwise this could lead to a buildup of wars
               // and might require using unfamiliar concepts
               if (WarCardTwo1.isGreater(WarCardTwo2))
               {
                  System.out.println("\nPlayer 1 Wins this WAR!");
                  player1DeckWinnings.enqueue(WarCardOne1);
                  player1DeckWinnings.enqueue(WarCardOne2);
                  player1DeckWinnings.enqueue(WarCardTwo1);
                  player1DeckWinnings.enqueue(WarCardTwo2);
                  
                  player1DeckWinnings.enqueue(roundCard1);
                  player1DeckWinnings.enqueue(roundCard2);

               }
               else if (WarCardTwo2.isGreater(WarCardTwo1))
               {
                  System.out.println("\nPlayer 2 Wins this WAR!");
                  player2DeckWinnings.enqueue(WarCardOne1);
                  player2DeckWinnings.enqueue(WarCardOne2);
                  player2DeckWinnings.enqueue(WarCardTwo1);
                  player2DeckWinnings.enqueue(WarCardTwo2);
                 
                  player2DeckWinnings.enqueue(roundCard1);
                  player2DeckWinnings.enqueue(roundCard2);
               }
               else if (WarCardTwo1.equals(WarCardTwo2))
               {
                  System.out.println("\nYour two armies destroyed each other in an epic battle and nothing was left.");
                  System.out.println("Nobody wins this round.");   
                  System.out.println("War is bad.");               
               }
               
            }
            //////////////////
            System.out.print("Press Enter ");
            String input = keyboard.nextLine();
            // quits game early for test purposes
            if (input.equals("a"))
            {
               endGame = true;
            }

         }
         
//////////////////////////////////////////////////////////////////         
      }
      System.out.println("QUEUE/STACK/LIST DEBUGGING SECTION");
         while(!player1DeckWinnings.isEmpty())
         {
            System.out.println("Player 1 Winnings: " + player1DeckWinnings.dequeue());
         }
         
         while(!player2DeckWinnings.isEmpty())
         {
            System.out.println("Player 2 Winnings: " + player2DeckWinnings.dequeue());
         }
   }    
}






//           while (!playDeck.isEmpty())
//      {
//          Card card = Card.class.cast(playDeck.peek());
//          System.out.println(card);
//          playDeck.pop();
//      }
// 
//       System.out.println("PLAYER!");
//        while (!player1Deck.isEmpty())
//      {
//          Card card = Card.class.cast(player1Deck.peek());
//          System.out.println(card);
//          player1Deck.dequeue();
//      }
//       System.out.println("PLAYER@");
//  while (!player2Deck.isEmpty())
//      {
//          Card card = Card.class.cast(player2Deck.peek());
//          System.out.println(card);
//          player2Deck.pop();
//      }