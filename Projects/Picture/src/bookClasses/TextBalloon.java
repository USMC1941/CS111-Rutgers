package bookClasses;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Hashtable;

/**
 * TextBalloon: this is used to
 * represent objects
 * in comic strips which are used to show
 * what a character is saying or thinking.  The tip of
 * tail points to the character who is
 * talking or thinking the text
 *
 * @author Barb Ericson
 */
public abstract class TextBalloon {
   ////////////// fields ////////////////

   /**
    * top left point of text balloon
    */
   private Point  upperLeft;
   /**
    * width of balloon showing text
    */
   private int    width;
   /**
    * Amount of space to leave at each end of the balloon
    */
   private int    margin   = 5;
   /**
    * end of triangular tail pointing to speaker
    */
   private Point  tailEnd;
   /**
    * text in the balloon
    */
   private String message;
   /**
    * font to draw the text with
    */
   private Font   font     = new Font("Arial", Font.BOLD, 14);
   /**
    * the number of lines of text in balloon
    */
   private int    numLines = 0;

   ///////////// constructors //////////////////

   /**
    * Constructor that takes the upper left, width,
    * tail end, and message to display
    *
    * @param uLeft      the upper left corner of a rectangle
    *                   enclosing the balloon
    * @param theWidth   the width of the enclosing rectangle
    * @param tEnd       the point which is the end of the tail
    *                   that shows who is speaking or thinking
    * @param theMessage the message to display
    */
   public TextBalloon(Point uLeft, int theWidth, Point tEnd, String theMessage) {
      this.upperLeft = uLeft;
      this.width = theWidth;
      this.tailEnd = tEnd;
      this.message = theMessage.toUpperCase();
   }

   //////////// methods ////////////////

   /**
    * Method to get the upper left point of
    * the rectangle that encloses the balloon
    *
    * @return the upper left point
    */
   public Point getUpperLeft() {
      return this.upperLeft;
   }

   /**
    * Method to set the upper left point of
    * the rectangle that encloses the balloon
    *
    * @param p the upper left point to use
    */
   public void setUpperLeft(Point p) {
      this.upperLeft = p;
   }

   /**
    * Method to get the width of the rectangle
    * that encloses the balloon
    *
    * @return the width of the enclosing rectangle
    */
   public int getWidth() {
      return this.width;
   }

   /**
    * Method to set the width of the rectangle
    * that encloses the balloon
    *
    * @param theWidth the new width to use
    */
   public void setWidth(int theWidth) {
      this.width = theWidth;
   }

   /**
    * Method to get the margin
    *
    * @return the margin in pixels
    */
   public int getMargin() {
      return this.margin;
   }

   /**
    * Method to set the margin
    *
    * @param theMargin the new margin to use
    */
   public void setMargin(int theMargin) {
      this.margin = theMargin;
   }

   /**
    * Method to get the point that is the end
    * of the tail that indicates who is speaking
    *
    * @return the end point of the tail
    */
   public Point getTailEnd() {
      return this.tailEnd;
   }

   /**
    * Method to set the end point of the tail
    * which indicates who is speaking
    *
    * @param p the end point to use
    */
   public void setTailEnd(Point p) {
      this.tailEnd = p;
   }

   /**
    * Method to get the message that is
    * displayed in the balloon
    *
    * @return the message to display
    */
   public String getMessage() {
      return this.message;
   }

   /**
    * Method to set the message that is
    * displayed in the balloon
    *
    * @param theMessage the message to use
    */
   public void setMessage(String theMessage) {
      this.message = theMessage;
   }

   /**
    * Method to get the font used to display
    * the message
    *
    * @return the font used
    */
   public Font getFont() {
      return this.font;
   }

   /**
    * Method to set the font used to display
    * the balloon
    *
    * @param theFont the font to use
    */
   public void setFont(Font theFont) {
      this.font = theFont;
   }

   /**
    * Method to get the number of lines of text.
    * This will be 0 until getHeight is called
    * and then it will be set correctly.
    *
    * @return the number of lines of text
    */
   public int getNumLines() {
      return this.numLines;
   }

   /**
    * Method to get the height of the balloon
    *
    * @param g2           the grahics 2d context to draw in
    * @param attrCharIter the attributed character iterator
    *                     that is used to display the text
    * @return the height in pixels
    */
   public int getHeight(Graphics2D g2, AttributedCharacterIterator attrCharIter) {
      FontRenderContext frc      = g2.getFontRenderContext();
      LineBreakMeasurer measurer = new LineBreakMeasurer(attrCharIter, frc);
      TextLayout        layout   = null;
      int               height   = 0;
      Rectangle2D       bounds   = null;
      int               adWidth  = this.width - (2 * this.margin);
      while ((layout = measurer.nextLayout(adWidth)) != null) {
         numLines++;
         height += layout.getAscent() + layout.getDescent() + layout.getLeading();
      }
      height += (2 * margin);
      return height;
   }

   /**
    * Method to get the attributed character iterator
    * used to display the text
    *
    * @return the attributed character iterator
    */
   protected AttributedCharacterIterator getAttrIterator() {
      Hashtable<TextAttribute, Font> map = new Hashtable<TextAttribute, Font>();
      map.put(TextAttribute.FONT, this.font);
      AttributedString attrString = new AttributedString(message, map);
      return attrString.getIterator();
   }

   /**
    * Method to draw the speech balloon
    *
    * @param ellipseHeight the height of the ellipse
    * @param fillColor     the color to fill with
    * @param outlineColor  the color to outline with
    * @param g2            the 2d graphics context
    */
   protected void drawBalloon(int ellipseHeight, Color fillColor, Color outlineColor, Graphics2D g2) {
      // draw the background rounded rectangle
      int   margin    = getMargin();
      Point upperLeft = getUpperLeft();
      int   width     = getWidth();

      g2.setColor(fillColor);
      float                   x    = upperLeft.x + margin;
      float                   y    = upperLeft.y + margin;
      RoundRectangle2D.Double rect = new RoundRectangle2D.Double(upperLeft.x, upperLeft.y, width, ellipseHeight, 10, 10);
      g2.fill(rect);
      g2.setColor(outlineColor);
      g2.draw(rect);

   }

   /**
    * Method to draw the text in the balloon
    *
    * @param measurer  the line break measurer
    * @param textColor the color to draw the text in
    * @param g2        the 2d graphics context
    */
   protected void drawText(LineBreakMeasurer measurer, Color textColor, Graphics2D g2) {
      int        margin    = getMargin();
      int        width     = getWidth();
      int        halfWidth = width / 2;
      Point      upperLeft = getUpperLeft();
      TextLayout layout    = null;
      int        x         = upperLeft.x + margin;
      int        y         = upperLeft.y + margin;

      // draw the text
      g2.setColor(textColor);
      Rectangle2D bounds  = null;
      int         adWidth = width - (2 * margin);
      while ((layout = measurer.nextLayout(adWidth)) != null) {
         // if only one line center text in balloon
         if (getNumLines() == 1) {
            bounds = layout.getBounds();
            x = upperLeft.x + halfWidth - (int) (bounds.getWidth() * 0.5);
         }
         y += layout.getAscent();
         layout.draw(g2, x, y);
         y += layout.getDescent() + layout.getLeading();
      }
   }

   /**
    * Method to draw the tail of the balloon
    */
   protected abstract void drawTail(int ellipseHeight, Color fillColor, Color outlineColor, Graphics2D g2);

   /**
    * Method to draw the text
    * balloon using the passed graphics
    * context
    *
    * @param g the graphics context to draw on
    */
   public void draw(Graphics g) {
      // cast to graphics 2d and set colors
      Graphics2D g2           = (Graphics2D) g;
      Color      fillColor    = Color.WHITE;
      Color      outlineColor = Color.BLACK;

      // get the font render context
      FontRenderContext frc = g2.getFontRenderContext();

      // get the attributed character iterator
      AttributedCharacterIterator attrCharIter = this.getAttrIterator();

      // get the height of the ellipse
      int ellipseHeight = this.getHeight(g2, attrCharIter);

      // draw the balloon
      drawBalloon(ellipseHeight, fillColor, outlineColor, g2);

      // draw the tail to the speaker
      drawTail(ellipseHeight, fillColor, outlineColor, g2);

      // draw message
      LineBreakMeasurer measurer = new LineBreakMeasurer(attrCharIter, frc);
      drawText(measurer, outlineColor, g2);

   }

} // end of TextBalloon class
  
