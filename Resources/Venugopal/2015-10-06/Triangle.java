
public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter length of side: ");
		int n = IO.readInt();
		
		for (int r=1; r <= n; r++) {
			for (int c=1; c <= r; c++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
