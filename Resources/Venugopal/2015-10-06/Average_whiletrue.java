
public class Average_whiletrue {

	public static void main(String[] args) {
		
		System.out.print("Enter termination value (int): ");
		int terminator = IO.readInt();
		
		int sum=0;
		int count=0;
		System.out.print("Enter next value, or terminator: ");
		int number = IO.readInt();
		
		while (true) {
			if (number == terminator) {
				break;   // breaks out of the loop
			}
			sum += number;  // sum = sum + number
			count++;        // count = count + 1
			
			System.out.print("Enter next value, or terminator: ");
			number = IO.readInt();
			
		}
		
		
		if (count == 0) {
			System.out.println("No inputs!");
		} else {
			float avg = sum*1f/count;
			System.out.printf("Average = %.2f%n", avg);
			
		}
		
		
	}
}
