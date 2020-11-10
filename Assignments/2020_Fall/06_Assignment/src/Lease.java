public class Lease {

   // Instance variables
   private double dueAtSigning;        // dollar amount due at signing the lease
   private int    numberOfMonths;      // lease length in months
   private double monthlyCost;         // monthly lease cost
   private int    mileageAllowance;    // mileage allowance per 12 months

   // Constructor
   public Lease(double dueAtSigning, int numberOfMonths, double monthlyCost, int mileageAllowance) {
      this.dueAtSigning = dueAtSigning;
      this.numberOfMonths = numberOfMonths;
      this.monthlyCost = monthlyCost;
      this.mileageAllowance = mileageAllowance;
   }

   // Accessor methods
   public double getDueAtSigning() {
      return dueAtSigning;
   }

   public int getNumberOfMonths() {
      return numberOfMonths;
   }

   public double getMonthlyCost() {
      return monthlyCost;
   }

   public int getMileageAllowance() {
      return mileageAllowance;
   }

   // String representation of Lease
   public String toString() {
      String str = "\nLease";
      str += "\n\tDue at signing: " + dueAtSigning;
      str += "\n\tNumber of months: " + numberOfMonths;
      str += "\n\tMonthly cost: " + monthlyCost;
      str += "\n\tMileage allowance: " + mileageAllowance;
      return str;
   }
}