package examples;

public class StringTest {

	public static void main(String[] args) {
		System.out.println("Enter two strings: ");
		String  x = IO.readString();
		String  k = IO.readString();
		boolean b = stringEquals(x, k);
		if (b == true) {
			System.out.printf("Strings %s and %s are equal\n", x, k);
		}
		b = stringReverse(x, k);
		if (b == true) {
			System.out.printf("Strings %s and %s are the reverse\n", x, k);
		}
		b = areLetters(x);
		if (b == true) {
			System.out.printf("%s has only letters", x);
		}
		letterFrequency(x);
	}

	public static void letterFrequency(String a) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < alphabet.length(); i++) {
			int count = letterCount(a, alphabet.charAt(i));
			if (count > 0) {
				System.out.printf("\nLetter %c frequency is %d", alphabet.charAt(i), count);
			}
		}
	}

	public static int letterCount(String a, char c) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static boolean areLetters(String a) {
		for (int i = 0; i < a.length(); i++) {
			if (!Character.isLetter(a.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean stringReverse(String a, String b) {

		if (a.length() != b.length()) {
			/* Strings have different lengths */
			return false;
		}
		else {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(b.length() - 1 - i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean stringEquals(String a, String b) {
		if (a.length() != b.length()) {
			/* Strings have different lengths */
			return false;
		}
		else {
			/* String have same length */
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

}
