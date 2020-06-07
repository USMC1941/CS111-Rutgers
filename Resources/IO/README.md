# How to use the IO module in programming assignments

## Overview

For each programming assignment that requires direct input from or output to a human user, you should use the IO module as described below. When we grade your programs, we will replace this IO module with a different one, which interacts with our grading program rather than with a human user. This allows us to grade your programs automatically.

Make sure you place the file `IO.java` into the same folder as your program.

## Input

1. Use the IO module to obtain inputs.
2. Read the inputs in the precise order specified in the assignment.
3. Use the correct input method for the type of input you need. For example, if you need an integer, use `readInt`, not `readDouble`.

## Output

1. Use the methods of the IO module to output your FINAL ANSWERS ONLY.
2. Do NOT use the IO module to print messages asking for input, nor for debugging statements.
3. Anything your program prints using `System.out` will be ignored. If you wish, you may use `System.out` to print input prompts, verbose error messages, and debugging statements. This is entirely optional. All such statements will be ignored by the grading program.
4. Generate the outputs in the precise order specified in the assignment.
5. Use the correct output method for the type of output you produce. For example, if you need to output an integer, use `outputIntAnswer`, not `outputDoubleAnswer`.

The following table shows when you should and when you should not use the IO module for output:

|   What you are printing   | Is this required? | What you should use to print |
| :-----------------------: | :---------------: | :--------------------------: |
| Prompt messages for input |        No         |         `System.out`         |
|       Final answers       |        Yes        |     `IO.output___Answer`     |
|   Debugging statements    |        No         |         `System.out`         |

## Error conditions

Use the `reportBadInput` method of the IO module to signal error conditions. `reportBadInput` does not halt the program - you must still halt it yourself, if that is required.

## Examples

### Problem: Weight conversion

Write your code in the file `Convert.java`.
Your program should convert a weight in pounds to a weight in kilograms.

Solution:

```java
public class Convert {
   public static void main(String[] args) {
      double lbs, kgs;
      //
      lbs = IO.readDouble();
      //
      if (lbs <= 0) {
         IO.reportBadInput();
      }
      else {
         kgs = lbs / 2.2;
         IO.outputDoubleAnswer(kgs);
      }
   }
}
```

Alternate solution:

```java
public class Convert {
   public static void main(String[] args) {
      double lbs, kgs;
      //
      System.out.println("Enter weight in lbs"); // ignored by grading program
      lbs = IO.readDouble();
      //
      if (lbs <= 0) {
         System.out.println("Weight must be positive");  // ignored by grading program
         IO.reportBadInput();
      }
      else {
         kgs = lbs / 2.2;
         System.out.println("Weight in kgs: " + kgs); // ignored by grading program
         IO.outputDoubleAnswer(kgs);
      }
   }
}
```

### Problem: Area of rectangle

Write your code in the file `Rectangle.java`.
Your program should compute the area of a rectangle whose sides have whole-number lengths.

Solution:

```java
public class Rectangle {
   public static void main(String[] args) {
      int length, width, area;
      //
      length = IO.readInt();
      if (length <= 0) {
         IO.reportBadInput();
         return;
      }
      //
      width = IO.readInt();
      if (width <= 0) {
         IO.reportBadInput();
         return;
      }
      //
      area = length * width;
      IO.outputIntAnswer(area);
   }
}
```
