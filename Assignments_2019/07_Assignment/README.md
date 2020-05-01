# Searching, sorting and efficiency analysis – 20 course points
For this assignment, you will complete searching/sorting tasks and efficiency analysis. No code is to be written for this assignment.

The file [`Searchsort.java`](SearchSort.java) contains the implementations of several algorithms.

1. *Binary Search*. Search for the character S using the binary search algorithm on the following array of characters:
   ```
   A E G K M O R S Z
   ```
   For each iteration of binary search use a table similar to the table below to list:
      1. The left index
      2. The right index of the array that denote the region of the array that is still being searched
      3. The middle point of the array
      4. The character-to-character number of comparisons made during the search. Refer to the lines in the binary search algorithm:
      ```java
      public static int binarySearch(char[] chars, char target) {
         // ...
         if (chars[middle] == target) {
            //
         }
         else if (target < chars[middle]) {
            //
         }
         // ...
      }
      ```
      Table:

      | Iteration | Left | Right | Middle | Number of comparisons |
      |-----------|------|-------|--------|-----------------------|
      |           |      |       |        |                       |
      |           |      |       |        |                       |

2. *Selection sort*. List the resulting array after each iteration of the outer loop of the selection sort algorithm. Indicate the number of character-to-character comparisons made for each iteration. Sort the following array of characters (sort into alphabetical order)
   ```
   C Q S A X B T
   ```
   For the comparison, refer to the line in the Selection Sort algorithm:
   ```java
   public static void selectionSort(char[] chars) {
      // ...
      if (chars[j] < chars[min]) {
         //
      }
      // ...
   }
   ```

3. *Insertion sort*. List the resulting array after each iteration of the outer loop of the insertion sort algorithm. Indicate the number of character-to-character comparisons made for each iteration (line 06 of the Insertion Sort algorithm). Sort the following array of characters (sort into alphabetical order)
   ```
   C Q S A X B T
   ```

   For the comparison, refer to the lines in the Insertion Sort algorithm:
   ```java
   // ...
   public static void insertionSort(char[] chars) {
      // ...
      if (chars[j - 1] > chars[j]) {
         //
      }
      // ...
   }
   ```

4. *Mergesort*. List the resulting array after each iteration of the mergesort algorithm. Indicate the number of character-to-character comparisons made for each call to merge (line 22 of the Merge algorithm). Sort the following array of characters (sort into alphabetical order)
   ```
   C Q S A X B T
   ```

   For the comparisons, refer to the lines in the Merge sort algorithm:
   ```java
   //...
   public static void merge(char[] chars, int l, int m, int r) {
      // ...
      if (chars[j] < b[i]) {
         //
      }
      // ...
   }
   ```

5. *Efficiency Analysis*. For each problem given below, do the following:
   1. Create an algorithm in pseudocode to solve the problem.
   2. Identify the factors that would influence the running time of your algorithm. For example, if your algorithm is to search an array the factor that influences the running time is the array size. Assign names (such as `n`) to each factor.
   3. Count the operations performed by the algorithm. Express the count as a function of the factors you identified in Step 2. To do that, identify the basic operations of the algorithm. There is no need count every statement separately only the ones that will influence the running time.
   4. Describe the best case scenario for the algorithm and derive the big O.
   5. Describe the worst case scenario for the algorithm and derive the big O.

   The problems are:
   1. Determine if two arrays have no elements in common.
   2. Counting the total number of characters that have a duplicate within a string, including spaces. (i.e. `"gigi the gato"` would result in 9 (`g * 3 + i * 2 + t * 2 + " " * 2`)
   3. Finding a row where every entry is `'x'` in a 2-D array.

## Before submission
6. *Collaboration policy*. Read our collaboration policy [here](https://introcs.cs.rutgers.edu/#academic-integrity).
7. *Writeup*. Use your preferred text editor to type your answers, and then save the file in PDF format. We will only grade typed assignments and in PDF format. You will use Gradescope to submit your assignment. If you have not yet used Gradescope, go to your scarletmail inbox and look for an email from Gradescope with instructions on how to access your account.
8. *Submitting the assignment*. Submit your assignment  via the Web submission system called Gradescope. To do this, click the Assignments link from the course website; click the Submit link for that assignment.
9. Read Help − > Student Workflow − > Submitting a PDF for instructions on how to submit your PDF file.

## Getting help
If anything is unclear, don’t hesitate to drop by office hours or post a question on Piazza. Find instructors office hours by clicking the Staff link from the course website.
