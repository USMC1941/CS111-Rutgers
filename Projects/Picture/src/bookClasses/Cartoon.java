package bookClasses;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Class to create a cartoon out of a picture
 *
 * @author Barb Ericson
 */
public class Cartoon {

   //////////// fields ///////////////////
   private final Picture picture;


   /////////// constructor ///////////////

   /**
    * Constructor that takes the picture
    *
    * @param p the picture to use
    */
   public Cartoon(Picture p) {
      this.picture = p;
   }

   /////////// methods //////////////////

   public static void main(String[] args) {
      Picture picture = new Picture(FileChooser.getMediaPath("horse.jpg"));
      Cartoon cartoon = new Cartoon(picture);
      cartoon.addWordBalloon("Just Horsing Around!", 42, 20);
      picture.explore();
   }

   /**
    * Method to add a word balloon that contians the message
    *
    * @param message the text to show
    * @param xPos    the top left for the word balloon
    * @param yPos    the top left for the word balloon
    */
   public void addWordBalloon(String message, int xPos, int yPos) {
      // get the Graphics2D
      Graphics   g  = this.picture.getGraphics();
      Graphics2D g2 = (Graphics2D) g;

      // get the font information for the message
      Font              font       = new Font("Arial", Font.BOLD, 24);
      FontRenderContext frc        = g2.getFontRenderContext();
      Rectangle2D       bounds     = font.getStringBounds(message, frc);
      LineMetrics       metrics    = font.getLineMetrics(message, frc);
      float             lineHeight = metrics.getHeight();
      float             ascent     = metrics.getAscent();

      // draw the ellipse for the word ballon
      double ellipseWidth  = bounds.getWidth() * 1.5;
      double ellipseHeight = bounds.getHeight() * 2.0;
      g2.setColor(Color.WHITE);
      g2.fill(new Ellipse2D.Double(xPos, yPos, ellipseWidth, ellipseHeight));

      // draw the message centered in the ellipse
      float x0 = (float) ((ellipseWidth - bounds.getWidth()) / 2 + xPos);
      float y0 = (float) ((ellipseHeight - lineHeight) / 2 + yPos + ascent);
      g2.setColor(Color.BLACK);
      g2.setFont(font);
      g2.drawString(message, x0, y0);
   }

}
  
