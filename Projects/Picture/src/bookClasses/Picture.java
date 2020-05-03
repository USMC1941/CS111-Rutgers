package bookClasses;

import java.awt.image.BufferedImage;

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 * <p>
 * Copyright Georgia Institute of Technology 2004-2005
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
   ///////////////////// constructors //////////////////////////////////

   /**
    * Constructor that takes no arguments
    */
   public Picture() {
      /* not needed but use it to show students the implicit call to super()
       * child constructors always call a parent constructor
       */
      super();
   }

   /**
    * Constructor that takes a file name and creates the picture
    *
    * @param fileName the name of the file to create the picture from
    */
   public Picture(String fileName) {
      // let the parent class handle this fileName
      super(fileName);
   }

   /**
    * Constructor that takes the width and height
    *
    * @param width  the width of the desired picture
    * @param height the height of the desired picture
    */
   public Picture(int width, int height) {
      // let the parent class handle this width and height
      super(width, height);
   }

   /**
    * Constructor that takes a picture and creates a
    * copy of that picture
    */
   public Picture(Picture copyPicture) {
      // let the parent class do the copy
      super(copyPicture);
   }

   /**
    * Constructor that takes a buffered image
    *
    * @param image the buffered image to use
    */
   public Picture(BufferedImage image) {
      super(image);
   }

   ////////////////////// methods ///////////////////////////////////////

   public static void main(String[] args) {
      String  fileName = FileChooser.pickAFile();
      Picture pictObj  = new Picture(fileName);
      pictObj.explore();
   }

   /**
    * Method to return a string with information about this picture.
    *
    * @return a string with information about the picture such as fileName,
    * height and width.
    */
   public String toString() {
      return "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
   }

} // this } is the end of class Picture, put all new methods before this
