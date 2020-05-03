package bookClasses;

import java.awt.*;

/**
 * Interface to used to communicate between a model
 * and its display
 * <p>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public interface ModelDisplay {
   /**
    * method to notify the thing that displays that
    * the model has changed
    */
   void modelChanged();

   /**
    * method to add the model to the world
    *
    * @param model the model object to add
    */
   void addModel(Object model);

   /**
    * Method to remove the model from the world
    *
    * @param model the model object to remove
    */
   void remove(Object model);

   /**
    * Method that returns the graphics context
    * for this model display
    *
    * @return the graphics context
    */
   Graphics getGraphics();

   /**
    * Method to clear the background
    */
   void clearBackground();

   /**
    * Method to get the width of the display
    *
    * @return the width in pixels of the display
    */
   int getWidth();

   /**
    * Method to get the height of the display
    *
    * @return the height in pixels of the display
    */
   int getHeight();
}
