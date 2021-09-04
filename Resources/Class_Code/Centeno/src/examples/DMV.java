package examples;

import java.util.ArrayList;

public class DMV {

    public static final int NBR_VEHICLES = 100;

    private ArrayList<Vehicle> vehicles;

    public DMV() {
        vehicles = new ArrayList<>(NBR_VEHICLES);
    }

    public DMV(int numberOfVehicles) {
        vehicles = new ArrayList<>(numberOfVehicles);
    }

    public void addVehicle(Vehicle newVehicle) {
        vehicles.add(newVehicle);
    }

    public Person getOwner(int registrationNumber) {
        for (Vehicle v : vehicles) {
            if (v.getRegistrationNumber() == registrationNumber) {
                return v.getOwner();
            }
        }
        System.out.println("Unknown vehicle");
        return null;
    }

    /** Searches linearly until it finds a vehicle with registrationNumber. Called linear search */
    public void displayInformation(int registrationNumber) {
        for (Vehicle v : vehicles) {
            if (v.getRegistrationNumber() == registrationNumber) {
                /* toString() method is either Car or Truck */
                System.out.println(v);
                return;
            }
        }
        System.out.println("Unknown registration number: " + registrationNumber);
    }
}
