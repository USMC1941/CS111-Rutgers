/**
 * Example for age = 50, years = 5, rate = 74.7,
 * 5 years after the transplant, people with age less
 * than 50 years old have a survivability rate of 74.7%
 */
public class SurvivabilityByAge {

   /**
    * People with age less than age
    */
   private final int age;

   /**
    * Years post transplant
    */
   private final int years;

   /**
    * Survival rate
    */
   private final double rate;

   public SurvivabilityByAge(int age, int years, double rate) {
      this.age = age;
      this.years = years;
      this.rate = rate;
   }

   /**
    * @return Age
    */
   public int getAge() {
      return age;
   }

   /**
    * @return yearsPostTransplant
    */
   public int getYears() {
      return years;
   }

   /**
    * @return rate
    */
   public double getRate() {
      return rate;
   }

   /**
    * @return The string representation
    */
   public String toString() {
      return age + ", " + years + ", " + rate;
   }
}