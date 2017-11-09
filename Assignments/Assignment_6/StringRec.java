
public class StringRec {

    public static String decompress(String compressedText) {
        // System.out.println("Calling decompress: " + compressedText);

        //Step 1: cut out first token from input
        int 	n;				//first token: char repeats n time
        char 	c;				//first token: char
        String	remaining;		//compressedText after first token cut out

        //three logic branches: no token left, token without leading digit, token with leading digit
        if (!compressedText.equals("")) {
            char first_char = compressedText.charAt(0);
            if (!Character.isDigit(first_char)) {			// If the first character is not a digit
                n			= 1;							// token is 1 character long, n = 1
                c			= first_char;
                remaining	= compressedText.substring(1);
            }
            else {											// token is 2 characters long: first digit is how many times the following char repeats
                n			= first_char - '0';				// Assume that the character counts will be single-digit numbers. A character will not repeat more than 9 times consecutively
                c			= compressedText.charAt(1);		// Only if the token is 2 characters long
                remaining	= compressedText.substring(2);
            }
        }
        else {												// no token
            n			= 0;
            c			= 0;
            remaining	= "";
        }

        //Step 2: do decompress recursive
        if (n>0) {
            return repeatChar(n, c) + decompress(remaining);
        }
        else {
            return "";
        }
    }

    private static String repeatChar(int n, char c) {
        if (n==1) {
            return ("" + c);
        }
        else {
            return ("" + c) + repeatChar(n-1, c);
        }
    }
}