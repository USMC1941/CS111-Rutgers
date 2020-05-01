import javax.swing.JOptionPane;

/**
 * This module provides methods for obtaining user input and displaying messages,
 * using graphical dialog boxes rather than printed text.
 */
public class GIO {
	/**
	 * Displays the given prompt and allows the user to enter a string.
	 */
	public static String readString(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}

	/**
	 * Displays the given prompt and allows the user to choose Yes or No.
	 */
	public static boolean readBoolean(String prompt) {
		int i = JOptionPane.showConfirmDialog(null, prompt, "Blackjack", JOptionPane.YES_NO_OPTION);
		return i == JOptionPane.YES_OPTION;
	}

	/**
	 * Displays the given prompt and allows the user to enter an integer.
	 */
	public static int readInt(String prompt) {
		String s = JOptionPane.showInputDialog(prompt);

		while (true) {
			try {
				return Integer.parseInt(s);
			}
			catch (NumberFormatException e) {
				s = JOptionPane.showInputDialog("That is not an integer.  Enter again: ");
			}
		}
	}

	/**
	 * Displays the given message and waits for the user to press OK.
	 */
	public static void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Do not use this constructor.
	 * It is declared private to prevent its use.
	 */
	private GIO() {
	}
}
