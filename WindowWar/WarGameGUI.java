// Michael Chilton
// CS 110
/** GUI for WarGameCore, providing all necessary panels and buttons to display and play a game of war
2 player game, able to shpw status of the game, as well as player scores at the end
players are able to show normal round cards as well as their war round cards
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WarGameGUI extends JFrame
{
// declares JLabels for title status and winner
   private JLabel title, status, winner;     
// declares JLabels for the facedown cards at different spots   
   private JLabel faceDown1, faceDown2;
// declares JButtons for exit, continue, end, and reset buttons   
   private JButton exitButton, continueButton, endButton, resetButton;
// declares panels to break up regions   
   private JPanel titlePanel, player1Panel, player2Panel, exitPanel, statusPanel;  
// declares a war game object   
   private WarGameCore warGame;
// declares ImageIcons for player 1 and player 2   
   private ImageIcon player1Icon;
   private ImageIcon player2Icon;
// declares Cards for normal rounds for player 1 and 2   
   private Card roundCard1;
   private Card roundCard2;
// declares Cards for war rounds for player 1 and 2   
   private Card warCardTwo1;
   private Card warCardTwo2;
// declares CardPanel objects for round 1 and 2, war round 1 and 2   
   private CardPanel round1, round2, war1, war2;
// declares JLabels for round Card images for player 1 and 2  
   private JLabel roundImage1, roundImage2;
// declares JLabels for war round Card images for player 1 and 2   
   private JLabel warImage1, warImage2;
// declares JLabels for labeling player 1 and 2 panels   
   private JLabel player1, player2;
// declares JLables for displaying player 1 and 2 scores   
   private JLabel player1Score, player2Score;
// declares ImageIcon that will represent a facedown card   
   private ImageIcon faceDownCard;
// declares new JLabel to label war window
   private JLabel warLabel;   
// declares blank JLabel to be used as a spacer
   private JLabel spacerLabel;   
   
   
/** constructor that sets up the GUI container for warGame
*/   
   public WarGameGUI() 
   {
   // creates new instance of the coer war game
      warGame = new WarGameCore();
// sets container title      
      setTitle("The Game of War");
// sets default close operation      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// sets overall layour to BorderLayout      
      setLayout(new BorderLayout());
      
   // initializes faceDownCard to new ImageIcon at given string
      faceDownCard = new ImageIcon("cardpics/back.jpg");

   // intializes spacerLabel to blank string
      spacerLabel = new JLabel("");
      
      
////////////////////////////////////////////////////////////////////////////////////

// creates new title panel and adds a GridLayout layout manager to it      
      titlePanel = new JPanel();
      titlePanel.setLayout(new GridLayout(6,1));
// creates new JLabel with game title set to Helvetica font and placed in the center      
      title = new JLabel("Michael's War Game");
      title.setForeground(Color.WHITE);
      title.setFont(new Font("HELVETICA",Font.ITALIC,25));
      title.setHorizontalAlignment(JLabel.CENTER);
// initilaizes game status to new blank string JLabel with Arial font at center
      status = new JLabel("");
      status.setFont(new Font("ARIAL",Font.BOLD,15));
      status.setHorizontalAlignment(JLabel.CENTER);
// initilaizes winner to new blank string JLabel with Arial font at center    
      winner = new JLabel("");
      winner.setFont(new Font("ARIAL",Font.BOLD,15));
      winner.setHorizontalAlignment(JLabel.CENTER);
// creates new JButton with initial text of Start and adds an action listener to it      
      continueButton = new JButton("Start");
      continueButton.addActionListener(new ContinueButtonListener());            
// sets warLabel to new JLabel to label panel and sizes/positions it
      warLabel = new JLabel("Battlefield");
      warLabel.setForeground(Color.GREEN);
      warLabel.setFont(new Font("ARIAL",Font.BOLD,20));
      warLabel.setHorizontalAlignment(JLabel.CENTER);     
////////////////////////////////////////////////////////////////////////////////////

// creates new JPanel to hold player 1 information      
      player1Panel = new JPanel();     
// gives it a GridLayout manager      
      player1Panel.setLayout(new GridLayout(3,1));
// creates new JLabel in Arial font positioned in the center to label Player 1      
      player1 = new JLabel("Player 1");
      player1.setFont(new Font("ARIAL",Font.BOLD,20));
      player1.setHorizontalAlignment(JLabel.CENTER);
// creates new JLabel in Arial font positioned in the center to show player score, and initializes to blank string
      player1Score = new JLabel("");
      player1Score.setFont(new Font("ARIAL",Font.BOLD,15));
      player1Score.setHorizontalAlignment(JLabel.CENTER);

// intializes card image for player 1 round card to faceDownCard, at CENTER      
      roundImage1 = new JLabel(faceDownCard, SwingConstants.CENTER);  
      
      
////////////////////////////////////////////////////////////////////////////////////

// creates new JPanel to hold player 2 information       
      player2Panel = new JPanel();
// gives it a GridLayout manager           
      player2Panel.setLayout(new GridLayout(3,1)); 
// creates new JLabel in Arial font positioned in the center to label Player 2      
      player2 = new JLabel("Player 2");
      player2.setFont(new Font("ARIAL",Font.BOLD,20));
      player2.setHorizontalAlignment(JLabel.CENTER);
// creates new JLabel in Arial font positioned in the center to show player score, and initializes to blank string
      player2Score = new JLabel("");
      player2Score.setFont(new Font("ARIAL",Font.BOLD,15));
      player2Score.setHorizontalAlignment(JLabel.CENTER);
// intializes card image for player 2 round card to faceDownCard, at CENTER     
      roundImage2 = new JLabel(faceDownCard, SwingConstants.CENTER); 

////////////////////////////////////////////////////////////////////////////////////

// creates new statuspanel to hold war images      
      statusPanel = new JPanel();            
// intializes card image for player 1 and 2 war cards to faceDownCard, at CENTER                 
      warImage1 = new JLabel(faceDownCard, SwingConstants.CENTER); 
      warImage2 = new JLabel(faceDownCard, SwingConstants.CENTER);

////////////////////////////////////////////////////////////////////////////////////

// creates new exitPanel to hold exit, reset, and end buttons 
      exitPanel = new JPanel();
      exitButton = new JButton("Exit");     
// gives exitButton action listener
      exitButton.addActionListener(new ExitButtonListener());    
// creates new button for end to end the game early and gives it an action listener
      endButton = new JButton("End");
      endButton.addActionListener(new EndButtonListener());
// creates new button for reset to reset everything to default values and 
// gives it an action listener
      resetButton = new JButton("Reset");
      resetButton.addActionListener(new RestartGameListener());
// deactivates button until needed      
      resetButton.setEnabled(false);
     
     
     
 ////////////////////////////////////////////////////////////////////////////////////    
// adds constituents to titlePanel      
      titlePanel.add(title);    
      titlePanel.add(status);     
      titlePanel.add(winner); 
      titlePanel.add(continueButton);
      titlePanel.add(spacerLabel);
      titlePanel.add(warLabel);
// adds constituents to statusPanel      
      statusPanel.add(warImage1);      
      statusPanel.add(warImage2);
     
// adds constituents to player1Panel   
      player1Panel.add(player1);
      player1Panel.add(roundImage1);
      player1Panel.add(player1Score);      
      

// adds constituents to player2Panel      
      player2Panel.add(player2);
      player2Panel.add(roundImage2);
      player2Panel.add(player2Score);

// adds constituents to exitPanel      
      exitPanel.add(exitButton);       
      exitPanel.add(endButton);
      exitPanel.add(resetButton);      

// adds panels into appropriate spots, then packs and sets visible everything      
      add(titlePanel, BorderLayout.NORTH);
      add(exitPanel, BorderLayout.SOUTH);
      add(player1Panel, BorderLayout.WEST);
      add(player2Panel, BorderLayout.EAST);
      add(statusPanel, BorderLayout.CENTER);
// color aesthetics sets background color of panels      
      titlePanel.setBackground(Color.RED);
      exitPanel.setBackground(Color.RED);
      player1Panel.setBackground(Color.GREEN);
      player2Panel.setBackground(Color.GREEN);
      statusPanel.setBackground(Color.GREEN);
      
      pack();
      setVisible(true);

//////////////////////////////////////////////
       /////////////////////////////////////////////////////////////////////////      
   }
/**implements the action listener for continuebutton
*/
   private class ContinueButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent c)
      {     
         if (warGame.getWarStatus())
         {
               // calls the win method, prematurely ending the game      
            warGame.win();
   // sets warStatus to true, making sure that the game is really ending         
            warGame.setWarStatus(true);
   // disables continueButton, as it is no longer needed         
            continueButton.setEnabled(false);
   // changes status text to reflect state of the game         
            status.setText("Game Over");           
   // changes winner text to appropriate text depending on who did/did not win         
            winner.setText(warGame.getWinMessage());
   // displays player scores         
            player1Score.setText("Score: " + warGame.getPlayer1Score());
            player2Score.setText("Score: " + warGame.getPlayer2Score());
   // disables endButton, as it is no longer needed         
            endButton.setEnabled(false);
   // enables resetbutton as it will be needed to restart game         
            resetButton.setEnabled(true);          
         }
         else
         {
   // sets status text to a Game in Progress
            status.setText("Game in Progress");
   // changes contninue button text to Continue         
            continueButton.setText("Continue");
   // sets war cards to faceDown image if they are not already so         
            warImage1.setIcon(faceDownCard);
            warImage2.setIcon(faceDownCard);
            
   // does a round of warGame
            warGame.gameRound();
            
   
   
   // gets normal round cards that will need to be displayed
            roundCard1 = warGame.getPlayer1RoundCard();
            roundCard2 = warGame.getPlayer2RoundCard();       
   // picture display stuff for normal round cards for player 1 and 2
            round1 = new CardPanel(roundCard1.getSuit(), roundCard1.getRank());         
            round2 = new CardPanel(roundCard2.getSuit(), roundCard2.getRank()); 
            roundImage1.setIcon(round1.getImage());
            roundImage2.setIcon(round2.getImage());
   // checks if battleStatus is true, if it is then actions needed for war are carried out, else it doesnt do it         
            if (warGame.getBattleStatus())
            {
   // grabs cards for the second, face up war card for player 1 and 2
               warCardTwo1 = warGame.getPlayer1WarCardTwo();
               warCardTwo2 = warGame.getPlayer2WarCardTwo();
   // makes a new CardPanel object for player 1 and 2 war cards, and sets the image on those cards to what
   // was retrieved using CardPanel       
               war1 = new CardPanel(warCardTwo1.getSuit(), warCardTwo1.getRank());
               war2 = new CardPanel(warCardTwo2.getSuit(), warCardTwo2.getRank());
               
               warImage1.setIcon(war1.getImage());
               warImage2.setIcon(war2.getImage());                        
            }
            
        }   
      }
   }
/**implements action listener for exit button
*/   
   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
// exits the program
         System.exit(0);
      }
   }
/**implements action listener for end button, prematurely stopping the game
*/   
   private class EndButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent r)
      {
// calls the win method, prematurely ending the game      
         warGame.win();
// sets warStatus to true, making sure that the game is really ending         
         warGame.setWarStatus(true);
// disables continueButton, as it is no longer needed         
         continueButton.setEnabled(false);
// changes status text to reflect state of the game         
         status.setText("Game Over");           
// changes winner text to appropriate text depending on who did/did not win         
         winner.setText(warGame.getWinMessage());
// displays player scores         
         player1Score.setText("Score: " + warGame.getPlayer1Score());
         player2Score.setText("Score: " + warGame.getPlayer2Score());
// disables endButton, as it is no longer needed         
         endButton.setEnabled(false);
// enables resetbutton as it will be needed to restart game         
         resetButton.setEnabled(true);
          
      }
   }
/**implements action listener for restart button
*/   
   private class RestartGameListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ng)
      {
// calls reset method
         reset();
      }
   }
/** method that resets all buttons, texts, and pictures to default values, and makes new instance of warGame
*/   
   private void reset()
   {
            
      continueButton.setText("Start");
     ////////////////////  ///////////
      continueButton.setEnabled(true);
      resetButton.setEnabled(false);
      endButton.setEnabled(true);
      status.setText("");
      winner.setText("");
      player1Score.setText("");
      player2Score.setText("");
      
      roundImage1.setIcon(faceDownCard);
      warImage1.setIcon(faceDownCard);
      roundImage2.setIcon(faceDownCard);
      warImage2.setIcon(faceDownCard);
      
      warGame = new WarGameCore();
   }
///////////////////////////////////////////////////////   
//    public static void main(String[] args)
//    {
//       new WarGameGUI();
//    }
///////////////////////////////////////////////////////
}