package bookClasses;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Properties;

/**
 * A class to make working with a file chooser easier
 * for students.  It uses a JFileChooser to let the user
 * pick a file and returns the chosen file name.
 * <p>
 * Copyright Georgia Institute of Technology 2004
 *
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class FileChooser {

   ///////////////////////////// class fields ///////////////////
   /**
    * Property key for the media directory
    */
   private static final String MEDIA_DIRECTORY = "mediaDirectory";
   /**
    * Name for property file
    */
   private static final String PROPERTY_FILE_NAME = "SimplePictureProperties.txt";
   /**
    * Properties to use during execution
    */
   private static Properties appProperties = null;

   /////////////////////// methods /////////////////////////////

   /**
    * Method to pick an item using the file chooser
    *
    * @param fileChooser the file Chooser to use
    * @return the path name
    */
   public static String pickPath(JFileChooser fileChooser) {
      String path = null;

      /* create a JFrame to be the parent of the file
       * chooser open dialog if you don't do this then
       * you may not see the dialog.
       */
      JFrame frame = new JFrame();
      frame.setAlwaysOnTop(true);

      // get the return value from choosing a file
      int returnVal = fileChooser.showOpenDialog(frame);

      // if the return value says the user picked a file
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         path = fileChooser.getSelectedFile().getPath();
      }
      return path;
   }

   /**
    * Method to let the user pick a file and return
    * the full file name as a string.  If the user didn't
    * pick a file then the file name will be null.
    *
    * @return the full file name of the picked file or null
    */
   public static String pickAFile() {
      JFileChooser fileChooser = null;

      // start off the file name as null
      String fileName = null;

      // get the current media directory
      String mediaDir = getMediaDirectory();

      /* create a file for this and check that the directory exists
       * and if it does set the file chooser to use it
       */
      try {
         File file = new File(mediaDir);
         if (file.exists()) {
            fileChooser = new JFileChooser(file);
         }
      }
      catch (Exception ex) {
      }

      // if no file chooser yet create one
      if (fileChooser == null) {
         fileChooser = new JFileChooser();
      }

      // pick the file
      fileName = pickPath(fileChooser);

      return fileName;
   }

   /**
    * Method to let the user pick a directory and return
    * the full path name as a string.
    *
    * @return the full directory path
    */
   public static String pickADirectory() {
      JFileChooser fileChooser = null;
      String       dirName     = null;

      // get the current media directory
      String mediaDir = getMediaDirectory();

      // if no file chooser yet create one
      if (mediaDir != null) {
         fileChooser = new JFileChooser(mediaDir);
      }
      else {
         fileChooser = new JFileChooser();
      }

      // allow only directories to be picked
      fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

      // pick the directory
      dirName = pickPath(fileChooser);

      return dirName + "/";
   }

   /**
    * Method to get the full path for the passed file name
    *
    * @param fileName the name of a file
    * @return the full path for the file
    */
   public static String getMediaPath(String fileName) {
      String  path      = null;
      String  directory = getMediaDirectory();
      boolean done      = true;

      // if the directory is null
      if (directory == null) {
         // try to find the mediasources directory
         try {
            // get the URL for where we loaded this class
            Class currClass = Class.forName("FileChooser");
            URL   classURL  = currClass.getResource("FileChooser.class");
            URL   fileURL   = new URL(classURL, "../mediasources/");
            directory = fileURL.getPath();
            File dirFile = new File(directory);
            if (dirFile.exists()) {
               setMediaPath(directory);
               done = true;
            }
         }
         catch (Exception ex) {
         }
         if (!done) {

            SimpleOutput.showError(
                    "The media path (directory)" + " has not been set yet!  " + "Please pick the directory " + "that contains your media " +
                    "(usually called mediasources) " + "with the following FileChooser.  " + "The directory name will be stored " +
                    "in a file and remain unchanged unless you use " + "FileChooser.pickMediaPath() or " +
                    "FileChooser.setMediaPath(\"full path name\") " +
                    "(ex: FileChooser.setMediaPath(\"c:/intro-prog-java/mediasources/\")) " + " to change it.");
            pickMediaPath();
            directory = getMediaDirectory();
         }
      }
      // get the full path
      path = directory + fileName;
      return path;
   }

   /**
    * Method to get the directory for the media
    *
    * @return the media directory
    */
   public static String getMediaDirectory() {
      String  directory = null;
      boolean done      = false;

      // check if the application properties are null
      if (appProperties == null) {
         appProperties = new Properties();

         // load the properties from a file
         try {
            // get the URL for where we loaded this class
            Class  currClass = Class.forName("FileChooser");
            URL    classURL  = currClass.getResource("FileChooser.class");
            URL    fileURL   = new URL(classURL, PROPERTY_FILE_NAME);
            String path      = fileURL.getPath();
            path = path.replace("%20", " ");
            FileInputStream in = new FileInputStream(path);
            appProperties.load(in);
            in.close();
         }
         catch (Exception ex) {
            directory = null;
         }
      }

      // get the media directory
      if (appProperties != null) {
         directory = (String) appProperties.get(MEDIA_DIRECTORY);
      }
      File dirFile = null;

      // check if the directory exists
      if (directory != null) {
         dirFile = new File(directory);
      }

      if (directory == null || !dirFile.exists()) {
         // try to find the mediasources directory
         try {
            // get the URL for where we loaded this class
            Class currClass = Class.forName("FileChooser");
            URL   classURL  = currClass.getResource("FileChooser.class");
            URL   fileURL   = new URL(classURL, "../mediasources/");
            directory = fileURL.getPath();
            dirFile = new File(directory);
            if (dirFile.exists()) {
               setMediaPath(directory);
            }
         }
         catch (Exception ex) {
         }
      }

      return directory;
   }

   /**
    * Method to set the media path by setting the directory to use
    *
    * @param directory the directory to use for the media path
    */
   public static void setMediaPath(String directory) {

      // check if the directory exists
      File file = new File(directory);
      if (!file.exists()) {
         System.out.println("Sorry but " + directory + " doesn't exist, try a different directory.");
         FileChooser.pickMediaPath();
      }

      else {

         /* check if there is an application properties object
          * and if not create one
          */
         if (appProperties == null) {
            appProperties = new Properties();
         }

         // set the media directory property
         appProperties.put(MEDIA_DIRECTORY, directory);

         // write out the application properties to a file
         try {

            // get the URL for where we loaded this class
            Class  currClass = Class.forName("FileChooser");
            URL    classURL  = currClass.getResource("FileChooser.class");
            URL    fileURL   = new URL(classURL, PROPERTY_FILE_NAME);
            String path      = fileURL.getPath();
            path = path.replace("%20", " ");
            FileOutputStream out = new FileOutputStream(path);
            appProperties.store(out, "Properties for the Simple Picture class");
            out.close();
            System.out.println("The media directory is now " + directory);
         }
         catch (Exception ex) {
            System.out.println("Couldn't save media path to a file");
         }
      }
   }

   /**
    * Method to pick a media path using
    * the file chooser and set it
    */
   public static void pickMediaPath() {
      String dir = pickADirectory();
      setMediaPath(dir);
   }

}
