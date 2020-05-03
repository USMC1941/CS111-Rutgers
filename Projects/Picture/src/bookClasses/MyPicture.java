package bookClasses;

public class MyPicture {

   // Fields or instance variables

   private Picture picture; // basis that provides the extension of class Picture
   private String  filename; // the name of the image file
   private int     width;       // the image width
   private int     length;      // the image length
   private String  description; // the image description

   /**
    * Constructor.
    * Takes as a parameter the name of the file to load and a description of the picture.
    * The width and height of an image are available in the {@link Picture} class.
    */
   public MyPicture(String filename, String description) {
      // WRITE YOUR CODE HERE
   }

   /**
    * Returns the string representation for a {@link bookClasses.MyPicture} object.
    * The string's format should match the following EXACTLY:
    * <pre>
    *    {@code <imagename>.<extension> <width> x <length> <description>}
    * </pre>
    * Replace {@code <xxx>} with the respective data about this image
    */
   public String toString() {
      // WRITE YOUR CODE HERE
      return null;
   }

   /**
    * Returns true of the parameter {@link bookClasses.MyPicture} object is equal
    * to the current instance, false otherwise. {@link bookClasses.MyPicture} objects
    * are considered equal if and only if their filenames are the
    * same AND their descriptions are the same.
    */
   public boolean equals(MyPicture p) {
      // WRITE YOUR CODE HERE
      return false;
   }

   /**
    * Returns a new Picture object representing the 'negative'
    * image of this {@link bookClasses.MyPicture} object. The negative of a pixel
    * is defined by taking each pixel's red, blue, and green value and
    * subtracting that value from 255.
    */
   public Picture negative() {
      // WRITE YOUR CODE HERE
      return null;
   }

   /**
    * Returns the redness score of this image.
    * The redness score is defined by the total number of pixels that have
    * a red value that is greater than both the blue and green
    * pixels divided by the total number of pixels
    */
   public double redness() {
      // WRITE YOUR CODE HERE
      return 1.0;
   }

   /**
    * Convert flipHorizontal from Part 1 to an instance method
    */
   public void flipHorizontal() {
      // WRITE YOUR CODE HERE
   }

   /**
    * Convert flipVertical from Part 1 to an instance method
    */
   public void flipVertical() {
      // WRITE YOUR CODE HERE
   }
}
