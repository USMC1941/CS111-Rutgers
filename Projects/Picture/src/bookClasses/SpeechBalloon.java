package bookClasses;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * SpeechBalloon: this is used to
 * represent objects
 * in comic strips which are used to show
 * what a character is saying.  The tip of
 * tail points to the character who is
 * talking
 *
 * @author Barb Ericson
 */
public class SpeechBalloon extends TextBalloon {


   ///////////// constructors //////////////////

   /**
    * Constructor that takes the upper left, width,
    * tail end, and message to display
    *
    * @param uLeft      the upper left corner of a rectangle
    *                   enclosing the balloon
    * @param theWidth   the width of the enclosing rectangle
    * @param tEnd       the point which is the end of the tail
    *                   that shows who is speaking
    * @param theMessage the message to display
    */
   public SpeechBalloon(Point uLeft, int theWidth, Point tEnd, String theMessage) {
      super(uLeft, theWidth, tEnd, theMessage);
   }

   //////////// methods ////////////////

   public static void main(String[] args) {
      Picture       p       = new Picture(FileChooser.getMediaPath("horse.jpg"));
      Graphics      g       = p.getGraphics();
      Point         ul      = new Point(68, 24);
      Point         te      = new Point(182, 123);
      String        message = "This is a test." + "  Of a message with more than one line in it.";
      SpeechBalloon balloon = new SpeechBalloon(ul, 200, te, message);
      balloon.draw(g);
      p.show();
   }

   /**
    * method to draw the tail of the balloon
    *
    * @param ellipseHeight the height of the
    *                      ellipse
    * @param fillColor     the color to bill the
    *                      balloon with
    * @param outlineColor  the color to outline
    *                      the balloon with
    * @param g2            the 2d graphics context
    */
   protected void drawTail(int ellipseHeight, Color fillColor, Color outlineColor, Graphics2D g2) {
      Point       tailEnd   = getTailEnd();
      Point       upperLeft = getUpperLeft();
      int         margin    = getMargin();
      int         halfWidth = getWidth() / 2;
      int         topY      = upperLeft.y + ellipseHeight;
      int         startX    = upperLeft.x + halfWidth - margin;
      int         endX      = upperLeft.x + halfWidth + margin;
      GeneralPath triangle  = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
      triangle.moveTo(startX, topY);
      triangle.lineTo(endX, topY);
      triangle.lineTo(tailEnd.x, tailEnd.y);
      triangle.lineTo(startX, topY);
      g2.setColor(fillColor);
      g2.fill(triangle);
      g2.setColor(outlineColor);
      g2.draw(new Line2D.Double(tailEnd.x, tailEnd.y, startX, topY));
      g2.draw(new Line2D.Double(tailEnd.x, tailEnd.y, endX, topY));
   }

} // end of SpeechBalloon class
  
