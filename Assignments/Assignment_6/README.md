# Assignment 6

## Overview

For this assignment, you will develop a method.

We have created a "skeleton" Java file which you will fill in. This are linked in the "Attachments" section, below. Download the file and fill in code where specified. **You should test your methods by writing code in main() (either in the same file or a different file) to call your methods and execute your chosen test cases**.

If you know some Java already, you may use advanced features that we have not covered in class yet (though it is not necessary to do so). However, you may NOT use any modules or classes from outside java.lang (do not add any "import" statements to your programs).

## Input, output, and error conditions

When writing a *method*, inputs are provided directly through the method's arguments. Output should be returned using the `return` statement. Error conditions should be reported by returning an appropriate value (as described in the problem). Do not use the IO module.

Links to Documentation:

[Character](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html) module:

* [isDigit](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#isDigit-char-)
* [isLetter](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#isLetter-char-)
* [toLowerCase](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#toLowerCase-char-)
* [toUpperCase](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#toUpperCase-char-)

[String](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#) class:

* [charAt](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#charAt-int-)
* [compareTo](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#compareTo-java.lang.String-) (alphabetical order, case-sensitive)
* [compareToIgnoreCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#compareToIgnoreCase-java.lang.String-) (alphabetical order, case-insensitive)
* [concat](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#concat-java.lang.String-) (+)
* [endsWith](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#endsWith-java.lang.String-)
* [equals](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#equals-java.lang.Object-) (case-sensitive)
* [equalsIgnoreCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#equalsIgnoreCase-java.lang.String-) (case-insensitive)
* [indexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#indexOf-int-) (finds a single character)
* [indexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#indexOf-java.lang.String-int-) (finds a string)
* [lastIndexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#lastIndexOf-int-) (finds a single character)
* [lastIndexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#lastIndexOf-int-int-) (finds a string)
* [length](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#length--)
* [startsWith](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#startsWith-java.lang.String-)
* [substring](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#substring-int-int-) (substring from start, up to but not including end)
* [substring](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#substring-int-) (substring to end of string)
* [toLowerCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#toLowerCase--)
* [toUpperCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#toUpperCase--)
* [trim](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#trim--) (trims spaces from ends of string)

## Problems

### Problem 1

Write your code in the file `StringRec.java`. For this problem, the following restrictions apply:

* YOUR CODE MUST BE RECURSIVE.
* Do not use loops (`while`, `do`/`while`, or `for`).
* Do not declare any variables outside of a method. You may declare local variables inside a method.

Complete the following method:

`public static String decompress(String compressedText)`: Decompress the input text, which has been compressed using the RLE algorithm (previous hw assignment):

>  Run-length encoding (RLE) is a simple "compression algorithm" (an algorithm which takes a block of data and reduces its size, producing a block that contains the same information in less space). It works by replacing repetitive sequences of identical data items with short "tokens" that represent entire sequences. Applying RLE to a string involves finding sequences in the string where the same character repeats. Each such sequence should be replaced by a "token" consisting of:
> 1. the number of characters in the sequence
> 2. the repeating character
> 
> If a character does not repeat, it should be left alone. For example, consider the following string:
>
>`qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT`
>
>After applying the RLE algorithm, this string is converted into:
>
>`q9w5e2rt5y4qw2Er3T`
>
>In the compressed string, "9w" represents a sequence of 9 consecutive lowercase "w" characters. "5e" represents 5 consecutive lowercase "e" characters, etc.


You may assume that the character counts will be single-digit numbers (a character will not repeat more than 9 times consecutively).

Hint #1: remember that characters are represented by numeric codes. You can decrement a character variable as follows:

```
char c = '7';
c--;           // c will now hold the character '6'
```

Hint #2: You probably will not need to use this hint for this problem. However, a fast way to convert a digit character into the numeric value of the digit is to subtract the character code for the digit zero:

```
char c = '7';    // this has the character code 55, not 7
int x = c - '0'; // this produces the number 7
```

## Additional resources for assignment

[StringRec.java](StringRecjava)
