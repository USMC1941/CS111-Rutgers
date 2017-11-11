# Assignment 4

## Overview

For this assignment, you will develop Java *methods* as part of a single software application. You will not have to submit test cases, although you should test your code thoroughly using a good set of test cases.

## Problem 1

Write your code in the file `MatrixOps.java`.

Consider the following definitions from matrix algebra:

* A *vector* is a one-dimensional set of numbers, such as [42 9 20].
* The *dot product* of two equal-length vectors A and B is computed by multiplying the first entry of A by the first entry of B, the second entry of A by the second entry of B, etc., and then summing these products. For example, the dot product of [42 9 20] and [2 28 79] is 42* 2 + 9 * 28 + 20 * 79 = 1916.
*  A *matrix* is a two-dimensional set of numbers. For example, here is a matrix with 4 rows and 3 columns (each row or column can be treated as a vector):

```
	42   9  20
	 2  28  79
	19  -3   1
	37  55  64
````

* Two matrices A and B may be "multiplied" into a "product matrix" in the following manner: The number in row *i* and column *j* of the product matrix is the dot product of row *i* of matrix A and column *j* of matrix B. Since you must have equal-length vectors in order to compute a dot product, it follows that the number of columns in matrix A must be the same as the number of rows in matrix B. The product matrix will have as many rows as matrix A, and as many columns as matrix B. Example:

```
	 1   2          7   8   9        	(1*7 + 2*10)  (1*8 + 2*11)  (1*9 + 2*12)        		27  30  33
	 3   4    *   10  11  12    	=   	(3*7 + 4*10)  (3*8 + 4*11)  (3*9 + 4*12)    =    		61  68  75
	 5   6                           	(5*7 + 6*10)  (5*8 + 6*11)  (5*9 + 6*12)           		95 106 117
```
### Complete the following method of MatrixOps:

`public static double[][] multiply(double[][] A, double[][] B)`: Multiply matrices A and B. Return the product matrix. This method must work for matrices of any size (i.e., with any number of rows and/or columns). **Treat "rows" as the first dimension and "columns" as the second dimension. Return null if the matrices cannot be multiplied.**

Use `MatrixDriver.java` to test your method. MatrixDriver will ask you for the names of files containing matrices to multiply. Sample files `m1.txt` and `m2.txt` are provided for your use. **If your method works for this pair of matrices, that does NOT mean it will always work. You MUST create your own text files containing matrices, formatted like these samples, but with different numbers of rows and columns, in order to test your code.**

Example:

```
java MatrixDriver

Enter name of file containing first matrix:
m1.txt
Enter name of file containing second matrix:
m2.txt
product matrix:
0.0	-5.0
-6.0	-7.0
```
For this assignment, you should submit:

MatrixOps.java

## Additional resources for assignment

[MatrixDriver.java](MatrixDriver.java)

[MatrixOps.java](MatrixOps.java)

[m1.txt](m1.txt)

[m2.txt](m2.txt)
