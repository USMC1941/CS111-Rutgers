import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * CS111 input/output module. This module serves two purposes:
 *
 * <ul>
 *   <li>It provides input methods which make it easy to read data from the keyboard and force the
 *       user to enter data of a specific type.
 *   <li>It provides output methods which allow us to grade your programs using a grading script.
 * </ul>
 */
public class IO {
    private static BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

    private static BufferedReader fio = null;

    public static boolean openFile(String filename) {
        try {
            fio = new BufferedReader(new FileReader(filename));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String readLine() {
        if (fio == null) {
            return null;
        }

        try {
            return fio.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Ask (and force) the user to enter text.
     *
     * @return Text entered, as a String object.
     */
    public static String readString() {
        while (true) {
            try {
                return kb.readLine();
            } catch (IOException e) {
                // should never happen
            }
        }
    }

    /**
     * Ask (and force) the user to enter an integer.
     *
     * @return Integer entered.
     */
    public static int readInt() {
        while (true) {
            try {
                String s = kb.readLine();
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("That is not an integer.  Enter again: ");
            } catch (IOException e) {
                // should never happen
            }
        }
    }

    /**
     * Ask (and force) the user to enter a real number.
     *
     * @return Real number entered.
     */
    public static double readDouble() {
        while (true) {
            try {
                String s = kb.readLine();
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("That is not a number.  Enter again: ");
            } catch (IOException e) {
                // should never happen
            }
        }
    }

    /**
     * Ask (and force) the user to enter a single character.
     *
     * @return Character entered.
     */
    public static char readChar() {
        String s = null;

        try {
            s = kb.readLine();
        } catch (IOException e) {
            // should never happen
        }

        while (Objects.requireNonNull(s).length() != 1) {
            System.out.print("That is not a single character.  Enter again: ");
            try {
                s = kb.readLine();
            } catch (IOException e) {
                // should never happen
            }
        }

        return s.charAt(0);
    }

    /**
     * Ask (and force) the user to enter text that can be interpreted as a boolean. "true", "t",
     * "yes", "y", "false", "f", "no", and "n" are valid responses.
     *
     * @return boolean interpretation of text entered.
     */
    public static boolean readBoolean() {
        String s = null;

        while (true) {
            try {
                s = kb.readLine();
            } catch (IOException e) {
                // should never happen
            }

            if (s != null) {
                if (s.equalsIgnoreCase("yes")
                        || s.equalsIgnoreCase("y")
                        || s.equalsIgnoreCase("true")
                        || s.equalsIgnoreCase("t")) {
                    return true;
                } else if (s.equalsIgnoreCase("no")
                        || s.equalsIgnoreCase("n")
                        || s.equalsIgnoreCase("false")
                        || s.equalsIgnoreCase("f")) {
                    return false;
                } else {
                    System.out.print("Enter \"yes\" or \"no\": ");
                }
            }
        }
    }

    /**
     * Print a string to the screen and/or send it to the grading script.
     *
     * @param s String to output.
     */
    public static void outputStringAnswer(String s) {
        if (s != null) {
            System.out.println("RESULT: \"" + s + "\"");
        } else {
            System.out.println("RESULT: null");
        }
    }

    /**
     * Print an integer to the screen and/or send it to the grading script.
     *
     * @param i Integer to output.
     */
    public static void outputIntAnswer(int i) {
        System.out.println("RESULT: " + i);
    }

    /**
     * Print a real number to the screen and/or send it to the grading script.
     *
     * @param d Real number to output.
     */
    public static void outputDoubleAnswer(double d) {
        System.out.println("RESULT: " + d);
    }

    /**
     * Print a single character to the screen and/or send it to the grading script.
     *
     * @param c Character to output.
     */
    public static void outputCharAnswer(char c) {
        System.out.println("RESULT: '" + c + "'");
    }

    /**
     * Print a boolean to the screen (as "true" or "false") and/or send it to the grading script.
     *
     * @param b Boolean to output.
     */
    public static void outputBooleanAnswer(boolean b) {
        System.out.println("RESULT: " + b);
    }

    /**
     * Print an error message to the screen and/or send it to the grading script. This method does
     * not take any inputs - it always prints the same error message.
     */
    public static void reportBadInput() {
        System.out.println("User entered bad input.");
    }
}
