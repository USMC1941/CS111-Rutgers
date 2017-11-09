
public class Sorter {
	
	public static void selectionSort(int[] arr) {
		
		for (int n=arr.length; n > 0; n--) {
			int maxIndex = 0;
			for (int i=1; i < n; i++) {
				if (arr[i] > arr[maxIndex]) {
					maxIndex = i;
				}
			}
			int temp = arr[maxIndex];
			arr[maxIndex] = arr[n-1];
			arr[n-1] = temp;
			BinarySearch.printArray(arr);
		}
	}
	
	public static void insertionSort(int[] arr) {
		
		for (int i=1; i < arr.length; i++) {
			int temp = arr[i];
			int j=i-1;
			for (; j >= 0; j--) {
				if (arr[j] > temp) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2,-10,15,5,18,91,-25,15};
		insertionSort(arr);
		BinarySearch.printArray(arr);
		
		/*
		selectionSort(arr);
		BinarySearch.printArray(arr);
		
		int[] arr2 = {-2,-10,-15,-5,-18,-91,-25,-15};
		selectionSort(arr2);
		BinarySearch.printArray(arr2);
		*/
		
	}
	
	

}
