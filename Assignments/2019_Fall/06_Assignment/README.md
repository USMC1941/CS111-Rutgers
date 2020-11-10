# Using Abstract Data Types – 50 course points

This assignment consists of two parts to exercise your ability to work with Strings and recursion.

Refer to our [Programming Assignments FAQ](https://introcs.cs.rutgers.edu/assignment-faq/) for instructions on how to install VSCode, how to use the command line and how to submit your assignments.

## Programming

Write 2 programs and submit on Autolab. We provide the files [`RecursiveAppend.java`](RecursiveAppend.java), and [`RunLengthEnconding.java`](RunLengthEncoding.java). For each problem update and submit the corresponding file.

Observe the following rules:

-  DO NOT use [`System.exit()`](<https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/System.html#exit(int)>)
-  DO NOT add the project or package statements.
-  DO NOT change the class name.
-  DO NOT change the headers of ANY of the given methods.
-  DO NOT add any new class fields.
-  ONLY display the result as specified by the example for each problem.
-  DO NOT print other messages, follow the examples for each problem
-  You may USE the `StdOut` library.

1. _Recursive Append_ (15 points). On `RecursiveAppend.java`, write a recursive method `appendNTimes` that receives two arguments, a string and an integer. The method `appendNTimes` returns the original string appended to the original string `n` times.

   Use the following method header

   ```java
   public static String appendNTimes (String original, int n) {

   }
   ```

   Examples:

   -  `appendNTimes("cat", 0)` returns `"cat"`
   -  `appendNTimes("cat", 1)` returns `"catcat"`
   -  `appendNTimes("cat", 2)` returns `"catcatcat"`

   The following restrictions apply to method `appendNTimes`:

   -  YOUR CODE MUST BE RECURSIVE
   -  Do not use loops (`while`, `do`/`while`, or `for`).
   -  Your code must return a string without extra space, comma or any other character that is not in the original string

   You may write your own main method to test your `appendNTimes` method. Autolab will ignore your main method.

2. _Run-length encoding_ (35 points). Data compression is used behind the scenes in computer systems quite often, computer files and other kinds of data can be compressed to a smaller size for easy storage or transportation. Later, they are decompressed and used in their original form. One basic idea is to find parts of the data that are identical to each other and use some kind of trick to describe that more efficiently.

   Run-length encoding (RLE) encodes a run of repetitions with the length of that run. RLE is a simple compression algorithm (an algorithm which takes a block of data and reduces its size, producing a block that contains the same information in less space). It works by replacing repetitive sequences of identical data items with short tokens that represent entire sequences. Applying RLE to a string involves finding sequences in the string where the same character repeats. Replace each such sequence by a token consisting of:

   1. the number of characters in the sequence
   2. the repeating character

   If a character does not repeat, it appears as a single character in the compressed string with no number preceding it.

   For example, consider the following string:

   ```
   qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT
   ```

   After applying the RLE algorithm, this string is converted into:

   ```
   q9w5e2rt5y4qw2Er3T
   ```

   In the compressed string, `"9w"` represents a sequence of 9 consecutive lowercase `"w"` characters. `"5e"` represents 5 consecutive lowercase `"e"` characters, etc.

   Write a RLE library by implementing the following API:

   ```java
   public class RunLengthEncoding {

      /**
      * Encodes the original string by finding sequences in the string
      * where the same character repeats.
      * <p>
      * Replace each such sequence by a token consisting of: the number
      * of characters in the sequence followed by the repeating character.
      * <p>
      * Write an iterative encode method.
      * Returns the encoded string.
      * @param original Original string
      * @return Encoded string
      */
      public static String encode(String original) {

      }

      /**
      * Decodes the original string encoded with the encode method.
      * Returns the decoded string.
      * <p>
      * YOUR decode METHOD MUST BE RECURSIVE.
      * Do not use while, do/while, or for loops.
      * @param original Original string encoded with the encode method.
      * @return Decoded string
      */
      public static String decode(String original) {

      }

      /**
      * Tests each of the API methods by directly calling them.
      * @param args Command line arguments
      */
      public static void main(String[] args) {

      }
   }
   ```

   For decode, you may assume that the character counts will be single-digit numbers (a character will not repeat more than 9 times consecutively).

   Hints:

   1. Remember that characters are represented by numeric codes. You can decrement a character variable as follows:

      ```java
      char c = '7';
      c--; // c will now hold the character '6'
      ```

   2. You can check if a character is a digit by using the [`isDigit(char)`](<https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Character.html#isDigit(char)>) method from the `Character` class as follows:

      ```java
      char c = '7';
      Character.isDigit(c); // returns true
      ```

   3. You probably will not need to use this hint for this problem. However, a fast way to convert a digit character into the numeric value of the digit is to subtract the character code for the digit zero:

      ```java
      char c = '7';    // this has the character code 55, not 7
      int x = c - '0'; // this produces the number 7
      ```

## Before submission

3. Collaboration policy. Read our collaboration policy [here](https://introcs.cs.rutgers.edu/#academic-integrity).
4. Update `@author`. Update the `@author` tag of the files with your name, email and netid.
5. Submitting the assignment. Submit `RecursiveAppend.java`, and `RunLengthEncoding.java` separately via the web submission system called Autolab. To do this, click the Assignments link from the course website; click the Submit link for that assignment.
