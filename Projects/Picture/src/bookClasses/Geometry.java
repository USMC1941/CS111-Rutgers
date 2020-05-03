package bookClasses;

import java.awt.*;

/**
 * Class to hold methods for doing simple geometry
 * All methods are static (class) methods.  You
 * do not need to create an object of the Geometry
 * class to use these methods.
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 * Copyright 2005
 */
public class Geometry {
   /**
    * Method to get the slope between two points
    *
    * @param x1 the x value for one of the points
    * @param y1 the y value for one of the points
    * @param x2 the x value for a second point
    * @param y2 the y value for a second point
    * @return the slope
    */
   public static double getSlope(double x1, double y1, double x2, double y2) {
      return (y2 - y1) / (x2 - x1);
   }

   /**
    * Method to get the slope angle between 2 points
    * The slope angle is the interior angle of the
    * triangle of the slope line with the y and x axis.
    * So it is the angle from the x axis.
    *
    * @param x1 the x value for one of the points
    * @param y1 the y value for one of the points
    * @param x2 the x value for a second point
    * @param y2 the y value for a second point
    * @return the slope angle in degrees
    */
   public static double getSlopeAngle(double x1, double y1, double x2, double y2) {
      double slope = getSlope(x1, y1, x2, y2);
      double angle = Math.atan(slope);
      return Math.abs(Math.toDegrees(angle));
   }

   /**
    * Method to return the heading for a turtle
    * which uses 0 degrees as north
    *
    * @param x1 x from the first point
    * @param y1 y from the first point
    * @param x2 x from the second point
    * @param y2 y from the second point
    * @return the heading in degrees from north
    */
   public static double getTurtleHeading(double x1, double y1, double x2, double y2) {
      double heading = 0;
      // don't allow a divide by zero
      if (x1 == x2) {
         if (y2 > y1) {
            heading = 180;
         }
         else {
            heading = 0;
         }
      }
      // calculate the heading from the slope angle
      else {
         double slopeAngle = getSlopeAngle(x1, y1, x2, y2);
         heading = 180 - (90 - slopeAngle);
         if (x2 < x1) {
            heading = heading * -1;
         }
      }
      return heading;
   }

   /**
    * Method to get a new point at a given distance
    * from an old point along a heading (angle in degrees)
    *
    * @param x1       x of a point
    * @param y1       y of a point
    * @param heading  the heading in degrees with north
    *                 being 0 and south 180
    * @param distance the distance for the returned point
    * @return the point at the distance in the direction
    * of the heading
    */
   public static Point getPointAtDistance(int x1, int y1, double heading, double distance) {
      double radiansHeading = Math.toRadians(heading);
      int    x2             = x1 + (int) (distance * Math.sin(radiansHeading));
      int    y2             = y1 + (int) (distance * -Math.cos(radiansHeading));
      return new Point(x2, y2);
   }

   /**
    * Method to get a new point at a given distance
    * from an old point along a heading (angle in degrees)
    *
    * @param startPoint the point to get the distance
    *                   from
    * @param heading    the heading in degrees with north
    *                   being 0 and south 180
    * @param distance   the distance for the returned point
    * @return the point at the distance in the direction
    * of the heading
    */
   public static Point getPointAtDistance(Point startPoint, double heading, double distance) {
      return getPointAtDistance(startPoint.x, startPoint.y, heading, distance);
   }

   /**
    * Method to get the distance between two points
    *
    * @param x1 x value of first point
    * @param y1 y value of first point
    * @param x2 x value of second point
    * @param y2 y value of second point
    * @return distance between the points
    */
   public static double getDistance(double x1, double y1, double x2, double y2) {
      double xDiff = x2 - x1;
      double yDiff = y2 - y1;
      return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
   }

} // end of class 
