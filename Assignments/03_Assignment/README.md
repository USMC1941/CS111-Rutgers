# Assignment 3

## Overview

For this assignment, you will develop Java programs to solve several problems. You will also write test cases with which to test the solutions.

If you know some Java already, you may use advanced features that we have not covered in class yet (though it is not necessary to do so). However, you may NOT use any modules or classes from outside java.lang (do not add any "import" statements to your programs).

## Problems 1 - 3 [String and character manipulations]

For all of the problems below, follow instructions explicitly. You are to name the files and methods exactly as written, or you will receive no credit.

### Links to Documentation

You may find some or all of the following methods of the [Character](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html) module useful:

-  [isDigit](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#isDigit-char-)
-  [isLetter](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#isLetter-char-)
-  [toLowerCase](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#toLowerCase-char-)
-  [toUpperCase](https://docs.oracle.com/javase/9/docs/api/java/lang/Character.html#toUpperCase-char-)

**Remember that a character is not an object in Java, so you cannot invoke methods on a character in the same way that you would on a string**. You call methods of this module as in this example:

```java
char c = 'a';
char c2 = Character.toUpperCase(c);
System.out.println(c2); // prints 'A'
```

You may also need to use some or all of the following [String](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#) methods:

-  [charAt](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#charAt-int-)
-  [compareTo](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#compareTo-java.lang.String-) (alphabetical order, case-sensitive)
-  [compareToIgnoreCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#compareToIgnoreCase-java.lang.String-) (alphabetical order, case-insensitive)
-  [concat](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#concat-java.lang.String-) (+)
-  [endsWith](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#endsWith-java.lang.String-)
-  [equals](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#equals-java.lang.Object-) (case-sensitive)
-  [equalsIgnoreCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#equalsIgnoreCase-java.lang.String-) (case-insensitive)
-  [indexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#indexOf-int-) (finds a single character)
-  [indexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#indexOf-java.lang.String-int-) (finds a string)
-  [lastIndexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#lastIndexOf-int-) (finds a single character)
-  [lastIndexOf](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#lastIndexOf-int-int-) (finds a string)
-  [length](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#length--)
-  [startsWith](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#startsWith-java.lang.String-)
-  [substring](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#substring-int-int-) (substring from start, up to but not including end)
-  [substring](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#substring-int-) (substring to end of string)
-  [toLowerCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#toLowerCase--)
-  [toUpperCase](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#toUpperCase--)
-  [trim](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#trim--) (trims spaces from ends of string)

## Problem 1

Write your code in the file `PigLatin.java`. The graders will ignore your main method. You may write your own main method to test your code. Your code should go into a method with the following signature:

```java
public static String translate (String original){}
```

"Pig Latin" is a fake language used as a children's game. A word in English is "translated" into Pig Latin using the following rules:

-  If the English word begins with a consonant, move the consonant to the end of the word and add "ay". The letter Y should be considered a consonant.
-  If the English word begins with a vowel (A, E, I, O, or U), simply add "way" to the end of the word.

(This is a simplified dialect of Pig Latin, of course.)

Write your method so that it returns the pig latin translated original string. **You may assume that the input does not contain digits, punctuation, or spaces**. The input may be in any combination of uppercase or lowercase. The case of your output does not matter.

---

## Problem 2

Write your code in the file `WordCount.java`. The graders will ignore your main method. You may write your own main method to test your code. Your code should go into a method with the following signature:

```java
public static int countWords(String original, int minLength){}
```

Your method should count the number of words in the sentence that **meet or exceed** minLength (in letters). For example, if the minimum length given is 4, your program should only count words that are at least 4 letters long.

Words will be separated by one or more spaces. Non-letter characters (spaces, punctuation, digits, etc.) may be present, but should not count towards the length of words.

Hint: write a method that counts the number of letters (and ignores punctuation) in a string that holds a single word without spaces. In your countWords method, break the input string up into words and send each one to your method.

---

## Problem 3

Write your code in the file `Compress.java`. The graders will ignore your main method. You may write your own main method to test your code. Your code should go into a method with the following signature:

```java
public static String compress (String original){}
```

Run-length encoding (RLE) is a simple "compression algorithm" (an algorithm which takes a block of data and reduces its size, producing a block that contains the same information in less space). It works by replacing repetitive sequences of identical data items with short "tokens" that represent entire sequences. Applying RLE to a string involves finding sequences in the string where the same character repeats. Each such sequence should be replaced by a "token" consisting of:

1. the number of characters in the sequence
2. the repeating character

If a character does not repeat, it should be left alone.

For example, consider the following string:

```
qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT
```

After applying the RLE algorithm, this string is converted into:

```
q9w5e2rt5y4qw2Er3T
```

In the compressed string, "9w" represents a sequence of 9 consecutive lowercase "w" characters. "5e" represents 5 consecutive lowercase "e" characters, etc.

Write a method called `compress()` that takes a string as input, compresses it using RLE, and returns the compressed string. Case matters - uppercase and lowercase characters should be considered distinct. **You may assume that there are no digit characters in the input string. There are no other restrictions on the input - it may contain spaces or punctuation**. There is no need to treat non-letter characters any differently from letters.
