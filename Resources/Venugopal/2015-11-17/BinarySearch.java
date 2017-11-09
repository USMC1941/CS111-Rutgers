
public class BinarySearch {

	// input array must be in sorted order!!!!
	public static int binarySearch(int[] list, int target) {
		int lo=0, hi=list.length-1;
		
		while (lo <= hi) {
			int mid = (lo+hi)/2;   // midpoint of lo..hi
			if (target == list[mid]) {
				return mid;
			}
			if (target < list[mid]) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		return -1;
	}
	
	public static int[] getItems() {
		int n=0;
		do {
			System.out.print("How many items in array? (need at least 1) : ");
			n = IO.readInt();
		} while (n <= 0);
		
		int[] items = new int[n];
		System.out.println("Enter integers in sorted order:");
		for (int i=0; i < n; i++) {
			items[i] = IO.readInt();
		}
		return items;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = getItems();
		System.out.print("Sorted array: ");
		printArray(arr);
		
		System.out.print("\nEnter target to search ('quit' to stop) : ");
		String input = IO.readString();
		while (!"quit".equals(input)) {
			int target = Integer.parseInt(input);
			int pos = binarySearch(arr, target);
			if (pos != -1) {
				System.out.println(target + " is in the array");
			} else {
				System.out.println(target + " is not in the array");
			}
			System.out.print("\nEnter target to search ('quit' to stop) : ");
			input = IO.readString();
		}
	}

	public static void printArray(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		System.out.print("[");
		System.out.print(arr[0]);
		for (int i=1; i < arr.length; i++) {
			System.out.print("," + arr[i]);
		}
		System.out.println("]");
	}
	
}
