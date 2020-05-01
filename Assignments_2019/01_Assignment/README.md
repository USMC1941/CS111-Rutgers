# Pseudocode, test cases, and counting operations – 20 course points

In this assignment you will develop algorithms for problems described below, write test cases that exercise all the possible algorithm execution paths, and calculate the number of operations that are executed in certain algorithmic paths.

## Assignment

For each of the following problems provide:

- inputs
- outputs
- error conditions
- an algorithm using the pseudocode reference used in class
- a set of test cases
- the minimum number of operations executed in your algorithm
- the maximum number of operations executed in your algorithm

1. *Largest*. Write an algorithm that read 5 distinct integers and displays the largest value. Assume the input values are distinct integers.
2. *ISBN*. The International Standard Book Number (ISBN) is a 10-digit code that uniquely specifies a book. The rightmost digit is a checksum digit that can be uniquely determined from the other 9 digits in the following manner:
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
   - Hint 1: to extract the rightmost digit of a number use: COMPUTE digit AS number MODULUS 10
   - Hint 2: to remove the rightmost digit of a number use: COMPUTE number AS number / 10
   - Hint 3: for full credit use a loop to compute the sum

   Assume the input value is a 9-digit positive integer. Also assume that the input is a valid ISBN number without the checksum digit.

## Before submission

3. Collaboration policy. Read our collaboration policy [here](https://introcs.cs.rutgers.edu/#academic-integrity).
4. Writeup. Use your preferred text editor to type your answers, and then save the file in PDF format. We will only grade typed assignments and in PDF format. You will use [Gradescope](https://www.gradescope.com/) to submit your assignment. If you have not yet used Gradescope, go to your scarletmail inbox and look for an email from Gradescope with instructions on how to access your account.
5. On Gradescope read. Help − > Student Workflow − > Submitting a PDF for instructions on how to submit your PDF file.
6. Submitting the assignment. Submit your assignment via the Web submission system called Gradescope. To do this, click the Assignments link from the course website; click the Submit link for that assignment.

## Getting help

If anything is unclear, don’t hesitate to drop by office hours or post a question on Piazza. Find instructors office hours by clicking the [Staff](https://introcs.cs.rutgers.edu/staff/) link from the course website. You are welcome to ANY professor office hours.

In addition to office hours we have the [CAVE](https://resources.cs.rutgers.edu/docs/rooms-equipment/cave/) (Collaborative Academic Versatile Environment), a community space staffed with lab assistants which are undergraduate students further along the CS major to answer questions.