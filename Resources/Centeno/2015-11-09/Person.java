package examples;

public class Person {
	private String name;
	private Address address;
	
	/* General constructor */
	public Person (String name) {
		this.name = name;
	}
	
	public Person (String name, Address address) {
		this(name); // call general constructor
		setAddress(address);
	}
	
	public String toString() {
		return String.format("%s - %s", getName(),getAddress());
	}
	/* Setter and Getter methods */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
}
