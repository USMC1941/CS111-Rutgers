/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author:
 *
 *************************************************************************/

public class HeartTransplant {

   /* ------ Instance variables  -------- */

   /**
    * Person array, each Person is read from the data file
    */
   private Person[] listOfPatients;

   /**
    * SurvivabilityByAge array, each rate is read from data file
    */
   private SurvivabilityByAge[] survivabilityByAge;

   /**
    * SurvivabilityByCause array, each rate is read from data file
    */
   private SurvivabilityByCause[] survivabilityByCause;

   /* ------ Constructor  -------- */

   /**
    * Initializes all instance variables to null.
    */
   public HeartTransplant() {

      // WRITE YOUR CODE HERE
   }

   /* ------ Methods  -------- */

   /**
    * Client to test the methods you write
    */
   public static void main(String[] args) {

      HeartTransplant ht = new HeartTransplant();

      // read persons from file
      int numberOfLines    = StdIn.readInt();
      int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
      StdOut.println(numberOfReadings + " patients read from file.");

      // read survivability by age from file
      numberOfLines = StdIn.readInt();
      numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
      StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

      // read survivability by heart condition cause from file
      numberOfLines = StdIn.readInt();
      numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
      StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

      // list all patients
      for (Person p : ht.getListOfPatients()) {
         StdOut.println(p);
      }

      // list survivability by age rates
      for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
         StdOut.println(rate);
      }

      // list survivability by cause rates
      for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
         StdOut.println(rate);
      }

   }

   /**
    * Inserts Person p into listOfPatients
    * @param p Person
    * @param arrayIndex Array index
    * @return 0 if successfully inserts p into array, -1 if there is not enough space to insert p into array
    */
   public int addPerson(Person p, int arrayIndex) {

      // WRITE YOUR CODE HERE
   }

   /**
    * <ol>
    *    <li>Creates the listOfPatients array with numberOfLines length.</li>
    *    <li>
    *       Reads from the command line data file.
    *       <p>
    *       File Format: ID, Ethnicity, Gender, Age, Cause, Urgency, State of health.
    *       <p>
    *       Each line refers to one Person.
    *    </li>
    *    <li>
    *       Inserts each person from file into listOfPatients
    *       <p>
    *       Hint: uses addPerson() method
    *    </li>
    * </ol>
    * @param numberOfLines Length of listOfPatients array
    * @return The number of patients read from file
    */
   public int readPersonsFromFile(int numberOfLines) {

      // WRITE YOUR CODE HERE
   }

   /**
    * <ol>
    *    <li>Creates the survivabilityByAge array with numberOfLines length.</li>
    *    <li>
    *       Reads from the command line file.
    *       <p>
    *       File Format: Age YearsPostTransplant Rate
    *       <p>
    *       Each line refers to one survivability rate by age.
    *    </li>
    *    <li>Inserts each rate from file into the survivabilityByAge array</li>
    * </ol>
    * @param numberOfLines Length of survivabilityByAge array
    * @return The number of survivability rates read from file
    */
   public int readSurvivabilityRateByAgeFromFile(int numberOfLines) {

      // WRITE YOUR CODE HERE
   }

   /**
    * <ol>
    *    <li>Creates the survivabilityByCause array with numberOfLines length.</li>
    *    <li>
    *       Reads from the command line file.
    *       <p>
    *       File Format: Cause YearsPostTransplant Rate
    *       <p>
    *       Each line refers to one survivability rate by cause.
    *    </li>
    *    <li>Inserts each rate from file into the survivabilityByCause array.</li>
    * </ol>
    * @param numberOfLines Length of survivabilityByCause array
    * @return The number of survivability rates read from file
    */
   public int readSurvivabilityRateByCauseFromFile(int numberOfLines) {

      // WRITE YOUR CODE HERE
   }

   /**
    * @return listOfPatients
    */
   public Person[] getListOfPatients() {
      return listOfPatients;
   }

   /**
    * @return survivabilityByAge
    */
   public SurvivabilityByAge[] getSurvivabilityByAge() {
      return survivabilityByAge;
   }

   /**
    * @return survivabilityByCause
    */
   public SurvivabilityByCause[] getSurvivabilityByCause() {
      return survivabilityByCause;
   }

   /**
    * The return array has to be completely full with no empty
    * spots, that is the array size should be equal to the number
    * of persons with age above the parameter age.
    *
    * @param age Age from the listOfPatients array
    * @return A Person array in which with every Person that has
    * age above the parameter age from the listOfPatients array, null if there
    * is no Person with age above the parameter age.
    */
   public Person[] getPatientsWithAgeAbove(int age) {

      // WRITE YOUR CODE HERE
   }

   /**
    * The return array has to be completely full with no empty
    * spots, that is the array size should be equal to the number
    * of persons with the state of health equal to the parameter state.
    *
    * @param state State from the listOfPatients array
    * @return A Person array with every Person that has the state of health
    * equal to the parameter state from the listOfPatients array,
    * null if there is no Person with the state of health
    * equal to the parameter state.
    */
   public Person[] getPatientsByStateOfHealth(int state) {

      // WRITE YOUR CODE HERE
   }

   /*
    * Returns a Person array with every person that has the heart
    * condition cause equal to the parameter cause from the listOfPatients array.
    *
    * The return array has to be completely full with no empty
    * spots, that is the array size should be equal to the number
    * of persons with the heart condition cause equal to the parameter cause.
    *
    * Return null if there is no Person with the heart condition cause
    * equal to the parameter cause.
    */
   public Person[] getPatientsByHeartConditionCause(int cause) {

      // WRITE YOUR CODE HERE
   }

   /**
    * Assume there are numberOfHearts available for transplantation surgery.
    * Also assume that the hearts are of the same blood type as the persons on the listOfPatients.
    * This method finds a set of persons to be the recipients of these hearts.
    * <p>
    * The method returns a Person array from the listOfPatients
    * array that have the highest potential for survivability after
    * the transplant. The array size is numberOfHearts.
    * <p>
    * If numberOfHeartsAvailable is greater than listOfPatients
    * array size all Persons will receive a transplant.
    * <p>
    * If numberOfHeartsAvailable is smaller than listOfPatients
    * array size find the set of people with the highest
    * potential for survivability.
    * <p>
    * There is no correct solution, you may come up with any set of
    * persons from the listOfPatients array.
    *
    * @param numberOfHearts Size of Person array
    * @return A Person array from the listOfPatients
    * array that have the highest potential for survivability after
    * the transplant. The array size is numberOfHearts.
    */
   public Person[] match(int numberOfHearts) {

      // WRITE YOUR CODE HERE
   }
}
