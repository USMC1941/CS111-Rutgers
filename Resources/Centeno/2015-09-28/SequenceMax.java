package examples;

public class SequenceMax {

	public static void main(String[] args) {

		System.out.println("Enter terminating value:");
		int terminator = IO.readInt();
		System.out.println("Enter next value:");
		int number = IO.readInt();
		if (number == terminator) {
			System.out.println("No maximum");
			return;
		}
		int max = number;
		do {
			System.out.println("Enter next value:");
			number = IO.readInt();
			if (number != terminator && number > max) {
				max = number;
			}
		}
		while (number != terminator);
		System.out.println("Maximum is " + max);
	}
}
