public class F2CIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fahrenheit;  // DECLARE fahrenheit to hold data of type double

		// ask fahrenheit value from user
		System.out.print("Enter fahrenheit value: ");
		fahrenheit = IO.readDouble();

		// check if fahrenheit is < -459.67
		if (fahrenheit < -459.67) {
			System.out.println("Invalid input, fahrenheit must be >= -459.67");
			return;   // terminates the program
		}

		double celsius = (fahrenheit - 32) * 5 / 9;
		//System.out.println("celsius=" + celsius);
		System.out.println(String.format("celsius=%.2f", celsius));


	}

}
