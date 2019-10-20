package examples;

public class Scope {

	public static void main(String[] args) {

		int y = 10;
		while (y > 5) {
			int x = 0;
			while (x < 10) {
				x++;
			}
			y--;
			/* the scope of x ends here */
		}

		while (y < 5) {
			int x = 3; /* Another x */
			y++;
			while (x > 1) {
				int x = 4; /* Already declared */
			}
		}
	}
}
