package bookClasses;

/**
 * Class that demonstrates search algorithms
 *
 * @author Mark Guzdial
 * @author Barb Ericson
 **/
public class Searcher {

   /**
    * Implement a linear search through the list
    */
   public static String linearFind(String target, String[] list) {
      for (int index = 0; index < list.length; index++) {
         if (target.compareTo(list[index]) == 0) {
            return ("Found it!");
         }
      }
      return ("Not found");
   }

   /**
    * Method to use a binary search to find a target string in a
    * sorted array of strings
    */
   public static String binaryFind(String target, String[] list) {
      int start      = 0;
      int end        = list.length - 1;
      int checkpoint = 0;

      while (start <= end) { //While there are more to search
         // find the middle
         checkpoint = (int) ((start + end) / 2.0);
         System.out.println("Checking at: " + checkpoint + " start=" + start + " end=" + end);
         if (target.compareTo(list[checkpoint]) == 0) {
            return "Found it!";
         }
         else if (target.compareTo(list[checkpoint]) > 0) {
            start = checkpoint + 1;
         }
         else if (target.compareTo(list[checkpoint]) < 0) {
            end = checkpoint - 1;
         }
      }
      return "Not found";
   }

   /** main for testing linearFind */
  /*
  public static void main(String[] args)
  {
    String[] searchMe = {"apple","bear","cat","dog","elephant"};
    System.out.println(linearFind("apple",searchMe));
    System.out.println(linearFind("cat",searchMe));
    System.out.println(linearFind("giraffe",searchMe));
  }
  */


   /**
    * Main for testing binary find
    */
   public static void main(String[] args) {
      String[] searchMe = {"apple", "bear", "cat", "dog", "elephant"};
      System.out.println(binaryFind("apple", searchMe));
      System.out.println(binaryFind("cat", searchMe));
      System.out.println(binaryFind("giraffe", searchMe));
   }
}
