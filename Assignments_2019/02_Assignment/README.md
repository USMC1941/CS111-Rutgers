# Hello, world – 20 course points

The purpose of this assignment is to introduce you to programming in Java and to familiarize you with the process of preparing and submitting programming assignments. You will learn how to use the VSCode editor to edit Java files, use the command line to compile and execute your programs, as well as submit your assignment on Autolab.

Refer to our [Programming Assignments FAQ](https://introcs.cs.rutgers.edu/assignment-faq/) for instructions on how to install VSCode, how to use the command line and how to submit your assignments.

## Programming
Write 3 programs and submit on Autolab.

We provide the files [`HelloWorld.java`](HelloWorld.java), [`WindChill.java`](WindChill.java), and [`OrderCheck.java`](OrderCheck.java). For each problem UPDATE and SUBMIT the corresponding file.

Observe the following rules:

- DO NOT use `if` statements on this assignment
- DO NOT add any import statements
- DO NOT add the project statement
- DO NOT change the class name
- DO NOT change the headers of ANY of the given methods
- DO NOT add any new class fields
- DO NOT use [System.exit()](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/System.html#exit(int))
- Observe the examples output, display only what the problem is asking for

1. *Hello, World* [5 points]. This is everyone’s first program. Write a program `HelloWorld.java` that, when run, displays the phrase: `Hello, World`.
   ```sh
   % java HelloWorld
   Hello, World
   ```
2. *Wind chill* [8 points]. Given the temperature `T` (in degrees Fahrenheit) and the wind speed `v` (in miles per hour), the National Weather Service defines the effective temperature (the wind chill) as follows:
   ```
   w = 35.74 + 0.6215 T + (0.4275 T – 35.75) v^0.16
   ```
   Write a program `WindChill.java` that takes two double command-line arguments temperature and velocity and prints the wind chill. Use [Math.pow(a, b)](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Math.html#pow(double,double)) to compute `a^b`.
   
   Notes:
   1. `a^b` means `a` to the power of `b`.
   2. The formula is not valid if `T` is larger than 50 in absolute value or if `v` is larger than 120 or less than 3 (assume that the input values testing your program are in range).
   3. It is not necessary to round the wind chill value, display the value that is computed.
   ```sh
   java WindChill 35.0 10.0
   27.445420
   ```
3. *Order check* [7 points]. Write a program `OrderCheck.java` that takes four int command-line arguments `w`, `x`, `y`, and `z`. Define a boolean variable whose value is true if the four values are either in strictly ascending order (w < x < y < z) or strictly descending order (w > x > y > z), and false otherwise. Then, display the boolean variable value.

   Notes:
   1. Do not use `if` statements on this program.
   2. Assume that the inputs will always be integers.
   ```sh
   java OrderCheck 5 10 15 2
   false

   java OrderCheck 15 11 9 4
   true
   ```

## Before submission

4. Collaboration policy. Read our collaboration policy [here](https://introcs.cs.rutgers.edu/#academic-integrity).
5. Update `@author`. Update the `@author` tag of the files with your name, email and netid.
6. Submitting the assignment. Submit `HelloWorld.java`, `WindChill.java`, and `OrderCheck.java` separately via the web submission system called Autolab. To do this, click the Assignments link from the course website; click the Submit link for that assignment.

## Getting help

If anything is unclear, don’t hesitate to drop by office hours or post a question on Piazza. Find instructors office hours by clicking the [Staff](https://introcs.cs.rutgers.edu/staff/) link from the course website. You are welcome to ANY professor office hours.

In addition to office hours we have the [CAVE](https://resources.cs.rutgers.edu/docs/rooms-equipment/cave/) (Collaborative Academic Versatile Environment), a community space staffed with lab assistants which are undergraduate students further along the CS major to answer questions.