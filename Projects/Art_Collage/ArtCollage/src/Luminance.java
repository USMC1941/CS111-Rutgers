/******************************************************************************
 *  Compilation:  javac Luminance.java
 *  Execution:    java Luminance r1 g1 b1 r2 g2 b2
 *
 *  Library for dealing with monochrome luminance. 
 *  Uses the NTSC formula Y = 0.299*r + 0.587*g + 0.114*b.
 *
 *  % java Luminance 0 0 0 0 0 255
 *
 ******************************************************************************/

import java.awt.*;

/**
 *  The class {@code Luminance} is a library of static methods related to
 *  the monochrome luminance of a color. It supports computing the monochrome
 *  luminance of a color (r, g, b) using the NTSC formula
 *  Y = 0.299*r + 0.587*g + 0.114*b; converting the color to a grayscale color,
 *  and checking whether two colors are compatible.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/31datatype">Section 3.1</a>
 *  of <i>Computer Science: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 */
public class Luminance {

   /**
    * Returns the monochrome luminance of the given color as an intensity
    * between 0.0 and 255.0 using the NTSC formula Y = 0.299*r + 0.587*g + 0.114*b.
    *
    * @param color the color to convert
    * @return the monochrome luminance (between 0.0 and 255.0)
    * @deprecated Replaced by {@link #intensity(Color)}.
    */
   @Deprecated
   public static double lum(Color color) {
      return intensity(color);
   }

   /**
    * Returns the monochrome luminance of the given color as an intensity
    * between 0.0 and 255.0 using the NTSC formula
    * Y = 0.299*r + 0.587*g + 0.114*b. If the given color is a shade of gray
    * (r = g = b), this method is guaranteed to return the exact grayscale
    * value (an integer with no floating-point roundoff error).
    *
    * @param color the color to convert
    * @return the monochrome luminance (between 0.0 and 255.0)
    */
   public static double intensity(Color color) {
      int r = color.getRed();
      int g = color.getGreen();
      int b = color.getBlue();
      if (r == g && r == b) {
         return r;   // to avoid floating-point issues
      }
      return 0.299 * r + 0.587 * g + 0.114 * b;
   }

   /**
    * Returns a grayscale version of the given color as a {@code Color} object.
    *
    * @param color the {@code Color} object to convert to grayscale
    * @return a grayscale version of {@code color}
    */
   public static Color toGray(Color color) {
      int   y    = (int) (Math.round(intensity(color)));   // round to nearest int
      Color gray = new Color(y, y, y);
      return gray;
   }

   /**
    * Are the two given colors compatible? Two colors are compatible if the
    * the difference in their monochrome luminances is at least 128.0).
    *
    * @param a one color
    * @param b the other color
    * @return {@code true} if colors {@code a} and {@code b} are compatible;
    *    {@code false} otherwise
    */
   public static boolean areCompatible(Color a, Color b) {
      return Math.abs(intensity(a) - intensity(b)) >= 128.0;
   }

   /**
    * Takes six command-line arguments r1, g1, b1, r2, g2, and b2, prints to
    * standard output the monochrome luminances of (r1, g1, b1) and (r2, g2, b2)
    * and whether they are compatible.
    *
    * @param args the six command-line arguments
    */
   public static void main(String[] args) {
      int[] a = new int[6];
      for (int i = 0; i < 6; i++) {
         a[i] = Integer.parseInt(args[i]);
      }
      Color c1 = new Color(a[0], a[1], a[2]);
      Color c2 = new Color(a[3], a[4], a[5]);
      Color c3 = Luminance.toGray(c1);
      StdOut.println("c1 = " + c1);
      StdOut.println("c2 = " + c2);
      StdOut.println("c3 = " + c3);
      StdOut.println("intensity(c1) =  " + intensity(c1));
      StdOut.println("intensity(c2) =  " + intensity(c2));
      StdOut.println("intensity(c3) =  " + intensity(c3));
      StdOut.println(areCompatible(c1, c2));
   }
}
