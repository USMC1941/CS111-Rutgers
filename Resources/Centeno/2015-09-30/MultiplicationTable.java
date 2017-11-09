package examples;

public class MultiplicationTable {

	public static void main(String[] args) {
		
		System.out.println("Enter number of rows:");
		int numRows = IO.readInt();
		System.out.println("Enter number of cols:");
		int numCols = IO.readInt();
		if (numRows < 0 || numCols < 0) {
			System.out.println("Invalid cols or rows");
			return;
		}
		int row = 1;
		while (row <= numRows) {
			int col = 1;
			while (col <= numCols) {
				int result = row * col;
				System.out.printf("%d  ",result);
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
