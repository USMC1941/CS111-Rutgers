public class AdditivePersistence {

	private static int addDigits(int number) { // number is the parameter to this method
		int sum = 0;
		while (number > 9) {
			sum += number % 10;         // get last digit
			number /= 10;              // number = number / 10 => all digits except last
		}
		sum += number;  // don't forget to add the single digit

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = getInput();   // call method getInput to get user input integer

		int count = 0;   // for additive persistence
		while (n > 9) {
			count++;
			/*
			int sum = addDigits(n);
			n = sum;   // for the next iteration of the outer while loop
			*/

			n = addDigits(n);
		}

		System.out.printf("Additive persistence = %d, digital root = %d", count, n);
	}

	private static int getInput() {
		int n = 0;
		do {
			System.out.print("Enter number (>= 0): ");
			n = IO.readInt();
		}
		while (n < 0);
		return n;
	}

}
