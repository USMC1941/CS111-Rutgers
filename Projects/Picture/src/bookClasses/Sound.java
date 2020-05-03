package bookClasses;

/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound.
 * <p>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound {

   /////////////// constructors ////////////////////////////////////

   /**
    * Constructor that takes a file name
    *
    * @param fileName the name of the file to read the sound from
    */
   public Sound(String fileName) {
      // let the parent class handle setting the file name
      super(fileName);
   }

   /**
    * Constructor that takes the number of samples in
    * the sound
    *
    * @param numSamples the number of samples desired
    */
   public Sound(int numSamples) {
      // let the parent class handle this
      super(numSamples);
   }

   /**
    * Constructor that takes the number of samples that this
    * sound will have and the sample rate
    *
    * @param numSamples the number of samples desired
    * @param sampleRate the number of samples per second
    */
   public Sound(int numSamples, int sampleRate) {
      // let the parent class handle this
      super(numSamples, sampleRate);
   }

   /**
    * Constructor that takes a sound to copy
    */
   public Sound(Sound copySound) {
      // let the parent class handle this
      super(copySound);
   }

   ////////////////// methods ////////////////////////////////////

   public static void main(String[] args) {
      Sound sound1 = new Sound(FileChooser.pickAFile());
      sound1.explore();
   }

   /**
    * Method to return the string representation of this sound
    *
    * @return a string with information about this sound
    */
   public String toString() {
      String output   = "Sound";
      String fileName = getFileName();

      // if there is a file name then add that to the output
      if (fileName != null) {
         output = output + " file: " + fileName;
      }

      // add the length in frames
      output = output + " number of samples: " + getLengthInFrames();

      return output;
   }

} // this } is the end of class Sound, put all new methods before this
