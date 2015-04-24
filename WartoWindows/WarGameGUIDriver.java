import javax.swing.*;

public class WarGameGUIDriver
{
   public static void main(String [] args)
   {
      JFrame frame = new WarGameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
      // OR
      frame.setSize(1000,500);
      frame.validate();
      frame.setVisible(true);


   
   }


}