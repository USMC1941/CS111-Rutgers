package examples;

public class Truck extends Vehicle {

	private int numberOfAxels;

	public Truck(int registrationNumber, Person owner) {
		super(registrationNumber, owner); // call superclass constructor (Vehicle)
	}

	public Truck(int registrationNumber, Person owner, int numberOfAxels) {
		super(registrationNumber, owner); // call superclass constructor (Vehicle)
		setNumberOfAxels(numberOfAxels);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Truck: " + getNumberOfAxels() + " axels - ");
		sb.append(super.toString() + "\n");
		return sb.toString();
	}

	/* Getter and Setter methods */
	public int getNumberOfAxels() {
		return numberOfAxels;
	}

	private void setNumberOfAxels(int numberOfAxels) {
		this.numberOfAxels = numberOfAxels;
	}
}
