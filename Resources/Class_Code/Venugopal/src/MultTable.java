public class MultTable {

    public static void main(String[] args) {
        System.out.print("Enter number of rows (> 0): ");
        int numRows = IO.readInt();

        System.out.print("Enter number of columns (> 0): ");
        int numColumns = IO.readInt();

        /* VERSION 1
        for (int r=0; r < numRows; r++) {  // outer loop for rows of table
        	for (int c=0; c < numColumns; c++) {
        		System.out.printf("%4d ", (r+1)*(c+1));
        	}
        	System.out.println();
        }
         */

        /* VERSION 2: Run the loops from 1..numRows and 1..numCols */
        // outer loop for rows of table
        for (int r = 1; r <= numRows; r++) {
            for (int c = 1; c <= numColumns; c++) {
                System.out.printf("%4d ", r * c);
            }
            System.out.println();
        }
    }
}
