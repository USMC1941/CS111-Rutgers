public class MultTableWithMethods {

    // parameter rows: if true, ask for rows, otherwise ask for columns
    private static int getRowsOrColumns(boolean rows) {
        int n;
        do {
            if (rows) {
                System.out.print("Enter number of rows (> 0): ");
            } else {
                System.out.print("Enter number of columns (> 0): ");
            }
            n = IO.readInt();
        } while (n <= 0);
        return n;
    }

    public static void main(String[] args) {
        int numRows = getRowsOrColumns(true);
        int numColumns = getRowsOrColumns(false);

        // outer loop for rows of table
        for (int r = 1; r <= numRows; r++) {
            for (int c = 1; c <= numColumns; c++) {
                System.out.printf("%4d ", r * c);
            }
            System.out.println();
        }
    }
}
