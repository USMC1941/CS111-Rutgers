public class VandC {

    public static void main(String[] args) {
        System.out.print("Enter sentence: ");
        String sentence = IO.readString();

        int vowels = 0, consonants = 0;
        // cycle through characters
        for (int i = 0; i < sentence.length(); i++) {
            // get character at index i
            char ch = sentence.charAt(i);
            // if ch is not a letter, skip
            if (!Character.isLetter(ch)) {
                continue; // skip rest of this iteration and go to next
            }
            ch = Character.toLowerCase(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.printf("Vowels = %d, consonants = %d", vowels, consonants);
    }
}
