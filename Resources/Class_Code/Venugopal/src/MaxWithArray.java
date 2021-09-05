public class MaxWithArray {

    public static void main(String[] args) {
        System.out.print("How many values? => ");
        int n = IO.readInt();

        int[] scores = new int[n]; // n is length of array

        // read in all values
        for (int i = 0; i < n; i++) {
            System.out.print("Enter next value => ");
            scores[i] = IO.readInt();
        }

        printArray(scores);

        int max = Integer.MIN_VALUE; // min possible value that can be stored in this program
        for (int score : scores) {
            max = Math.max(max, score);
        }

        // OR
        int maxTemp = scores[0];
        for (int i = 1; i < scores.length; i++) {
            maxTemp = Math.max(maxTemp, scores[i]);
        }

        System.out.print("max = " + max);
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        System.out.print("[");
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print("," + arr[i]);
        }
        System.out.println("]");
    }
}
