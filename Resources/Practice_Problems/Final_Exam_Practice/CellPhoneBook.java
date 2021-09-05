public class CellPhoneBook {
	public static void main(String[] args) {
		System.out.print("Enter the maximum size of the cell phone book: ");
		int max = IO.readInt();
		while (true) {
			// print out all entries here
			System.out.println("\nTest menu:\n");
			System.out.println("1. Add entry");
			System.out.println("2. Delete entry");
			System.out.println("3. Lookup cellphone number");
			System.out.println("4. Change cellphone number");
			System.out.println("5. Sort entries");
			System.out.println("6. Quit");

			System.out.print("\nEnter your choice: ");
			int choice = IO.readInt();

			if (choice == 1) {


			}
			else if (choice == 2) {


			}
			else if (choice == 3) {


			}
			else if (choice == 4) {


			}
			else if (choice == 5) {


			}
			else if (choice == 6) {
				return;
			}
			else {
				System.out.println("Invalid choice");
			}
		}
	}
}
