# Conditionals and Loops – 35 course points
The purpose of this assignment is to practice conditionals and loops. You will write Java programs for the four algorithms that you wrote on Assignment 1 and for one new problem.

Refer to our [Programming Assignments FAQ](https://introcs.cs.rutgers.edu/assignment-faq/) for instructions on how to install VSCode, how to use the command line and how to submit your assignments.

## Programming
We provide the files [`LargestOfFive.java`](LargestOfFive.java), [`ISBNChecksum.java`](ISBNChecksum.java), [`LuckySevens.java`](LuckySevens.java), and [`TwoSmallest.java`](TwoSmallest.java). For each problem update and submit the corresponding file.

Observe the following rules:

- DO NOT use `if` statements on this assignment
- DO NOT add any import statements
- DO NOT add the project statement
- DO NOT change the class name
- DO NOT change the headers of ANY of the given methods
- DO NOT add any new class fields
- DO NOT use [System.exit()](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/System.html#exit(int))
- Observe the examples output, display only what the problem is asking for
- DO NOT print other messages, follow the examples for each problem.

1. *Largest of five* (5 points). Write an algorithm that read 5 distinct integers and displays the largest value. Assume the input values are distinct integers.
   ```sh
   java LargestOfFive 17 23 5 1 6
   23

   java LargestOfFive 8 3 -8 4 1
   8
   ```

2. Write a program `ISBNChecksum.java` that takes a 9-digit `int` as a command-line argument and displays the checksum digit according to the following rules:
   - Multiply the first digit by 10, the second by 9, the third by 8, and so on, down to the ninth digit by 2.
   - Add the values together.
   - Divide the sum by 11. What is the remainder?
   - If the remainder is 0, the checksum is 0; otherwise, subtract the remainder from 11 to get the checksum digit.
   - If the checksum that you come up with is 10, then X is used as the checksum digit!

   As an example, the checksum digit corresponding to `020131452` is 5 since 5 is the only value of x between 0 and 10 for which 
   ```
   10*0 + 9*2 + 8*0 + 7*1 + 6*3 + 5*1 + 4*4 + 3*5 + 2*2 + 1*x
   ```
   is a multiple of 11.

   Write an algorithm that reads an integer number of 9 digits and displays the checksum digit of the ISBN.

   Hints:
   1. To extract the rightmost digit of a number use the modulus operator.
   2. To remove the rightmost digit of a number use the integer division by 10
   3. For full credit use a loop to compute the sum

   Assume the input value is a 9-digit positive integer. Also assume that the input is a valid ISBN number without the checksum digit.
   ```sh
   java ISBNChecksum 313481157
   X

   java ISBNChecksum 153296217
   7
   ```

3. *Lucky Sevens*  (10 points). Write a program `LuckySevens.java` that takes an int as a command-line argument and displays how many digits in the integer number are 7s.

   Note: the number can be negative.
   ```sh
   java LuckySevens 3482
   0

   java LuckySevens 372777
   4

   java LuckySevens -2378272
   2
   ```

4. *Two Smallest*  (10 points). Write a program `TwoSmallest.java` that takes a set of `double` command-line arguments and prints the smallest and second-smallest number, in that order. It is possible for the smallest and second-smallest numbers to be the same (if the sequence contains duplicate numbers).

   Note: display one number per line.

   Hint: [`Double.MAX_VALUE`](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Double.html#MAX_VALUE) is the largest real number that can be stored in a `double` variable.
   ```sh
   java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
   0.3
   1.1

   java TwoSmallest 1.0 35.0 2.0 1.1 6.9 0.3 0.3 6.7
   0.3
   0.3
   ```

## Before submission
5. Collaboration policy. Read our collaboration policy [here](https://introcs.cs.rutgers.edu/#academic-integrity).
6. Update `@author`. Update the `@author` tag of the files with your name, email and netid.
7. Submitting the assignment. Submit `LargestOfFive.java`, `ISBNChecksum.java`, `LuckySevens.java`, and `TwoSmallest.java` separately via the web submission system called Autolab. To do this, click the Assignments link from the course website; click the Submit link for that assignment.

## Getting help

If anything is unclear, don’t hesitate to drop by office hours or post a question on Piazza. Find instructors office hours by clicking the [Staff](https://introcs.cs.rutgers.edu/staff/) link from the course website. You are welcome to ANY professor office hours.

In addition to office hours we have the [CAVE](https://resources.cs.rutgers.edu/docs/rooms-equipment/cave/) (Collaborative Academic Versatile Environment), a community space staffed with lab assistants which are undergraduate students further along the CS major to answer questions.