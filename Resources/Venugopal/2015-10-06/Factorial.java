
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=0;  // declare before do { } block, otherwise num will not be visible in the
        		  // while condition after the closing }
		do {
			System.out.print("Enter n (> 0): ");
			n = IO.readInt();
		} while (n <= 0);

		
		// compute factorial(n)
		
		/* VERSION 1
		long prod=1;
		for (int i=1; i <= n; i++) {
			prod *= i;
			System.out.println("i=" + i + ",prod=" + prod);
		}
		*/
		
		/* VERSION 2
		long prod=1;
		int i=1;    // initialize i outside for
		for (; i <= n; i++) {
			prod *= i;
			System.out.println("i=" + i + ",prod=" + prod);
		}
		*/
		
		/* VERSION 3
		long prod=1;
		int i=2;    // initialize i outside for
		for (; ; i++) {   // leave out condition
			if (i > n) {  // flip condition and break if true
				break;
			}
			prod *= i;
			System.out.println("i=" + i + ",prod=" + prod);
		}
		*/
		
		/* VERSION 4 - NONE OF THE FOR LOOP HEADER PARTS ARE CODED */
		long prod=1;
		int i=2;    // initialize i outside for
		for (; ; ) {   // leave out last part as well, place it at end of loop
			if (i > n) {  // flip condition and break if true
				break;
			}
			prod *= i;
			System.out.println("i=" + i + ",prod=" + prod);
			i++;
		}
		
		
		System.out.printf("fact(%d) = %d%n", n, prod);
	}

}
