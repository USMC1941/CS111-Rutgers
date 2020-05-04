package bookClasses;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Interface to describe a digital picture.  A digital picture can have a
 * associated file name.  It can have a title.  It has pixels
 * associated with it and you can get and set the pixels.  You
 * can get an Image from a picture or a {@link BufferedImage}.  You can load
 * it from a file name or image.  You can show a picture.  You can
 * create a new image for it.
 * <p>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public interface DigitalPicture {
   String getFileName(); // get the file name that the picture came from

   String getTitle(); // get the title of the picture

   void setTitle(String title); // set the title of the picture

   int getWidth(); // get the width of the picture in pixels

   int getHeight(); // get the height of the picture in pixels

   Image getImage(); // get the image from the picture

   BufferedImage getBufferedImage(); // get the buffered image

   int getBasicPixel(int x, int y); // get the pixel information as an int

   void setBasicPixel(int x, int y, int rgb); // set the pixel information

   Pixel getPixel(int x, int y); // get the pixel information as an object

   void load(Image image); // load the image into the picture

   boolean load(String fileName); // load the picture from a file

   void show(); // show the picture
}
