// Michael Chilton
// CS 110
/**Class that grabs file path for picture according to suit and rank passed from the 
WarGameGUI, and then facillitates appropriate image display*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

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
   
 //  private JPanel imagePanel;
   private JLabel imageLabel;
   private ImageIcon cardImage;
   private File imageFile;
   
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
       imageFile = new File(filePathString);
// exception handling in the event of no files being found
// theoretically the game could continue, but I chose to end the game in this case, as there is 
// quite a lot of data missing, so i just told them to contact who gave them the game for the files
      try
      {
// calls buildImagePanel to make what was necessary     
         buildImagePanel();       
      }
      catch (FileNotFoundException f)
      {      
         JOptionPane.showMessageDialog(null,"Card image not found. Contact game distributor for proper game files.\n\n"
                                             +"Click OK to exit.");
         System.exit(0);
      }
   }
/**returns the value stored in filePathString
@return filePathString returns the string associated with the particular path of the picture file
*/   
   public String getPath()
   {
      return filePathString;
   }
/**toString method to print what is stored
@return str represents the value stored in str (filePathString
*/   
   public String toString()
   {
      String str = filePathString;
      return str;
   }
   ////////////////
/**private method to build the image information
@exception FileNotFoundException can throw this exception in the event that the picture file was not found
*/   
   private void buildImagePanel() throws FileNotFoundException
   {
// if the imageFile was found to not exist, then a FileNotFoundException is thrown
      if(!imageFile.exists())
      {
         throw new FileNotFoundException("Picture not found");
      }
// otherwise program proceeds normally
      else
      {
         cardImage = new ImageIcon(filePathString);
         imageLabel = new JLabel(cardImage, SwingConstants.CENTER);        
      }   
   }
/** gets the image stored in cardImage
@return cardImage represents the ImageIcon image grabbed with the filePathString
*/   
   public ImageIcon getImage()
   {
      return cardImage;
   }
   ////////////////
//    public static void main(String[] args)
//    {
//       CardPanel panel = new CardPanel(3,12);
//       System.out.println(panel);
//         new CardPanel(4,2);
// 
//    }
   ////////////////
}