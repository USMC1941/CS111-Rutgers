package examples;

public class Search {

	/*
	 * Linear or Sequential Search
	 * Scans the array until it finds the target
	 * Best case: 1 comparison
	 * Worst case: n comparisons
	 */
	public static void linearSearch(int[] a, int target) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) {
				System.out.println("Linear Search found " + target);
				return;
			}
		}
		System.out.println(target + " not found by Linear Search");
	}

	/*
	 * Binary Search
	 * Repeatedly divides the search space (array) in half
	 */
	public static void binarySearch(int[] a, int target) {

		int left  = 0;           // first element of the array
		int right = a.length - 1; // last element of the array

		while (left <= right) {

			int middle = (right + left) / 2;

			if (a[middle] == target) {
				System.out.println("Binary Search found " + target);
				return;
			}
			else {
				if (target < a[middle]) {
					right = middle - 1;
				}
				else {
					left = middle + 1;
				}
			}
		}
		/* Left and right have crossed each other left > right */
		System.out.println(target + " not found by Binary Search");
	}

	public static void main(String[] args) {

		int[] array = {2, 4, 6, 8, 12, 90, 102, 120, 133};
		linearSearch(array, 102);
		linearSearch(array, 9);

		binarySearch(array, 102);
		binarySearch(array, 9);
	}

}
