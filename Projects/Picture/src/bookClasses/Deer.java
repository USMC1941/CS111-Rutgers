package bookClasses;

import java.awt.*;
import java.util.Random;

/**
 * Class that represents a deer.  The deer class
 * tracks all living deer with a linked list.
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Deer extends Turtle {

   /////////////// fields //////////////////////

   /**
    * class constant for the color
    */
   private static final Color DEER_COLOR = new Color(116, 64, 35);

   /**
    * class constant for probability of turning
    */
   private static final double PROB_OF_TURN = 4.0 / 5;

   /**
    * class constant for top speed (max num steps can move in a timestep)
    */
   private static final int maxSpeed = 50;

   /**
    * random number generator
    */
   private static final Random randNumGen = new Random();

   /**
    * class variable for the last created deer (head of linked list)
    */
   private static Deer head = null;

   /**
    * object variable for the next deer in the linked list
    */
   private Deer next = null;

   ////////////////////////////// Constructors ////////////////////////

   /**
    * Constructor that takes the model display (the original
    * position will be randomally assigned
    *
    * @param modelDisplayer thing which will display the model
    */
   public Deer(ModelDisplay modelDisplayer) {
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
   public Deer(int x, int y, ModelDisplay modelDisplayer) {
      // let the parent constructor handle it
      super(x, y, modelDisplayer);
      init();
   }

   ////////////////// methods ////////////////////////////////////////

   /**
    * Method to get the head of the linked list of deer
    *
    * @return the head of the linked list of deer (may be null)
    */
   public static Deer getHead() {
      return head;
   }

   /**
    * main method for testing
    */
   public static void main(String[] args) {
      World w = new World();
      w.setAutoRepaint(false);
      Deer[] deerArray = new Deer[20];
      for (int i = 0; i < 20; i++) {
         deerArray[i] = new Deer(w);
      }

      // now loop to do simulation
      for (int i = 0; i < 100; i++) {
         for (int d = 0; d < 20; d++) {
            deerArray[d].act();
         }
         w.repaint();
         try {
            Thread.sleep(1000);
         }
         catch (Exception ex) {
         }
      }
   }

   /**
    * Method to get the next Deer in the linked list
    *
    * @return the next deer in the linked list of deer
    * or null
    */
   public Deer getNext() {
      return this.next;
   }

   /**
    * Method to initialize the new deer object
    */
   public void init() {
      // set the color of this deer
      setColor(DEER_COLOR);

      // add this deer to the linked list of deer
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
    * Method to act during a time step
    * pick a random direction and move some random amount up to top speed
    */
   public void act() {
      // if the random number is <= prob of turning then turn
      if (randNumGen.nextFloat() <= PROB_OF_TURN) {
         this.turn(randNumGen.nextInt(360));
      }

      // go forward some random amount
      forward(randNumGen.nextInt(maxSpeed));
   }

   /**
    * Method that handles when a deer dies
    */
   public void die() {
      Deer prev = null;
      Deer curr = null;

      // remove this deer from the linked list of deer
      if (head == this) {
         head = head.next;
      }
      else {
         prev = head;
         curr = prev.next;
         while (curr != null && curr != this) {
            prev = curr;
            curr = prev.next;
         }
         if (curr != null) {
            prev.next = curr.next;
         }
      }

      // ask the model display to remove this
      getModelDisplay().remove(this);
   }

}
