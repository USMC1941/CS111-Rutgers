public class F2Cdowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double fahrenheit;  // DECLARE fahrenheit to hold data of type double

		do {
			System.out.print("Enter fahrenheit value, MUST be >= -459.67: ");
			fahrenheit = IO.readDouble();
		}
		while (fahrenheit < -459.67); // check if fahrenheit is < -459.67

		double celsius = (fahrenheit - 32) * 5 / 9;
		//System.out.println("celsius=" + celsius);
		System.out.printf("celsius=%.2f%n", celsius);


	}

}
