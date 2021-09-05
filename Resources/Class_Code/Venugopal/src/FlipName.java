public class FlipName {

    public static void main(String[] args) {
        System.out.print("Enter name (first last): ");
        String name = IO.readString();
        // System.out.println(name);

        // look for blank space to separate first and last names
        int pos = name.indexOf(' ');

        // System.out.println(pos);

        // extract th first and last name substrings
        String firstName = name.substring(0, pos);
        String lastName = name.substring(pos + 1);
        System.out.println(lastName + ", " + firstName);
    }
}
