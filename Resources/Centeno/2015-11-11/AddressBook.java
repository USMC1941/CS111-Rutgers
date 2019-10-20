package examples;

/*
 * Keeps an address book using a array.
 * The array can only have empty spots at the end of the array.
 */
public class AddressBook {

	Person[] book;
	int      counter; /* used to add at the end of the array */

	public AddressBook(int numberEntries) {
		book = new Person[numberEntries];
		counter = 0;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < counter; i++) {
			if (book[i] != null) {
				str += book[i].toString() + "\n";
			}
		}
		return str;
	}

	/*
	 * Scans the array until it finds a empty space
	 * Best case: 1 comparison
	 * Worst case: n comparisons
	 */
	public void addLinear(Person newEntry) {
		for (int i = 0; i < book.length; i++) {
			if (book[i] == null) {
				/* Found first empty space */
				book[i] = newEntry;
				counter++;
				return;
			}
		}
	}

	/*
	 * Add at the end of the array using the counter variable
	 * It always takes the same amount of time, no matter how
	 * big the array is.
	 */
	public void addConstant(Person newEntry) {
		if (counter == book.length) {
			System.out.println("Address Book is full");
			return;
		}
		else {
			/* Add at the first empty spot */
			book[counter] = newEntry;
			counter++;
		}
	}

	/*
	 * Scans the array to find the element to remove
	 * Removes the element at index i by shifting (n-i) elements
	 * to the left.
	 * Best case: 1 comparison, n-1 shifts
	 * Worst case: n-1 comparisons, 1 shift
	 */
	public void removeShift(String name) {
		int i = 0;
		for (i = 0; i < counter; i++) {
			if (book[i].getName().equals(name)) {
				/* i is the position of Person with name == name */
				break;
			}
		}
		if (counter == i) {
			/* Went over the end of the array */
			System.out.println(name + " not found");
			return;
		}
		/* Shift elements from i+1 to n-1 left by one position */
		for (int k = i; k < counter - 1; k++) {
			book[k] = book[k + 1];
		}
		counter--;
	}

	/*
	 * Scans the array to find the element to remove
	 * Removes the element at index i by replacing it with the last element
	 * Best case: 1 comparison
	 * Worst case: n-1 comparisons
	 */
	public void removeReplace(String name) {
		int i = 0;
		for (i = 0; i < counter; i++) {
			if (book[i].getName().equals(name)) {
				/* i is the position of Person with name == name */
				break;
			}
		}
		if (i == counter) {
			System.out.println(name + " not found");
			return;
		}
		/* Replace Person at position i with the Person
		 * at the last position of the array */
		book[i] = book[counter - 1];
		counter--;
	}
}
