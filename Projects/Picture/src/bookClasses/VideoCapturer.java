package bookClasses;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Interface for working with video capture
 * Copyright Georgia Institute of Technology 2007
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public interface VideoCapturer {
   /**
    * Method that captures the screen
    */
   BufferedImage captureScreen() throws Exception;

   /**
    * Method to start the capture
    */
   void startCapture();

   /**
    * Method to start the capture and capture numSeconds of video
    *
    * @param numSeconds the number of seconds to capture
    */
   void startCapture(int numSeconds);

   /**
    * Method to stop the capture
    */
   void stopCapture();

   /**
    * Method to play the captured movie
    */
   void playMovie();

   /**
    * Method to get the frame sequencer
    *
    * @return the frame sequencer used in the capture
    */
   FrameSequencer getFrameSequencer();

   /**
    * Method to get the region to capture
    *
    * @return the region to capture
    */
   Rectangle getRegion();

   /**
    * Method that sets a region to capture
    *
    * @param region the rectangular region to capture
    */
   void setRegion(java.awt.Rectangle region);

   /**
    * Method to return the number of frames per second
    *
    * @return the number of frames per second being captured
    */
   int getFramesPerSecond();

   /**
    * Method to set the number of frames per second
    */
   void setFramesPerSecond(int frameRate);

}
