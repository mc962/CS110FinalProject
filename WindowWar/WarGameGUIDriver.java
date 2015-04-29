// Michael Chilton
// CS 110

/** Driver for the GUI version of wargame, launches game to desired size
*/
import javax.swing.*;
public class WarGameGUIDriver
{
   public static void main(String [] args)
   {
   // makes new GUI object
      JFrame frame = new WarGameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
      // OR
      // sets size that it initializes at
      frame.setSize(700,1000);
      frame.validate();
      frame.setVisible(true);
   
   }


}