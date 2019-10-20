public class Sum_for {

	public static void main(String[] args) {

		int num = 0;  // declare before do { } block, otherwise num will not be visible in the
		// while condition after the closing }
		do {
			System.out.print("Enter number of values (int, > 0): ");
			num = IO.readInt();
		}
		while (num <= 0);

		int sum = 0;
		for (int i = 0; i < num; i++) {
			System.out.print("Enter next value: ");
			int number = IO.readInt();
			sum += number;  // sum = sum + number
		}

		System.out.println("Sum = " + sum);
	}
}
