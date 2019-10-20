package examples;

public class Methods {

	/* Definition of method factorial */
	public static int factorial(int n) {
		int result = 1;
		for (int count = 1; count <= n; count++) {
			result = result * count;
		}
		return result;
	}

	/* Definition of method captalization */
	public static String captalize(String str) {
		String result = "";

		/* The first character of a string is at index 0
		 * str.length() gives the length of a string */
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			result += Character.toUpperCase(c);
		}
		return result;
	}

	/* Definition of method alphabeticalOrder */
	public static void alphabeticalOrder(String s1, String s2) {

		int c = s1.compareTo(s2);
		if (c == 0) {
			System.out.println(s1 + " is equal to " + s2);
		}
		else if (c < 0) {
			System.out.println(s1 + " comes before " + s2);
		}
		else {
			System.out.println(s1 + " comes after " + s2);
		}
	}

	/* Definition of method main */
	public static void main(String[] args) {
		alphabeticalOrder("cs111", "cs111");
	}
}
