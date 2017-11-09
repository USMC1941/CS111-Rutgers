package examples;

public class DMV_App {

	public static void main(String[] args) {

		DMV dmvNY = new DMV();
		
		/* Car 1 */
		Address a = new Address(2, "Maple St", "New York", "NY", 10201);
		Person p = new Person("Mary", a);
		Car c = new Car(123456, p, 2);
		dmvNY.addVehicle(c);
		
		/* Car 2 */
		a = new Address(678, "145th St", "New York", "NY", 10600);
		p = new Person("Paul", a);
		c = new Car(872933, p, 4);
		dmvNY.addVehicle(c);
		
		/* Truck 1 */
		a = new Address(45, "Pitt St", "Nyack", "NY", 11670);
		p = new Person("John", a);
		Truck t = new Truck(7392, p, 8);
		dmvNY.addVehicle(t);
		
		dmvNY.displayInformation(123456);
		dmvNY.displayInformation(7392);
	}

}
