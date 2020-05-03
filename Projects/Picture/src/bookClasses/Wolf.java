package bookClasses;

import java.awt.*;
import java.util.Random;

/**
 * Class that represents a wolf.   The wolf class
 * tracks all the living wolves with a linked list.
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Wolf extends Turtle {

   /////////////// fields //////////////////////

   /**
    * class constant for the color
    */
   private static final Color WOLF_COLOR = Color.RED;

   /**
    * class constant for probability of turning
    */
   private static final double PROB_OF_TURN = 1.0 / 10;

   /**
    * class constant for top speed (max num steps can move in a timestep)
    */
   private static final int maxSpeed = 60;

   /**
    * random number generator
    */
   private static final Random randNumGen = new Random();

   /**
    * class variable for the last created wolf (head of linked list)
    */
   private static Wolf head = null;

   /**
    * object variable for the next wolf in the linked list
    */
   private Wolf next = null;

   ////////////////////////////// Constructors ////////////////////////

   /**
    * Constructor that takes the model display (the original
    * position will be randomly assigned)
    *
    * @param modelDisplayer thing that displays the model
    */
   public Wolf(ModelDisplay modelDisplayer) {
      super(randNumGen.nextInt(modelDisplayer.getWidth()), randNumGen.nextInt(modelDisplayer.getHeight()), modelDisplayer);
      init();
   }

   /**
    * Constructor that takes the x and y and a model
    * display to draw it on
    *
    * @param x              the starting x position
    * @param y              the starting y position
    * @param modelDisplayer the thing that displays the model
    */
   public Wolf(int x, int y, ModelDisplay modelDisplayer) {
      // let the parent constructor handle it
      super(x, y, modelDisplayer);
      init();
   }

   ////////////////// methods ////////////////////////////////////////

   /**
    * Method to get the head of the linked list of wolves
    *
    * @return the head of the linked list (may be null)
    */
   public static Wolf getHead() {
      return head;
   }

   /**
    * main method for testing
    */
   public static void main(String[] args) {
      World w = new World();

      // create some deer
      int numDeer = 20;
      for (int i = 0; i < numDeer; i++) {
         new Deer(w);
      }

      // create some wolves
      int numWolves = 5;
      for (int i = 0; i < numWolves; i++) {
         new Wolf(w);
      }

      // declare a wolf and deer
      Wolf wolf = null;
      Deer deer = null;

      // loop for a set number of timesteps
      for (int t = 0; t < 100; t++) {
         // loop through all the wolves
         wolf = Wolf.getHead();
         while (wolf != null) {
            wolf.act();
            wolf = wolf.getNext();
         }

         // loop through all the deer
         deer = Deer.getHead();
         while (deer != null) {
            deer.act();
            deer = deer.getNext();
         }

         // wait a bit
         try {
            Thread.sleep(1000);
         }
         catch (Exception ex) {
         }
      }
   }

   /**
    * Method to get the next Wolf in the linked list
    *
    * @return the next wolf in the linked list of wolves
    * or null
    */
   public Wolf getNext() {
      return this.next;
   }

   /**
    * Method to initialize the new wolf object
    */
   public void init() {
      // set the color of this wolf
      setColor(WOLF_COLOR);

      // add this deer to the linked list of wolf
      if (head == null) {
         head = this;
      }
      else {
         this.next = head;
         head = this;
      }

      // turn some random direction
      this.turn(randNumGen.nextInt(360));
   }

   /**
    * Method to get the closest deer within the passed distance
    * to this wolf
    *
    * @param distance the distance to look within
    * @return the closest deer in the given distance or null
    */
   public Deer getClosestDeer(double distance) {
      // get the head of the deer linked list
      Deer   head            = Deer.getHead();
      Deer   curr            = head;
      Deer   closest         = null;
      double closestDistance = 0;
      double currDistance    = 0;


      // loop through the linked list looking for the closest deer
      while (curr != null) {
         currDistance = curr.getDistance(this.getXPos(), this.getYPos());
         if (currDistance < distance) {
            if (closest == null || currDistance < closestDistance) {
               closest = curr;
               closestDistance = currDistance;
            }
         }
         curr = curr.getNext();
      }
      return closest;
   }

   /**
    * Method to act during a time step
    * pick a random direction and move some random amount up to top speed
    */
   public void act() {

      // get the closest deer in some specified distance
      Deer closeDeer = getClosestDeer(30);
      if (closeDeer != null) {
         this.moveTo(closeDeer.getXPos(), closeDeer.getYPos());
         closeDeer.die();
      }

      else {

         // if the random number is <= prob of turning then turn
         if (randNumGen.nextFloat() <= PROB_OF_TURN) {
            this.turn(randNumGen.nextInt(360));
         }

         // go forward some random amount
         forward(randNumGen.nextInt(maxSpeed));
      }
   }

}
