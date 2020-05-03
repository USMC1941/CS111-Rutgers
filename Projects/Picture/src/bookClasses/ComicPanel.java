package bookClasses;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to create a comic panel.  A comic panel
 * will have a picture and can have one or more
 * text balloons.  It uses a JLabel to show the
 * picture.
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 * Copyright 2005
 */
public class ComicPanel extends JPanel {
   ////////////// fields //////////////////

   /**
    * the picture for the comic panel
    */
   private Picture picture = null;

   /**
    * the list of text balloons
    */
   private final List<TextBalloon> textBalloonList = new ArrayList<TextBalloon>();
   // comment above and uncomment below for 1.4
   //private List textBalloonList =
   //  new ArrayList();

   /**
    * the label used to display the picture
    */
   private final JLabel pictureLabel = new JLabel();

   /**
    * flag if line border for this panel
    */
   private final boolean lineBorder = true;

   //////////////// constructors ////////////

   /**
    * Constructor that takes just the picture
    * to use
    *
    * @param thePicture the picture to use
    */
   public ComicPanel(Picture thePicture) {
      this.picture = thePicture;
      init();
   }

   ////////// methods //////////////////////////

   public static void main(String[] args) {
      Picture        p        = new Picture(FileChooser.getMediaPath("MattJennyCorn.jpg"));
      ComicPanel     panel    = new ComicPanel(p);
      SpeechBalloon  sBalloon = new SpeechBalloon(new Point(209, 18), 100, new Point(218, 149), "It sure is corny in here!");
      ThoughtBalloon tBalloon = new ThoughtBalloon(new Point(14, 60), 100, new Point(167, 226), "Oh, that was corny!");
      panel.add(sBalloon);
      panel.add(tBalloon);
      Picture finalPic = panel.getFinalPicture();
      finalPic.explore();
   }

   /**
    * Method to initialize this panel
    */
   private void init() {
      if (lineBorder) {
         Border border = BorderFactory.createLineBorder(Color.BLACK);
         this.setBorder(border);
      }
      updateLabel();
      this.add(pictureLabel);
   }

   /**
    * Method to update the label icon
    */
   private void updateLabel() {
      Picture finalPicture = getFinalPicture();
      Icon    icon         = new ImageIcon(finalPicture.getImage());
      pictureLabel.setIcon(icon);
      repaint();
   }

   /**
    * Method to add a text balloon to the panel
    */
   public void add(TextBalloon textBalloon) {
      textBalloonList.add(textBalloon);
      updateLabel();
   }

   /**
    * Method to remove a text balloon from the panel
    *
    * @param textBalloon the text balloon to remove
    */
   public void remove(TextBalloon textBalloon) {
      textBalloonList.remove(textBalloon);
      updateLabel();
   }

   public Picture getFinalPicture() {
      Picture  finalPicture = new Picture(picture);
      Graphics g            = finalPicture.getGraphics();

      // loop through text balloons
      for (TextBalloon balloon : textBalloonList) {
         balloon.draw(g);
      }
      // comment out above and uncomment below for 1.4
      //    Iterator listIterator = textBalloonList.iterator();
      //    TextBalloon balloon = null;
      //    while (listIterator.hasNext())
      //    {
      //      balloon = (TextBalloon) listIterator.next();
      //      balloon.draw(g);
      //    }
      return finalPicture;
   }

   /**
    * Method to write out the comic panel
    *
    * @param fileName the full path name of the file
    *                 to write.  Be sure to include .jpg or .bmp
    */
   public void write(String fileName) {
      Picture finalPicture = getFinalPicture();
      finalPicture.write(fileName);
   }
}
