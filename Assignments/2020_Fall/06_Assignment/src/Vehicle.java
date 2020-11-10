public class Vehicle {

   // Instance variables
   private String name;        // Vehicle's name
   private Fuel   fuel;        // reference to fuel information
   private Lease  lease;       // reference to lease information
   private double co2Emission; // total CO2 emission for the length of the lease
   private double otherCost;   // cost, in dollars, of oil change (gas-powered) or home charger (electric-powered)
   private double fuelCost;    // cost, in dollars, of fuel for the length of the lease
   private double totalCost;   // cost, in dollars, of driving this model for the length of the lease. Includes other costs.

   /**
    * Constructor
    */
   public Vehicle(String name, Fuel fuel, Lease lease, double otherCost) {
      this.name = name;
      this.fuel = fuel;
      this.lease = lease;
      this.otherCost = otherCost;
      this.co2Emission = 0.0;
      this.fuelCost = 0.0;
      this.totalCost = 0.0;
   }

   // toString
   public String toString() {
      String str = "\n____________________\n";
      str += "\nVehicle " + name;
      str += fuel.toString();
      str += lease.toString();
      str += String.format("\n\nCO2 Emission: %.2f kg/CO2\n", co2Emission);
      str += "\nCost";
      str += String.format("\n\tOther: %.2f dollars", otherCost);
      str += String.format("\n\tFuel : %.2f dollars for %d months of lease", fuelCost, lease.getNumberOfMonths());
      str += String.format("\n\tTotal: %.2f dollars for %d months of lease", totalCost, lease.getNumberOfMonths());
      return str;
   }

   /**
    * Returns vehicle name
    */
   public String getName() {
      return name;
   }

   /**
    * Returns fuel
    */
   public Fuel getFuel() {
      return fuel;
   }

   /**
    * Returns Lease
    */
   public Lease getLease() {
      return lease;
   }

   /**
    * Return other costs which can include oil change (gas-powered) or home charger (electric-powered)
    */
   public double getOtherCost() {
      return otherCost;
   }

   /**
    * Updates the CO2 emission
    */
   public void setCO2Emission(double co2Emission) {
      this.co2Emission = co2Emission;
   }

   /**
    * Returns CO2Emission
    */
   public double getCO2Emission() {
      return co2Emission;
   }

   /**
    * Updates the fuel cost
    */
   public void setFuelCost(double fuelCost) {
      this.fuelCost = fuelCost;
   }

   /**
    * Returns fuel cost
    */
   public double getFuelCost() {
      return fuelCost;
   }

   /**
    * Updates the total cost
    */
   public void setTotalCost(double totalCost) {
      this.totalCost = totalCost;
   }

   /**
    * Returns the total cost
    */
   public double getTotalCost() {
      return totalCost;
   }
}