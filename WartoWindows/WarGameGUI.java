import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGameGUI extends JFrame
{

   private JLabel status;  
   private JLabel title;   
   private JLabel faceDown1, faceDown2;
   private JButton exitButton, continueButton;
   private JPanel titlePanel, player1Panel, player2Panel, exitPanel, statusPanel;  // break up regions
   
   private WarGameCore warGame;
   
   private ImageIcon player1Icon;
   private ImageIcon player2Icon;
   
   private Card roundCard1;
   private Card roundCard2;
   
   private Card warCardTwo1;
   private Card warCardTwo2;
   
   private CardPanel round1, round2, war1, war2;
  
   private JLabel roundImage1, roundImage2;
   private JLabel warImage1, warImage2;
   private ImageIcon faceDownCard;
   public WarGameGUI()
   {
      warGame = new WarGameCore();
      setTitle("The Game of War");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setLayout(new BorderLayout());
     
      titlePanel = new JPanel();
      title = new JLabel("Michael's War Game");
      title.setFont(new Font("HELVETICA",Font.ITALIC,24));
      titlePanel.add(title);
      
      player1Panel = new JPanel();      
      player2Panel = new JPanel();
      
      exitPanel = new JPanel();
      exitButton = new JButton("Exit");
     
      
      exitPanel.add(exitButton); 
      exitButton.addActionListener(new ExitButtonListener());     
      statusPanel = new JPanel();
      
      
   
      faceDownCard = new ImageIcon("cardpics/back.jpg");
      roundImage1 = new JLabel(faceDownCard, SwingConstants.CENTER);  
      warImage1 = new JLabel(faceDownCard, SwingConstants.CENTER); 
      roundImage2 = new JLabel(faceDownCard, SwingConstants.CENTER);
      warImage2 = new JLabel(faceDownCard, SwingConstants.CENTER);
      
   

      player1Panel.add(roundImage1);
      statusPanel.add(warImage1);
      player2Panel.add(roundImage2);
      statusPanel.add(warImage2);
     
      status = new JLabel("Game in progress");
      status.setFont(new Font("ARIAL",Font.BOLD,20));

      
      continueButton = new JButton("Continue");
      continueButton.addActionListener(new ContinueButtonListener());
      titlePanel.add(continueButton);
       


      add(titlePanel, BorderLayout.NORTH);
      add(exitPanel, BorderLayout.SOUTH);
      add(player1Panel, BorderLayout.WEST);
      add(player2Panel, BorderLayout.EAST);
      add(statusPanel, BorderLayout.CENTER);
      
      pack();
      setVisible(true);

//////////////////////////////////////////////
       /////////////////////////////////////////////////////////////////////////      
   }
   private class ContinueButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent c)
      {     
         warImage1.setIcon(faceDownCard);
         warImage2.setIcon(faceDownCard);
         // does a round of warGame
         warGame.gameRound();
         // gets cards that will need to be displayed
         roundCard1 = warGame.getPlayer1RoundCard();
         roundCard2 = warGame.getPlayer2RoundCard();
   
         
         // picture display stuff for normal round cardsd for player 1 and 2
         round1 = new CardPanel(roundCard1.getSuit(), roundCard1.getRank());         
         round2 = new CardPanel(roundCard2.getSuit(), roundCard2.getRank()); 
         roundImage1.setIcon(round1.getImage());
         roundImage2.setIcon(round2.getImage());
         
         if (warGame.getBattleStatus())
         {
            warCardTwo1 = warGame.getPlayer1WarCardTwo();
            warCardTwo2 = warGame.getPlayer2WarCardTwo();
            
            war1 = new CardPanel(warCardTwo1.getSuit(), warCardTwo1.getRank());
            war2 = new CardPanel(warCardTwo2.getSuit(), warCardTwo2.getRank());
            
            warImage1.setIcon(war1.getImage());
            warImage2.setIcon(war2.getImage());                        
         }
         
        
      }
   }
   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}