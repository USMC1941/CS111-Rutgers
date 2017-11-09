# Assignment 1 - Fall 2015

## Overview

For this assignment, you will develop programs to solve several problems. For **ALL** you will write Java programs.

Submit problem analysis and test cases for this assignment in a file called `assign1.txt`. You should test your programs thoroughly to make sure they work. The assignment will be graded by running each program against our own set of test cases and giving credit for correct output.

### Problem 1 (Warmup)

Write and submit your code in a file called `Sum.java`. Use the [IO module](https://github.com/USMC1941/CS111-Rutgers/blob/master/Resources/IO/IO.java) to read inputs. Use `IO.outputIntAnswer()` to print your answer (refer to the documentation below for usage instructions).

Ask the user for 2 integers. Output the sum of those 2 numbers. Example:
```
Enter the first number:
5
Enter the second number:
-3

Result: 2
```

### Problem 2

Write and submit your code in a file called `Poly.java`. Use the [IO module](https://github.com/USMC1941/CS111-Rutgers/blob/master/Resources/IO/IO.java) to read inputs. Use `System.out.println()` to print your answer.

Write a program that generates a canonical-form, degree-3 (cubic) polynomial given its roots. For example, if the roots are 5, -3, and 2, the polynomial equation is

```
(x - 5)(x + 3)(x - 2) = 0
```

The canonical form of the polynomial is therefore

```
x^3 - 4x^2 - 11x + 30
```

The above is just text, not code that could appear in a Java program.

Ask the user for three roots (integers). Output the canonical form of the polynomial with those roots (as text) using `System.out.println()`, as in the following example:

```
java Poly

Enter the first root:
5
Enter the second root:
-3
Enter the third root:
2

The polynomial is:
x^3 - 4x^2 - 11x + 30
```

### Problem 3

Write and submit your code in a file called `Intersect.java`. Use the [IO module](https://github.com/USMC1941/CS111-Rutgers/blob/master/Resources/IO/IO.java) to read inputs. Use `System.out.println()` to print your answer.

Write a program that calculates the intersection between 2 equations:

a degree-2 (quadratic) polynomial i.e.  

```
y = dx^2 + fx + g
```

where d, f, and g are constants

and a degree-1 (linear) equation i.e.

```
y = mx + b
```

where m is the slope and b is a constant

The above is just text, not code that could appear in a Java program.

Ask the user for the constant values in each equation. Output the intersection(s) as ordered pair(s) (x,y), or "none" if none exists. Below is an example run.

```
java Intersect

Enter the constant d:
5
Enter the constant f:
-3
Enter the constant g:
2
Enter the constant m:
1
Enter the constant b:
3

The intersection(s) is/are:
(1,4)
(-0.20,2.8)
```

For this assignment, you should be submitting 4 files:

1. Sum.java


2. Poly.java


3. Intersect.java


4. assign1.txt

<br>
Failure to follow directions will result in point penalties.

### Additional resources for assignment
[How-To-Use-The-IO-Module-In-Programming-Assignments.html](https://github.com/USMC1941/CS111-Rutgers/blob/master/Resources/IO/How-To-Use-The-IO-Module-In-Programming-Assignments.html)

[IO.html](https://github.com/USMC1941/CS111-Rutgers/blob/master/Resources/IO/IO.html)

[IO.java](https://github.com/USMC1941/CS111-Rutgers/blob/master/Resources/IO/IO.java)
