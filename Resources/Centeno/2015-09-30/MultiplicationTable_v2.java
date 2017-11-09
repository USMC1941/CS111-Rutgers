package examples;

public class MultiplicationTable_v2 {

	public static void main(String[] args) {
		
		System.out.println("Enter number of rows:");
		int numRows = IO.readInt();
		System.out.println("Enter number of cols:");
		int numCols = IO.readInt();
		if (numRows < 0 || numCols < 0) {
			System.out.println("Invalid cols or rows");
			return;
		}
		for (int row = 1; row <= numRows; row++) {
			for (int col = 1; col <= numCols; col++) {
				int result = row * col;
				System.out.printf("%d  ",result);
			}
			System.out.println();
		}
	}
}
