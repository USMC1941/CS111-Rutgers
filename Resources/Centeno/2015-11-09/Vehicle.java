package examples;

public class Vehicle {

	private int    registrationNumber;
	private Person owner;

	public Vehicle(int registrationNumber, Person owner) {
		setRegistrationNumber(registrationNumber);
		setOwner(owner);
	}

	public void transferOwnership(Person newOwner) {
		setOwner(newOwner);
	}

	public String toString() {
		return String.format("Registration number: %d \nOwner: %s", getRegistrationNumber(), getOwner());
	}

	/* Getter and Setter methods */
	public int getRegistrationNumber() {
		return registrationNumber;
	}

	private void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Person getOwner() {
		return owner;
	}

	private void setOwner(Person owner) {
		this.owner = owner;
	}
}
