package bookClasses;

import javax.swing.*;
import java.awt.*;


/**
 * Class to display a comic strip.  A comic strip has
 * 4 comic panels.  Each comic panel has a picture and
 * one or more text balloons.  A comic strip has a name
 * and an author.
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class ComicStrip extends JPanel {
   ////////////////// fields ///////////////////////
   private final String author;
   private final String name;
   private       ComicPanel[] panelArray = null;
   private int          width;

   /////////////// constructors //////////////////////

   /**
    * Constructor that takes the name, author, and
    * an array of panels
    *
    * @param theName       the name of the strip
    * @param theAuthor     the author's name
    * @param thePanelArray an array of panels
    */
   public ComicStrip(String theName, String theAuthor, ComicPanel[] thePanelArray) {
      this.name = theName;
      this.author = theAuthor;
      this.panelArray = thePanelArray;
      init();
   }

   //////////////////// methods ////////////////////////

   public static void main(String[] args) {
      JFrame       frame      = new JFrame("Comic Strip");
      ComicPanel[] panelArray = new ComicPanel[4];
      Picture      p1         = new Picture("C:\\intro-prog-java\\Alice\\ComicStrip\\panel1.jpg");
      //p1.grayscaleWithLuminance();
      Picture p2 = new Picture("C:\\intro-prog-java\\Alice\\ComicStrip\\panel2.jpg");
      //p2.grayscaleWithLuminance();
      Picture p3 = new Picture("C:\\intro-prog-java\\Alice\\ComicStrip\\panel3.jpg");
      //p3.grayscaleWithLuminance();
      Picture p4 = new Picture("C:\\intro-prog-java\\Alice\\ComicStrip\\panel4.jpg");
      //p4.grayscaleWithLuminance();
      panelArray[0] = new ComicPanel(p1);
      panelArray[1] = new ComicPanel(p2);
      panelArray[2] = new ComicPanel(p3);
      panelArray[3] = new ComicPanel(p4);
      SpeechBalloon b0 = new SpeechBalloon(new Point(20, 10), 100, new Point(97, 54), "Hey Baby!");
      panelArray[0].add(b0);
      SpeechBalloon b1 = new SpeechBalloon(new Point(102, 7), 100, new Point(164, 48), "Yikes!");
      panelArray[1].add(b1);
      SpeechBalloon b3 = new SpeechBalloon(new Point(23, 3), 150, new Point(108, 75), "I was just too hot for her!");
      panelArray[3].add(b3);
      ComicStrip strip = new ComicStrip("Snowman Love", "Barb Ericson", panelArray);
      frame.getContentPane().add(strip);
      frame.pack();
      frame.setVisible(true);
   }

   /**
    * Set up the graphics to display the comic
    * strip
    */
   private void init() {
      this.setLayout(new BorderLayout());
      JPanel topPanel = new JPanel();
      topPanel.setLayout(new BorderLayout());
      JLabel nameLabel = new JLabel(name);
      topPanel.add(nameLabel, BorderLayout.WEST);
      JLabel authorLabel = new JLabel(author);
      topPanel.add(authorLabel, BorderLayout.EAST);
      this.add(topPanel, BorderLayout.NORTH);
      JPanel stripPanel = new JPanel();
      stripPanel.setLayout(new BoxLayout(stripPanel, BoxLayout.X_AXIS));
      ComicPanel comicPanel   = null;
      JLabel     panelLabel   = null;
      Picture    finalPicture = null;
      for (int i = 0; i < panelArray.length; i++) {
         stripPanel.add(panelArray[i]);
         if (i < panelArray.length - 1) {
            stripPanel.add(Box.createRigidArea(new Dimension(3, 0)));
         }
      }
      this.add(stripPanel, BorderLayout.CENTER);
   }

}
