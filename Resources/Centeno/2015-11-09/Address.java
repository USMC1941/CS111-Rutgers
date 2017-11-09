package examples;

public class Address {

	private String street;
	private String town;
	private String state;
	private int zipcode;
	private int number;
	private String apartment;
	
	/* General constructor */
	public Address(int number, String street, String town, String state,
			int zipcode) {
		this.street = street;
		this.town = town;
		this.state = state;
		this.zipcode = zipcode;
		this.number = number;
	}
	/* Constructor in case person lives in an apartment*/
	public Address(int number, String street, String apartment, String town, String state,
			int zipcode) {
	
		this(number,street,town,state,zipcode); // call the general constructor
		this.apartment = apartment;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(number); sb.append(' ');
		sb.append(street); sb.append(", ");
		if (apartment != null) {
			sb.append(apartment); sb.append(' ');
		}
		sb.append(town); sb.append(", ");
		sb.append(state); sb.append(' ');
		sb.append(zipcode);
		return sb.toString(); // return sb + "";  works as well
	}
}
