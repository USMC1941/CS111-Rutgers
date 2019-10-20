public class F2Cwhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fahrenheit;  // DECLARE fahrenheit to hold data of type double

		// ask fahrenheit value from user
		System.out.print("Enter fahrenheit value: ");
		fahrenheit = IO.readDouble();

		// check if fahrenheit is < -459.67
		while (fahrenheit < -459.67) {
			System.out.println("Invalid input, fahrenheit must be >= -459.67");
			System.out.print("Enter fahrenheit value: ");
			fahrenheit = IO.readDouble();
		}

		double celsius = (fahrenheit - 32) * 5 / 9;
		//System.out.println("celsius=" + celsius);
		System.out.printf("celsius=%.2f%n", celsius);


	}

}
