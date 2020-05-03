package bookClasses;

import javax.swing.*;
import java.awt.*;

/**
 * Class that demonstrates creating buttons with different
 * colors in a panel
 *
 * @author Barb Ericson
 */
public class ColorSquares extends JPanel {
   Color[] colorArray = {Color.red, Color.green, Color.blue, Color.black, Color.white, Color.yellow, Color.gray, Color.orange, Color.pink
           , Color.cyan, Color.magenta};

   /**
    * Constructor that takes no arguments
    */
   public ColorSquares() {
      init();
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Colors");
      frame.getContentPane().add(new ColorSquares());
      frame.pack();
      frame.setVisible(true);
   }

   /**
    * Method to initialize the panel
    */
   public void init() {
      JButton button = null;
      Color   color  = null;

      // loop through the colors in the color array
      for (int i = 0; i < colorArray.length; i++) {
         color = colorArray[i];
         button = new JButton(color.getRed() + ", " + color.getGreen() + ", " + color.getBlue());
         if (color.equals(Color.black)) {
            button.setForeground(Color.white);
         }
         button.setBackground(color);
         this.add(button);
      }
   }


}
