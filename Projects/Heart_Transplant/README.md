# Heart Transplant – 100 course points

This assignment consists of creating an abstract data type called `HeartTransplant`, where you will match available donor hearts to recipients waiting for transplant.

Refer to our [Programming Assignments FAQ](https://introcs.cs.rutgers.edu/assignment-faq/) for instructions on how to install VSCode, how to use the command line and how to submit your assignments.

## Programming
Update and submit the file [`HeartTransplant.java`](HeartTransplant/src/HeartTransplant.java) on Autolab

Observe the following rules:
- DO NOT use [`System.exit()`](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/System.html#exit(int)).
- DO NOT add the project or package statements.
- DO NOT change the class name.
- DO NOT change the headers of ANY of the given methods.
- DO NOT add any new class fields.
- ONLY display the result as specified by the example for each problem.
- You may USE any of the libraries provided.

## Overview
A heart transplant is a surgical procedure that replaces the person’s heart with a donor heart. A person may require a heart transplant for several reasons including congenital, arterial and muscle diseases or for unforeseen reasons such as accidents or viral infections.

The donor heart is matched to the recipient by blood type. Additional variables are also used to decide which recipient receives a heart if there are not enough hearts available for all recipients waiting for a transplant. The variables included in the decision may include the recipient state of health, cause of the heart condition and the urgency of the transplant.

The primary goal of this project is for you to write a matching function that receives as a parameter the number of available hearts for transplant and will output all the recipients ranked in order of precedence.

## Project Classes
This project includes several classes. Following is a high level description of each class (more information available in the respective `.java` file):

- `Person` defines a person waiting for a heart transplant. This class is already written for you.
- `SurvivabilityByAge` defines the rate of survivability by age after a certain number of years after the transplant. This class is already written for you.
- `SurvivabilityByCause` defines the rate of survivability by heart condition cause after a certain number of years after the transplant. This class is already written for you.
- `HeartTransplant` is the driver of the heart transplant program, it contains a main method that is already written for you to test the methods that you will write in this class.

## Data File and Execution

We provide a data file with *real* data that is the input for the program. The data file contains information on 21 people of the same blood type, 24 survivability by age rates, and 15 survivability by heart condition cause rates. More on the data file format below.

Execute the program as follows:
```sh
java HeartTransplant < data.txt
```
The file `data.txt` is redirected as the input for the program `HeartTransplant` and can be read using the `StdIn` library functions `StdIn.readInt()` and `StdIn.readDouble()`.

## HeartTransplant
Following are the methods to be completed in `HeartTransplant.java`:

```java
public HeartTransplant() {

}
```
> Initializes all instance variables to `null`.
```java
public int addPerson(Person p, int arrayIndex) {

}
```
> Inserts the parameter Person `p` into the instance variable array `listOfPatients`. Returns the integer `0` if it successfully inserts `p` into the array, and `-1` if there is not enough space to insert `p` into array.

```java
public int readPersonsFromFile(int numberOfLines) {

}
```
> Allocates the `listOfPatients` array with `numberOfLines` length, then reads `numberOfLines` persons from the data file (each line refers to one Person). For each person read from the data file (a) instantiates a `Person` object, and (b) inserts the `Person` object into the `listOfPatients` array. The method returns the number of patients read from file. File Format: ID, Ethnicity, Gender, Age, Cause, Urgency, State of health.

```java
public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {

}
```
> Allocates the `survivabilityByAge` array with `numberOfLines` length, then reads `numberOfLines` survivability by age rates from the data file (each line refers to one survivability rate by age). For each rate read from the data file (a) instantiates a `SurvivabilityByAge` object, and (b) inserts the object into the `survivabilityByAge` array. The method returns the number of survivability rates read from file.

```java
public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

}
```
> Allocates the `survivabilityByCause` array with `numberOfLines` length, then reads `numberOfLines` survivability by cause rates from the data file (each line refers to one survivability rate by cause). For each rate read from the data file (a) instantiates a `SurvivabilityByCause` object, and (b) inserts the object into the `survivabilityByCause` array. The method returns the number of survivability rates read from file.

```java
public Person[] getPatientsWithAgeAbove(int age) {

}
```
> Returns a `Person` array with every Person that has age above the parameter age from the `listOfPatients` array. The return array has to be completely full with no empty spots, that is the array size should be equal to the number of persons with age above the parameter age. Return `null` if there is no Person with age above the parameter age.

```java
public Person[] getPatientsByStateOfHealth(int state) {

}
```
> Returns a `Person` array with every Person that has the state of health equal to the parameter state from the `listOfPatients` array. The return array has to be completely full with no empty spots, that is the array size should be equal to the number of persons with the state of health equal to the parameter state. Returns `null` if there is no Person with the state of health equal to the parameter state.

```java
public Person[] getPatientsByHeartConditionCause(int cause) {

}
```
Returns a `Person` array with every person that has the heart condition cause equal to the parameter cause from the `listOfPatients` array. The return array has to be completely full with no empty spots, that is the array size should be equal to the number of persons with the heart condition cause equal to the parameter cause. Return `null` if there is no Person with the heart condition cause equal to the parameter cause.

```java
public Person[] match(int numberOfHearts) {

}
```
> Assume there are `numberOfHearts` available for transplantation surgery. Also assume that the hearts are of the same blood type as the persons on the `listOfPatients`. This method finds a set of persons to be the recepients of these hearts. The method returns a Person array from the `listOfPatients` array that have the highest potential for survivability after the transplant. The array size is `numberOfHearts`. If `numberOfHeartsAvailable` is greater than `listOfPatients` array size all Persons will receive a transplant. If `numberOfHeartsAvailable` is smaller than `listOfPatients` array size find the set of people with the highest potential for survivability. There is no correct solution, you may come up with any set of persons from the `listOfPatients` array.

> For you to compare how effective your matching function is we will provide, 5 days before the due date, the data file with the condition of each patient after 3 years of the transplant. [Data file](HeartTransplant/data-post-transplant.txt) where the last column has the condition of each patient 3 years post transplant (`Person.java` with condition code).

## Data File Format
The data file is divided in three sections.

1. Person

   The first line of this section has an integer that refers to the number of persons in the file. The file has one person per line in the following format:
   ```
   PersonID Ethinicity Gender Age Cause Urgency StateOfHealth
   ```

   The example below has 3 persons, the first person’s ID  10, Ethnicity 0, Gender 0, Age 75, Cause 3, Urgency 0, and StateOfHealth 2. You can see the meaning of each code in the `Person.java` file.

2. Survivability by age

   The first line of this section has an integer that refers to the number of survivability by age rates in the file. The file has one rate per line in the following format:
   ```
   Age YearsPostTransplant Rate
   ```

   The example below has 8 rates, the first rate specifies that people with age LESS than 1 year old, 5 years post transplant have a survivability rate of 83.6%.

3. Survivability by heart condition cause

   The first line of this section has an integer that refers to the number of survivability by cause rates in the file. The file has one rate per line in the following format:
   ```
   Cause YearsPostTransplant Rate
   ```
   The example below has 5 rates, the first rate specifies that people with heart condition cause 4 (heart muscle disease), 1 year post transplant have a survivability rate of 89.4%. You can see the meaning of each code in the `Person.java` file.

```
3
10  0  0  75  3  0  2
11  1  0  78  4  1  0
12  2  0  40  3  0  0
8
 1  5 83.6
 6  5 87.4
 11 5 86.8
 18 5 90
 35 5 86.9
 50 5 88.8
 65 5 87.8
120 5 84.3
5
4 1 89.4
1 1 82.1
3 1 87.1
0 1 88.2
2 1 88.2
```

## Before submission
1. Collaboration policy. Read our collaboration policy [here](https://introcs.cs.rutgers.edu/#academic-integrity).
2. Update `@author`. Update the `@author` tag of the files with your name, email and netid.
3. Submitting the assignment. Submit `HeartTransplant.java` via the web submission system called Autolab. To do this, click the Assignments link from the course website; click the Submit link for that assignment.

## Getting help
If anything is unclear, don’t hesitate to drop by office hours or post a question on Piazza. Find instructors office hours by clicking the Staff  link from the course website.

In addition to office hours we have the CAVE (Collaborative Academic Versatile Environment), a community space staffed with lab assistants which are undergraduate students further along the CS major to answer questions.
