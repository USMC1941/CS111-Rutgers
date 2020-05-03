package bookClasses;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * This class represents a displayable path segment
 * it has a color, width, and a Line2D object
 * Copyright Georgia Institute of Technology 2005
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class PathSegment {
   //////////////// fields /////////////////////
   private final Color color;
   private final int   width;
   private final Line2D.Float line;

   //////////////// constructors ///////////////

   /**
    * Constructor that takes the color, width,
    * and line
    */
   public PathSegment(Color theColor, int theWidth, Line2D.Float theLine) {
      this.color = theColor;
      this.width = theWidth;
      this.line = theLine;
   }

   //////////////// methods ////////////////////

   /**
    * Method to paint this path segment
    *
    * @param g the graphics context
    */
   public void paintComponent(Graphics g) {
      Graphics2D  g2        = (Graphics2D) g;
      BasicStroke penStroke = new BasicStroke(this.width);
      g2.setStroke(penStroke);
      g2.setColor(this.color);
      g2.draw(this.line);
   }

} // end of class
