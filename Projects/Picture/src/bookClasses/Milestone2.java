package bookClasses;

/**
 * Submit this file for Project Part 1
 */
public class Milestone2 {

   public static void main(String[] args) {

      // Instantiate a Picture object from file mypic.jpg
      Picture p = new Picture("/home/anapaula/Pics/mypic.jpg");

      // The object referenced by p will be manipulated by your methods.

      // Example on how to call the countRedPixels method
      int redPixels = countRedPixels(p);
      System.out.println("The number of red pixels is: " + p);
   }

   /**
    * 1) Returns the number of red pixels in picture v
    */
   public static int countRedPixels(Picture v) {
      // WRITE YOUR CODE HERE
      return 1;
   }

   /**
    * 2) Change all the red pixels in an image to blue pixels and vice versa
    *    Only pure red and pure blue
    */
   public static void switchRedBlue(Picture v) {
      // WRITE YOUR CODE HERE
   }

   /**
    * 3. Take the left half of an image and reflect it over an imaginary
    *    vertical line going across the middle of the image.
    *    IF pixels exist ON the midline, leave them there without reflecting
    */
   public static void flipHorizontal(Picture v) {
      // WRITE YOUR CODE HERE
   }

   /**
    * 4. Take the top half of an image and reflect it over an imaginary horizontal
    *    line going through the image
    *    IF pixels exist ON the midline, leave them there without reflecting
    */
   public static void flipVertical(Picture v) {
      // WRITE YOUR CODE HERE
   }

   /**
    * 5. Take the upper half of an image and reflect it over an imaginary diagonal
    *    line going from the upper left corner of the image to the lower right corner.
    *    Upper right to lower left diagonal line
    *    You may assume SQUARE images (height == width)
    *    IF pixels exist ON the midline, leave them there without reflecting
    */
   public static void flipDiagonal(Picture v) {
      // WRITE YOUR CODE HERE
   }
}
