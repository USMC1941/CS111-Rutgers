# Conditionals and Loops – 60 course points

Observe the following rules:

-  DO NOT add any import statements
-  DO NOT add the project statement
-  DO NOT change the class name
-  DO NOT change the headers of ANY of the given methods
-  DO NOT add any new class fields
-  DO NOT use `System.exit()`
-  ONLY print the result as specified by each problem. DO NOT print other messages, follow the examples for each problem.

## Check Digit

Write a program [`CheckDigit.java`](CheckDigit.java) that takes a 12 or 13-digit long as a command-line argument and displays the digit computed as follows:

1. Take for an example the number `048231312622`
2. Sum every other digit of the code, starting from the right. In the example, that is `2 + 6 + 1 + 1 + 2 + 4 = 16`. Discard the tens digit and keep the ones digit, 6.
3. Start with the second to last digit and do the same thing. Sum the digits, discard the tens digit and keep the ones digit. In this example this is `2 + 2 + 3 + 3 + 8 + 0 = 18`. Discarding the 10 leaves 8. Multiply this number by 3 and again discard the tens digit. `8 * 3 = 24`, leaving 4.
4. Add the numbers from steps 1 and 2. Again drop the tens digit. `6 + 4 = 10`, leaving the digit 0 (zero).

Hints:

1. The maximum value that can be stored in an integer variable is `2147483647` which is only 10 digits long. To read a 12 or 13-digit integer from command line argument you will need to store it in a `long` variable. Use:

   ```java
   long number = Long.parseLong(args[0]);
   ```

   to read a `long` from the command line.

2. To extract the rightmost digit of a number use the modulus operator.
3. To remove the rightmost digit of a number use the integer division by 10
4. For full credit use a loop to compute the sums

Assume the input value used to test your program is a 12 or 13-digit positive integer.

```sh
java CheckDigit 048231312622
0

java CheckDigit 9780470454310
8
```
