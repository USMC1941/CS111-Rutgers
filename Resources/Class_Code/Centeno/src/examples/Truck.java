package examples;

public class Truck extends Vehicle {

    private int numberOfAxels;

    public Truck(int registrationNumber, Person owner) {
        // call superclass constructor (Vehicle)
        super(registrationNumber, owner);
    }

    public Truck(int registrationNumber, Person owner, int numberOfAxels) {
        // call superclass constructor (Vehicle)
        super(registrationNumber, owner);
        setNumberOfAxles(numberOfAxels);
    }

    public String toString() {
        return "Truck: " + getNumberOfAxles() + " axles - " + super.toString() + "\n";
    }

    /* Getter and Setter methods */
    public int getNumberOfAxles() {
        return numberOfAxels;
    }

    private void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxels = numberOfAxles;
    }
}
