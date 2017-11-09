
public class MaxWithArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = getValues();
		
		printArray(scores);
		
		int max = Integer.MIN_VALUE;  // min possible value that can be stored in this program
		
		for (int i=0; i < scores.length; i++) {
			max = Math.max(max, scores[i]);
		}
		
		/* OR
		int max = scores[0];
		for (int i=1; i < scores.length; i++) {
			max = Math.max(max, scores[i]);
		}		
		*/
		
		System.out.print("max = " + max);
		
	}

	private static int[] getValues() {
		System.out.print("How many values? => ");
		int n = IO.readInt();
		
		int[] scores = new int[n]; // n is length of array
		
		// read in all values
		for (int i=0; i < n; i++) {
			System.out.print("Enter next value => ");
			scores[i] = IO.readInt();
		}
		return scores;
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
