# Final Exam Practice Assignment

## Overview
For this assignment, you will write several programs, methods, and classes. **You will NOT hand in any files**. This assignment is only practice for the Final Exam. **It is not a "practice exam"**. The actual exam will not be this length or have this many questions.

Whenever you write code in this assignment, you should construct a set of test cases to thoroughly test your code. You may need to write a simple test driver program to execute your test cases.

## Problems

The first 2 problems are on Strings.

### Problem 1

#### Part 1

Your program should take a string representing a sentence in English and format it properly. The input sentence may have any or all of the following errors:
* Random letters may be capitalized.
* The sentence may not end with a proper punctuation mark (period, question mark, or exclamation point).
* There may be spaces at the beginning or end, or more than one space between words.

Format the sentence to fit the following rules:
* The first letter of the first word should be capitalized.
* The word "I" should be capitalized.
* All other letters in all words should be in lowercase.
* The sentence should end with a punctuation mark. If the original sentence did not end with a punctuation mark, add a period. (If the original sentence ended with more than one punctuation mark, it is not your responsibility to detect or fix this. However, you should not cause this problem yourself by adding a period if the sentence already ends with a punctuation mark.)
* There should be no spaces at the beginning or end of the sentence.
* There should be only a single space between words.

Example:
```sh
java Sentence
  corRect pUNCtuation    is hard, i  tHINk
RESULT: Correct punctuation is hard, I think.
```
#### Part 2

Create a **method** that does the same thing as your program, but takes its input from, and provides its output to, a calling program (do not use the IO module to interact with a human user). Define appropriate arguments (inputs) and return type, and implement this method. Test your method by calling it from another program.

### Problem 2
Ask the user for a sentence (one string). Take each word and reverse the order of its letters, keeping the order of the words unchanged. Output the modified sentence (one string). Assume that the sentence is properly capitalized and ends with a period, and do the same to the output. You may assume that the input does not contain digits, punctuation, or extraneous spaces.

Example:
```sh
java ReverseWords
The quick brown fox jumps over the lazy dog.
RESULT: "Eht kciuq nworb xof spmuj revo eht yzal god."
```
---
The following three problems should be solved recursively. Do not use any loops (while, do/while, or for) Do not use any static variables.

### Problem 3
Write a method that takes a decimal number x and an integer n. Round x to n decimal places (for example, 0 means round to the nearest integer, 1 means round to the nearest tenth, etc.).

### Problem 4
Write a method that takes a string and produces a backwards version of it. (for example, "good gravy" backwards is "yvarg doog").

### Problem 5
Consider the square spiral program you wrote in Recitation. Write a recursive method (and helper method, if necessary) to draw a square spiral, where the number of revolutions (turns) of the spiral is an input. Use the [`Drawing.java`](Drawing.java) class that you have used in prior homeworks and lectures.

---
This problem is on Arrays.
### Problem 6
Write your code in the file [`CellPhoneBook.java`](CellPhoneBook.java).

`CellPhoneBook` is a user's cellphone number directory. The user can enter the names of his or her acquaintances and their cellphone numbers, and later he or she can look up a particular person's phone number when needed.

We have written part of the program for you already. The program you are given inputs the maximum number of entries the phone book can hold, then displays a menu to the user. You will complete the program by doing the following:
* Adding any needed variables and initializing them
* Writing code to respond to each of the menu options

Complete the following menu options of `CellPhoneBook`. You may write additional methods if you wish.
> Put the given entry into the phone book. Output true if successful. This method should run in `O(1)` time. You do not have to check for duplicate entries.
* Add entry
  * inputs: contact's name (string), contact's phone number (string)
  * outputs: success/failure (boolean)

> Remove the given entry from the phone book. Output true if successful. Finding the entry may take up to O(n) time where n is the number of entries. However, after finding the entry, deleting it should take `O(1)` time. You do not have to check for duplicate entries.
* Delete entry
  * inputs: contact's name (string)
  * outputs: success/failure (boolean)

> Retrieve the cellphone number recorded for the person with the given name. If no entry for that person exists, output null. **Use binary search if possible, and sequential search if not.**
* Lookup cell number
  * inputs: contact's name (string)
  * outputs: contact's phone number (string)

> Change the cellphone number for the given person to the specified new number. Output true if successful. **Use binary search if possible, and sequential search if not.**
* Change cell number
  * inputs: contact's name (string), contact's new phone number (string)
  * outputs: success/failure (boolean)

> Sort the entries in the given phone book alphabetically by name, and display them. **Use quicksort.**
* Sort entries
  * inputs: none
  * outputs: names and phone numbers in alphabetical order (strings)

Remember to test each of your menu options thoroughly.

---
This problem is on 2D Arrays.

### Problem 7
In this problem you will write methods to help implement a tic-tac-toe game. To simplify, tic-tac-toe is a game played on a 3 by 3 grid by two players, one of whom makes X marks in the grid, and the other of whom makes O marks. Players alternate placing marks. The winner is the first player to get 3 of their own marks in a row on the grid.

Assume that the game board is represented by a 2D array of type `char`. Entries in the array can either be `'X'`, `'O'`, or `'  '` (space). Spaces indicate that neither player has placed a mark in that entry.

#### Part 1
Consider an extension of tic-tac-toe played on an `N` by `N` grid, where `N` is some positive number. The goal is now to get `N` marks in a row, rather than 3. Write a method that takes a tic-tac-toe board as a 2D array of type `char`, and determines who (if anyone) has won the game. Return `'X'` if player X won, `'O'` if player O won, and `' '` (space) if no one has won.

#### Part 2
Consider a further extension of the game where there is some number `K`, and exactly `K` marks in a row are needed to win the game. `K` may be different from `N`, the size of the grid. Write a method that determines who (if anyone) has won this game.

---
This problem is on Efficiency Analysis.

### Problem 8
For each code segment given below, do the following:
1. Identify the factors that would influence the running time, and which can be known before the algorithm or code is executed. Assign names (such as `n`) to each factor.
2. Identify the operations that must be counted. You need not count every statement separately. If a group of statements always executes together, treat the group as a single unit. If a method is called, and you do not know the running time of that method, count it as a single operation.
3. Count the operations performed by the algorithm or code. Express the count as a function of the factors you identified in Step 1. If the count cannot be expressed as a simple function of those factors, define the bounds that can be placed on the count: the best case (lower bound) and worst case (upper bound).
4. Transform your count formula into big-O notation by:
    * Dropping insignificant terms.
    * Dropping constant coefficients.

**Fully explain your answers.**

1.
```java
double[] combine(double[] array1, double[] array2) {
  double[] result = new double[array1.length + array2.length];
  int r = 0;
  for (int i = 0; i < array1.length; i++) {
    result[r] = array1[i];
    r++;
  }
  for (int i = 0; i < array2.length; i++) {
    result[r] = array2[i];
    r++;
  }
  return result;
}
```
2.
```java
void foo(int[] array) {
  int i = 0;
  while (i < array.length) {
    System.out.println(array[i]);
    if (array[i] == 0) {
      array[i] = -1;
      i = 0;
    }
    else {
      i++;
    }
  }
}
```
3.
```java
void countsort(int[] array) {
  // assume no negative values in array
  int max = array[0];
  for (int i = 1; i < array.length; i++) {
    if (array[i] > max) {
      max = array[i];
    }
  }
  int[] counts = new int[max + 1];
  for (int i = 0; i < array.length; i++) {
    counts[array[i]]++;
  }
  int i = 0;
  for (int j = 0; j < counts.length; j++) {
    for (int c = 0; c < counts[j]; c++) {
      array[i] = j;
      i++;
    }
  }
}
```
4.
```java
double sum(double[] array) {
  return recursiveSum(array, 0, array.length - 1);
}

double recursiveSum(double[] array, int lo, int hi) {
  if (lo == hi) {
    return array[lo];
  }
  int    mid      = (lo + hi) / 2;
  double leftsum  = recursiveSum(array, lo, mid);
  double rightsum = recursiveSum(array, mid + 1, hi);
  return leftsum + rightsum;
}
```
5.
```java
double maximum(double[] array) {
  return maximum(array, 0);
}

double maximum(double[] array, int startIndex) {
  if (startIndex == array.length - 1) {
    return array[array.length - 1];
  }
  //
  if (array[startIndex] > maximum(array, startIndex + 1)) {
    return array[startIndex];
  }
  else {
    return maximum(array, startIndex + 1);
  }
}
```
---
The next 3 problems are on Searching and Sorting.

### Problem 9
1. Trace selection sort on the following array of letters (sort into alphabetical order):
```
J W U D T A Q E P D
```
After each pass (outer loop iteration) of selection sort, show the contents of the array and the number of letter-to-letter comparisons performed on that pass (an exact number, not big-O).

2. Trace insertion sort on the following array of letters (sort into alphabetical order):
```
J W U D T A Q E P D
```
After each pass (outer loop iteration) of insertion sort, show the contents of the array and the number of letter-to-letter comparisons performed on that pass (an exact number, not big-O).

3. Trace quicksort on the following array of letters (sort into alphabetical order):
```
J W U D T A Q E P D
```
For each recursive quicksort call, show the part of the array that is being sorted both before and after the partition step. Then show the number of letter-to-letter comparisons performed during that partition (an exact number, not big-O).

4. Trace binary search for the letter P on the following array of letters:
```
A D D E J P Q T U W
```
For each iteration of binary search, show the part of the array that is still being searched. List all letter-to-letter comparisons made during the search.

5. Trace binary search for the letter B on the following array of letters:
```
A D D E J P Q T U W
```
For each iteration of binary search, show the part of the array that is still being searched. List all letter-to-letter comparisons made during the search.

### Problem 10
Write a method that performs reverse insertion sort on an array of strings. In other words, the sorted section of the array should be at the right end (highest indexes). Items should be inserted into the sorted section by being shifted rightwards.

### Problem 11
Write a method that inserts a string into a sorted array of strings. Assume that the array is not full - take an input that tells you how many actual strings are in the array (the array is being used as a container).
Since the strings are sorted, use binary search to locate the insertion point. You will have to shift items to the right by one slot in order to make room for the item being inserted.

The item to be inserted will not be in the array, so locating the insertion point requires letting the search fail and recording where in the array you are when it fails. You must think carefully about the precise index at which to insert the new item after this.

---
The next 2 problems are on Defining Classes.

### Problem 12

Write your code in the file [`HotelRoom.java`](HotelRoom.java).
A `HotelRoom` object represents a reservation for a hotel room. The following types of rooms are available:

|    room type   | price per night |
|:--------------:|:---------------:|
|     single     |      $80.00     |
|     double     |     $120.00     |
| business suite |     $200.00     |

According to the hotel's reservation policy, if a guest checks out earlier than expected (stays for fewer days than the room was reserved for), they are charged a $5.00 cancellation fee for every day that was reserved but not used (they are not charged the full room rate for unused days). There is no charge for staying longer than the room was reserved for.

Define appropriate fields and complete the following methods of `HotelRoom`:
* Making a reservation

Constructor: Initialize a `HotelRoom` object representing a reservation for the guest with the given name, in a room of the given type, for the given number of days.
```java
HotelRoom(String guestname, String roomtype, int days)
```
* Reviewing a reservation

Retrieve the name of the guest who made this reservation.
```java
String getGuestName()
```
Retrieve the type of room reserved.
```java
String getRoomType()
```
Retrieve the number of days for which the room is reserved.
```java
int getReservationLength()
```
Compute the estimated price of the hotel stay. This method should assume that the guest will stay for the reserved number of days.
```java
double getEstimatedPrice()
```
* Changing a reservation

Change type of room.
```java
void setRoomType(String roomtype)
```
Change number of days for which to reserve the room.
```java
void setReservationLength(int days)
```
* Checking out of the hotel

Compute the actual price that will be charged to the guest when they check out, after having stayed at the hotel for the given number of days.
```java
double getActualPrice(int daysStayed)
```

In [`HotelRoom.java`](HotelRoom.java), we have defined strings for the names of each type of room and stored them in `final` (unchangeable) fields. To avoid any chance of misspelling these, use the room type fields we have defined for you, rather than typing the room type names yourself.

You may use [`ReserveRooms.java`](ReserveRooms.java) to test your class. When responding to the prompts, use the terms "single", "double", and "business" to describe the type of room.

### Problem 13
Write your code in the file [`Polygon.java`](Polygon.java).

In file `Point.java`, a `Point` object represents a point in two-dimensional space, with a horizontal (x) coordinate and a vertical (y) coordinate. Each coordinate may have any real-number value. The `Point` class offers the following methods:

* Constructor: Takes x- and y-coordinates.
```java
Point(double x, double y)
```
* Returns the x-coordinate of this point.
```java
double getX()
```
* Returns the y-coordinate of this point.
```java
double getY()
```
* Returns the straight-line distance from this point to another.
```java
double distanceTo(Point other)
```
A `Polygon` object represents a multi-sided shape in two-dimensional space. It should support polygons with any number of sides.

Define appropriate fields, and complete the following methods of `Polygon`:

* Initialize a `Polygon` object that can have up to the specified number of vertices (the number of sides will be equal to the number of vertices).
```java
Polygon(int numvertices)
```
* Set the specified vertex to the given point in 2D space. Return true if successful.
```java
boolean setVertex(int vertexnumber, Point v)
```
* Compute the perimeter of this polygon (the sum of the lengths of its sides).
```java
double getPerimeter()
```
* Compute the area of this polygon. Use the [standard formula](https://en.wikipedia.org/wiki/Polygon#Area) for the area of a simple polygon.
```java
double getArea()
```

**You may assume that the user is responsible for selecting points that form a geometrically valid, simple polygon**. In particular, you can assume that the vertices will be in counterclockwise order, which is necessary to compute the perimeter and area without excessive difficulty.

You should write your own test driver to test your class. The following program will get you started: [`polyd.java`](polyd.java).
