package bookClasses;

import java.awt.image.BufferedImage;

/**
 * Interface for working with getting a region of an image
 * Copyright Georgia Institute of Technology 2007
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public interface RegionInterface {
   /**
    * Method to set the background image to select the region from
    *
    * @param image the image to use
    */
   void setBackgroundImage(BufferedImage image);

   /**
    * Method to clear the picked region (a shape)
    */
   void clearShapes();
}
