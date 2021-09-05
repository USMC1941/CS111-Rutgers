public class Array2D {

    public static void main(String[] args) {
        int[][] int2d = new int[3][4]; // 3 rows, 4 columns

        System.out.println(int2d.length);
        System.out.println(int2d[0].length);

        // fill with values
        for (int r = 0; r < int2d.length; r++) {
            for (int c = 0; c < int2d[0].length; c++) {
                int2d[r][c] = 10;
            }
        }

        printArray(int2d);
    }

    public static void printArray(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return;
        }

        for (int[] ints : arr) {
            System.out.print("|");
            System.out.print(ints[0]);
            for (int c = 1; c < arr[0].length; c++) {
                System.out.print("," + ints[c]);
            }
            System.out.println("|");
        }
    }
}
