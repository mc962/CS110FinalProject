// Michael Chilton
// CS 110
/**Class that grabs file path for picture according to suit and rank passed from the 
WarGameGUI, and then facillitates appropriate image display*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardPanel extends JFrame
{
   // declares variables for suit, rank, appropriate strings and string constants
   private int suit;
   private int rank;
   private String suitString;
   private String rankString;
   private String pictureString;
   private final String FILETYPE = ".jpg";
   private final String PATH = "cardpics/";
   private String fileString;
   private String filePathString;
   
   private JPanel imagePanel;
   private JLabel imageLabel;
   private ImageIcon cardImage;
   
//    public CardPanel()
//    {
//       pictureString = "back";
//       fileString = pictureString.concat(FILETYPE);
//       filePathString = PATH.concat(fileString);
//    }
/**constructor that accepts integer arguments for suit and rank from the function that called it
@param s represents the integer suit value
@param r repreesents the integer rank value*/   
   public CardPanel(int s, int r)
   {
     // sets suit and rank equal to appropriate values
      suit = s;
      rank = r;
// determines which suit string to use, in relation to how it appears in the file,
// using the number pased for suit
      if (suit == 1)
      {
         suitString = "s";
      //spades
      }
      else if (suit == 2)
      {
         suitString = "h";
      //hearts
      }
      else if (suit == 3)
      {
         suitString = "c";
      //clubs
      }
      else if (suit == 4)
      {
         suitString = "d";
      //diamonds
      }
      /////////
// determines which rank string to use, in relation to how it appears in the file,
// using the number pased for rank      
      if (rank == 1)
      {
         rankString = "ace";
      }
      else if (rank == 2)
      {
         rankString = "2";
      }
      else if (rank == 3)
      {
         rankString = "3";
      }
      else if (rank == 4)
      {
         rankString = "4";
      }
      else if (rank == 5)
      {
         rankString = "5";
      }
      else if (rank == 6)
      {
         rankString = "6";
      }
      else if (rank == 7)
      {
         rankString = "7";
      }
      else if (rank == 8)
      {
         rankString = "8";
      }
      else if (rank == 9)
      {
         rankString = "9";
      }
      else if (rank == 10)
      {
         rankString = "10";
      }
      else if (rank == 11)
      {
         rankString = "jack";
      }
      else if (rank == 12)
      {
         rankString = "queen";
      }
      else if (rank == 13)
      {
         rankString = "king";
      }
// concatenates rank string to suit string, then concatenates that to constant string values
// representing filepath/type      
      pictureString = rankString.concat(suitString);
      fileString = pictureString.concat(FILETYPE);
      filePathString = PATH.concat(fileString);
      
      ////////////////GUI bit////////////////////
      //setTitle("Card Test");////hide later
      builImagePanel();
      //add(imagePanel);
      //pack();
     // setVisible(true);
   }
   public String getPath()
   {
      return filePathString;
   }
   
   public String toString()
   {
      String str = filePathString;
      return str;
   }
   ////////////////
   private void builImagePanel()
   {
      //imagePanel = new JPanel();
      cardImage = new ImageIcon(filePathString);
      imageLabel = new JLabel(cardImage, SwingConstants.CENTER);
      //imagePanel.add(imageLabel);
   }
   public ImageIcon getImage()
   {
      return cardImage;
      // ImageIcon faceDownCard = new ImageIcon("/home/michael/Desktop/Java/cardpics/back.jpg");
//       JLabel faceDown1 = new JLabel(faceDownCard, SwingConstants.CENTER);   
//       JLabel faceDown2 = new JLabel(faceDownCard, SwingConstants.CENTER);
   }
   ////////////////
   public static void main(String[] args)
   {
      CardPanel panel = new CardPanel(3,12);
      System.out.println(panel);
        new CardPanel(4,2);
   }
   ////////////////
}