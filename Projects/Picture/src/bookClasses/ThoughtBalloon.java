package bookClasses;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * ThoughtBalloon: this is used to
 * represent objects
 * in comic strips which are used to show
 * what a character is thinking.  The tip of
 * tail points to the character who is
 * doing the thinking
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 * Copyright 2005
 */
public class ThoughtBalloon extends TextBalloon {


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
   public ThoughtBalloon(Point uLeft, int theWidth, Point tEnd, String theMessage) {
      super(uLeft, theWidth, tEnd, theMessage);
   }

   //////////// methods ////////////////

   public static void main(String[] args) {
      Picture        p       = new Picture(FileChooser.getMediaPath("horse.jpg"));
      Graphics       g       = p.getGraphics();
      Point          ul      = new Point(68, 24);
      Point          te      = new Point(179, 127);
      String         message = "This is a test." + "  Of a message with more than one line in it.";
      ThoughtBalloon balloon = new ThoughtBalloon(ul, 200, te, message);
      balloon.draw(g);
      p.explore();
   }

   /**
    * Method to draw the passed ellipse
    *
    * @param g2           the 2d graphics context
    * @param fillColor    the color to fill with
    * @param outlineColor the color to outline with
    * @param ellipse      the ellipse to draw
    */
   private void drawEllipse(Graphics2D g2, Color fillColor, Color outlineColor, Ellipse2D.Double ellipse) {
      g2.setColor(fillColor);
      g2.fill(ellipse);
      g2.setColor(outlineColor);
      g2.draw(ellipse);
   }

   /**
    * Method to draw a circle of a given width
    *
    * @param circleTop  the top point on the circle
    * @param heading    the heading in degrees with 0
    *                   being north
    * @param width      the width of the circle
    * @param distance   the distance from the start point
    * @param startPoint the point to start the distance
    *                   from
    * @param g2         the 2d graphics context used for drawing
    * @return a point on the circle at the given distance
    * away from the start point
    */
   public Point drawCircle(Point circleTop, double heading, double width, double distance, Point startPoint, Color fillColor,
                           Color outlineColor, Graphics2D g2) {
      Point            p2     = Geometry.getPointAtDistance(startPoint, heading, distance);
      Ellipse2D.Double circle = new Ellipse2D.Double(circleTop.x - (width / 2), circleTop.y, width, width);
      drawEllipse(g2, fillColor, outlineColor, circle);
      return p2;
   }

   /**
    * Method to draw the circles from the
    * bottom of the text balloon to the tail
    * end point
    *
    * @param g2           the 2d graphics context
    * @param fillColor    the color to fill the
    *                     circle with
    * @param outlineColor the color to outline
    *                     the circle with
    * @param height       the height of the circles
    */
   private void drawCircles(Graphics2D g2, Color fillColor, Color outlineColor, int height) {
      Point  upperLeft     = getUpperLeft();
      int    startX        = upperLeft.x + (getWidth() / 2);
      int    startY        = height + upperLeft.y;
      Point  tailStart     = new Point(startX, startY);
      Point  tailEnd       = getTailEnd();
      double totalDistance = 0;
      double distance      = Geometry.getDistance(startX, startY, tailEnd.x, tailEnd.y);
      double heading       = Geometry.getTurtleHeading(startX, startY, tailEnd.x, tailEnd.y);
      Point  nextPoint     = null;

      // if the distance is less than 3 do nothing
      if (distance < 3) {
      }
      // if distance <= 6 draw 1 circle of distance width
      else if (distance <= 6) {
         drawCircle(tailStart, heading, distance, distance, tailStart, fillColor, outlineColor, g2);
         // draw 2 circles
      }
      else if (distance <= 10) {
         // draw one of size 6
         nextPoint = drawCircle(tailStart, heading, 6, 6, tailStart, fillColor, outlineColor, g2);
         // and another of remaining size
         distance = distance - 6;
         totalDistance = 6 + distance;
         drawCircle(nextPoint, heading, distance, totalDistance, tailStart, fillColor, outlineColor, g2);
      }
      else {
         // draw one of size 10
         nextPoint = drawCircle(tailStart, heading, 10, 10, tailStart, fillColor, outlineColor, g2);
         distance = distance - 10;
         // if more room draw a size 6 one
         if (distance >= 6) {
            totalDistance = 10 + 6;
            nextPoint = drawCircle(nextPoint, heading, 6, totalDistance, tailStart, fillColor, outlineColor, g2);
            distance = distance - 6;
         }
         // draw size 4 ones with space of 2 pixels between
         while (distance >= 6) {
            totalDistance += 2;
            distance = distance - 2;
            nextPoint = Geometry.getPointAtDistance(tailStart, heading, totalDistance);
            totalDistance = totalDistance + 4;
            nextPoint = drawCircle(nextPoint, heading, 4, totalDistance, tailStart, fillColor, outlineColor, g2);
            distance = distance - 4;
         }
      }
   }

   /**
    * Method to draw the thought
    * balloon using the passed graphics
    * context
    *
    * @param ellipseHeight the height of
    *                      the ellipse
    * @param fillColor     the color to fill the tail
    *                      with
    * @param outlineColor  the color to outline
    *                      the tail with
    * @param g2            the 2D graphics context
    */
   protected void drawTail(int ellipseHeight, Color fillColor, Color outlineColor, Graphics2D g2) {
      // draw the circles to the speaker
      drawCircles(g2, fillColor, outlineColor, ellipseHeight);
   }

} // end of SpeechBalloon class
  
